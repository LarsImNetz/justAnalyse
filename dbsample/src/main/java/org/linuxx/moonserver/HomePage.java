package org.linuxx.moonserver;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.util.string.StringValue;

public class HomePage extends WebPage {

	// private static final Logger LOGGER =
	// LoggerFactory.getLogger(HomePage.class);

	@SuppressWarnings("serial")
	public HomePage(final PageParameters parameters) {
		super(parameters);

		// LOGGER.debug("HomePage of DateViewer");
		//
		// IModel<String> textToView = new LoadableDetachableModel<String>() {
		//
		// @Override
		// protected String load() {
		// final String textToString = "Heute ist " + new Date();
		// LOGGER.debug("Zu zeigender Text: " + textToString);
		// return textToString;
		// }
		//
		// };

		StringValue value = parameters.get("a");

		final Label label = new Label("label", value.toString());
		add(label);
	}
}
