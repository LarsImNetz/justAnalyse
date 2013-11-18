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

	private final static Logger logger = LoggerFactory.getLogger(SecondPage.class);

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
		logger.debug("SecondPage() ctor");
		setResponsePage(HomePage.class);
	}

	@SuppressWarnings("serial")
	public SecondPage(final PageParameters parameters) {
		super(parameters);

		logger.debug("SecondPage() with parameters");

		HomePage.sleep();

		Form<Void> form = new Form<Void>("form") {

			@Override
			public void onError() {
				logger.debug("Form Error");
				super.onError();
			}

			@Override
			public void onSubmit() {
				logger.debug("Form Submit");
				super.onSubmit();
			}

		};

		IModel<String> labelModel = new AbstractReadOnlyModel<String>() {

			@Override
			public String getObject() {
				++counter;
				logger.debug("SecondPage() set label");
				String label = parameters.get("label").toString();
				return label + " " + String.valueOf(counter);
			}
		};			

		Label label = new Label("label", labelModel) {
				
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
				logger.debug("Button Error");
				super.onError();
			}

			@Override
			public void onSubmit() {
				logger.debug("Button Submit");
				setResponsePage(HomePage.class);
				super.onSubmit();
			}
		});

		add(form);

		List<String> liste = new ArrayList<String>();
		listeModel = new ListModel<String>(liste);

		/*
		 * AjaxSelfUpdatingTimerBehavior
		 * hier wird ein Timer erstellt, der alle Sekunde ein Update ausführen soll
		 * am Ende jedes Updates wird geprüft, ob das Update noch ein weiteres mal gebraucht wird.
		 */
		final AjaxSelfUpdatingTimerBehavior ajaxSelfUpdatingTimerBehavior = new AjaxSelfUpdatingTimerBehavior(
				Duration.ONE_SECOND) {

			@Override
			protected void onPostProcessTarget(AjaxRequestTarget target) {
				super.onPostProcessTarget(target);

				logger.debug("post process target");
				if (getThread().isReady()) {
					logger.debug("post process target was ready");

					this.stop(target);
				}
			}
		};

		/*
		 * Anzeigen der Liste.
		 */
		final ShowList showList = new ShowList("list", listeModel) {

			@Override
			public Page getZielPageHook(PageParameters p) {
				String gewaehlt = p.get("name").toString();
				p.add("label", gewaehlt);
				Page newPage = new SecondPage(p);
				return newPage;
			}

			@Override
			protected void onConfigure() {
				super.onConfigure();

				logger.debug("onConfigure");

				if (getThread().isReady()) {
					logger.debug("was ready");
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
			public void onClick(AjaxRequestTarget target) {
				logger.debug("showlist");
				new Thread(getThread()).start();
			}

		});
	}

	/**
	 * Threaqd der eine Liste erstellt
	 */
	private class SOAPEmulatingThread implements Runnable {

		private boolean ready = false;
		private Integer mutexReady = new Integer(4);
		private Integer mutex = new Integer(5);
		private List<String> liste;

		@Override
		public void run() {
			logger.debug("run");
			synchronized (mutexReady) {
				ready = false;
			}

			synchronized (mutex) {
				liste = ShowList.createList();
			}

			synchronized (mutexReady) {
				ready = true;
			}
			logger.debug("run ready");
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
