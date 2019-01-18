package org.homelinux.moonserver.bean;

public class BeanArray {
	String[] elements;
	
	public BeanArray(final BeanList list) {
		elements = list.getList();
	}
	
	public String[] getElements() {
		return elements;
	}
}
