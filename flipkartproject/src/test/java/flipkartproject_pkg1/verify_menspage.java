package flipkartproject_pkg1;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class verify_menspage {

	
	WebDriver driver;
	
	public verify_menspage(WebDriver dr)
	{
		this.driver=dr;
	}
	
	//WebDriver driver=new ChromeDriver();
	
	@BeforeTest
	public void page_launching() {
		
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		
	}
	@Test
	public void firstproduct_menspage() throws InterruptedException {
		WebElement fashion_menu=driver.findElement(By.xpath("//div[@aria-label=\"Fashion\"]"));
		fashion_menu.click();
		WebElement All_option= driver.findElement(By.linkText("All"));
		All_option.click();
		
		//Checking the first offer
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,300)");
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofMillis(6000));

		WebElement offer=driver.findElement(By.xpath("//div[contains(text(),'Buy More, Save More')]"));
		offer.click();
		Thread.sleep(5000);
		
		//choosing the first product check with VIJETHA
		js.executeScript("window.scrollBy(0,80)");

		WebElement select_firstproduct = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[2]/div/div[1]/div/a/div[1]/div/div/div")));

		select_firstproduct.click();

		
		//Redirected to new window
		String parent_window= driver.getWindowHandle();
		
		//System.out.println("PArent **"+parent_window);
		
		Set<String>totalwindow= driver.getWindowHandles();
		//System.out.println("child window"+child_window);
		
		for(String window:totalwindow)
		{ if (window!=parent_window)
		{
			System.out.println("child inside if loop  window");
			driver.switchTo().window(window);

		}
		
		
		}
		
		
		

		Thread.sleep(5000);
		WebElement select_size= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@id='swatch-2-size']/a")));;
		select_size.click();	
		Thread.sleep(4000);
		js.executeScript("window.scrollBy(0,900)");

		
		WebElement add_cart= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Add to cart')]")));
		add_cart.click();
		
		driver.quit();
		
		
	}
	
}
