package apache;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Lists;

public class VHostInterpreter {

	private static Logger LOGGER = LoggerFactory.getLogger(VHostInterpreter.class);

	private final File file;

	public VHostInterpreter(final File file) {
		this.file = file;
	}

	private int lineNumber = 1;

	public List<VirtualHost> interpret() {
		final List<VirtualHost> virtualHosts = Lists.newArrayList();

		try (FileInputStream inputStream = new FileInputStream(file); BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {

			String currentLine;
			while ((currentLine = reader.readLine()) != null) {
				final String trimmedLine = currentLine.trim();

				final VirtualHost virtualHost = handleCurrentLine(trimmedLine);
				if (virtualHost != null) {
					virtualHosts.add(virtualHost);
				}
				lineNumber++;
			}
			if (inVirtualHost) {
				throw new IllegalStateException("Der <VirtualHost> State wurde nicht verlassen: " + file.getName());
			}
			reader.close();
			inputStream.close();
			return virtualHosts;
		}
		catch (final IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private boolean inVirtualHost = false;
	private String serverName;
	private String serverAdmin;
	private VirtualHost.Redirect redirect;
	private List<String> serverAliases;

	private VirtualHost handleCurrentLine(final String line) {
		VirtualHost virtualHost = null;
		final String lowercaseLine = line.toLowerCase();
		if (lowercaseLine.startsWith("<virtualhost")) {
			inVirtualHost = true;
			serverName = null;
			serverAdmin = null;
			redirect = null;
			serverAliases = null;		
		}
		else if (lowercaseLine.startsWith("</virtualhost>")) {
			virtualHost = new VirtualHost(serverAdmin, serverName, serverAliases, redirect);
			inVirtualHost = false;
		}
		else if (inVirtualHost) {
			final String[] split = line.split("\\s+");
			if (lowercaseLine.startsWith("serveradmin")) {
				serverAdmin = split[1];
			}
			else if (lowercaseLine.startsWith("servername")) {
				serverName = split[1];
			}
			else if (lowercaseLine.startsWith("serveralias")) {
				if (serverAliases == null) {
					serverAliases = Lists.newArrayList();
				}
				for (int i = 1; i < split.length; i++) {
					serverAliases.add(split[i]);
				}
			}
			else if (lowercaseLine.startsWith("redirect")) {
				// Redirect permanent / https://www.vergleich.de/ 
				redirect = new VirtualHost.Redirect(split[1], split[2], split[3]);
			}
			else if (lowercaseLine.startsWith("redirectmatch")) {
				// RedirectMatch 301 (.*)  http://www.qualitypool.de 
				redirect = new VirtualHost.Redirect(split[1], split[2], split[3]);
			}
			else {
				LOGGER.warn("Unbekannter State (" + split[0] + ") in Zeile: " + lineNumber + " Content: " + line);
			}
		}
		return virtualHost;
	}
}
