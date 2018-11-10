package org.md.util.scraper;

/**
 * Data holding object for data scraped from web page.
 * 
 * @author Cameron
 */
public class ScrapedDataModel {

	private String name;
	private String type;
	private String payload;

	/**
	 * Empty constructor
	 */
	public ScrapedDataModel() {
		super();
		name = "";
		type = "";
		payload = "";
	}

	/**
	 * Constructor loaded with all three String variables to be held in object.
	 * 
	 * @param name
	 *            String name of the data being stored.
	 * @param type
	 *            String type of the data being stored.
	 * @param payload
	 *            String the payload, the sought after content, or the data scrape.
	 */
	public ScrapedDataModel(String name, String type, String payload) {
		super();
		this.name = name;
		this.type = type;
		this.payload = payload;
	}

	/**
	 * Constructor used to copy an existing Model.
	 * 
	 * @param obj
	 *            ScrapedDataModel being copied. If null, initializes variables as
	 *            empty Strings.
	 */
	public ScrapedDataModel(ScrapedDataModel obj) {
		super();
		this.name = (obj != null ? obj.name : "");
		this.type = (obj != null ? obj.type : "");
		this.payload = (obj != null ? obj.payload : "");
	}

	/**
	 * Getter for name of data.
	 * 
	 * @return String of name data.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter for name data.
	 * 
	 * @param name
	 *            String to be set as name data.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Getter for type of data.
	 * 
	 * @return String of type data.
	 */
	public String getType() {
		return type;
	}

	/**
	 * Setter for type of data.
	 * 
	 * @param type
	 *            String to be set as type.
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Getter for payload data.
	 * 
	 * @return String of payload data
	 */
	public String getPayload() {
		return payload;
	}

	/**
	 * Setter for payload data of data.
	 * 
	 * @param payload
	 *            String to be set as payload.
	 */
	public void setPayload(String payload) {
		this.payload = payload;
	}

	@Override
	public String toString() {
		return "ScrapedDataModel [name=" + name + ", type=" + type + ", payload=" + payload + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((payload == null) ? 0 : payload.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		ScrapedDataModel other = (ScrapedDataModel) obj;
		if (payload == null) {
			if (other.payload != null) {
				return false;
			}
		} else if (!payload.equals(other.payload)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (type == null) {
			if (other.type != null) {
				return false;
			}
		} else if (!type.equals(other.type)) {
			return false;
		}
		return true;
	}
}
