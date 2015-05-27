package org.homelinux.moonserver;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.OnDomReadyHeaderItem;

public class TableBehavior extends Behavior {
	public TableBehavior() {
	}

	@Override
	public void renderHead(Component component, IHeaderResponse response) {
		super.renderHead(component, response);

		// response.render(OnLoadHeaderItem.forScript("alert('onload!');"));
		response.render(OnDomReadyHeaderItem.forScript("alert('on dom ready!');"));
	}
}
