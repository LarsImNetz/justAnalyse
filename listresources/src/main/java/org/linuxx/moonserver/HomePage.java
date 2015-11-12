package org.linuxx.moonserver;

import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.request.resource.CssResourceReference;

public class HomePage extends WebPage {

	// private static final Logger LOGGER =
	// LoggerFactory.getLogger(HomePage.class);

	public HomePage(final PageParameters parameters) {
		super(parameters);

		add(new ListView<String>("list", new ListStringModel()) {

			@Override
			protected void populateItem(ListItem<String> item) {
				final String filename = item.getModelObject();
				Label label = new Label("label", filename);
				// label.setOutputMarkupId(true); // Einbinden von IDs
				item.add(label);
			}

		});
	}

	@Override
	public void renderHead(IHeaderResponse response) {
		response.render(CssHeaderItem.forReference(new CssResourceReference(HomePage.class, "HomePage.css")));
	}
}
