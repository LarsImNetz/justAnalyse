package de.vergleich.sample;

import org.apache.wicket.request.mapper.parameter.PageParameters;

public interface BeanAdoptee {
	PageParameters adapt(Bean bean);
}
