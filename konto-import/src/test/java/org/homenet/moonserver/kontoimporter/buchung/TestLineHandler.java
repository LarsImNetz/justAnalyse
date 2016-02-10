package org.homenet.moonserver.kontoimporter.buchung;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class TestLineHandler {
	
	private final CSVLineSplitter linesplitter = Mockito.mock(CSVLineSplitter.class);
	private final CSVBuchungFactory csvBuchungFactory = Mockito.mock(CSVBuchungFactory.class);
	private final LineHandler lineHandler = new LineHandler(linesplitter, csvBuchungFactory);

	@Test
	public void testHandleCurrentLineNoFormat() throws Exception {
		
		final String line = "a;b;c";
		Mockito.when(csvBuchungFactory.create(line)).thenReturn(BuchungFormatEnum.format1);

		Assert.assertNull(lineHandler.getFormat());

		lineHandler.handleCurrentLine(line, 1);
		
		Assert.assertEquals(BuchungFormatEnum.format1, lineHandler.getFormat());
		
		// wir wollen nur wissen, ob die entsprechenden Funktionen aufgerufen wurden
		Mockito.verify(csvBuchungFactory, Mockito.times(1)).create(line);
	}
	
	@Test
	public void testHandleCurrentLineWithFormatSet() throws Exception {
		final String line = "a;b;c";
		final String[] splitAnswer = {"a"};
		Mockito.when(linesplitter.split(line)).thenReturn(splitAnswer);

		lineHandler.setFormat(BuchungFormatEnum.format1);

		/* final IBuchung buchung = */ lineHandler.handleCurrentLine(line, 1);

		// wir wollen nur wissen, ob die entsprechenden Funktionen aufgerufen wurden
		Mockito.verify(linesplitter, Mockito.times(1)).split(line);
		Mockito.verify(csvBuchungFactory, Mockito.times(1)).create(BuchungFormatEnum.format1, splitAnswer);
	}
}
