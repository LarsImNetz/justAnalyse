package org.homelinux.moonserver.bean;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class BeanList {
	List<String> list;
	
	public BeanList(){
		list = new ArrayList<>();
	}

	public void add(String element) {
		list.add(element);
	}

	String[] getList() {
		String[] elements = new String[list.size()];
		return list.toArray(elements);
	}
	
	int size() {
		return list.size();
	}
	

}
