package org.homenet.moonserver.cookies;

import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.request.resource.JavaScriptResourceReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CookiePage extends WebPage {

	private static final Logger LOGGER = LoggerFactory.getLogger(CookiePage.class);

	@SuppressWarnings("serial")
	public CookiePage() {

		LOGGER.debug("CookiePage of Simple Page");

		final Label label = new Label("label", new AbstractReadOnlyModel<String>() {

			@Override
			public String getObject() {
				return "Siehe unteren Rand!";
			}
		});
		add(label);
	}

	@Override
	public void renderHead(final IHeaderResponse response) {
		super.renderHead(response);
		// response.render(OnDomReadyHeaderItem.forScript("(function(){})();"));

		// wir brauchen jQuery
		response.render(JavaScriptHeaderItem.forReference(getApplication().getJavaScriptLibrarySettings().getJQueryReference()));

		// on dom ready, braucht jQuery
		final JavaScriptResourceReference nutzungVonCookiesJScript = new JavaScriptResourceReference(CookiePage.class, "NutzungVonCookies.js");
		response.render(JavaScriptHeaderItem.forReference(nutzungVonCookiesJScript));
	}

}
