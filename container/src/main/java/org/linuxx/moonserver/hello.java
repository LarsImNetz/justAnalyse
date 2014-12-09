package org.linuxx.moonserver;

import com.google.common.base.Preconditions;

public class hello  {
    public static void main( String[] argv ) {
		Preconditions.checkArgument(argv != null);
    	System.out.println("Hello World");
    }
}
