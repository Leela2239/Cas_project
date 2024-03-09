package Base;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.ITestListener;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


import io.github.bonigarcia.wdm.WebDriverManager;

public class base implements ITestListener{
	
	public static WebDriver driver;
	public static List<WebElement> news; 
	static File file;
	static FileInputStream fis1;
	public static Properties p1;
	public static String str1;
	

	static File file1;
	static FileInputStream fis;
	public static Properties p;
	public static String str;
	

	@BeforeClass
	@Parameters({"browser"})
	public  void driverSetup(String br) throws InterruptedException, IOException {
		
		if(br.equals("chrome")){
			ChromeOptions option=new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver(option);
			System.out.println("Chrome Browser Launched Successfully");
		
		}
		else if(br.equals("edge")) {
			EdgeOptions option = new EdgeOptions();
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver(option);
			System.out.println("Edge Browser Launched Successfully");
		}

		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		
		driver.get("https://cognizantonline.sharepoint.com/sites/Be.Cognizant/SitePages/Home.aspx");
		driver.manage().window().maximize();
		
		

	}
	

	
	
	@AfterClass
	public void closeBrowser()
	{
		driver.quit();
		
	}
}
	
