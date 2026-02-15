package thrillio.entities;

import java.util.Arrays;

public class Book extends Bookmark {
	private int publicationYear;
	private String publisher, genre;
	private String[] authors;
	private double amazonRating;

	public int getPublicationYear() {
		return publicationYear;
	}

	public void setPublicationYear(int publicationYear) {
		this.publicationYear = publicationYear;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String[] getAuthors() {
		return authors;
	}

	public void setAuthors(String[] authors) {
		this.authors = authors;
	}

	public double getAmazonRating() {
		return amazonRating;
	}

	public void setAmazonRating(double amazonRating) {
		this.amazonRating = amazonRating;
	}

	@Override
	public String toString() {
		return "Book [publicationYear=" + publicationYear + ", publisher=" + publisher + ", genre=" + genre
				+ ", authors=" + Arrays.toString(authors) + ", amazonRating=" + amazonRating + "]";
	}

}
