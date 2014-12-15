package de.linuxx.experimental.jquery.animation;

import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.PriorityHeaderItem;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.request.resource.CssResourceReference;

public class APage extends WebPage {

	public APage(final PageParameters parameters) {
		super(parameters);

		add(new Label("title", Model.of("Animation Demonstration")));
		add(new APanel("panel"));

		add(new TablePanel("table"));
	}

	@Override
	public void renderHead(final IHeaderResponse response) {
		response.render(CssHeaderItem.forReference(new CssResourceReference(getClass(), "apage.css")));

		// PriorityHeaderItem spült die css ganz an den Anfang
		response.render(new PriorityHeaderItem(CssHeaderItem.forReference(new CssResourceReference(getClass(), "apage-template.css"))));
		response.render(new PriorityHeaderItem(CssHeaderItem.forReference(new CssResourceReference(getClass(), "apage-template-second.css"))));
	}

}
