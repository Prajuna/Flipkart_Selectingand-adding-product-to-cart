package flipkartproject_pkg1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {

	public static void main(String[] args) {


	   WebDriver dr=new ChromeDriver();
	   
	   //Constructor calling
	   verify_menspage object= new verify_menspage(dr);
	   
	   object.page_launching();
	   
	   
	}

}
