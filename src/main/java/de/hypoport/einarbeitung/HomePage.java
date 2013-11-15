package de.hypoport.einarbeitung;

import java.io.IOException;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomePage extends WebPage {

	private final static Logger logger = LoggerFactory.getLogger(HomePage.class);

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("serial")
	public HomePage(final PageParameters parameters) throws InterruptedException, IOException {
		super(parameters);

		logger.debug("HomePage() with parameters");

		sleep();

		Form<Void> form = new Form<Void>("form") {

			@Override
			public void onError() {
				logger.debug("Form Error");
				super.onError();
			}

			@Override
			public void onSubmit() {
				logger.debug("Form Submit");
				super.onSubmit();
			}

		};

		form.add(new Label("label", new AbstractReadOnlyModel<String>() {

			@Override
			public String getObject() {
				return "Hier könnte Ihr Text stehen"; // EnvironmentProvider.getHostname();
			}
		}

		) {

			@Override
			protected void onConfigure() {
				setVisibilityAllowed(true);
				super.onConfigure();
			}
		});

		form.add(new Button("button") {

			@Override
			public void onSubmit() {
				logger.debug("Submit");
				PageParameters params = new PageParameters();
				params.add("label", "hier steht etwas");
				setResponsePage(SecondPage.class, params);
				super.onSubmit();
			}
		});

		add(form);
	}

	public static void sleep() {
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
