package org.linuxx.moonserver;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.resource.PackageResourceReference;

/**
 * Application object for your web application. If you want to run this
 * application without deploying, run the Start class.
 * 
 * @see org.homelinux.moonserver.JettyStart#main(String[])
 */
public class WicketApplication extends WebApplication {

	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	@Override
	public Class<? extends WebPage> getHomePage() {
		return HomePage.class;
	}

	/**
	 * @see org.apache.wicket.Application#init()
	 */
	@Override
	public void init() {
		super.init();

		// mountSharedResource("/images/submit.jpg", new
		// ResourceReference(HomePage.class, "foo.jpg").getSharedResourceKey());

		// mountResource("bild.ico", new
		// PackageResourceReference(HomePage.class, "favicon.ico"));

		// add your configuration here

		mountResourcesFrom(this.getClass(), "org/linuxx/moonserver");
	}

	private void mountResourcesFrom(Class<? extends WicketApplication> clazz, String directory) {
		java.net.URL url = clazz.getResource(clazz.getSimpleName() + ".class");

		File[] files = new File(url.getPath()).getParentFile().listFiles();

		listOfResources = new ArrayList<String>();

		for (int i = 0; i < files.length; i++) {
			String fileName = files[i].getName();
			if (files[i].isFile() && mountableFiletype(fileName)) {
				mountResource(fileName, new PackageResourceReference(clazz, fileName));
				listOfResources.add(fileName);
			}
		}
	}

	private boolean mountableFiletype(String filename) {
		if (filename.endsWith("class")) {
			return false;
		}
		if (filename.endsWith(".html")) {
			return false;
		}
		if (filename.endsWith(".css")) {
			return false;
		}
		return true;
	}

	private static List<String> listOfResources;

	public static List<String> getListOfResources() {
		return listOfResources;
	}

}
