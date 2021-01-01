package com.atmecs.yatra.constants;

import java.io.File;

public class FilePathClass {

	public final static String USER_HOME = System.getProperty("user.dir") + File.separator;
	public final static String RESOURCES_HOME = USER_HOME + File.separator + "src" + File.separator + "main"
			+ File.separator + "resources" + File.separator;
	public final static String CHROME_DRIVER_PATH = USER_HOME + File.separator + "lib" + File.separator + "ChromeDriver"
			+ File.separator + "chromedriver.exe" + File.separator;
	public final static String CONFIGURATION_HOME = RESOURCES_HOME + File.separator + "configuration.properties"
			+ File.separator;

	public final static String GECKO_DRIVER_PATH = USER_HOME + File.separator + "lib" + File.separator + "FireFox"
			+ File.separator + "geckodriver.exe" + File.separator;
	public final static String LOCATORS_HOME = RESOURCES_HOME + File.separator + "locators" + File.separator
			+ "locatorsPath.properties" + File.separator;
	public final static String XLSX_DATA_HOME = RESOURCES_HOME + File.separator + "xlsxFile" + File.separator
			+ "dataFile.xlsx" + File.separator;
}
