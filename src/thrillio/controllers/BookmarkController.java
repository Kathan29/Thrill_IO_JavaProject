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

	public void setKidFriendlyStatus(User user, String takeDecision, Bookmark bookmark) {
		
		BookmarkManager.getInstance().setKidFriendlyStatus(user,takeDecision,bookmark);
		
	}

	public void share(User user, Bookmark bookmark) {
		BookmarkManager.getInstance().share(user,bookmark);
		
	}
	
	
}
