package org.homelinux.moonserver;

import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;

public class TablePanel extends Panel {

	public TablePanel(String id) {
		super(id);

		Label label = new Label("cell2", "Labelable Cell 2");
		label.add(new AttributeAppender("class", "label", " "));
		add(label);
	}

}
