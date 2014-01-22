package de.vergleich.sample;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.util.string.StringValue;

import de.vergleich.sample.adapter.BeanAdapter;

public class ResponsePage extends WebPage  {

	public ResponsePage(PageParameters params) {

		StringValue name = params.get(BeanAdapter.NAME);
		add(new Label("name", name.toString()));

		StringValue darlehensbetrag = params.get(BeanAdapter.DARLEHENSBETRAG);
		add(new Label("darlehensbetrag", darlehensbetrag.toString()));

		StringValue immobilienwert = params.get(BeanAdapter.IMMOBILIENWERT);
		add(new Label("immobilienwert", immobilienwert.toString()));

		StringValue monatlicheRate = params.get(BeanAdapter.MONATLICHERATE);
		add(new Label("mtl-rate", monatlicheRate.toString()));

	}
}
