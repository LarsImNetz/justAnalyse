package de.hypoport.einarbeitung.page;

import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SinglePanel extends Panel {

	private static Logger LOGGER = LoggerFactory.getLogger(SinglePanel.class);

	public SinglePanel(final String id, final IModel<String> model) {
		super(id, model);

		add(new Label("label", "Hier auch nix zu sehen."));
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
	}

}
