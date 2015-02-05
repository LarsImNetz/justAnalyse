package de.lla.tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.StringTokenizer;

/**
 * Primitiver Differ, der auf CSV (Comma)Semikolon Separated Values arbeitet!
 *
 */
public class CsvDiff {

	final File left;
	final File right;

	// for Status
	String[] headerLine;

	int currentLine = 1;
	int currentColumn;

	int exitStatus = 0;

	public CsvDiff(final File left, final File right) {
		this.left = left;
		this.right = right;
		currentLine = 1;
		currentColumn = 0;
	}

	public int getExitStatus() {
		return exitStatus;
	}

	public void workOnFiles() throws IOException {
		try (InputStream leftfis = new FileInputStream(left);
		        InputStreamReader leftisr = new InputStreamReader(leftfis, Charset.forName("UTF-8"));
		        BufferedReader leftReader = new BufferedReader(leftisr);
		        InputStream rightfis = new FileInputStream(right);
		        InputStreamReader rightisr = new InputStreamReader(rightfis, Charset.forName("UTF-8"));
		        BufferedReader rightReader = new BufferedReader(rightisr);) {

			workOnLines(leftReader, rightReader);

			leftReader.close();
			rightReader.close();
		} catch (IOException ex) {
			System.out.println("IOException caught " + ex.getMessage());
			exitStatus = 1;
		}
	}

	private void workOnLines(BufferedReader leftReader, BufferedReader rightReader) throws IOException {
		String leftLine;
		String rightLine;
		String headLine = leftReader.readLine();
		rightReader.readLine();
		headerLine = headLine.split(";");
		while ((leftLine = leftReader.readLine()) != null && (rightLine = rightReader.readLine()) != null) {
			currentColumn = 0;
			workOnOneLine(leftLine, rightLine);
			++currentLine;
		}
		if (leftReader.readLine() != null) {
			exitStatus = 1;
			throw new IOException("left has more lines");
		}
		if (rightReader.readLine() != null) {
			exitStatus = 1;
			throw new IOException("right has more lines");
		}
	}

	public void workOnOneLine(final String leftLine, final String rightLine) {
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
			exitStatus = 1;
			throw new IllegalStateException("left has more token");
		}
		if (rightTokenizer.hasMoreTokens()) {
			exitStatus = 1;
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
		System.exit(diff.getExitStatus());
	}
}
