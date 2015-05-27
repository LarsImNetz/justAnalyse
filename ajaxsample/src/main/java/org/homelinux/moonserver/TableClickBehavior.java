package org.homelinux.moonserver;

import org.apache.wicket.ajax.AjaxEventBehavior;
import org.apache.wicket.ajax.AjaxRequestTarget;

public class TableClickBehavior extends AjaxEventBehavior {

	public TableClickBehavior() {
		this("onclick");
	}

	private TableClickBehavior(String event) {
		super(event);
	}

	@Override
	protected void onEvent(AjaxRequestTarget target) {
		target.appendJavaScript("alert('in tabelle geklicket.')");
	}

}
