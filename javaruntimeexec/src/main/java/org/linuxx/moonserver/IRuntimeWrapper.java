package org.linuxx.moonserver;

import java.io.IOException;

interface IRuntimeWrapper {

	Process exec(String command) throws IOException;

}