package de.hypoport.einarbeitung;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.Page;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.AjaxSelfUpdatingTimerBehavior;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.util.ListModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.util.time.Duration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SecondPage extends WebPage {

	private final static Logger LOGGER = LoggerFactory.getLogger(SecondPage.class);

	private static final long serialVersionUID = 1L;

	private int counter = 0;
	private ListModel<String> listeModel;
	
	private transient SOAPEmulatingThread soapThread = null;

	SOAPEmulatingThread getThread() {
		if (soapThread == null) {
			soapThread = new SOAPEmulatingThread();
		}
		return soapThread;
	}

	public SecondPage() {
		LOGGER.debug("SecondPage() ctor");
		setResponsePage(HomePage.class);
	}

	@SuppressWarnings("serial")
	public SecondPage(final PageParameters parameters) {
		super(parameters);

		LOGGER.debug("SecondPage() with parameters");

		HomePage.sleep();

		final Form<Void> form = new Form<Void>("form") {

			@Override
			public void onError() {
				LOGGER.debug("Form Error");
				super.onError();
			}

			@Override
			public void onSubmit() {
				LOGGER.debug("Form Submit");
				super.onSubmit();
			}

		};

		final IModel<String> labelModel = new AbstractReadOnlyModel<String>() {

			@Override
			public String getObject() {
				++counter;
				LOGGER.debug("SecondPage() set label");
				final String label = parameters.get("label").toString();
				return label + " " + String.valueOf(counter);
			}
		};			

		final Label label = new Label("label", labelModel) {
				
			@Override
			protected void onConfigure() {
				setVisibilityAllowed(true);
				super.onConfigure();
			}
		};
		
		label.add(new AjaxSelfUpdatingTimerBehavior(Duration.seconds(3)));
		form.add(label);

		form.add(new Button("button") {

			@Override
			public void onError() {
				LOGGER.debug("Button Error");
				super.onError();
			}

			@Override
			public void onSubmit() {
				LOGGER.debug("Button Submit");
				setResponsePage(HomePage.class);
				super.onSubmit();
			}
		});

		add(form);

		final List<String> liste = new ArrayList<String>();
		listeModel = new ListModel<String>(liste);

		/*
		 * AjaxSelfUpdatingTimerBehavior
		 * hier wird ein Timer erstellt, der alle Sekunde ein Update ausführen soll
		 * am Ende jedes Updates wird geprüft, ob das Update noch ein weiteres mal gebraucht wird.
		 */
		final AjaxSelfUpdatingTimerBehavior ajaxSelfUpdatingTimerBehavior = new AjaxSelfUpdatingTimerBehavior(
				Duration.ONE_SECOND) {

			@Override
			protected void onPostProcessTarget(final AjaxRequestTarget target) {
				super.onPostProcessTarget(target);

				LOGGER.debug("post process target");
				if (getThread().isReady()) {
					LOGGER.debug("post process target was ready");

					this.stop(target);
				}
			}
		};

		/*
		 * Anzeigen der Liste.
		 */
		final ShowList showList = new ShowList("list", listeModel) {

			@Override
			public Page getZielPageHook(final PageParameters p) {
				final String gewaehlt = p.get("name").toString();
				p.add("label", gewaehlt);
				final Page newPage = new SecondPage(p);
				return newPage;
			}

			@Override
			protected void onConfigure() {
				super.onConfigure();

				LOGGER.debug("onConfigure");

				if (getThread().isReady()) {
					LOGGER.debug("was ready");
					listeModel.setObject(getThread().getListe());
					//					this.remove(ajaxSelfUpdatingTimerBehavior);
				}
			}
		};
		showList.add(ajaxSelfUpdatingTimerBehavior);
		showList.setOutputMarkupId(true);
		add(showList);

		/*
		 * Beim Drücken auf den Button showlist, wird über einen Thread eine Liste erstellt
		 */
		add(new AjaxLink<String>("showlist", Model.of("Klick mich")) {

			@Override
			public void onClick(final AjaxRequestTarget target) {
				LOGGER.debug("showlist");
				new Thread(getThread()).start();
			}

		});
	}

	/**
	 * Threaqd der eine Liste erstellt
	 */
	private class SOAPEmulatingThread implements Runnable {

		private boolean ready = false;
		private final Integer mutexReady = new Integer(4);
		private final Integer mutex = new Integer(5);
		private List<String> liste;

		@Override
		public void run() {
			LOGGER.debug("run");
			synchronized (mutexReady) {
				ready = false;
			}

			synchronized (mutex) {
				liste = ShowList.createList();
			}

			synchronized (mutexReady) {
				ready = true;
			}
			LOGGER.debug("run ready");
		}

		public boolean isReady() {
			final boolean result;
			synchronized (mutexReady) {
				result = ready;
			}

			return result;
		}

		public List<String> getListe() {
			final List<String> result;
			synchronized (mutex) {
				result = liste;
			}

			return result;
		}
	}

}
