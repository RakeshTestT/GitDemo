package NCLearning.SeleniumFrameworkMaven;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.pageobjects.Catalogue;
import rahulshettyacademy.pageobjects.LandingPage;

public class StandaloneTest {

	public static void main(String[] args) throws InterruptedException, IOException {
		String ProdName = "ADIDAS ORIGINAL";
		WebDriverManager.chromedriver().setup();
		WebDriver dr = new ChromeDriver();
		
	//	WebDriverManager.firefoxdriver().setup();
		//WebDriver dr = new FirefoxDriver();
		dr.manage().window().maximize();

		
		LandingPage landingpage = new LandingPage(dr);
		dr.get("https://rahulshettyacademy.com/client/");
		landingpage.goTo();
		
		dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(dr, Duration.ofSeconds(5));
		landingpage.landingPage("rakesh.tiwari@nathcorp.com" , "Nathcorp!123");
		Catalogue Catalogue = new Catalogue(dr);
		List<WebElement> products = Catalogue.getProductList();
		Catalogue.addProductToCart(ProdName);
		
	
		dr.findElement(By.cssSelector("[routerlink*='/dashboard/cart']")).click();
		
		List <WebElement>	Cartprods = dr.findElements(By.cssSelector(".cartSection h3"));
		Boolean match = Cartprods.stream().anyMatch(Cartprod-> Cartprod.getText().equalsIgnoreCase(ProdName));
		Assert.assertTrue(match);
		dr.findElement(By.cssSelector(".totalRow button")).click();
		System.out.println("Going to Checkout the product");
		Actions a = new Actions(dr);
		a.sendKeys(dr.findElement(By.cssSelector("[Placeholder='Select Country']")), "India").build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
	//	dr.findElement(By.cssSelector(".ta-results button:nth-of-type(2)")).click();
		dr.findElement(By.xpath("//button[contains(@class,'ta-item')][2]")).click();
		
		dr.findElement(By.xpath("//a[contains(@class,'action__submit')]")).click();
		
		String msg = dr.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertTrue(msg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		dr.quit();
		
		
	}

}
