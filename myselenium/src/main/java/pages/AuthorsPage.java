package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pl.spring.demo.web.seleniumclasses.AbstractPageObject;

public class AuthorsPage extends AbstractPageObject {
	@FindBy(xpath = "//*[@class=\"ng-scope\"]/input")
	private WebElement authorInput;
	
	@FindBy(xpath = "//ul/li[2]/a")
	private WebElement saveButton;
	
	@FindBy(xpath = "//ul/li[1]/a")
	private WebElement bookListButton;
	
	@FindBy(tagName = "table")
	private WebElement authorsTable;
	
	public AuthorsPage(WebDriver driver) {
		super(driver);
	}
	
	public AuthorsPage setAuthor(String author) {
		this.authorInput.clear();
		this.authorInput.sendKeys(author);
		return this;
	}
	
	public SaveBookPage clickSaveButton() {
		saveButton.click();
		return PageFactory.initElements(driver, SaveBookPage.class);
	}
	
	public BookListPage clickBookListButton() {
		bookListButton.click();
		return PageFactory.initElements(driver, BookListPage.class);
	}

	public Boolean isAuthorsTableEmpty() {
		return authorsTable.findElements(By.tagName("td")).isEmpty();
	}
}
