package de.linuxx.experimental.wicket;

import java.io.Serializable;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import de.linuxx.experimental.jquery.animation.APage;

public class HomePage extends WebPage {

	public HomePage(final PageParameters params) {
		add(new Label("label", "Hallo jQuery!"));

		final Count count = new Count(); // simple counter object

		Link<Void> buttonLink = new Link<Void>("link1") {
			public void onClick() {
				count.increment();
			}
		};

		buttonLink.add(new Label("label1", new Model<String>() {
			public String getObject() {
				return count.toString();
			}
		}));
		add(buttonLink);

		Link<Void> buttonToJQueryAnimation = new Link<Void>("button-to-jquery-animation") {
			public void onClick() {
				setResponsePage(APage.class);
			}
		};
		add(buttonToJQueryAnimation);
	}

	private static class Count implements Serializable {
		int i = 0;

		public Count() {
			i = 0;
		}

		public void increment() {
			i++;
		}

		@Override
		public String toString() {
			return String.valueOf(i);
		}
	}
}
