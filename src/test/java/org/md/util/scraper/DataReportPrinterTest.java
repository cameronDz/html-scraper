package org.md.util.scraper;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class DataReportPrinterTest {

	private static List<ScrapedDataModel> data;

	@Before
	public void setUp() throws Exception {
		data = new ArrayList<ScrapedDataModel>();
	}

	@Test
	public void printOutDataModelList_emptyList_containsEmpty() {
		boolean expected = true;
		boolean actual = DataReportPrinter.printOutDataModelList(data).contains("[ERROR]");
		assertEquals(expected, actual);
	}

	@Test
	public void printOutDataModelList_noneEmptyList_containsInfo() {
		data.add(new ScrapedDataModel());
		boolean expected = true;
		boolean actual = DataReportPrinter.printOutDataModelList(data).contains("[INFO]");
		assertEquals(expected, actual);
	}
}
