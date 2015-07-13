package org.linuxx.moonserver.pattern.decorator;

public class FYIInfo extends InfoDecorator {

	public FYIInfo(final Info info) {
		super(info);
	}

	@Override
	public String getInfo() {
		return "FYI:" + super.getInfo();
	}
}
