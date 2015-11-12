package org.homelinux.moonserver;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.event.Broadcast;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.util.string.StringValue;
import org.homelinux.moonserver.bean.Bean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomePage extends WebPage {

	public static final String GLOBAL_BEAN = "bean";

	private static final Logger LOGGER = LoggerFactory.getLogger(HomePage.class);

	IModel<Bean> beanModel;

	@SuppressWarnings("serial")
	public HomePage(final PageParameters parameters) {
		super(parameters);

		LOGGER.debug("HomePage LOGGER output");
		//
		// IModel<String> textToView = new LoadableDetachableModel<String>() {
		//
		// @Override
		// protected String load() {
		// final String textToString = "Heute ist " + new Date();
		// LOGGER.debug("Zu zeigender Text: " + textToString);
		// return textToString;
		// }
		//
		// };

		final StringValue value = parameters.get("a");

		final Bean bean = new Bean();
		final String string = value.toString();
		bean.setA(string);

		beanModel = Model.of(bean);

		setDefaultModel(beanModel);
		// this.getSession().setAttribute("beanModel", beanModel);
		this.getSession().setAttribute(GLOBAL_BEAN, bean);

		LabelPanel labelPanel = new LabelPanel("label");
		labelPanel.setOutputMarkupId(true);
		add(labelPanel);

		add(new AjaxLink<Void>("button") {

			@Override
			public void onClick(AjaxRequestTarget target) {
				if (beanModel.getObject() == null) {
					beanModel = Model.of(new Bean());
					beanModel.getObject().setA("hä");
				}
				String a = beanModel.getObject().getA();
				if (a == null) {
					a = "leer";
				}
				else if ("button pressed".equals(a)) {
					a = "button pressed again";
				}
				else if (a.startsWith("button pressed again")) {
					a = a + " again";
				}
				else {
					a = "button pressed";
				}
				beanModel.getObject().setA(a);
				this.getPage().send(getPage(), Broadcast.DEPTH, new SimplePayload(target));
				target.add(this);
			}

		});
	}
}
