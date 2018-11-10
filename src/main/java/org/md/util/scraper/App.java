package org.md.util.scraper;

import java.util.List;

/**
 * Used to scrape an HTML page pulled from a web page stored in the PATH
 * provided.
 * 
 * @author Cameron
 */
public class App {

	private static final String PATH = "src/main/resources/index.html";

	public static void main(String[] args) {
		String fileContent = new HtmlFileReader().readFileAsString(PATH);
		List<ScrapedDataModel> data = new HtmlStringScraper().scrapeDataFromHtmlString(fileContent);
		String report = DataReportPrinter.printOutDataModelList(data);
		System.out.println(report);
	}
}
