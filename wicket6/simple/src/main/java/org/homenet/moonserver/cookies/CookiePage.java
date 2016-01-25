package org.homenet.moonserver.cookies;

import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.StringHeaderItem;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.AbstractReadOnlyModel;
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
		final StringHeaderItem item = StringHeaderItem.forString("<title>CookiePage Title</title>");
		response.render(item);
	}

}
