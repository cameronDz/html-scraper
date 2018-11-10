package org.md.util.scraper;

import static org.junit.Assert.*;

import org.junit.Test;

public class HtmlFileReaderTest {

	private static final String TEST_PATH = "src/test/resources/test.html";
	private static final HtmlFileReader READER = new HtmlFileReader();

	@Test
	public void readFileAsString_testHtmlFile_returnTestString() {
		String expected = "<!doctype html>";
		String actual = READER.readFileAsString(TEST_PATH).trim();
		assertEquals(expected, actual);
	}
}
