package de.vergleich.sample;

import java.util.List;

import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;

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

import de.vergleich.sample.adapter.BeanAdapter;
import de.vergleich.sample.bean.Bean;
import de.vergleich.sample.validator.OValValidator;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;

	private final IModel<Bean> beanModel;

	public HomePage(final PageParameters parameters) {
		super(parameters);

		Bean bean = new Bean();
		if (parameters != null) {
			beanModel = Model.of(new BeanAdapter().adapt(parameters));
		} else {
			beanModel = Model.of(bean);
		}

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

		final TextField<String> textField = new TextField<String>("name", new PropertyModel<String>(beanModel, "name"), String.class);
		textField.setRequired(true);
		textField.add(new OValValidator(bean, "name"));
		// textField.add(new NameStartsWithGreatCharacterValidator());
		textField.add(createFormUpdatingBehavior());
		form.add(textField);

		final TextField<Double> darlehensbetrag = new TextField<Double>("darlehensbetrag", new PropertyModel<Double>(beanModel, "darlehensbetrag"), Double.class);
		darlehensbetrag.add(createFormUpdatingBehavior());
		form.add(darlehensbetrag);

		final TextField<Double> immobilienwert = new TextField<Double>("immobilienwert", new PropertyModel<Double>(beanModel, "immobilienwert"), Double.class);
		immobilienwert.add(createFormUpdatingBehavior());
		form.add(immobilienwert);

		final TextField<Double> monatlicheRate = new TextField<Double>("monatlicheRate", new PropertyModel<Double>(beanModel, "monatlicheRate"), Double.class);
		monatlicheRate.add(createFormUpdatingBehavior());
		form.add(monatlicheRate);

		form.add(new FeedbackPanel("feedback"));

		Button button = new Button("button") {
			public void onSubmit() {
				info("Button wurde gedrückt.");
			}
		};
		form.add(button);
		add(form);

		@SuppressWarnings("unused")
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

				Validator validator = new Validator();
				List<ConstraintViolation> violations = validator.validate(aBean);
				for (ConstraintViolation violation : violations) {
					final String errorCode = violation.getErrorCode();
					final StringResourceModel explanationString = new StringResourceModel(errorCode, HomePage.this, null);
					form.error(explanationString.getObject());
				}

				// // TODO: Hier die Bean prüfen
				// if (!form.hasError()) {
				// if (aBean.getName().toLowerCase().equals("asdf")) {
				// final StringResourceModel explanationString = new
				// StringResourceModel("asdf", HomePage.this, null);
				// form.error(explanationString.getObject());
				// }
				// }
			}
		};
		// !!! TOD !!! form.add(multiFormValidator);
	}

	private AjaxFormComponentUpdatingBehavior createFormUpdatingBehavior() {
		return new AjaxFormComponentUpdatingBehavior("blur") {
			@Override
			protected void onUpdate(AjaxRequestTarget target) {
			}
		};
	}

	private static class ImALocalFormComponentForMultifieldValidation extends FormComponent<Bean> {

		public ImALocalFormComponentForMultifieldValidation(String id, IModel<Bean> model) {
			super(id, model);
		}

	}
}
