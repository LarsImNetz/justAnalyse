package org.homelinux.moonserver;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;

public class SimplePayload {

	private AjaxRequestTarget target;
	private String userInfo;

	public SimplePayload(AjaxRequestTarget target) {
		this.target = target;
	}

	public SimplePayload(AjaxRequestTarget target, final String userInfo) {
		this.target = target;
		this.userInfo = userInfo;
	}

	public AjaxRequestTarget getAjaxRequestTarget() {
		return this.target;
	}

	public void update(Component... components) {
		this.target.add(components);
	}

	public String getUserInfo() {
		return userInfo;
	}
}
