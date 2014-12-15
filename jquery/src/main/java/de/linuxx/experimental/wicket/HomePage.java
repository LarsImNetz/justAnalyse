package de.linuxx.experimental.wicket;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class HomePage extends WebPage{

	public HomePage(final PageParameters params) {
		add(new Label("label", "Hallo Welt!"));
	}
}
