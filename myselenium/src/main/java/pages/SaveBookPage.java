package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pl.spring.demo.web.seleniumclasses.AbstractPageObject;

public class SaveBookPage extends AbstractPageObject {
	@FindBy(xpath = "//*[@class=\"ng-scope\"]/input")
	private WebElement titleInput;

	@FindBy(css = "td button")
	private WebElement removeAuthorButton;
	
	@FindBy(xpath = "//section[@class=\"ng-scope\"]/button[1]")
	private WebElement addAuthorButton;

	@FindBy(xpath = "//section[@class=\"ng-scope\"]/button[2]")
	private WebElement saveButton;

	@FindBy(tagName = "table")
	private WebElement authorsTable;

	@FindBy(xpath = "//*[@role=\"alert\"]")
	private WebElement flashAlert;

	@FindBy(css = ".modal-content")
	private WebElement modal;

	public SaveBookPage(WebDriver driver) {
		super(driver);
	}
	
	public void navigateBack(){
		driver.navigate().back();
	}
	
	public SaveBookPage setTitle(String title) {
		this.titleInput.sendKeys(title);
		return this;
	}

	public SaveBookPage clickSaveButton() {
		saveButton.click();
		return this;
	}

	public SaveBookPage clickRemoveAuthorButton() {
		removeAuthorButton.click();
		return this;
	}

	public AddAuthorPage clickAddAuthorButton() {
		addAuthorButton.click();
		return PageFactory.initElements(driver, AddAuthorPage.class);
	}

	public Boolean isSaveButtonEnabled() {
		return saveButton.isEnabled();
	}

	public Boolean isAuthorsTableEmpty() {
		return authorsTable.findElements(By.tagName("td")).isEmpty();
	}
	
	public Boolean isFlashAlertDisplayed(){
		return flashAlert.isDisplayed();
	}

	public Boolean isModalDisplayed(){
		return modal.isDisplayed();
	}
}
