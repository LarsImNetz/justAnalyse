package org.homelinux.moonserver.guice;

import org.homelinux.moonserver.visible.ILabelVisibilityHelper;
import org.homelinux.moonserver.visible.LabelVisibilityHelper;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

public class VisibilityHelperModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(ILabelVisibilityHelper.class).to(LabelVisibilityHelper.class).in(Singleton.class);
	}

}
