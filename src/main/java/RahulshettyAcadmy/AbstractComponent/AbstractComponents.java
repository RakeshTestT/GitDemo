package RahulshettyAcadmy.AbstractComponent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponents {
	 WebDriver dr;
	public AbstractComponents(WebDriver dr) {
		// TODO Auto-generated constructor stub
		this.dr=dr;

	}

	public void waitForElementToAppear(By Findby) {

		WebDriverWait wait = new WebDriverWait(dr, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(Findby));
	}
	public void waitForElementToDisappear(WebElement ele) {

		WebDriverWait wait = new WebDriverWait(dr, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}
	
}
