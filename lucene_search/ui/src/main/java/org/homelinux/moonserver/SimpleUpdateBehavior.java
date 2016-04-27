package org.homelinux.moonserver;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.form.AjaxFormComponentUpdatingBehavior;

public class SimpleUpdateBehavior extends AjaxFormComponentUpdatingBehavior {

	/*
	 * mit onblur wird ein Event ausgelöst, wenn eine FormComponente verlassen wird, also z.B. der Cursor zum nächsten
	 * Feld weiter wandert.
	 * 
	 * mit 'onkeyup' wird ein Event ausgelöst, wenn eine Taste gedrückt wurde, leider lassen sich damit bisher nicht die
	 * Testfields vernünftig überwachen, da
	 * immer alles markiert wird, sobald der Event gefeuert wird.
	 */
	private static final String REACT_ON = "onblur";

	public SimpleUpdateBehavior(final String reactOn) {
		super(reactOn);
	}

	public SimpleUpdateBehavior() {
		super(REACT_ON);
	}

	@Override
	protected void onUpdate(final AjaxRequestTarget target) {
		final Component c = this.getComponent();
		target.add(c);
	}

	@Override
	protected void onError(final AjaxRequestTarget target, final RuntimeException e) {
		final Component c = this.getComponent();
		target.add(c);

		super.onError(target, e);
	}
}
