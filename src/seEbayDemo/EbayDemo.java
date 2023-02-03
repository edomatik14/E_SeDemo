/*
	 * USERCASE:
	 * Selenium program developed to solve the following test case:
	 * 1. As a user, i want to go to ebay web page and search for "JBL Speakers", Then i want to check daily offers.
	 * 2. From ebay web page, i want to navigate to Simplilearn web page and then navigate back.
	 * 3. Once i navigated back, in ebay web page i want to get the page title, and then close the browser.
*/

package seEbayDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EbayDemo {
		
	WebDriver driver;
	
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "\\C:\\Users\\eddao\\Downloads\\Selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://co.ebay.com/");
	}
	
	public void searchProduct() throws InterruptedException {
		Thread.sleep(3000);
		driver.manage().deleteAllCookies();
		driver.findElement(By.id("gh-ac")).sendKeys("JBL Speakers");
		driver.findElement(By.xpath("//input[@id='gh-btn']")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("ebay Ofertas")).click();
	}
	
	// Navigate commands. This class allows me to head to a newly assigned URL and then navigate back to the previous page.
	// Comandos navigate, esta clase permite dirigirme a otra url asignada y luego volver a la pagina previa.
	public void navigate() throws InterruptedException {
		Thread.sleep(2000);
		// Link to the new assigned URL. Enlaza a la URL asignada.
		driver.navigate().to("https://www.simplilearn.com/"); 
		Thread.sleep(3000);
		// Navigate back to the previous web page. Regresa a la pagina previa al nuevo enlace.
		driver.navigate().back(); 
		System.out.println("The title of this page is: " + driver.getTitle());
	}
	
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(4000);
		driver.quit();
	}
	
	public static void main (String[] args) throws InterruptedException {
		EbayDemo obj = new EbayDemo();
		
		obj.launchBrowser();
		obj.searchProduct();
		obj.navigate();
		obj.closeBrowser();
	}

}
