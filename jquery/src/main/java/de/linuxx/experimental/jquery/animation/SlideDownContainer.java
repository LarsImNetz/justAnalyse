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
public class SlideDownContainer extends WebMarkupContainer implements IAnimationContainer {

	private boolean visibleInWicket;
	private boolean visibleInJQuery;
	private boolean currentlyOpening;

	public SlideDownContainer(String id, VisibilityEnum initallyOpen) {
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see experiment.lars.jquery.animation.IAnimationContainer#isVisible()
	 */

	@Override
	public boolean isVisible() {
		return visibleInWicket;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see experiment.lars.jquery.animation.IAnimationContainer#show(org.apache.wicket.ajax.AjaxRequestTarget)
	 */
	@Override
	public void show(AjaxRequestTarget ajax) {
		visibleInWicket = true;
		if (!visibleInJQuery) {
			visibleInJQuery = true;
			currentlyOpening = true;
			ajax.add(this); // wir müssen uns selbst neu rendern bei show
			ajax.appendJavaScript("$('#" + this.getMarkupId() + "').slideDown('slow');");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see experiment.lars.jquery.animation.IAnimationContainer#hide(org.apache.wicket.ajax.AjaxRequestTarget)
	 */
	@Override
	public void hide(AjaxRequestTarget ajax) {
		if (visibleInJQuery) {
			// visibleInWicket = false; // ist hier falsch!!! Wir müssen noch gerendert werden
			visibleInJQuery = false;
			ajax.add(this);
			ajax.appendJavaScript("$('#" + this.getMarkupId() + "').slideUp('slow');");
		}
	}

	@Override
	protected void onAfterRender() {
		super.onAfterRender();
		visibleInWicket = visibleInJQuery;
		currentlyOpening = false;
	}

	@Override
	public void renderHead(IHeaderResponse response) {
		super.renderHead(response);

		response.render(JavaScriptReferenceHeaderItem.forReference(Application.get() //
		.getJavaScriptLibrarySettings() // seit Wicket 6
		.getJQueryReference()));
	}
}
