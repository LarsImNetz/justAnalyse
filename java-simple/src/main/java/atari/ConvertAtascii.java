package atari;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConvertAtascii {

	public static void main(String[] argv) throws IOException {
		FileInputStream inputStream = new FileInputStream(argv[0]);

		InputStreamReader reader = new InputStreamReader(inputStream, "iso-8859-1");
		BufferedReader read = new BufferedReader(reader);

		int value;
		while ((value = read.read()) != -1) {
			if (value == 0x9b) {
				value = '\n';
			}
			if (value > 127) {
				value -= 128;
			}
			System.out.print((char) value);
		}

		read.close();
		reader.close();
		inputStream.close();
	}
}
