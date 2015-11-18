package org.linuxx.moonserver;

import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.head.OnDomReadyHeaderItem;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.request.resource.JavaScriptResourceReference;
import org.apache.wicket.util.string.StringValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomePage extends WebPage {

	// private static final Logger LOGGER = LoggerFactory.getLogger(HomePage.class);

	@SuppressWarnings("serial")
	public HomePage(final PageParameters parameters) {
		super(parameters);

		//		LOGGER.debug("HomePage of DateViewer");
		//
		//		IModel<String> textToView = new LoadableDetachableModel<String>() {
		//
		//			@Override
		//			protected String load() {
		//				final String textToString = "Heute ist " + new Date();
		//				LOGGER.debug("Zu zeigender Text: " + textToString);
		//				return textToString;
		//			}
		//
		//		};

		StringValue value = parameters.get("a");

		final Label label = new Label("label", value.toString());
		add(label);
	}

	@Override
	public void renderHead(IHeaderResponse response) {
		super.renderHead(response);
		final JavaScriptResourceReference omnitureScript = new JavaScriptResourceReference(HomePage.class, "file.js");

		response.render(JavaScriptHeaderItem.forReference(omnitureScript));
		response.render(OnDomReadyHeaderItem.forScript("funktion();"));
	}
}
