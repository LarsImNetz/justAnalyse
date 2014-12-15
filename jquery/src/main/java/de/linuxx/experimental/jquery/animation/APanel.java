package de.linuxx.experimental.jquery.animation;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.PriorityHeaderItem;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.resource.CssResourceReference;

public class APanel extends Panel {

	private IModel<String> text;
	final SlideDownContainer entryContainer;

	IModel<Boolean> switcher;

	private AjaxButton zeigen;
	private AjaxButton wegmachen;

	public APanel(String id) {
		super(id);
		switcher = Model.of(Boolean.TRUE);

		text = Model.of("Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.");

		Form<Void> form = new Form<Void>("form");

		zeigen = new AjaxButton("an") {

			@Override
			protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
				super.onSubmit(target, form);
				entryContainer.show(target);

				switcher.setObject(false);
				System.out.println("Button an gedrueckt: switcher:state " + switcher.getObject());

				target.add(zeigen);
				target.add(wegmachen);
			}
		};

		zeigen.add(new ButtonUsabilityBehavior(new AbstractReadOnlyModel<Boolean>() {

			@Override
			public Boolean getObject() {
				Boolean enabled = switcher.getObject();
				return enabled;
			}
		}));
		zeigen.setOutputMarkupId(true);
		form.add(zeigen);

		wegmachen = new AjaxButton("aus") {

			@Override
			protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
				super.onSubmit(target, form);
				entryContainer.hide(target);

				switcher.setObject(true);
				System.out.println("Button aus gedrueckt switcher:state " + switcher.getObject());

				target.add(zeigen);
				target.add(wegmachen);
			}

		};
		wegmachen.add(new ButtonUsabilityBehavior(new AbstractReadOnlyModel<Boolean>() {

			@Override
			public Boolean getObject() {
				Boolean enabled = switcher.getObject();
				return !enabled;
			}
		}));
		wegmachen.setOutputMarkupId(true);
		form.add(wegmachen);
		add(form);

		entryContainer = new SlideDownContainer("entryContainer", VisibilityEnum.HIDE) {

			//			@Override
			//			protected void onConfigure() {
			//				super.onConfigure();
			//				setVisible(text.getObject() != null);
			//			}
		};
		entryContainer.add(new Label("label", text));

		// entryContainer.setOutputMarkupId(true);
		entryContainer.setOutputMarkupPlaceholderTag(true);

		add(new Label("label", Model.of("Gelaber Rhabarber")));
		add(new Label("value", Model.of("This is a value")));
		add(entryContainer);
	}

	@Override
	public void renderHead(final IHeaderResponse response) {
		response.render(new PriorityHeaderItem(CssHeaderItem.forReference(new CssResourceReference(getClass(), "apanel.css"))));

		//		// PriorityHeaderItem spült die css ganz an den Anfang
		//		response.render(new PriorityHeaderItem(CssHeaderItem.forReference(new CssResourceReference(getClass(), "apage-template.css"))));
		//		response.render(new PriorityHeaderItem(CssHeaderItem.forReference(new CssResourceReference(getClass(), "apage-template-second.css"))));
	}

	private class ButtonUsabilityBehavior extends Behavior {

		private final IModel<Boolean> buttonUsabilityModel;

		public ButtonUsabilityBehavior(IModel<Boolean> buttonUsabilityModel) {
			this.buttonUsabilityModel = buttonUsabilityModel;
		}

		@Override
		public void onConfigure(Component component) {
			component.setEnabled(buttonUsabilityModel.getObject());
		}

		@Override
		public void bind(Component component) {
			super.bind(component);
			IModel<String> gruenOrGrau = new AbstractReadOnlyModel<String>() {

				@Override
				public String getObject() {
					if (buttonUsabilityModel.getObject()) {
						return "gruen";
					}
					return "grau";
				}
			};

			component.add(new AttributeAppender("class", gruenOrGrau, " "));
		}
	}

}
