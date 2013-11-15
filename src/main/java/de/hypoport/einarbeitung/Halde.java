package de.hypoport.einarbeitung;

/**
 * Stuff, den ich nicht vergessen möchte
 */
public class Halde {

	private Halde() {

		// Diese ist eine nicht ganz saubere Möglichkeit etwas zu senden.
		// Nachteile:
		// Wicket ist nicht mehr zuständig für
		// - Fehler werden nicht mehr gesendet, ab hier Status 200!
		// - setResponsePage(...) geht ab hier nicht mehr, da Status 200 gesendet wird
		// - redirects gehen nicht, da die Seite fertig gemeldet wird.
		//
		//		javax.servlet.http.HttpServletResponse x = (javax.servlet.http.HttpServletResponse) this.getRequestCycle().getResponse().getContainerResponse();
		//		x.getWriter().write("<!-- WURST -->\r\n");
		//		x.flushBuffer();

		// Macht den Stream kaputt!!!
		//		OutputStream outputStream = this.getResponse().getOutputStream();
		//		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
		//		try {
		//			writer.write("<!-- wurst -->\r\n");
		//			writer.flush();
		//
		//		} catch (IOException e) {
		//			// ebenfalls wurst
		//		}

	}
}
