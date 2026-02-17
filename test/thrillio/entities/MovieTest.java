package thrillio.entities;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import thrillio.constants.MovieGenre;
import thrillio.managers.BookmarkManager;

class MovieTest {

	@Test
	void testIsKidFriendly() {
		
		//Test 1 : Genre Horror
		Movie movie = BookmarkManager.getInstance().createMovie(3000, "Citizen Kane", "", 1941,
				new String[] { "Orson Welles", "Joseph Cotten" }, new String[] { "Orson Welles" }, MovieGenre.HORROR,
				8.5);
		boolean isKidFriendly = movie.isKidFriendly();
		assertFalse("Test case failed because movie genre is horror : not kid friendly",isKidFriendly);
		
		//Test 2 : Genre Thriller
		movie = BookmarkManager.getInstance().createMovie(3000, "Citizen Kane", "", 1941,
				new String[] { "Orson Welles", "Joseph Cotten" }, new String[] { "Orson Welles" }, MovieGenre.THRILLERS,
				8.5);
		isKidFriendly = movie.isKidFriendly();
		assertFalse("Test case failed because movie genre is thriller : not kid friendly",isKidFriendly);
		
		//Test 3 : Any other genre 
		movie = BookmarkManager.getInstance().createMovie(3000, "Citizen Kane", "", 1941,
				new String[] { "Orson Welles", "Joseph Cotten" }, new String[] { "Orson Welles" }, MovieGenre.COMEDIES,
				8.5);
		isKidFriendly = movie.isKidFriendly();
		assertTrue("Test case failed because movie genre is not horror & not thrillers : it should be kid friendly",isKidFriendly);
	}

}
