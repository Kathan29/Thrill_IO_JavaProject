package thrillio;

import thrillio.controllers.BookmarkController;
import thrillio.entities.Bookmark;
import thrillio.entities.User;

public class View {
	
	public static void bookmarking(User u,Bookmark[][] bookmark) {
		System.out.println("\nUser : "+u.getFirstName()+" is bookmarking");
		
		for(int i=0;i<DataStore.BOOKMARK_LIMIT;i++) {
			int typeOffset = (int)(Math.random()*DataStore.TOTAL_BOOKMARK_TYPE);
			int bookmarkOffset = (int)(Math.random()*DataStore.EACH_BOOKMARK_TYPE_COUNT);
			
			Bookmark bookmarked = bookmark[typeOffset][bookmarkOffset];
			System.out.println("Item bookmarked : "+bookmarked);
			
			BookmarkController.getInstance().storeBookmarking(u,bookmarked);
		}
	}
	
}
