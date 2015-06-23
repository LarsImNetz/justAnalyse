package de.vergleich.sample.adapter;

import org.apache.wicket.request.mapper.parameter.PageParameters;

import de.vergleich.sample.bean.Bean;

public interface BeanAdoptee {

	PageParameters adapt(Bean bean);

	Bean adapt(PageParameters params);
}
