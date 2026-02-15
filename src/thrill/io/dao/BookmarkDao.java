package thrill.io.dao;

import thrill.io.DataStore;
import thrill.io.entities.Bookmark;

public class BookmarkDao {
	public Bookmark[][] getBookmark(){
		return DataStore.getBookmark();
	}
}
