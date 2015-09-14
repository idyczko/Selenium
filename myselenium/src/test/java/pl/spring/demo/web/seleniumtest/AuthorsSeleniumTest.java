package pl.spring.demo.web.seleniumtest;

import static org.junit.Assert.assertFalse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.capgemini.myselenium.AbstractSelenium;

import pages.AuthorsPage;

public class AuthorsSeleniumTest extends AbstractSelenium {

	private AuthorsPage authorsPage;
	

	@Override
	@Before
	public void setUp() {
		super.setUp();
		authorsPage = openPetClinic().clickAuthorsDialog();		
		addBook();
	}

	@After
	public void removeBook(){
		authorsPage.clickBookListButton().setTitle("Title").clickSearchButton().clickDeleteButton();
	}

	public void addBook(){
		authorsPage.clickSaveButton().clickAddAuthorButton().setFirstName("FirstName").setLastName("LastName")
		.clickSubmitButton().setTitle("Title").clickSaveButton().navigateBack();
	}
	
	@Test
	public void shouldCheckIfAuthorTableIsNotInitialyEmpty() {
		assertFalse(authorsPage.isAuthorsTableEmpty());
	}

	@Test
	public void shouldCheckIfScriptFindsAuthorsOnTheFly() {
		authorsPage.setAuthor("First");
		assertFalse(authorsPage.isAuthorsTableEmpty());
	}

}
