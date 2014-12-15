package de.linuxx.experimental.jquery.animation;

import java.util.Arrays;
import java.util.List;

import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.util.ListModel;

public class TablePanel extends Panel {

	public TablePanel(String id) {
		super(id);

		List<String> list = Arrays.asList("eine Zeile", "", "Noch eine Zeile", "", "Noch eine weitere Zeile", "", "und noch eine", "", "eine hab ich noch");
		IModel<List<String>> listModel = new ListModel<>(list);

		ListView<String> listview = new ListView<String>("tablerow", listModel) {

			// ROW
			@Override
			protected void populateItem(ListItem<String> item) {
				item.add(new APanel("item"));
				// item.add(new APanel("item"));
				// item.add(new Label("label", item.getModel()));
			}

		};
		add(listview);

	}
}
