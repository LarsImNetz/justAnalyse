package de.hypoport.einarbeitung;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.Page;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class ShowList extends Panel {

	private static final Logger LOGGER = LoggerFactory.getLogger(ShowList.class);
	
	public ShowList(final String id, final IModel<List<String>> liste) {
		super(id);

		add(new ListView<String>("list", liste) {

			@Override
			protected void populateItem(final ListItem<String> item) {
				final String teilnehmer = item.getModelObject();

				final Label label = new Label("name", teilnehmer); // Setzen eines simplen Labels
				item.add(label);

				// Setzen eines Labels innerhalb eines Links
				final Link<Void> link = new Link<Void>("link") {

					@Override
					public void onClick() {
						final PageParameters p = new PageParameters();
						p.add("name", teilnehmer);

						// Wir holen aus einer extern zu erstellenden Funktion das Sprungziel
						setResponsePage(getZielPageHook(p));
					}
				};

				final Label label2 = new Label("name", teilnehmer);
				link.add(label2);
				item.add(link);

			}
		});

	}

	public abstract Page getZielPageHook(PageParameters p);

	public static List<String> createList() {

		// Füllen einer Pseudo-Liste
		final List<String> liste = new ArrayList<String>();
		final String[] strings = {"Anakin Skywalker", "Ben Obi-Wan Kenobi", "Luke Skywalker", "Leia Organa", "Han Solo",
				"Darth Vader", "Boba Fett", "Jabba the Hutt", "R2 D2", "C-3P0", "Lando Calrissian", "Qui-Gon Jinn",
				"Padme Amidala", "Darth Maul", "Mace Windu", "Yoda", "Chewbacca"};

		for (final String f : strings) {
			final String name = f;
			liste.add(name);

			try {
				Thread.sleep(2 * 1000 / strings.length);
			} catch (final InterruptedException e) {
				LOGGER.error(e.getMessage());
			}
		}
		return liste;

	}
}
