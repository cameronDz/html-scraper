package org.md.util.scraper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Used to extract String content of an assumed HTML file.
 * @author Cameron
 */
public class HtmlFileReader {

	/**
	 * Empty constructor.
	 */
	public HtmlFileReader() {
		super();
	}

	/**
	 * Gets the content of a file as a String.
	 * 
	 * @param fileName
	 *            String of filename assumed to be an HTML file for scraping.
	 * @return String of content of file provided by in the parameter. If any
	 *         IOException occurs, it will be caught and an empty String will
	 *         returned.
	 */
	public String readFileAsString(String fileName) {
		String ret = "";
		FileReader reader;
		BufferedReader br;
		try {
			reader = new FileReader(fileName);
			br = new BufferedReader(reader);
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			while (line != null) {
				sb.append(line).append("\n");
				line = br.readLine();
			}
			br.close();
			reader.close();
			ret = sb.toString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ret;
	}
}
