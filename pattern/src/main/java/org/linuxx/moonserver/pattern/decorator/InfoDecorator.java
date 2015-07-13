package org.linuxx.moonserver.pattern.decorator;

/**
 * Dekorator Pattern
 *
 * Die zu dekorierende Klasse wird als Protected Field gehalten und jede öffentliche Methode wird an die zu dekorierende Klasse weiter delegiert.
 */
public class InfoDecorator implements IInformation {

	protected Info info;
	
	public InfoDecorator(final Info info) {
		this.info = info;
	}

	@Override
	public String getInfo() {
		return info.getInfo();
	}

}
