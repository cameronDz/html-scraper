package org.md.util.scraper;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class ScrapedDataModelTest {

	private static final ScrapedDataModel FULL_MODEL = new ScrapedDataModel("name", "type", "payload");

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void contructor_modelParam_equalObjs() {
		ScrapedDataModel expected = FULL_MODEL;
		ScrapedDataModel actual = new ScrapedDataModel(FULL_MODEL);
		assertEquals(expected, actual);
	}

	@Test
	public void constructor_emptyParam_equalObjs() {
		ScrapedDataModel expected = FULL_MODEL;
		ScrapedDataModel actual = new ScrapedDataModel();
		actual.setName(FULL_MODEL.getName());
		actual.setType(expected.getType());
		actual.setPayload(expected.getPayload());
		assertEquals(expected, actual);
	}

	@Test
	public void toString_nullConstructor_expectedString() {
		ScrapedDataModel model = new ScrapedDataModel(null);
		String expected = "ScrapedDataModel [name=, type=, payload=]";
		String actual = model.toString();
		assertEquals(expected, actual);
	}

}
