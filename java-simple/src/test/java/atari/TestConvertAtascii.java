package atari;

import org.junit.Ignore;
import org.junit.Test;

public class TestConvertAtascii {

	private final String path = "/usr/local/src/lla.atarixl/software/eigenes/ataripath/";
	
	@Ignore
	@Test
	public void testCompiler() throws Exception {
		final String file = path + "COMPILER.LST";
		final String[] argv = { file };
		ConvertAtascii.main(argv);
	}

	@Ignore
	@Test
	public void testGetsym() throws Exception {
		final String file = path + "GETSYM.LST";
		final String[] argv = { file };
		ConvertAtascii.main(argv);
	}

	@Ignore
	@Test
	public void testAusdruck2() throws Exception {
		final String file = path + "AUSDRCK2.LST";
		final String[] argv = { file };
		ConvertAtascii.main(argv);
	}

	@Ignore
	@Test
	public void testAusdruck() throws Exception {
		final String file = path + "AUSDRUCK.LST";
		final String[] argv = { file };
		ConvertAtascii.main(argv);
	}

	@Ignore
	@Test
	public void testFacio() throws Exception {
		final String file = path + "FACIO.LST";
		final String[] argv = { file };
		ConvertAtascii.main(argv);
	}

	@Ignore
	@Test
	public void testZahlen() throws Exception {
		final String file = path + "ZAHLEN.LST";
		final String[] argv = { file };
		ConvertAtascii.main(argv);
	}

	@Ignore
	@Test
	public void testZahlen2() throws Exception {
		final String file = path + "ZAHLEN2.LST";
		final String[] argv = { file };
		ConvertAtascii.main(argv);
	}

	@Ignore
	@Test
	public void testAusdruckFlp() throws Exception {
		final String file = path + "AUSDRFLP.LST";
		final String[] argv = { file };
		ConvertAtascii.main(argv);
	}

}
