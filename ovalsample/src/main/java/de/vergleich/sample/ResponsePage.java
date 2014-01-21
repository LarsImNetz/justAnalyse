package de.vergleich.sample;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.util.string.StringValue;

public class ResponsePage extends WebPage  {

	public ResponsePage(PageParameters params) {

		StringValue value = params.get("name");
		add(new Label("name", value.toString()));

	}
}
