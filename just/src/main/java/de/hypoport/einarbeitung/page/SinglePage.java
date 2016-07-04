package de.hypoport.einarbeitung.page;

import org.apache.wicket.Application;
import org.apache.wicket.application.HeaderContributorListenerCollection;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("serial")
public class SinglePage extends WebPage {

	private static final Logger LOGGER = LoggerFactory.getLogger(SinglePage.class);

	public SinglePage(final PageParameters parameters) {
		super(parameters);
		LOGGER.info("CTor()");
		add(new Label("label", "Hier ist nix zu sehen"));
		add(new SinglePanel("panel", Model.of("Wurst")));
	}

	@Override
	protected void onConfigure() {
		LOGGER.info("onConfigure()");
		super.onConfigure();
	}

	@Override
	protected void onInitialize() {
		LOGGER.info("onInitialize()");
		super.onInitialize();
	}

	@Override
	protected void onBeforeRender() {
		LOGGER.info("onBeforeRender()");
		super.onBeforeRender();
	}

	@Override
	protected void onAfterRender() {
		LOGGER.info("onAfterRender()");
		super.onAfterRender();
	}

	@Override
	protected void onAfterRenderChildren() {
		LOGGER.info("onAfterRenderChildren()");
		super.onAfterRenderChildren();
	}

	@Override
	public void renderHead(final IHeaderResponse response) {
		LOGGER.info("renderHead()");
		super.renderHead(response);

		final HeaderContributorListenerCollection x = Application.get().getHeaderContributorListenerCollection();
	}
}
