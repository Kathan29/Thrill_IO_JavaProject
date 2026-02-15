package thrillio;

import thrillio.entities.Bookmark;
import thrillio.entities.User;
import thrillio.managers.BookmarkManager;
import thrillio.managers.UserManager;

public class Launch {
	private static User[] users;
	private static Bookmark[][] bookmarks;
	
	private static void loadData() {
		
		System.out.println("Loading data...");
		DataStore.loadData();
		
		users = UserManager.getInstance().getUser();
		bookmarks = BookmarkManager.getInstance().getBookmark();
		
		System.out.println("Printing data....");
		printUser();
		printBookmark();
		
	}
	private static void printBookmark() {
		for(Bookmark[] bookmarkList : bookmarks) {
			for(Bookmark bookmark : bookmarkList) {
				System.out.println(bookmark);
			}
		}
		
	}
	private static void printUser() {
		for(User user:users) {
			System.out.println(user);
		}
		
	}
	public static void main(String[] args) {
		loadData();
	}

}
