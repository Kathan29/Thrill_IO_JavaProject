package thrillio;

import thrillio.constants.BookGenre;
import thrillio.constants.Gender;
import thrillio.constants.MovieGenre;
import thrillio.constants.UserType;
import thrillio.entities.Bookmark;
import thrillio.entities.User;
import thrillio.entities.UserBookmark;
import thrillio.managers.BookmarkManager;
import thrillio.managers.UserManager;

public class DataStore {

	public static final int TOTAL_USER_COUNT = 5;
	public static final int TOTAL_BOOKMARK_TYPE = 3;
	public static final int EACH_BOOKMARK_TYPE_COUNT = 5;
	public static final int BOOKMARK_LIMIT = 5;

	private static User[] user = new User[TOTAL_USER_COUNT];
	private static Bookmark[][] bookmark = new Bookmark[TOTAL_BOOKMARK_TYPE][EACH_BOOKMARK_TYPE_COUNT];
	private static UserBookmark[] userbookmarks = new UserBookmark[TOTAL_USER_COUNT * BOOKMARK_LIMIT];

	public static User[] getUser() {
		return user;
	}

	public static Bookmark[][] getBookmark() {
		return bookmark;
	}

	public static void loadData() {
		loadUsers();
		loadBook();
		loadMovie();
		loadWebLink();
	}

	private static void loadWebLink() {
		bookmark[0][0] = BookmarkManager.getInstance().createWeblink(2000, "Taming Tiger, Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html",
				"http://www.javaworld.com");
		bookmark[0][1] = BookmarkManager.getInstance().createWeblink(2001,
				"How do I import a pre-existing Java project into Eclipse and get up and running?",
				"http://stackoverflow.com/questions/142863/how-do-i-import-a-pre-existing-java-project-into-eclipse-and-get-up-and-running",
				"http://www.stackoverflow.com");
		bookmark[0][2] = BookmarkManager.getInstance().createWeblink(2002, "Interface vs Abstract Class",
				"http://mindprod.com/jgloss/interfacevsabstract.html", "http://mindprod.com");
		bookmark[0][3] = BookmarkManager.getInstance().createWeblink(2003, "NIO tutorial by Greg Travis",
				"http://cs.brown.edu/courses/cs161/papers/j-nio-ltr.pdf", "http://cs.brown.edu");
		bookmark[0][4] = BookmarkManager.getInstance().createWeblink(2004, "Virtual Hosting and Tomcat",
				"http://tomcat.apache.org/tomcat-6.0-doc/virtual-hosting-howto.html", "http://tomcat.apache.org");

	}

	private static void loadMovie() {
		bookmark[1][0] = BookmarkManager.getInstance().createMovie(3000, "Citizen Kane", "", 1941,
				new String[] { "Orson Welles", "Joseph Cotten" }, new String[] { "Orson Welles" }, MovieGenre.CLASSICS,
				8.5);
		bookmark[1][1] = BookmarkManager.getInstance().createMovie(3001, "The Grapes of Wrath", "", 1940,
				new String[] { "Henry Fonda", "Jane Darwell" }, new String[] { "John Ford" }, MovieGenre.CLASSICS, 8.2);
		bookmark[1][2] = BookmarkManager.getInstance().createMovie(3002, "A Touch of Greatness", "", 2004,
				new String[] { "Albert Cullum" }, new String[] { "Leslie Sullivan" }, MovieGenre.DOCUMENTARIES, 7.3);
		bookmark[1][3] = BookmarkManager.getInstance().createMovie(3003, "The Big Bang Theory", "", 2007,
				new String[] { "Kaley Cuoco", "Jim Parsons" }, new String[] { "Chuck Lorre", "Bill Prady" },
				MovieGenre.TV_SHOWS, 8.7);
		bookmark[1][4] = BookmarkManager.getInstance().createMovie(3004, "Ikiru", "", 1952,
				new String[] { "Takashi Shimura", "Minoru Chiaki" }, new String[] { "Akira Kurosawa" },
				MovieGenre.FOREIGN_MOVIES, 8.4);

	}

	private static void loadBook() {
		bookmark[2][0] = BookmarkManager.getInstance().createBook(4000, "Walden", 1854, "Wilder Publications",
				BookGenre.PHILOSOPHY, new String[] { "Henry David Thoreau" }, 4.3);
		bookmark[2][1] = BookmarkManager.getInstance().createBook(4001, "Self-Reliance and Other Essays", 1993,
				"Dover Publications", BookGenre.PHILOSOPHY, new String[] { "Ralph Waldo Emerson" }, 4.5);
		bookmark[2][2] = BookmarkManager.getInstance().createBook(4002, "Light From Many Lamps", 1988, "Touchstone",
				BookGenre.PHILOSOPHY, new String[] { "Lillian Eichler Watson" }, 5);
		bookmark[2][3] = BookmarkManager.getInstance().createBook(4003, "Head First Design Patterns", 2004,
				"Touchstone", BookGenre.TECHNICAL,
				new String[] { "Eric Freeman", "Bert Bates", "Kathy Sierra", "Elisabeth Robson" }, 4.5);
		bookmark[2][4] = BookmarkManager.getInstance().createBook(4004, "Effective Java Programming Language Guide",
				2007, "Prentice Hall", BookGenre.TECHNICAL, new String[] { "Joshua Bloch" }, 4.9);

	}

	private static void loadUsers() {
		user[0] = UserManager.getInstance().createUser(1000, "user0@semanticsquare.com", "test", "John", "M",
				UserType.USER, Gender.MALE);
		user[1] = UserManager.getInstance().createUser(1001, "user1@semanticsquare.com", "test", "Sam", "M",
				UserType.USER, Gender.MALE);
		user[2] = UserManager.getInstance().createUser(1002, "user2@semanticsquare.com", "test", "Anita", "M",
				UserType.EDITOR, Gender.MALE);
		user[3] = UserManager.getInstance().createUser(1003, "user3@semanticsquare.com", "test", "Sara", "M",
				UserType.EDITOR, Gender.FEMALE);
		user[4] = UserManager.getInstance().createUser(1004, "user4@semanticsquare.com", "test", "Dheeru", "M",
				UserType.CHIEF_EDITOR, Gender.MALE);

	}

}
