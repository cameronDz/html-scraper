package org.md.util.scraper;

import static org.junit.Assert.*;

import org.junit.Test;

public class HtmlStringScraperTest {

	private static final HtmlStringScraper SCRAPER = new HtmlStringScraper();

	private static final String FIRST_TAG = "firstTag";
	private static final String SECOND_TAG = "secondTag";

	@Test
	public void breakContentByTags_firstTagNotInContent_returnEmptyString() {
		String content = "this content lacks first-tag but has " + SECOND_TAG + " in it";
		String expected = "";
		String actual = SCRAPER.breakContentByTags(content, FIRST_TAG, SECOND_TAG);
		assertEquals(expected, actual);
	}

	@Test
	public void breakContentByTags_secondTagNotInContent_returnEmptyString() {
		String content = "this content has " + FIRST_TAG + " but lacks second-tag";
		String expected = "";
		String actual = SCRAPER.breakContentByTags(content, FIRST_TAG, SECOND_TAG);
		assertEquals(expected, actual);
	}

	@Test
	public void breakContentByTags_firstTagAfterSecondTag_returnEmptyString() {
		String content = "this content has the " + SECOND_TAG + " but " + FIRST_TAG + " is after it";
		String expected = "";
		String actual = SCRAPER.breakContentByTags(content, FIRST_TAG, SECOND_TAG);
		assertEquals(expected, actual);
	}

	@Test
	public void breakContentByTags_firstTagBeforeSecondTag_returnStringBetweenTags() {
		String content = "this content has the " + FIRST_TAG + " and " + SECOND_TAG + " is after it";
		String expected = "and";
		String actual = SCRAPER.breakContentByTags(content, FIRST_TAG, SECOND_TAG);
		assertEquals(expected, actual);
	}

	@Test
	public void cleanWhiteSpace_hasNewLinesWithMultipleSpaces_cleanExtraWhitespace() {
		String dirty = "\n   \r   Testing,  testing.. \r TEST!";
		String expected = "Testing, testing.. TEST!";
		String actual = SCRAPER.cleanWhiteSpace(dirty);
		assertEquals(expected, actual);
	}

}
