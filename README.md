# HTML Scraper #
Simple HTML file scraped that examines HTML files for specific tages, and scrapes the data from those tags.

## Run ##
Basic run command:

```
mvn clean install exec:java -Dexec.mainClass
```
Running the above command currently points at /src/main/resources/index.html, which is an empty HTML file. All TAGS to used for scraping are in the HtmlStringScraper class, and need to be modified in order to pull the correct data from the desired HTML file.

## Test Coverage ##
Testing using JUnit 4 framework, and using reporting from [Maven JaCoCo plugin](https://www.baeldung.com/jacoco "Baeldung Intro to JaCoCo"), applications has 67% test coverage.

To run the JUnit tests with Maven, and get a JaCoCo report, run the following command.

```
mvn clean package
```
The JaCoCo report will be located in the /target/site/jacoco/index.html file. Open the index.html in a web browser to navigate the tests.
