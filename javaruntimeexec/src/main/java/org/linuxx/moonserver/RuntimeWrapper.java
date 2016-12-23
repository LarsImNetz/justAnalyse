package org.linuxx.moonserver;

import java.io.IOException;

class RuntimeWrapper implements IRuntimeWrapper {

	@Override
	public Process exec(final String command) throws IOException {
		return Runtime.getRuntime().exec(command);
	}
}
