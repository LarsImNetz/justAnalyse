package de.hypoport.einarbeitung;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;

import com.googlecode.wicket.jquery.ui.form.slider.Slider;

public class SliderPanel extends Panel {

	public SliderPanel(String id) {
		super(id);
		
		final Form<Integer> form = new Form<Integer>("form", new Model<Integer>(15));
		this.add(form);


		// Sliders //
		final Label label = new Label("label", form.getModel()); //the supplied model allows the initial display
		form.add(label);
		
		form.add(new Slider("slider", form.getModel(), label)); //will use the html markupId
		
	}

}
