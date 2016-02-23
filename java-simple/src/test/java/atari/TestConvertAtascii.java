package atari;

import org.junit.Test;

public class TestConvertAtascii {

	private String path = "/usr/local/src/lla.atarixl/software/eigenes/ataripath/";
	
	@Test
	public void testCompiler() throws Exception {
		String file = path + "COMPILER.LST";
		String[] argv = { file };
		ConvertAtascii.main(argv);
	}

	@Test
	public void testGetsym() throws Exception {
		String file = path + "GETSYM.LST";
		String[] argv = { file };
		ConvertAtascii.main(argv);
	}

	@Test
	public void testAusdruck2() throws Exception {
		String file = path + "AUSDRCK2.LST";
		String[] argv = { file };
		ConvertAtascii.main(argv);
	}

	@Test
	public void testAusdruck() throws Exception {
		String file = path + "AUSDRUCK.LST";
		String[] argv = { file };
		ConvertAtascii.main(argv);
	}

	@Test
	public void testFacio() throws Exception {
		String file = path + "FACIO.LST";
		String[] argv = { file };
		ConvertAtascii.main(argv);
	}

	@Test
	public void testZahlen() throws Exception {
		String file = path + "ZAHLEN.LST";
		String[] argv = { file };
		ConvertAtascii.main(argv);
	}

	@Test
	public void testZahlen2() throws Exception {
		String file = path + "ZAHLEN2.LST";
		String[] argv = { file };
		ConvertAtascii.main(argv);
	}

	@Test
	public void testAusdruckFlp() throws Exception {
		String file = path + "AUSDRFLP.LST";
		String[] argv = { file };
		ConvertAtascii.main(argv);
	}

}
