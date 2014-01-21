package de.vergleich.sample;

import org.apache.wicket.request.mapper.parameter.PageParameters;

public class BeanAdapter implements BeanAdoptee {

	@Override
    public PageParameters adapt(Bean bean) {
		PageParameters p = new PageParameters();
		p.add("name", bean.getName());
		return p;
    }

}
