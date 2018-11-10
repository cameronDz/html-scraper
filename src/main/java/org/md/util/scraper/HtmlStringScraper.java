package org.md.util.scraper;

import java.util.ArrayList;
import java.util.List;

/**
 * Scrapes data from an HTML file based on static Strings assumed to be tags in
 * the HTML file that surround the desired data.
 * 
 * @author Cameron
 */
public class HtmlStringScraper {

	private static final String INNER = "";
	private static final String OUTER = "";

	private static final String FIRST_NAME_TAG = "";
	private static final String SECOND_NAME_TAG = "";

	private static final String FIRST_TYPE_TAG = "";
	private static final String SECOND_TYPE_TAG = "";

	private static final String FIRST_PAYLOAD_TAG = "";
	private static final String SECOND_PAYLOAD_TAG = "";

	/**
	 * 
	 */
	public HtmlStringScraper() {
		super();
	}

	/**
	 * Takes an input String of an assumed HTML with a list/collection of data
	 * blocks, each surrounded by INNER and OUTER tags.
	 * 
	 * @param html
	 *            String of an HTML file.
	 * @return List of ScrapedDataModel objects scraped from HTML file. Empty list
	 *         if html String is null or empty.
	 */
	public List<ScrapedDataModel> scrapeDataFromHtmlString(String html) {
		List<ScrapedDataModel> list = new ArrayList<ScrapedDataModel>();
		if (html != null && !html.isEmpty()) {
			while (html.indexOf(INNER) != -1) {
				html = html.substring(html.indexOf(INNER) + INNER.length());
				String content = html.substring(0, html.indexOf(OUTER));
				ScrapedDataModel data = pullDataFromContent(content);
				list.add(data);
			}
		}
		return list;
	}

	/**
	 * Takes a content String and scrapes the data from between the name, type, and
	 * payload tags. Returns data in a data holding object,
	 * {@link ScrapedDataModel}.
	 * 
	 * @param content
	 *            String being expected
	 * @return ScrapedDataModel object holding any data that was scraped out from
	 *         between the tags.
	 */
	private ScrapedDataModel pullDataFromContent(String content) {
		ScrapedDataModel data = new ScrapedDataModel();
		data.setName(breakContentByTags(content, FIRST_NAME_TAG, SECOND_NAME_TAG));
		data.setType(breakContentByTags(content, FIRST_TYPE_TAG, SECOND_TYPE_TAG));
		data.setPayload(breakContentByTags(content, FIRST_PAYLOAD_TAG, SECOND_PAYLOAD_TAG));
		return data;
	}

	/**
	 * Retrieves the String content between the two provided tags with the white
	 * space cleaned out.
	 * 
	 * @param content
	 *            String to be split and scraped between two tags.
	 * @param firstTag
	 *            String first HTML tag that will be where the content String is
	 *            first cut off.
	 * @param secondTag
	 *            String second HTML tag that will cut off String content.
	 * @return String that is the content between the firstTag and secondTag
	 *         parameters. If either tag doesn't exist in the content String, or the
	 *         firstTag appears after the second tag, and empty String is returned.
	 */
	protected String breakContentByTags(String content, String firstTag, String secondTag) {
		String scrapedData = "";
		if (content != null && firstTag != null && secondTag != null) {
			int innerDataLimit = content.indexOf(firstTag);
			int outerDataLimit = content.indexOf(secondTag);
			if (innerDataLimit >= 0 && outerDataLimit >= 0) {
				innerDataLimit = innerDataLimit + firstTag.length();
				if (innerDataLimit < outerDataLimit) {
					scrapedData = content.substring(innerDataLimit, outerDataLimit);
				}
			}
		}
		return cleanWhiteSpace(scrapedData);
	}

	/**
	 * Used to clean any redundant white space from a String in order to limit white
	 * space to a single space character.
	 * 
	 * @param content
	 *            String being cleaned to whitespace.
	 * @return String of the content parameter with the whitespace limited to only
	 *         single space characters.
	 */
	protected String cleanWhiteSpace(String content) {
		StringBuilder sb = new StringBuilder();
		if (content != null && !content.isEmpty()) {
			content = content.replace("\n", "").replace("\r", "").trim();
			char[] ary = content.toCharArray();
			boolean prevWhiteSpace = false;
			for (char c : ary) {
				if (!prevWhiteSpace || c != ' ') {
					sb.append(c);
				}
				prevWhiteSpace = (c == ' ' ? true : false);
			}
		}
		return sb.toString();
	}
}
