package org.homelinux.moonserver;

import org.apache.wicket.ajax.AjaxEventBehavior;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomePage extends WebPage {

	private final static Logger logger = LoggerFactory.getLogger(HomePage.class);

	@SuppressWarnings("serial")
	public HomePage() {

		logger.debug("HomePage of Responsive Design Sample");

		add(new AjaxLink<Void>("ajaxLink") {

			@Override
			public void onClick(final AjaxRequestTarget target) {
				target.appendJavaScript("alert('hello world!');");
			}
		});

		final Label label = new Label("ajaxText", "Ajax Clickable Text");
		add(label);
		label.add(new AjaxEventBehavior("onclick") {

			@Override
			protected void onEvent(final AjaxRequestTarget target) {
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

		final Label einLabel = new Label("label1", "ein Label");
		add(einLabel);
		
		final Label zweiterLabel = new Label("label2", "ein zweiter Label");
		add(zweiterLabel);

		final Label dritterLabel = new Label("label3", "noch ein Label");
		add(dritterLabel);

	}
}
