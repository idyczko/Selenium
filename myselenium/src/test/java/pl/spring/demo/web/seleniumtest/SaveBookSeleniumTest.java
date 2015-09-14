package pl.spring.demo.web.seleniumtest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.capgemini.myselenium.AbstractSelenium;

import pages.AddAuthorPage;
import pages.SaveBookPage;

public class SaveBookSeleniumTest extends AbstractSelenium {

	private SaveBookPage saveBookPage;

	@Override
	@Before
	public void setUp() {
		super.setUp();
		saveBookPage = openPetClinic().clickSaveBookDialog();
	}

	@Test
	public void shouldCheckIfAuthorTableIsInitialyEmpty() {
		assertTrue(saveBookPage.isAuthorsTableEmpty());
	}

	@Test
	public void shouldCheckIfModalIsDisplayed() {
		saveBookPage.clickAddAuthorButton();
		assertTrue(saveBookPage.isModalDisplayed());
	}

	@Test
	public void shouldCheckIfModalDismissWorks() {
		saveBookPage.clickAddAuthorButton().setFirstName("Firstname").setLastName("Lastname").clickDismissButton();
		assertTrue(saveBookPage.isAuthorsTableEmpty());
	}

	@Test
	public void shouldCheckIfModalSubmitButtonIsDisabledWhenFirstNameIsNotTyped() {
		AddAuthorPage addAuthorPage = saveBookPage.clickAddAuthorButton().setLastName("Lastname");
		assertFalse(addAuthorPage.isSubmitButtonEnabled());
	}

	@Test
	public void shouldCheckIfModalSubmitButtonIsDisabledWhenLastNameIsNotTyped() {
		AddAuthorPage addAuthorPage = saveBookPage.clickAddAuthorButton().setFirstName("Firstname");
		assertFalse(addAuthorPage.isSubmitButtonEnabled());
	}

	@Test
	public void shouldCheckIfAuthorAddingWorks() {
		saveBookPage.clickAddAuthorButton().setFirstName("Firstname").setLastName("Lastname").clickSubmitButton();
		assertFalse(saveBookPage.isAuthorsTableEmpty());
	}

	@Test
	public void shouldCheckIfAuthorRemovingWorks() {
		saveBookPage.clickAddAuthorButton().setFirstName("Firstname").setLastName("Lastname").clickSubmitButton().clickRemoveAuthorButton();
		assertTrue(saveBookPage.isAuthorsTableEmpty());
	}

	@Test
	public void shouldCheckIfTitleIsRequired() {
		saveBookPage.clickAddAuthorButton().setFirstName("Firstname").setLastName("Lastname").clickSubmitButton();
		assertFalse(saveBookPage.isSaveButtonEnabled());
	}

	@Test
	public void shouldCheckIfAuthorIsRequired() {
		saveBookPage.setTitle("Title").clickSaveButton();
		assertTrue(saveBookPage.isFlashAlertDisplayed());
	}

	@Test
	public void shouldPerformSavingRequestAndDisplayFlashAlert() {
		saveBookPage.setTitle("Title");
		saveBookPage.clickAddAuthorButton().setFirstName("Firstname").setLastName("Lastname").clickSubmitButton().clickSaveButton();
		assertTrue(saveBookPage.isFlashAlertDisplayed());
	}

}
