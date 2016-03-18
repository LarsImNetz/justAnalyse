package org.homelinux.moonserver;



import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxEventBehavior;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.attributes.AjaxCallListener;
import org.apache.wicket.ajax.attributes.AjaxRequestAttributes;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.FormComponent;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.validation.validator.StringValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomePage extends WebPage {

	private static final Logger LOGGER = LoggerFactory.getLogger(HomePage.class);

	private final FormComponent<String> textComponent;

	public HomePage() {

		LOGGER.debug("HomePage of Simple Page");
		
		final IModel<String> textModel = new Model<String>();
		
		textComponent = new TextField<String>("input", textModel);
		textComponent.setOutputMarkupId(true);
		textComponent.add(new StringValidator(3, 20));
		textComponent.add(new UpdateBehavior());
		add(textComponent);
	}

	private static class UpdateBehavior extends AjaxEventBehavior {
		public UpdateBehavior() {
			super("onkeypress");
		}

		@Override
		protected void onEvent(final AjaxRequestTarget target) {
			System.out.println("update");
		}

    @Override
    protected void updateAjaxAttributes(final AjaxRequestAttributes attributes) {
        super.updateAjaxAttributes(attributes);

        attributes.getAjaxCallListeners().add(new AjaxCallListener(){
            @Override
						public CharSequence getPrecondition(final Component component) {
                return "if (Wicket.Event.keyCode(attrs.event)  != 13) " +
                        " { return true; } " +
                        "else { return false; }";
            }
        });
    }			
		
	}
}
