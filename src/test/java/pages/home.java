package pages;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import Base.base;


public class home extends base{
		//locators
		By Get_text = By.xpath("//*[@id=\'getting-social\']");
		By account_logo = By.className("_8ZYZKvxC8bvw1xgQGSkvvA==");
		By name = By.id("mectrl_currentAccount_primary");
		By email = By.id("mectrl_currentAccount_secondary");

		By inside_header = By.xpath("//*[@id='title_text']");
		By header_text = By.xpath("//a[@id='news_text_title' and @tabindex='-1']");
		By head_Lines = By.xpath("//*[@id='title_text' ]");
		By sp_button = By.xpath("//*[@id=\"spTopPlaceholder\"]/div/div[2]/div/div/div/div/div/div/div[1]/a/span");
	    By Be_cognizant = By.xpath("//*[@id='spTopPlaceholder']/div/div[2]/div/div/div/div/div/div/div[1]/a/span/span");
	    
	    
	public  void user_credential() throws IOException {
	   
		driver.findElement(account_logo).click();
		//screenShot("user_credential");
		String user =driver.findElement(email).getText();
		Assert.assertEquals("2304026@cognizant.com",user );	
	}
	
	
	
	public void count() throws IOException {
		news =(driver.findElements(header_text));
	    Assert.assertEquals(5, news.size());
	   
	    
	    
	    
	}
	public void tip_tool() {
		for( int i=0;i<news.size();i++)

		{
			String newss= news.get(i).getText();
			String actualTT = news.get(i).getAttribute("title");
			Assert.assertEquals(newss, actualTT);
	}

   }
	

	
	public void app_Tool() throws IOException {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		WebElement element=driver.findElement(By.xpath("//*[@id='5d7d4eec-cbe0-4c55-ae2e-f38d926d82a0']/div/div/div/p/span/strong"));
		js.executeScript("arguments[0].scrollIntoView()",element);
 
		java.util.List<WebElement>apps=driver.findElements(By.xpath("//div[contains(@id,'89c5ffca-2ffb-4052-a723-e99c8c9a14ef')]//div[contains(@class,'labelTextWrapper')]"));
		
		
		FileOutputStream file = new FileOutputStream(
				System.getProperty("user.dir") + "\\Excel\\Apps and Tools.xlsx");
				XSSFWorkbook workbook = new XSSFWorkbook();
				XSSFSheet sheet = workbook.createSheet("Apps");
		
		for(int i=0;i<apps.size();i++) {
		String text = apps.get(i).getText();	
		System.out.println(text);
		
		
		XSSFRow row = sheet.createRow(i);
		XSSFCell cell = row.createCell(0);
		cell.setCellValue(text);
				
	 }
		
		workbook.write(file);
		workbook.close();
		file.close();
		Assert.assertEquals(9,apps.size());
	
	}
	
	
	public void i_o_headers() {
		
		 SoftAssert sa = new SoftAssert();

		for(int i=0;i<news.size();i++) {
			news =(driver.findElements(header_text));	
		WebElement oo = news.get(i);
		String ohead = oo.getText();
		oo.click();
		
		WebElement inside_header = driver.findElement(head_Lines);
		String ihead = inside_header.getText();
		
		
		if(!ohead.equals(ihead)){
			System.out.println(ohead);
			System.out.println(i+"th" +"news outside header and inside header is not equal");
		}
		
		sa.assertEquals(ihead, ohead);
		driver.findElement(Be_cognizant).click();
			
	}
		sa.assertAll();
}
}


