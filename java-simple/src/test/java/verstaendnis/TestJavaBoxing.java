package verstaendnis;

import org.junit.Assert;
import org.junit.Test;


public class TestJavaBoxing {

	@Test
	public void test() {
		boolean lastresult = false;
		boolean runthrough = false;
        for (long l = 0 ; l < (65536L * 32768L); l++) {
        	Long a = Long.valueOf(l);
        	Long b = Long.valueOf(l);
        	boolean result = (a == b);
//        	boolean result = Long.valueOf(l) == Long.valueOf(l);
        	if (lastresult != result) {
        		System.out.println(l + ": " + (result));
        	}
        	lastresult = result;
        	runthrough = true;
        }
        Assert.assertTrue(runthrough);
	}
}
