package org.homelinux.moonserver;

import org.apache.wicket.Component;
import org.apache.wicket.event.IEvent;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.homelinux.moonserver.bean.Bean;
import org.homelinux.moonserver.visible.ILabelVisibilityHelper;

import com.google.inject.Inject;

public class LabelPanel extends Panel {

	IModel<String> labelText;
	Component label2;

	@Inject
	private ILabelVisibilityHelper labelVisibilityHelper;
	
	public LabelPanel(String id) {
		super(id);
		
		labelText = new Model<String>();
		labelText.setObject("leer");
		
		final Label label = new Label("label", labelText);
		label.setOutputMarkupId(true);
		add(label);

		label2 = new Label("label2", Model.of("Zeig etwas"));
		label2.setOutputMarkupPlaceholderTag(true);
		add(label2);
	}

	@Override
	public void onEvent(IEvent<?> event) {
		Object object = event.getPayload();
		if (object != null && object instanceof SimplePayload) {
			SimplePayload payload = (SimplePayload) object;
			payload.update(this);
		}
		super.onEvent(event);
	}
	
	@Override
	protected void onConfigure() {
		super.onConfigure();
//		
//		List<String> attributes = this.getSession().getAttributeNames();
//		System.out.println("Attributes: ");
//		for(String attribute : attributes) {
//
//			System.out.println(attribute);
//		}
		Object object = this.getSession().getAttribute(HomePage.GLOBAL_BEAN);
		if (object instanceof Bean) {
			Bean bean = (Bean)object;
			labelText.setObject(bean.getA());
		}

		label2.setVisibilityAllowed(labelVisibilityHelper.isVisible(this));
	}

}
