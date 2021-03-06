package dataProviders;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import enums.DriverType;
import enums.EnvironmentType;
import util.Constants;

public class ConfigFileReader {
	private Properties properties;
	private final String propertyFilePath = Constants.PROPERTY_PATH;

	public ConfigFileReader() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties não encontrado em " + propertyFilePath);
		}
	}

	public String getDriverChromePath() {
		String driverPath = properties.getProperty("driverPathChrome");
		if (driverPath != null)
			return driverPath;
		else
			throw new RuntimeException(
					"Driver Path not specified in the Configuration.properties file for the Key:driverPath");
	}
	public String getDriverFirefoxPath() {
		String driverPath = properties.getProperty("driverPathFirefox");
		if (driverPath != null)
			return driverPath;
		else
			throw new RuntimeException(
					"Driver Path not specified in the Configuration.properties file for the Key:driverPath");
	}

	public String getDriverIEPath() {
		String driverPath = properties.getProperty("driverPathIE");
		if (driverPath != null)
			return driverPath;
		else
			throw new RuntimeException(
					"Driver Path not specified in the Configuration.properties file for the Key:driverPath");
	}

	public long getImplicitlyWait() {
		String implicitlyWait = properties.getProperty("implicitlyWait");
		if (implicitlyWait != null) {
			try {
				return Long.parseLong(implicitlyWait);
			} catch (NumberFormatException e) {
				throw new RuntimeException("Not able to parse value : " + implicitlyWait + " in to Long");
			}
		}
		return 30;
	}

	public String getApplicationUrl() {
		String url = properties.getProperty("url");
		if (url != null)
			return url;
		else
			throw new RuntimeException(
					"Application Url not specified in the Configuration.properties file for the Key:url");
	}

	public DriverType getBrowser() {
		String browserName = properties.getProperty("browser");
		if (browserName == null || browserName.equals("chrome"))
			return DriverType.CHROME;
		else if (browserName.equalsIgnoreCase("firefox"))
			return DriverType.FIREFOX;
		else if (browserName.equals("iexplorer"))
			return DriverType.INTERNETEXPLORER;
		else
			throw new RuntimeException(
					"Browser Name Key value in Configuration.properties is not matched : " + browserName);
	}

	public EnvironmentType getEnvironment() {
		String environmentName = properties.getProperty("environment");
		if (environmentName == null || environmentName.equalsIgnoreCase("local"))
			return EnvironmentType.LOCAL;
		else if (environmentName.equals("remote"))
			return EnvironmentType.REMOTE;
		else
			throw new RuntimeException(
					"Environment Type Key value in Configuration.properties is not matched : " + environmentName);
	}

	public Boolean getBrowserWindowSize() {
		String windowSize = properties.getProperty("windowMaximize");
		if (windowSize != null)
			return Boolean.valueOf(windowSize);
		return true;
	}

	public String getReportConfigPath() {
		String reportConfigPath = properties.getProperty("reportConfigPath");
		if (reportConfigPath != null)
			return reportConfigPath;
		else
			throw new RuntimeException(
					"Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");
	}

	public String getPrintPath() {
		String printPath = properties.getProperty("printsPath");
		if (printPath != null)
			return printPath;
		else
			throw new RuntimeException("Configure o caminho para salvar os prints do PDF");
	}

	public String getReportPdfPath() {
		String reportPdfPath = properties.getProperty("relatoriPdfPath");
		if (reportPdfPath != null)
			return reportPdfPath;
		else
			throw new RuntimeException("Configure o caminho para salvar o relatorio PDF");

	}

	public String getReportVideoPath() {
		String reportVideoPath = properties.getProperty("relatorioVideoPath");
		if (reportVideoPath != null)
			return reportVideoPath;
		else
			throw new RuntimeException("Configure o caminho para salvar o relatorio em Video");
	}
	public String getExcelPath() {
		String excelPath = properties.getProperty("excelFile");
		if (excelPath != null)
			return excelPath;
		else
			throw new RuntimeException("Configure o caminho da planilha Excel");
	}
	public String getImageProject() {
		String imagePath = properties.getProperty("imageProject");
		if (imagePath!=null) {
			return imagePath;
			
		}else return null;
	}

}