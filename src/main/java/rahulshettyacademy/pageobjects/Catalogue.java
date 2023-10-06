package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import RahulshettyAcadmy.AbstractComponent.AbstractComponents;

public class Catalogue extends AbstractComponents{
	
	WebDriver dr;
	
	public Catalogue(WebDriver dr) {
		// This Constructor execute first so driver will be assigned and pagefactory will be activate all FindBy anotation.
		super(dr);

		this.dr=dr;
		PageFactory.initElements(dr, this);
	}

	// Page factory
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	By productsby = By.cssSelector(".col-sm-10");
	By addTocart = By.cssSelector(".card-body button:last-of-type");
	By toastMsg = By.cssSelector("#toast-container");
	public List<WebElement> getProductList() {
		
		waitForElementToAppear(productsby);
		return products;
		
	}
	
	
	public WebElement getProductByName(String productName) {

		WebElement prod = getProductList().stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equals("ADIDAS ORIGINAL")).findFirst().orElse(null);
return prod;

		}
	public void addProductToCart(String productName) {
		
		WebElement prod = getProductByName(productName);
		prod.findElement(addTocart).click();
		waitForElementToAppear(toastMsg);
		waitForElementToDisappear(spinner);
	}


}
