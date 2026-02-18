package thrillio;

import thrillio.constants.KidFriendlyStatus;
import thrillio.constants.UserType;
import thrillio.controllers.BookmarkController;
import thrillio.entities.Bookmark;
import thrillio.entities.User;
import thrillio.partners.Sharable;

public class View {

	public static void browse(User user, Bookmark[][] bookmarks) {
		System.out.println("\nUser : " + user.getFirstName() + " is browsing and User type is : " + user.getUserType());

		int bookmarkCount = 0;
		for (Bookmark[] bookmarkList : bookmarks) {
			for (Bookmark bookmark : bookmarkList) {

				// Check it user want to bookmark
				if (bookmarkCount < DataStore.BOOKMARK_LIMIT) {
					boolean toBookmark = (Math.random() < 0.5) ? true : false;
					if (toBookmark) {
						BookmarkController.getInstance().storeBookmarking(user, bookmark);
						System.out.println("Item bookmarked : " + bookmark);
						bookmarkCount++;
					}
				}

				// Do editor or chief editor task
				if (user.getUserType().equals(UserType.CHIEF_EDITOR) || user.getUserType().equals(UserType.EDITOR)) {

					// Approve or rejecting kid friendly status
					if (bookmark.isKidFriendly() && bookmark.getKidFriendlyStatus().equals(KidFriendlyStatus.UNKNOWN)) {
						String takeDecision = getKidFriendlyStatusDecision();
						if (!takeDecision.equals(KidFriendlyStatus.UNKNOWN)) {

							BookmarkController.getInstance().setKidFriendlyStatus(user,takeDecision, bookmark);
						}
					}
					
					
					//Sharing the book or weblink to partners
					if(bookmark.getKidFriendlyStatus().equals(KidFriendlyStatus.APPROVED) && bookmark instanceof Sharable) {
						boolean shareDecision = (Math.random() < 0.5) ? true : false;
						if(shareDecision) {
							BookmarkController.getInstance().share(user,bookmark);
						}
					}
				}

			}
		}

	}

	private static String getKidFriendlyStatusDecision() {
		double val = Math.random();
		return (val < 0.4) ? KidFriendlyStatus.APPROVED
				: (val < 0.8) ? KidFriendlyStatus.REJECTED : KidFriendlyStatus.UNKNOWN;
	}

}
