package de.hypoport.einarbeitung;

import java.io.IOException;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.request.resource.CssResourceReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomePage extends WebPage {

	private static final Logger LOGGER = LoggerFactory.getLogger(HomePage.class);

	private static final long serialVersionUID = 1L;

	private final Label label;
	private final StringModel labelText;

	@SuppressWarnings("serial")
	public HomePage(final PageParameters parameters) throws InterruptedException, IOException {
		super(parameters);

		LOGGER.debug("HomePage() with parameters");

		sleep();

		final Form<Void> form = new Form<Void>("form") {

			@Override
			public void onError() {
				LOGGER.debug("Form Error");
				super.onError();
			}

			@Override
			public void onSubmit() {
				LOGGER.debug("Form Submit");
				super.onSubmit();
			}

		};

//		labelText = new AbstractReadOnlyModel<String>() {
//
//			@Override
//			public String getObject() {
//				return "Hier könnte Ihr Text stehen"; // EnvironmentProvider.getHostname();
//			}
//		};
		labelText = new StringModel("Hier könnte Ihr Text stehen");

		label = new Label("label", labelText) {

			@Override
			protected void onConfigure() {
				setVisibilityAllowed(true);
				super.onConfigure();
			}
		};
		label.setOutputMarkupId(true);
		form.add(label);

		form.add(new Button("button") {

			@Override
			public void onSubmit() {
				LOGGER.debug("Submit");
				final PageParameters params = new PageParameters();
				params.add("label", "hier steht etwas");
				setResponsePage(SecondPage.class, params);
				super.onSubmit();
			}
		});

		form.add(new SliderPanel("slider"));
		add(form);

		add(createLink("link"));
	}

	private AjaxLink<Void> createLink(final String wicketId) {
		final AjaxLink<Void> ajaxLink = new AjaxLink<Void>(wicketId) {

			@Override
			public void onClick(final AjaxRequestTarget target) {
				// DisplayAnbieter current = getModelObject();
				// setModelObject(current.swap());
				// Events.send(this, new
				// BusinessPartnerChangedEventPayload(target));

				labelText.setObject("Hier steht jetzt Ihr Text");
				target.add(label);
			}
		};
		return ajaxLink;
	}

	public static void sleep() {
		try {
			Thread.sleep(200);
		} catch (final InterruptedException e) {
			LOGGER.error(e.getMessage());
		}
	}

	
	@Override
	public void renderHead(final IHeaderResponse response) {
		response.render(CssHeaderItem.forReference(new CssResourceReference(this.getClass(), "HomePage.css")));
	}


	public static class StringModel implements IModel<String> {

		private String text;

		public StringModel(final String text) {
			this.text = text;
		}

		@Override
		public void detach() {
			text = null;
		}

		@Override
		public String getObject() {
			return text;
		}

		@Override
		public void setObject(final String object) {
			text = object;
		}
	}


}
