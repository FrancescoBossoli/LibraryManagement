package abstracts;

import java.util.ArrayList;
import java.util.List;

import exceptions.FieldLengthException;
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
		} 	catch (ISBNException e) {
			System.out.println(e.getMessage());
		}	catch (FieldLengthException e) {
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
			throw new ISBNException("Error: Code ISBN " + ISBNCode + " already used in the Library Catalogue");
		}
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		if (title.length()>2) this.title = title;
		else throw new FieldLengthException("A Publication's Title field can't be less than 3 characters long");
	}

	public int getPublishingYear() {
		return publishingYear;
	}
	//missing exception because the control is on the input
	public void setPublishingYear(int publishingYear) {
		this.publishingYear = publishingYear;
	}

	public int getPageNumber() {
		return pageNumber;
	}
	//missing exception because the control is on the input 
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public abstract String toCodedString();
}
