package org.homelinux.moonserver;

import org.apache.wicket.ajax.AjaxEventBehavior;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomePage extends WebPage {

	private static final Logger LOGGER = LoggerFactory.getLogger(HomePage.class);

	@SuppressWarnings("serial")
	public HomePage() {

		LOGGER.debug("HomePage of Ajax Sample");

		add(new AjaxLink<Void>("ajaxLink") {

			@Override
			public void onClick(AjaxRequestTarget target) {
				target.appendJavaScript("alert('hello world!');");
			}
		});

		Label label = new Label("ajaxText", "Ajax Clickable Text");
		add(label);
		label.add(new AjaxEventBehavior("onclick") {

			@Override
			protected void onEvent(AjaxRequestTarget target) {
				target.appendJavaScript("alert('clicked')");
			}

			// Fehler erzwingen
			// @Override
			// protected void onEvent(AjaxRequestTarget target) {
			// throw new AbortWithHttpErrorCodeException(503,
			// "I need to check that");
			// }

			@Override
			protected CharSequence getFailureScript() {
				return "alert('there was a failure.')";
			}

			@Override
			protected CharSequence getSuccessScript() {
				return "alert('Ajax call was success.')";
			}
		});

		TablePanel tablePanel = new TablePanel("table");
		Behavior tableBehavior = new TableBehavior();
		tablePanel.add(tableBehavior);
		Behavior tableClickBehavior = new TableClickBehavior();
		tablePanel.add(tableClickBehavior);
		add(tablePanel);
	}
}
