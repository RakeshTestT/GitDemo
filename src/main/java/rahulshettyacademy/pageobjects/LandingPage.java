package rahulshettyacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import RahulshettyAcadmy.AbstractComponent.AbstractComponents;

public class LandingPage extends AbstractComponents{

	WebDriver dr;

	public LandingPage(WebDriver dr) {
		// This Constructor execute first so driver will be assigned and pagefactory will be activate all FindBy anotation.
		super(dr);
		this.dr=dr;
		PageFactory.initElements(dr, this);
		
	}

	// Page factory

	@FindBy(id="userEmail")
	WebElement userEmail;

	@FindBy(id="userPassword")
	WebElement password;

	@FindBy(id="login")
	WebElement submit;

	public void landingPage(String Email,String Pass) {
		userEmail.sendKeys(Email);
		password.sendKeys(Pass);
		submit.click();
	}
	public void goTo() {
		dr.get("https://rahulshettyacademy.com/client/");

	}
}
