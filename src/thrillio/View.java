package thrillio;

import thrillio.constants.KidFriendlyStatus;
import thrillio.constants.UserType;
import thrillio.controllers.BookmarkController;
import thrillio.entities.Bookmark;
import thrillio.entities.User;

public class View {

	public static void browse(User user, Bookmark[][] bookmarks) {
		System.out.println("\nUser : " + user.getFirstName() + " is browsing and User type is : " + user.getUserType());

		int bookmarkCount = 0;
		for (Bookmark[] bookmarkList : bookmarks) {
			for (Bookmark bookmark : bookmarkList) {
					
				//Check it user want to bookmark
				if (bookmarkCount < DataStore.BOOKMARK_LIMIT) {
					boolean toBookmark = (Math.random() < 0.5) ? true : false;
					if(toBookmark) {
						BookmarkController.getInstance().storeBookmarking(user, bookmark);
						System.out.println("Item bookmarked : " + bookmark);
						bookmarkCount++;
					}
				}
				
				//Mark it as kid friendly
				if(user.getUserType().equals(UserType.CHIEF_EDITOR) || user.getUserType().equals(UserType.EDITOR)) {
					if(bookmark.isKidFriendly() && bookmark.getKidFriendlyStatus().equals(KidFriendlyStatus.UNKNOWN)) {
						String takeDecision = getKidFriendlyStatusDecision();
						if(!takeDecision.equals(KidFriendlyStatus.UNKNOWN)) {
							bookmark.setKidFriendlyStatus(takeDecision);
							System.out.println("Kid Friendly Status : "+takeDecision+" ,"+bookmark);
						}	
					}
				}
				
			}
		}

	}

	private static String getKidFriendlyStatusDecision() {
		double val = Math.random();
		return (val<0.4) ? KidFriendlyStatus.APPROVED : (val<0.8) ? KidFriendlyStatus.REJECTED : KidFriendlyStatus.UNKNOWN;
	}

}
