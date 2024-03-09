package Stepdefinition;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class featurestepdef {
	public WebDriver driver;
	public static List<WebElement> news; 
	

	@Given("User navigates to homepage")
	public void user_navigates_to_homepage() {
	    // Write code here that turns the phrase above into concrete actions
		driver= new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://cognizantonline.sharepoint.com/sites/Be.Cognizant/SitePages/Home.aspx");
        
	    
	}
	@Then("user clicks on Profile button and validates user credentials")
	public void user_clicks_on_profile_button_and_validates_user_credentials() {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.className("_8ZYZKvxC8bvw1xgQGSkvvA==")).click(); 
		  
		  String str2 = driver.findElement(By.id("mectrl_currentAccount_secondary")).getText();
		  System.out.println("Email ID : "+str2); 
		  String mail = "2304026@cognizant.com";
		  if(str2.equals(mail)) {
			  System.out.println("user is verified");
		  }
		  else {
			  System.out.println("user is not verified");
		  }
	}
	@Then("user prints the count")
	public void user_prints_the_count() {
	    // Write code here that turns the phrase above into concrete actions
		   
		  List<WebElement> header= driver.findElements(By.xpath("//a[@id='news_text_title' and @tabindex='-1']"));
		  int news_count = header.size();
	      System.out.println("News Count is " + news_count);
	}
	
	@Then("user checks news header and validates with tool tip")
	public void user_checks_news_header_and_validates_with_tool_tip() {
	    // Write code here that turns the phrase above into concrete actions
		news =driver.findElements(By.xpath("//a[@id='news_text_title' and @tabindex]"));
		for( int i=0;i<news.size();i++)

		{
			
			String newss= news.get(i).getText();
			String actualTT = news.get(i).getAttribute("title");
			
			 if(newss.equals(actualTT)) {
				  System.out.println(i+"header and tiptool is matched");
			  }
			  else {
				  System.out.println(i+"header and tiptool is not matched");
			  }
			// driver.findElement(By.xpath("//*[@id='spTopPlaceholder']/div/div[2]/div/div/div/div/div/div/div[1]/a/span/span")).click();
			
	}

	}
	@Then("user clicks on each news and validates the tool tip with title")
	public void user_clicks_on_each_news_and_validates_the_tool_tip_with_title() {
	    // Write code here that turns the phrase above into concrete actions
		//news =driver.findElements(By.xpath("//a[@id='news_text_title' and @tabindex]"));
		for(int i=0;i<news.size();i++)
		{
			news =driver.findElements(By.xpath("//a[@id='news_text_title' and @tabindex]"));
		WebElement head = news.get(i);
		head.click();
		
		WebElement headlines = driver.findElement( By.xpath("//*[@id='title_text']"));
		String headlineText = headlines.getText();
		String headline_tooltip = headlines.getAttribute("title");
		if(headlineText.equals(headline_tooltip)) {
			  System.out.println(i+"header and tiptool is matched");
		  }
		  else {
			  System.out.println("header and tiptool is not matched");
		  }
    	driver.findElement(By.xpath("//*[@id='spTopPlaceholder']/div/div[2]/div/div/div/div/div/div/div[1]/a/span/span")).click();
		}
	}
	
	@Then("user get the inner news text")
	public void user_get_the_inner_news_text() {
		for(int i=0;i<news.size()-1 ;i++)
		{	
		news= driver.findElements(By.xpath("//a[@id='news_text_title' and @tabindex]"));
		WebElement head = news.get(i);
		head.click();

		WebElement text= driver.findElement(By.xpath("//*[@id='fa45f946-463e-428f-a84b-0bbbde09c3ba']"));
		String content = text.getText();
		System.out.println(i + content);
		driver.findElement(By.xpath("//*[@id='spTopPlaceholder']/div/div[2]/div/div/div/div/div/div/div[1]/a/span/span")).click();
		
	}
	}
	
	@Then("user prints all the apps and Tools in news page")
	public void user_prints_all_the_apps_and_tools_in_news_page() {
	    // Write code here that turns the phrase above into concrete actions
		JavascriptExecutor js=(JavascriptExecutor)driver;
		WebElement element=driver.findElement(By.xpath("//*[@id='5d7d4eec-cbe0-4c55-ae2e-f38d926d82a0']/div/div/div/p/span/strong"));
		js.executeScript("arguments[0].scrollIntoView()",element);
 
		java.util.List<WebElement>apps=driver.findElements(By.xpath("//div[contains(@id,'89c5ffca-2ffb-4052-a723-e99c8c9a14ef')]//div[contains(@class,'labelTextWrapper')]"));
		for(int i=0;i<apps.size();i++) {
			String text = apps.get(i).getText();	
			System.out.println(text);
			
	}
		driver.quit();


	}

}
