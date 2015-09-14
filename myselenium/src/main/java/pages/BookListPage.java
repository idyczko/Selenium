package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pl.spring.demo.web.seleniumclasses.AbstractPageObject;

public class BookListPage extends AbstractPageObject {
	@FindBy(xpath = "//*[@class=\"ng-scope\"]/input")
	private WebElement titleInput;

	@FindBy(css = "tr td:nth-child(3) button")
	private WebElement deleteButton;

	@FindBy(css = "tr td:nth-child(4) button")
	private WebElement modifyButton;
	
	@FindBy(xpath = "//*[@class=\"ng-scope\"]/button[1]")
	private WebElement searchButton;

	@FindBy(xpath = "//*[@class=\"ng-scope\"]/button[2]")
	private WebElement saveButton;

	@FindBy(tagName = "table")
	private WebElement booksTable;
	
	@FindBy(css = ".modal-content")
	private WebElement modal;
	
	public BookListPage(WebDriver driver) {
		super(driver);
	}
	
	public BookListPage setTitle(String title) {
		this.titleInput.clear();
		this.titleInput.sendKeys(title);
		return this;
	}

	public SaveBookPage clickSaveButton() {
		saveButton.click();
		return PageFactory.initElements(driver, SaveBookPage.class);
	}

	public BookListPage clickDeleteButton() {
		deleteButton =  booksTable.findElement(By.cssSelector("tr td:nth-child(3) button"));
		deleteButton.click();
		return this;
	}

	public ModifyBookPage clickModifyButton() {
		modifyButton.click();
		return PageFactory.initElements(driver, ModifyBookPage.class);
	}

	public BookListPage clickSearchButton() {
		searchButton.click();
		return this;
	}

	public Boolean isBooksTableEmpty() {
		return booksTable.findElements(By.tagName("td")).isEmpty();
	}

	public Boolean isModalDisplayed(){
		return modal.isDisplayed();
	}

}
