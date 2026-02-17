package thrillio.entities;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import thrillio.constants.BookGenre;
import thrillio.managers.BookmarkManager;

class BookTest {

	@Test
	void testIsKidFriendly() {
		
		//Test 1 : Genre Philosophy
		Book book = BookmarkManager.getInstance().createBook(4000, "Walden", 1854, "Wilder Publications",
				BookGenre.PHILOSOPHY, new String[] { "Henry David Thoreau" }, 4.3);
		boolean isKidFriendly = book.isKidFriendly();
		assertFalse("Test case failed : genre is philosophy : not kid friendly",isKidFriendly);
		
		//Test 2 : Genre Self help
		book = BookmarkManager.getInstance().createBook(4000, "Walden", 1854, "Wilder Publications",
				BookGenre.SELF_HELP, new String[] { "Henry David Thoreau" }, 4.3);
		isKidFriendly = book.isKidFriendly();
		assertFalse("Test case failed : genre is self help : not kid friendly",isKidFriendly);
		
		//Test 3 : any other genre
		book = BookmarkManager.getInstance().createBook(4000, "Walden", 1854, "Wilder Publications",
				BookGenre.ART, new String[] { "Henry David Thoreau" }, 4.3);
		isKidFriendly = book.isKidFriendly();
		assertTrue("Test case failed : genre is not philosophy and not self help: it shoould be kid friendly",isKidFriendly);
	}

}
