package week5.day2.assignments;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ProjectSpecificMethods {
		public RemoteWebDriver driver;
		public String excelFilePath;
		@Parameters("URL")
		@BeforeMethod
		public void invokeBrowser(String url) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		}
		@AfterMethod
		public void postConditions()
		{
			driver.close();
		}
		
		@DataProvider(name = "Data_from_excel")
		public String[][] testData() throws IOException {
			String[][] data = ReadExcel.getData(excelFilePath);
			return data;
		}
}
