package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pl.spring.demo.web.seleniumclasses.AbstractPageObject;

public class AddAuthorPage extends AbstractPageObject {
	@FindBy(xpath = "//*[@class=\"modal-body\"]/p[2]/input")
	private WebElement firstName;

	@FindBy(xpath = "//*[@class=\"modal-body\"]/p[4]/input")
	private WebElement lastName;

	@FindBy(css = ".btn")
	private WebElement submitButton;

	@FindBy(css = ".btn-warning")
	private WebElement dismissButton;

	public AddAuthorPage(WebDriver driver) {
		super(driver);
	}

	public AddAuthorPage setFirstName(String firstName) {
		this.firstName.sendKeys(firstName);
		return this;
	}

	public AddAuthorPage setLastName(String lastName) {
		this.lastName.sendKeys(lastName);
		return this;
	}

	public SaveBookPage clickSubmitButton() {
		submitButton.click();
		return PageFactory.initElements(driver, SaveBookPage.class);
	}

	public SaveBookPage clickDismissButton() {
		dismissButton.click();
		return PageFactory.initElements(driver, SaveBookPage.class);
	}
	
	public Boolean isSubmitButtonEnabled(){
		return submitButton.isEnabled();
	}

}
