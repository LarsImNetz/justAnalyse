package org.homelinux.moonserver;

import org.homelinux.moonserver.module.IRest;
import org.homelinux.moonserver.module.RestSample;

import com.google.inject.AbstractModule;

public class RestModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(IRest.class).to(RestSample.class);		
	}

}

