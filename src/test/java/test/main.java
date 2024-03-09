package test;




import java.io.IOException;
import org.testng.annotations.Test;
import Base.base;
import pages.*;


public class main extends base{
	
	home Home= new home();
	news News = new news();
	
	@Test(priority=0)
    public  void check() throws IOException {
		Home.user_credential();
		
        }
	
	
	@Test(priority=1)
	public void count_news() throws IOException {
		Home.count();
		
	}
	
	
	@Test(priority=2)
	public void check_tt() {
		Home.tip_tool();

	}
	
	
	
//	@Test(priority=3)
//	public void click_and_checks() throws InterruptedException, IOException {
//		Home.click_and_check();
//		
//	}
	
	
	@Test(priority=3)
	public void i_o_header() {
		Home.i_o_headers();

	}
	
	
	
	@Test(priority=4)
	public void news_Execs() throws InterruptedException, IOException {
		//Home.click_and_check();
		News.news_Exec();
	
	}
	
	
	@Test(priority=5)
	public void apps_tools() throws IOException {
		Home.app_Tool();

	}
	
}

