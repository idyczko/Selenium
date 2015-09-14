package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pl.spring.demo.web.seleniumclasses.AbstractPageObject;

public class ModifyBookPage extends AbstractPageObject {
	@FindBy(xpath = "//*[@class=\"modal-body\"]/p[2]/input")
	private WebElement newTitle;

	@FindBy(css = ".btn")
	private WebElement submitButton;

	@FindBy(css = ".btn-warning")
	private WebElement dismissButton;

	public ModifyBookPage(WebDriver driver) {
		super(driver);
	}

	public ModifyBookPage setNewTitle(String newTitle) {
		this.newTitle.sendKeys(newTitle);
		return this;
	}

	public BookListPage clickSubmitButton() {
		submitButton.click();
		return PageFactory.initElements(driver, BookListPage.class);
	}

	public BookListPage clickDismissButton() {
		dismissButton.click();
		return PageFactory.initElements(driver, BookListPage.class);
	}
	
	public Boolean isSubmitButtonEnabled(){
		return submitButton.isEnabled();
	}
}
