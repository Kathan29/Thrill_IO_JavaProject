package thrillio.dao;

import thrillio.DataStore;
import thrillio.entities.Bookmark;

public class BookmarkDao {
	public Bookmark[][] getBookmark(){
		return DataStore.getBookmark();
	}
}
