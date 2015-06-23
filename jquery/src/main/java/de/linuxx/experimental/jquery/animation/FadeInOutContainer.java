package de.linuxx.experimental.jquery.animation;

import org.apache.wicket.Application;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptReferenceHeaderItem;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.model.AbstractReadOnlyModel;

/**
 * HilfsContainer für AJAX geraffel
 *
 * @see https://cwiki.apache.org/WICKET/wicket-ajax.html
 * @author lars.langhans
 *
 */

@SuppressWarnings("serial")
public class FadeInOutContainer extends WebMarkupContainer implements IAnimationContainer {

	private boolean visibleInWicket;
	private boolean visibleInJQuery;
	private boolean currentlyOpening;

	public FadeInOutContainer(final String id, final VisibilityEnum initallyOpen) {
		super(id);
		visibleInJQuery = initallyOpen.isVisible();
		visibleInWicket = initallyOpen.isVisible();
		currentlyOpening = false;

		// Wicket soll es schon rendern, aber der Browser noch nicht anzeigen

		add(new AttributeAppender("style", new AbstractReadOnlyModel<String>() {

			@Override
			public String getObject() {
				if (currentlyOpening) {
					return "display:none;";
				}
				return "";
			}
		}, ";")); // dritter Parameter von AttributeAppender
		this.setOutputMarkupPlaceholderTag(true);
	}

	@Override
	public boolean isVisible() {
		return visibleInWicket;
	}

	@Override
	public void show(final AjaxRequestTarget ajax) {
		visibleInWicket = true;
		if (!visibleInJQuery) {
			visibleInJQuery = true;
			currentlyOpening = true;
			ajax.add(this); // wir müssen uns selbst neu rendern bei show
			ajax.appendJavaScript("$('#" + this.getMarkupId() + "').fadeIn('slow');");
		}
	}

	@Override
	public void hide(final AjaxRequestTarget ajax) {
		if (visibleInJQuery) {
			// visibleInWicket = false; // ist hier falsch!!! Wir müssen noch
			// gerendert werden
			visibleInJQuery = false;
			ajax.add(this);
			ajax.appendJavaScript("$('#" + this.getMarkupId() + "').fadeOut('slow');");
		}
	}

	@Override
	protected void onAfterRender() {
		super.onAfterRender();
		visibleInWicket = visibleInJQuery;
		currentlyOpening = false;
	}

	@Override
	public void renderHead(final IHeaderResponse response) {
		super.renderHead(response);

		response.render(JavaScriptReferenceHeaderItem.forReference(Application.get() //
		.getJavaScriptLibrarySettings() // seit Wicket 6
		.getJQueryReference()));
	}
}
