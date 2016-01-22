package apache;

import java.util.List;

public class VirtualHost {
	final String serverAdmin;
	final String serverName;
	final List<String> serverAliases;
	final Redirect redirect;

	public VirtualHost(final String serverAdmin, final String serverName, final List<String> serverAlias, final Redirect redirect) {
		this.serverAdmin = serverAdmin;
		this.serverName = serverName;
		this.serverAliases = serverAlias;
		this.redirect = redirect;
	}
	
	public static class Redirect {
		final String filter;
		final String state;
		final String url;
		
		public Redirect(final String state, final String filter, final String url) {
			this.filter = filter;
			this.state = state;
			this.url = url;
		}
	}
}
