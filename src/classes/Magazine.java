package classes;

import abstracts.Publication;
import enums.Periodicity;

public class Magazine extends Publication {
	
	private Periodicity periodicity;	

	public Magazine(String ISBNCode, String title, int publishingYear, int pageNumber, Periodicity periodicity) {
		super(ISBNCode, title, publishingYear, pageNumber);		
			setPeriodicity(periodicity);				
	}
	
	public static Magazine fromCodedString(String x) {
		String[] split = x.split("@");		
		return new Magazine(split[0], split[1], Integer.parseInt(split[2]), Integer.parseInt(split[3]), Periodicity.valueOf(split[4]));
	}
	
	public Periodicity getPeriodicity() {
		return periodicity;
	}

	private void setPeriodicity(Periodicity periodicity) {
		this.periodicity = periodicity;
	}

	@Override
	public String toString() {
		return "Magazine Details: ISBNCode: " + this.getISBNCode() + " | Title: " + this.getTitle() + " | Year of Publication: " 
				+ this.getPublishingYear() + " | Page Count: " + this.getPageNumber() + " | Periodicity: " + getPeriodicity();		
	}
	
	@Override
	public String toCodedString() {
		return this.getISBNCode() + "@" + this.getTitle() + "@" + this.getPublishingYear() + "@" + this.getPageNumber() + "@" + getPeriodicity();
	}	
}
