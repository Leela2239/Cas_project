package pages;



import java.io.FileOutputStream;
import java.io.IOException;


import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Base.base;
public class news extends base {
	
	
	//locators
	By header_text = By.xpath("//a[@id='news_text_title' and @tabindex]");
	By Be_cognizant = By.xpath("//*[@id=\"spTopPlaceholder\"]/div/div[2]/div/div/div/div/div/div/div[1]/a/span");
    By news_feed = By.xpath("//*[@id='fa45f946-463e-428f-a84b-0bbbde09c3ba']");
    By inside_header = By.xpath("//*[@id='title_text']");
    
public void news_Exec() throws InterruptedException, IOException {
	  
	FileOutputStream file = new FileOutputStream(
	System.getProperty("user.dir") + "\\Excel\\News Feed.xlsx");
	XSSFWorkbook workbook = new XSSFWorkbook();
	XSSFSheet sheet = workbook.createSheet("News");
	int j=1;
	for( int i=0;i<news.size()-1 ;i++)
	{	
	news= driver.findElements(header_text);
	WebElement head = news.get(i);
	head.click();
	WebElement headlines = driver.findElement(inside_header);
	String headlineText = headlines.getText();
	String headline_tooltip = headlines.getAttribute("title");
	Assert.assertEquals(headlineText,headline_tooltip);

	WebElement text= driver.findElement(news_feed);
	String content = text.getText();
	System.out.println( j + content);
	
	System.out.println("----------------------------------------------------------------------------------------------------");
	j++;
	XSSFRow row = sheet.createRow(i);
	XSSFCell cell = row.createCell(0);
	cell.setCellValue(content);
	
	driver.findElement(Be_cognizant).click();
  }
	workbook.write(file);
	workbook.close();
	file.close();
	Assert.assertEquals(5, j);
}

}
