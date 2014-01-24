package de.hypoport.einarbeitung;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import de.hypoport.einarbeitung.HomePage.StringModel;

public class ClientPage extends WebPage {

	private StringModel labelText;
	private Label label;

	public ClientPage(final PageParameters parameters) {
		super(parameters);


		labelText = new StringModel("später");

		label = new Label("label", labelText) {

			@Override
			protected void onConfigure() {
				setVisibilityAllowed(true);
				String ip = ClientInfo.getIPAddress();
				labelText.setObject(ip);
				super.onConfigure();
			}
		};
		// label.setOutputMarkupId(true);
		add(label);
	}
}
