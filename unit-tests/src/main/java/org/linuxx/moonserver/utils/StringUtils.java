package org.linuxx.moonserver.utils;

import com.google.common.base.Preconditions;

public class StringUtils {

	public String reverse(String toReverse) {
		Preconditions.checkArgument(toReverse != null);

		StringBuilder reverseString = new StringBuilder();
		for (int i = toReverse.length() - 1; i >= 0; --i) {
			reverseString.append(toReverse.charAt(i));
		}
		return reverseString.toString();
	}
}
