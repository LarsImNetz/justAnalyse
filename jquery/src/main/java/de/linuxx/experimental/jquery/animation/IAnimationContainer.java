package de.linuxx.experimental.jquery.animation;

import org.apache.wicket.ajax.AjaxRequestTarget;

public interface IAnimationContainer {

	public abstract boolean isVisible();

	public abstract void show(AjaxRequestTarget ajax);

	public abstract void hide(AjaxRequestTarget ajax);

}
