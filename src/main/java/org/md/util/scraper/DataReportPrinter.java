package org.md.util.scraper;

import java.util.List;

/**
 * Service class used to print out a gathered list of data from a scraped HTML
 * page.
 * 
 * @author Cameron
 */
public final class DataReportPrinter {

	/**
	 * Hidden constructor
	 */
	private DataReportPrinter() {
		// empty
	}

	/**
	 * Creates a String printing out the {@link ScrapedDataModel}s from the scraped
	 * web page.
	 * 
	 * @param data
	 *            List of ScrapedDataModel objects to be printed out.
	 * @return String for printing out resulting ScrapedDataModel list. Will include
	 *         an error message if not datum was in list.
	 */
	public static String printOutDataModelList(List<ScrapedDataModel> data) {
		StringBuilder sb = new StringBuilder();
		sb.append("================================================================================\n");
		sb.append("================= The resulting data from the scraped web page =================\n");
		if (data == null || data.isEmpty()) {
			sb.append("[ERROR] Unable to scrape data from provided source.\n");
		} else {
			for (int i = 0; i < data.size(); i++) {
				sb.append("[INFO] ScrapedDataModel #");
				sb.append(i + 1);
				sb.append(" from webpage:\n");
				sb.append("[INFO] ");
				sb.append(data.get(i).toString());
				sb.append("\n");
			}
		}
		sb.append("================================================================================");
		return sb.toString();
	}
}
