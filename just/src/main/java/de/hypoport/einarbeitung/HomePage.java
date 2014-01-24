package de.hypoport.einarbeitung;

import java.io.IOException;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.request.resource.CssResourceReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomePage extends WebPage {

	private final static Logger logger = LoggerFactory.getLogger(HomePage.class);

	private static final long serialVersionUID = 1L;

	private Label label;
	private StringModel labelText;

	@SuppressWarnings("serial")
	public HomePage(final PageParameters parameters) throws InterruptedException, IOException {
		super(parameters);

		logger.debug("HomePage() with parameters");

		sleep();

		Form<Void> form = new Form<Void>("form") {

			@Override
			public void onError() {
				logger.debug("Form Error");
				super.onError();
			}

			@Override
			public void onSubmit() {
				logger.debug("Form Submit");
				super.onSubmit();
			}

		};

//		labelText = new AbstractReadOnlyModel<String>() {
//
//			@Override
//			public String getObject() {
//				return "Hier könnte Ihr Text stehen"; // EnvironmentProvider.getHostname();
//			}
//		};
		labelText = new StringModel("Hier könnte Ihr Text stehen");

		label = new Label("label", labelText) {

			@Override
			protected void onConfigure() {
				setVisibilityAllowed(true);
				super.onConfigure();
			}
		};
		label.setOutputMarkupId(true);
		form.add(label);

		form.add(new Button("button") {

			@Override
			public void onSubmit() {
				logger.debug("Submit");
				PageParameters params = new PageParameters();
				params.add("label", "hier steht etwas");
				setResponsePage(SecondPage.class, params);
				super.onSubmit();
			}
		});

		form.add(new SliderPanel("slider"));
		add(form);

		add(createLink("link"));
	}

	private AjaxLink<Void> createLink(String wicketId) {
		AjaxLink<Void> ajaxLink = new AjaxLink<Void>(wicketId) {

			@Override
			public void onClick(AjaxRequestTarget target) {
				// DisplayAnbieter current = getModelObject();
				// setModelObject(current.swap());
				// Events.send(this, new
				// BusinessPartnerChangedEventPayload(target));

				labelText.setObject("Hier steht jetzt Ihr Text");
				target.add(label);
			}
		};
		return ajaxLink;
	}

	public static void sleep() {
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
<<<<<<< HEAD:src/main/java/de/hypoport/einarbeitung/HomePage.java
	
	@Override
	public void renderHead(IHeaderResponse response) {
		response.render(CssHeaderItem.forReference(new CssResourceReference(this.getClass(), "HomePage.css")));
	}
	private static class StringModel implements IModel<String> {
=======

	public static class StringModel implements IModel<String> {
>>>>>>> ae1e5a48684f04a6f409efbb6ca1d27a16fe4f97:just/src/main/java/de/hypoport/einarbeitung/HomePage.java
		private String text;

		public StringModel(String text) {
			this.text = text;
		}

		@Override
		public void detach() {
			text = null;
		}

		@Override
		public String getObject() {
			return text;
		}

		@Override
		public void setObject(String object) {
			text = object;
		}
	}


}
