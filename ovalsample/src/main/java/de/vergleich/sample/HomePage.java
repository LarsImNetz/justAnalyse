package de.vergleich.sample;

import org.apache.wicket.Page;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.form.AjaxFormComponentUpdatingBehavior;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.FormComponent;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.form.validation.IFormValidator;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.model.StringResourceModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;

	private final IModel<Bean> beanModel;

	public HomePage(final PageParameters parameters) {
		super(parameters);

		beanModel = Model.of(new Bean());

		Form<Void> form = new Form<Void>("form") {
			protected void onSubmit() {
				final Bean aBean = beanModel.getObject();
				// error("Das geht nicht");
				if (!hasError()) {
					final PageParameters params = new BeanAdapter().adapt(aBean);
					Page response = new ResponsePage(params);
					this.setResponsePage(response);
				}
			}
		};

		final TextField<String> textField = new TextField<String>("wert1", new PropertyModel<String>(beanModel, "name"), String.class);
		textField.setRequired(true);
		textField.add(new NameStartsWithGreatCharacterValidator());
		textField.add(new AjaxFormComponentUpdatingBehavior("blur") {
			@Override
			protected void onUpdate(AjaxRequestTarget target) {
			}
		});

		form.add(textField);

		form.add(new FeedbackPanel("feedback"));

		Button button = new Button("button") {
			public void onSubmit() {
				info("Button wurde gedrückt.");
			}
		};
		form.add(button);
		add(form);

		IFormValidator multiFormValidator = new IFormValidator() {

			@Override
			public FormComponent<?>[] getDependentFormComponents() {
				FormComponent<?>[] list = new FormComponent<?>[1];
				list[0] = new ImALocalFormComponentForMultifieldValidation("DieIdIstEgal", beanModel);
				return list;
			}

			@Override
			public void validate(Form<?> form) {
				// String text = textField.getConvertedInput();

				final Bean aBean = beanModel.getObject();

				// TODO: Hier die Bean prüfen
				if (!form.hasError()) {
					if (aBean.getName().toLowerCase().equals("asdf")) {
						final StringResourceModel explanationString = new StringResourceModel("asdf", HomePage.this, null);
						form.error(explanationString.getObject());
					}
				}
			}
		};
		form.add(multiFormValidator);
	}

	private static class ImALocalFormComponentForMultifieldValidation extends FormComponent<Bean> {

		public ImALocalFormComponentForMultifieldValidation(String id, IModel<Bean> model) {
			super(id, model);
		}

	}
}
