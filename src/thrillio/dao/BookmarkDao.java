package thrillio.dao;

import thrillio.DataStore;
import thrillio.entities.Bookmark;
import thrillio.entities.User;
import thrillio.entities.UserBookmark;

public class BookmarkDao {
	public Bookmark[][] getBookmark(){
		return DataStore.getBookmark();
	}

	public void storeBookmarking(UserBookmark userBookmark) {
		
		DataStore.storeBookmarking(userBookmark);
		
	}
}
