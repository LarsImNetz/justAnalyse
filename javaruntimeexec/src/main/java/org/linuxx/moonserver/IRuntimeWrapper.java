package org.linuxx.moonserver;

import java.io.IOException;
import java.util.List;

interface IRuntimeWrapper {

	Process exec(final List<String> command) throws IOException;

}
