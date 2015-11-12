package de.vergleich.sample.adapter;

import java.util.Locale;

import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.util.string.StringValue;

import de.vergleich.sample.bean.Bean;
import de.vergleich.sample.converter.DoubleConverter;

public class BeanAdapter implements BeanAdoptee {

	public static final String MONATLICHERATE = "monatlicherate";
	public static final String IMMOBILIENWERT = "immobilienwert";
	public static final String DARLEHENSBETRAG = "darlehensbetrag";
	public static final String NAME = "name";

	private static final DoubleConverter converter = new DoubleConverter();

	@Override
	public PageParameters adapt(Bean bean) {
		PageParameters p = new PageParameters();
		p.add(NAME, bean.getName());
		add(p, DARLEHENSBETRAG, bean.getDarlehensbetrag());
		add(p, IMMOBILIENWERT, bean.getImmobilienwert());
		add(p, MONATLICHERATE, bean.getMonatlicheRate());
		return p;
	}

	private void add(PageParameters p, String name, Double betrag) {
		if (betrag != null) {
			final String betragAsString = converter.convert(betrag, Locale.GERMANY);
			p.add(name, betragAsString);
		}
	}

	@Override
	public Bean adapt(PageParameters params) {
		Bean bean = new Bean();

		final StringValue name = params.get(NAME);
		bean.setName(name.toString());

		final StringValue darlehensbetrag = params.get(DARLEHENSBETRAG);
		if (!darlehensbetrag.isNull()) {
			bean.setDarlehensbetrag(converter.convert(darlehensbetrag.toString(), Locale.GERMANY));
		}

		final StringValue immobilienwert = params.get(IMMOBILIENWERT);
		if (!immobilienwert.isNull()) {
			bean.setImmobilienwert(converter.convert(immobilienwert.toString(), Locale.GERMANY));
		}

		final StringValue monatlicheRate = params.get(MONATLICHERATE);
		if (!monatlicheRate.isNull()) {
			bean.setMonatlicheRate(converter.convert(monatlicheRate.toString(), Locale.GERMANY));
		}
		return bean;
	}
}
