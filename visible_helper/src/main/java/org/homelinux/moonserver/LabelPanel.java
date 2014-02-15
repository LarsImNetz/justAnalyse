package org.homelinux.moonserver;

import java.util.List;
import java.util.StringTokenizer;

import org.apache.wicket.Component;
import org.apache.wicket.event.IEvent;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

public class LabelPanel extends Panel {

	IModel<String> labelText;
	Component label2;
	
	public LabelPanel(String id) {
		super(id);
		
		labelText = new Model<String>();
		
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

		labelText.setObject("leer");
//		
//		List<String> attributes = this.getSession().getAttributeNames();
//		System.out.println("Attributes: ");
//		for(String attribute : attributes) {
//
//			System.out.println(attribute);
//		}
		Object o = this.getSession().getAttribute("bean");
		if (o instanceof Bean) {
			Bean bean = (Bean)o;
			labelText.setObject(bean.getA());
		}

		label2.setVisibilityAllowed(isLabel2Visible(this));
	}

	private boolean isLabel2Visible(Component labelPanel) {
		Object o = labelPanel.getSession().getAttribute("bean");
		if (o instanceof Bean) {
			Bean bean = (Bean)o;
			int countWords = countWords(bean.getA());
			if(countWords % 2 == 0) {
				return true;
			}
		}
		return false;
	}

	protected static int countWords(String a) {
		if (a == null) {
			return 0;
		}
		StringTokenizer token = new StringTokenizer(a, " ");
		int count = token.countTokens();
		return count;
	}

	
	
//	private IModel<String> createLabel() {
//		return new AbstractReadOnlyModel<String>() {
//
//			@Override
//			public String getObject() {
//				return "leer";
//			}
//		};
//	}
}
