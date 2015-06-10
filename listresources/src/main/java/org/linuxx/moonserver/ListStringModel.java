package org.linuxx.moonserver;

import java.util.List;

import org.apache.wicket.model.LoadableDetachableModel;

class ListStringModel extends LoadableDetachableModel<List<String>> {

	public ListStringModel() {
	}

	@Override
	protected List<String> load() {
		List<String> aList = WicketApplication.getListOfResources();
		return aList;
	}

}