package classes;

import abstracts.Publication;
import exceptions.FieldLengthException;

public class Book extends Publication {
	
	private String author;
	private String genre;
	
	public Book(String ISBNCode, String title, int publishingYear, int pageNumber, String author, String genre) {
		super(ISBNCode, title, publishingYear, pageNumber);
		this.setAuthor(author);
		this.setGenre(genre);
	}
	
	public static Book fromCodedString(String x) {
		String[] split = x.split("@");		
		return new Book(split[0], split[1], Integer.valueOf(split[2]), Integer.valueOf(split[3]), split[4], split[5]);		
	}
	
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		if (author.length()>2) this.author = author;		
		else throw new FieldLengthException("A Publication's Author field can't be less than 3 characters long");
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		if (genre.length()>2) this.genre = genre;		
		else throw new FieldLengthException("A Publication's Title can't be less than 2 characters long");
	}
	
	@Override
	public String toString() {
		return "Book Details: ISBNCode: " + this.getISBNCode() + " | Title: " + this.getTitle() + " | Author: " + this.getAuthor() + 
			" | Genre: " + this.getGenre() + " | Year of Publication: " + this.getPublishingYear() + " | Page Count: " + this.getPageNumber();		
	}
	
	public String toCodedString() {
		return this.getISBNCode() + "@" + this.getTitle() + "@" + this.getPublishingYear() + "@" + this.getPageNumber() + "@" + this.getAuthor() + "@" + this.getGenre();		
	}
}
