package de.linuxx.experimental.jquery.animation;

public enum VisibilityEnum {
	SHOW(true),
	HIDE(false);

	private boolean visible;

	private VisibilityEnum(boolean visibility) {
		visible = visibility;
	}

	public boolean isVisible() {
		return visible;
	}
}
