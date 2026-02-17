package thrillio.entities;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import thrillio.managers.BookmarkManager;

class WeblinkTest {

	@Test
	void testIsKidFriendly() {
		
		//Test 1 : porn in url
		Weblink weblink = BookmarkManager.getInstance().createWeblink(2000, "Taming Tiger, Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-porn--part-2.html",
				"http://www.javaworld.com");
		boolean isKidFriendly = weblink.isKidFriendly();
		assertFalse("Test failed : Porn keyword found in url : not kid friendly", isKidFriendly);
		
		//Test 2 : porn in title
		weblink = BookmarkManager.getInstance().createWeblink(2000, "Taming porn, Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html",
				"http://www.javaworld.com");
		isKidFriendly = weblink.isKidFriendly();
		assertFalse("Test failed : Porn keyword found in title : not kid friendly", isKidFriendly);
		
		//Test 3 : adult in host
		weblink = BookmarkManager.getInstance().createWeblink(2000, "Taming Tiger, Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html",
				"http://www.adult.com");
		isKidFriendly = weblink.isKidFriendly();
		assertFalse("Test failed : Adult keyword found in host : not kid friendly", isKidFriendly);
		
		//Test 4 : adult in url and not in host
		weblink = BookmarkManager.getInstance().createWeblink(2000, "Taming Tiger, Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-adult--part-2.html",
				"http://www.javaworld.com");
		isKidFriendly = weblink.isKidFriendly();
		assertTrue("Test failed : Adult keyword found in url only and not in host: it should be kid friendly", isKidFriendly);
		
		//Test 5: adult in title
		weblink = BookmarkManager.getInstance().createWeblink(2000, "Taming adult, Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html",
				"http://www.javaworld.com");
		isKidFriendly = weblink.isKidFriendly();
		assertTrue("Test failed : Adult keyword found in title only: it should be kid friendly", isKidFriendly);
	}

}
