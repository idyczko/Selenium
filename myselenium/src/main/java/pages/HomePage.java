package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pl.spring.demo.web.seleniumclasses.AbstractPageObject;

public class HomePage extends AbstractPageObject {
	@FindBy(linkText="Books dialog")
	private WebElement bookListDialog;

	@FindBy(xpath = "//*[@class=\"nav navbar-nav\"]/li[2]/a")
	private WebElement saveBookDialog;

	@FindBy(xpath = "//*[@class=\"nav navbar-nav\"]/li[3]/a")
	private WebElement authorsDialog;
	
	@FindBy(xpath = "//*[@class=\"nav navbar-nav\"]/li[4]/a")
	private WebElement aDialog;
	
	@FindBy(xpath = "//*[@class=\"nav navbar-nav\"]/li[5]/a")
	private WebElement bDialog;
	
	
	public HomePage(WebDriver driver) {
		super(driver);
		this.driver.get("http://localhost:9721/workshop/#/main/welcome");
	}
	
	public BookListPage clickBookListDialog(){
		bookListDialog.click();
		return PageFactory.initElements(driver, BookListPage.class);
	}
	
	public SaveBookPage clickSaveBookDialog(){
		saveBookDialog.click();
		return PageFactory.initElements(driver, SaveBookPage.class);
	}
	
	public AuthorsPage clickAuthorsDialog(){
		authorsDialog.click();
		return PageFactory.initElements(driver, AuthorsPage.class);
	}
	
	public ADialogPage clickADialog(){
		aDialog.click();
		return PageFactory.initElements(driver, ADialogPage.class);
	}
	
	public BDialogPage clickBDialog(){
		bDialog.click();
		return PageFactory.initElements(driver, BDialogPage.class);
	}
}
