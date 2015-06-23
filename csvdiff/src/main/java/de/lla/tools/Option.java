package de.lla.tools;

public class Option implements IOption {

	private boolean ignoreMoreToken = false;

	public Option() {
	}

	@Override
	public boolean isIgnoreMoreToken() {
		return ignoreMoreToken;
	}

	public void setIgnoreMoreToken(boolean ignoreMoreToken) {
		this.ignoreMoreToken = ignoreMoreToken;
	}

}
