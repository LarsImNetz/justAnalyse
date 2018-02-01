package org.linuxx.moonserver;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlRootElement;

@Path("message")
public class MessageResource {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String message() {
		return "Yea!";
	}

	@GET
	@Path("serverinfo")
	@Produces({ MediaType.TEXT_XML, MediaType.APPLICATION_JSON })
	public ServerInfo serverinfo() {
		ServerInfo info = new ServerInfo();
		info.server = System.getProperty("os.name") + " " + System.getProperty("os.version");
		return info;
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("user/{user}")
	public String message(@PathParam("user") String user) {
		return String.format("Benutzer = %s", user);
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("user/{user}/search/{search}")
	public String message(@PathParam("user") String user, @PathParam("search") String search) {
		return String.format("Benutzer = %s, Suchstring = %s", user, search);
	}
}

@XmlRootElement
class ServerInfo {
	public String server;
}
