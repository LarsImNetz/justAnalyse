package org.homelinux.moonserver.bean;

public class BeanArrayAdapter {
	String[] elements;

	public BeanArrayAdapter(final BeanList list) {
		elements = list.getList();
	}

	public String[] getElements() {
		return elements;
	}
}
