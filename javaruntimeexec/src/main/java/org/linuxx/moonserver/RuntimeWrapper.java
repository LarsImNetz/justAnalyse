package org.linuxx.moonserver;

import java.io.IOException;
import java.util.List;

class RuntimeWrapper implements IRuntimeWrapper {

	@Override
	public Process exec(final List<String> commandList) throws IOException {
		// OLD return Runtime.getRuntime().exec(command);
		final Process p = new ProcessBuilder(commandList).start();
		return p;
	}
}
