package thrillio.controllers;

import thrillio.entities.Bookmark;
import thrillio.entities.User;
import thrillio.managers.BookmarkManager;

public class BookmarkController {
	
	private static BookmarkController instance = new BookmarkController();
	
	private BookmarkController() {

	}
	
	public static BookmarkController getInstance() {
		return instance;
	}

	public void storeBookmarking(User u, Bookmark bookmarked) {
		BookmarkManager.getInstance().storeBookmarking(u,bookmarked);
	}
	
	
}
