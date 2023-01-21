package abstracts;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
		} 	catch (ISBNException | FieldLengthException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public String getISBNCode() {
		return ISBNCode;
	}
	
	private void setISBNCode(String ISBNCode) {
		if (!univocalCodes.contains(ISBNCode)) {
			this.ISBNCode = ISBNCode;
			univocalCodes.add(ISBNCode);
		} else {
			throw new ISBNException("Error: Code ISBN " + ISBNCode + " already used in the Library Catalogue");
		}
	}
	
	public static void removeISBNfromCodeList(String ISBNCode) {
		univocalCodes = univocalCodes.stream().filter(code -> !code.equals(ISBNCode)).collect(Collectors.toList());
	}
	
	public static void resetCatalog() {
		univocalCodes.clear();
	}

	public String getTitle() {
		return title;
	}

	private void setTitle(String title) {
		if (title.length()>2) this.title = title;
		else throw new FieldLengthException("A Publication's Title field can't be less than 3 characters long");
	}

	public int getPublishingYear() {
		return publishingYear;
	}
	//missing exception because the control is on the input
	private void setPublishingYear(int publishingYear) {
		this.publishingYear = publishingYear;
	}

	public int getPageNumber() {
		return pageNumber;
	}
	//missing exception because the control is on the input 
	private void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public abstract String toCodedString();
}
