package thrillio.managers;

import thrillio.dao.BookmarkDao;
import thrillio.entities.Book;
import thrillio.entities.Bookmark;
import thrillio.entities.Movie;
import thrillio.entities.Weblink;

public class BookmarkManager {

	private static BookmarkManager instance = new BookmarkManager();
	private static BookmarkDao dao = new BookmarkDao();

	private BookmarkManager() {

	}

	public static BookmarkManager getInstance() {
		return instance;
	}

	public Movie createMovie(long id, String title, String profileUrl, int releaseYear, String[] cast,
			String[] directors, String genre, double imdbRating) {
		
		Movie movie = new Movie();
		
		movie.setId(id);
		movie.setTitle(title);
		movie.setProfileUrl(profileUrl);
		movie.setReleaseYear(releaseYear);
		movie.setCast(cast);
		movie.setDirectors(directors);
		movie.setGenre(genre);
		movie.setImdbRating(imdbRating);

		return movie;
	}

	public Book createBook(long id, String title, int publicationYear, String publisher, String genre, String[] authors,
			double amazonRating) {
		
		Book book = new Book();
		
		book.setId(id);
		book.setTitle(title);
		book.setPublicationYear(publicationYear);
		book.setGenre(genre);
		book.setAuthors(authors);
		book.setAmazonRating(amazonRating);
		book.setPublisher(publisher);
		
		return book;
	}

	public Weblink createWeblink(long id, String title, String url, String host) {
		
		Weblink weblink = new Weblink();
		
		weblink.setId(id);
		weblink.setTitle(title);
		weblink.setUrl(url);
		weblink.setHost(host);
		
		return weblink;
	}
	
	public Bookmark[][] getBookmark(){
		return dao.getBookmark();
	}
}
