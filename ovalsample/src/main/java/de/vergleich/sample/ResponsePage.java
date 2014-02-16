package de.vergleich.sample;

import org.apache.wicket.Page;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import de.vergleich.sample.adapter.BeanAdapter;
import de.vergleich.sample.bean.Bean;

public class ResponsePage extends WebPage {

	public ResponsePage(PageParameters params) {

		final Bean bean = new BeanAdapter().adapt(params);

		add(new Label("name", bean.getName()));

		add(new Label("darlehensbetrag", bean.getDarlehensbetrag()));

		add(new Label("immobilienwert", bean.getImmobilienwert()));

		add(new Label("mtl-rate", bean.getMonatlicheRate()));

		Form<Void> form = new Form<Void>("form");
		form.add(new FeedbackPanel("feedback"));

		Button button = new Button("button") {
			public void onSubmit() {
				PageParameters p = new BeanAdapter().adapt(bean);
				Page home = new HomePage(p);
				this.setResponsePage(home);
			}
		};
		form.add(button);
		add(form);

	}
}
