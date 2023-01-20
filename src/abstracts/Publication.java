package abstracts;

import java.util.ArrayList;
import java.util.List;

import exceptions.ISBNException;

//abstract class shared between books and magazines
public abstract class Publication {

	private static List<String> univocalCodes = new ArrayList<>();
	private String ISBNCode;	
	private String title;
	private int publishingYear;
	private int pageNumber;
	
	public Publication(String ISBNCode, String title, int publishingYear, int pageNumber) {
		try {
			this.setISBNCode(ISBNCode);
			this.setTitle(title);
			this.setPublishingYear(publishingYear);
			this.setPageNumber(pageNumber);
		} catch (ISBNException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public String getISBNCode() {
		return ISBNCode;
	}
	
	protected void setISBNCode(String ISBNCode) {
		if (!univocalCodes.contains(ISBNCode)) {
			this.ISBNCode = ISBNCode;
			univocalCodes.add(ISBNCode);
		} else {
			throw new ISBNException("Errore: Codice ISBN " + ISBNCode + " già assegnato a una voce in catalogo");
		}
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPublishingYear() {
		return publishingYear;
	}

	public void setPublishingYear(int publishingYear) {
		this.publishingYear = publishingYear;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public abstract String toCodedString();

}
