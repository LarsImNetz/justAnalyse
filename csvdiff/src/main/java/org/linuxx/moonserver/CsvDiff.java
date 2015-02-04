package org.linuxx.moonserver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.StringTokenizer;

/**
 * Hello world!
 *
 */
public class CsvDiff {

	final File left;
	final File right;

	String[] headerLine;
	int currentLine;
	int currentColumn;

	public CsvDiff(final File left, final File right) {
		this.left = left;
		this.right = right;
		currentLine = 1;
		currentColumn = 0;
	}

	public void workOnFiles() throws IOException {
		String leftLine;
		String rightLine;
		try (InputStream leftfis = new FileInputStream(left);
				InputStreamReader leftisr = new InputStreamReader(leftfis, Charset.forName("UTF-8"));
				BufferedReader leftbr = new BufferedReader(leftisr);
				InputStream rightfis = new FileInputStream(right);
				InputStreamReader rightisr = new InputStreamReader(rightfis, Charset.forName("UTF-8"));
				BufferedReader rightbr = new BufferedReader(rightisr);) {
			String headLine = leftbr.readLine();
			rightbr.readLine();
			headerLine = headLine.split(";");
			while ((leftLine = leftbr.readLine()) != null && (rightLine = rightbr.readLine()) != null) {
				currentColumn = 0;
				workOnLine(leftLine, rightLine);
				++currentLine;
			}
			if(leftbr.readLine() != null) {
				throw new IOException("left has more lines");
			}
			if(rightbr.readLine() != null) {
				throw new IOException("right has more lines");
			}
			leftbr.close();
			rightbr.close();
		}
		catch(IOException ex) {
			System.out.println("IOException caught " + ex.getMessage());
		}
	}

	public void workOnLine(final String leftLine, final String rightLine) {
		StringTokenizer leftTokenizer = new StringTokenizer(leftLine, ";");
		StringTokenizer rightTokenizer = new StringTokenizer(rightLine, ";");

		while (leftTokenizer.hasMoreTokens() && rightTokenizer.hasMoreTokens()) {
			String leftToken = leftTokenizer.nextToken();
			String rightToken = rightTokenizer.nextToken();
			if (!leftToken.equals(rightToken)) {
				illegalState(leftToken, rightToken);
			}
			++currentColumn;
		}
		if (leftTokenizer.hasMoreTokens()) {
			throw new IllegalStateException("left has more token");
		}
		if (rightTokenizer.hasMoreTokens()) {
			throw new IllegalStateException("right has more token");
		}
	}

	private void illegalState(String leftToken, String rightToken) {
		System.out.println("token differ: line=" + currentLine + " column='" + headerLine[currentColumn] + "'");
		System.out.println(" left='" + leftToken + "'");
		System.out.println("right='" + rightToken + "'");
	}

	public static void main(String[] args) throws IOException {
		String leftFilename = args[0];
		File left = new File(leftFilename);
		if (!left.exists()) {
			throw new java.io.FileNotFoundException("left does not exists");
		}
		String rightFilename = args[1];
		File right = new File(rightFilename);
		if (!right.exists()) {
			throw new java.io.FileNotFoundException("right does not exists");
		}

		CsvDiff diff = new CsvDiff(left, right);
		diff.workOnFiles();
	}
}
