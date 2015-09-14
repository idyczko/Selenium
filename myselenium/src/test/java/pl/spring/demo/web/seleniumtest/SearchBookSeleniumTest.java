package pl.spring.demo.web.seleniumtest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.capgemini.myselenium.AbstractSelenium;

import pages.BookListPage;

public class SearchBookSeleniumTest extends AbstractSelenium {

	private BookListPage bookListPage;

	@Override
	@Before
	public void setUp() {
		super.setUp();
		bookListPage = openPetClinic().clickBookListDialog();
	}

	private void setUpData() {
		bookListPage.clickSaveButton().clickAddAuthorButton().setFirstName("FirstName").setLastName("LastName")
		.clickSubmitButton().setTitle("Title").clickSaveButton().navigateBack();
		bookListPage.setTitle("Title");
		bookListPage.clickSearchButton();
	}

	@Test
	public void shouldCheckIfBooksTableIsInitialyEmpty() {
		assertTrue(bookListPage.isBooksTableEmpty());
	}

	@Test
	public void shouldCheckIfSearchFindsBooks(){
		setUpData();
		assertFalse(bookListPage.isBooksTableEmpty());
		bookListPage.clickDeleteButton();
	}


	@Test
	public void shouldCheckIfModifyModalIsDisplayed() {
		setUpData();
		bookListPage.clickModifyButton();
		assertTrue(bookListPage.isModalDisplayed());
		bookListPage.clickDeleteButton();
	}

	@Test
	public void shouldCheckIfModalSubmitButtonIsDisabledWhenNewTitleIsNotTyped() {
		setUpData();
		assertFalse(bookListPage.clickModifyButton().isSubmitButtonEnabled());
		bookListPage.clickDeleteButton();
	}

	@Test
	public void shouldCheckIfBookModificationWorks() {
		setUpData();
		bookListPage.clickModifyButton().setNewTitle("newTitle").clickSubmitButton();
		bookListPage.setTitle("newTitle");
		bookListPage.clickSearchButton();
		assertFalse(bookListPage.isBooksTableEmpty());
		bookListPage.clickDeleteButton();
	}

}
