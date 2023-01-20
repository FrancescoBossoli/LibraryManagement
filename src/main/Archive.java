package main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import org.apache.commons.io.FileUtils;
import abstracts.Publication;
import classes.*;
import enums.Periodicity;

public class Archive {
	
	private List<Publication> catalogueList = new ArrayList<>();

	private static Scanner input = new Scanner(System.in);	
	
	private static File backup = new File("storage/catalogue.txt");
	
	
	public void saveData() {
		String codedString = "";
		for (Publication pub : catalogueList) {
			if (pub instanceof Book) codedString += "#$";
			else codedString += "#&";
			codedString += pub.toCodedString();			
		}
		try {
			FileUtils.writeStringToFile(backup, codedString, "UTF-8");
			System.out.println("The library catalogue has been correctly saved on the hard drive");
		} catch (IOException e) {
			System.out.println("The saving process has not been possible");
		}
	}
	

	
	public List<Publication> readData() {
		try {
			String x = FileUtils.readFileToString(backup, "UTF-8");
			List<String> publications = Arrays.asList(x.split("#"));
			for (String pub : publications) {
				Publication newPub = null;
				if (pub.startsWith("$")) {
					newPub = Book.fromCodedString(pub.replace("$", ""));
				} else if (pub.startsWith("§")) {
					newPub = Magazine.fromCodedString(pub.replace("§", ""));
				}			
				if (newPub != null) catalogueList.add(newPub);
			}
		} catch (IOException e) {
			System.out.println("It wasn't possible to retrieve data from the specified location");
		} 		
		return catalogueList;
	}		
		
//		Temporary data input to memorize data		
//		Publication book1 = new Book("9788804711957", "Il Trono di Spade", 2019, 829, "George R. R. Martin", "Fantasy");
//		Publication book2 = new Book("9788821561573", "La Sacra Bibbia", 2008, 1968, "Conferenza episcopale italiana", "Religion");
//		Publication book3 = new Book("9788804746676", "Il Codice da Vinci", 2022, 516, "Dan Brown", "Mistery");
//						
//		Publication magazine1 = new Magazine("9788891290212", "Monster Deluxe Vol.2", 2019, 400, Periodicity.MONTHLY);
//		Publication magazine2 = new Magazine("9788862670999", "Heavy Metal", 2022, 128, Periodicity.MONTHLY);
//		Publication magazine3 = new Magazine("5000089506400", "The Burlington Magazine Vol.1308", 2012, 40, Periodicity.MONTHLY);
//
//		public List<Publication> fillCatalog() {
//	
//		addPublication(book1);
//		addPublication(book2);
//		addPublication(book3);
//	
//		addPublication(magazine1);
//		addPublication(magazine2);
//		addPublication(magazine3);
//	
//		return catalogueList;			
//		}
//				
		public void addPublication(Publication x) {
			catalogueList.add(x);
		}		
			
		public void removePublication(Publication x) {
			catalogueList.remove(x);
		}
			
		public void removeByISBN(String code) {
			catalogueList = catalogueList.stream().filter(pub -> !pub.getISBNCode().equals(code)).collect(Collectors.toList());
		}		
		
		public List<Publication> searchByISBN(String code) {
			return catalogueList.stream().filter(pub -> pub.getISBNCode().equals(code)).collect(Collectors.toList());			
		}
		
		public List<Publication> searchByYear(int year) {
			return catalogueList.stream().filter(pub -> Integer.toString(pub.getPublishingYear()).equals(Integer.toString(year))).collect(Collectors.toList());			
		}
		// partial match research preferred
		public List<Publication> searchByAuthor(String author) {
			return catalogueList.stream().filter(pub -> pub instanceof Book && ((Book)pub).getAuthor().contains(author)).collect(Collectors.toList());			
		}
		
		public List<Publication> getCatalog() {
			return catalogueList;
		}
		
		private static void printList(List<Publication> list) {
			if (list.size() == 0) System.out.println("No result has been found");		
			list.forEach(System.out::println);
		}
		
		public void mainMenu() {
			System.out.println(	  "------------------------------------------------- \n"
								+ "Interactive Library Archive: \n" 
								+ "1. Browse the Catalogue \n" 
								+ "2. Search for a Publication \n"
								+ "3. Add a new Publication to the Archive \n" 
								+ "4. Remove a Publication from the Archive \n"
								+ "5. Create a Local Backup \n" 
								+ "6. Load the last available Backup \n \n" 
								+ "0. Turn Off the Interactive Archive \n");
			
			int selection = 10;
			outerloop:
			while (selection != 0) {
				try {
					selection = Integer.parseInt(input.nextLine());
					switch (selection) {
					case 1:
						printList(getCatalog());
						break;
					case 2:
						 searchMenu();
						 selection = Integer.parseInt(input.nextLine());
						 switch (selection) {
							case 1:
								System.out.println("Input the ISBN Code");
								printList(searchByISBN(input.nextLine()));
								break;
							case 2:
								System.out.println("Input the Year of Publishing");
								printList(searchByYear(Integer.parseInt(input.nextLine())));
								break;
							case 3:
								System.out.println("Input the Author");
								printList(searchByAuthor(input.nextLine()));
								break;						
							case 9:
								break;
							case 0:
								break outerloop;
						 }
						 break;
					case 3:
						addMenu();
						String code, title, author, genre = null;
						int year, pages = 0;
						selection = Integer.parseInt(input.nextLine());
						switch (selection) {
							case 1:
								System.out.println("Input the ISBN Code");
								code = input.nextLine();
								System.out.println("Input the Title");
								title = input.nextLine();
								System.out.println("Input the Year of Publishing");
								year = Integer.parseInt(input.nextLine());
								System.out.println("Input the Number of Pages");
								pages = Integer.parseInt(input.nextLine());
								System.out.println("Input the Author");
								author = input.nextLine();
								System.out.println("Input the Genre");
								genre = input.nextLine();
								addPublication(new Book(code, title, year, pages, author, genre));
								break;
							case 2:
								System.out.println("Input the ISBN Code");
								code = input.nextLine();
								System.out.println("Input the Title");
								title = input.nextLine();
								System.out.println("Input the Year of Publishing");
								year = Integer.parseInt(input.nextLine());
								System.out.println("Input the Number of Pages");
								pages = Integer.parseInt(input.nextLine());
								System.out.println("Input the periodicity");
								Periodicity period = Periodicity.valueOf(input.nextLine());							
								addPublication(new Magazine(code, title, year, pages, period));
								break;
							case 9:
								break;
							case 0:
								break outerloop;
						}
						break;
					case 4:
						System.out.println("Input the ISBN Code of the Publication you want to delete");
						removeByISBN(input.nextLine());
						System.out.println("Any publications with the specified code have been removed from the archive");
						break;
					case 5: 
						saveData();
						break;
					case 6:
						printList(readData());
						break;
					case 0:
						break outerloop;					
					}
					mainMenu();				
				} catch (NumberFormatException e) {
					System.out.println("You have to input a valid selection number");
				} 
			}		
		}
		
		public void searchMenu() {
			System.out.println(	  "------------------------------------------------- \n"
								+ "What parameter do you want to use in your search? \n" 
								+ "1. ISBN Code \n" 
								+ "2. Year of Publishing \n"
								+ "3. Author \n \n"
								+ "9. Go Back \n" 
								+ "0. Turn Off the Interactive Archive \n");
		}
		
		public void addMenu() {
			System.out.println(	  "-------------------------------------------------"
								+ "What kind of Publication do you want to add? \n" 
								+ "1. Book \n" 
								+ "2. Magazine \n \n"								
								+ "9. Go Back \n" 
								+ "0. Turn Off the Interactive Archive \n");
		}
		
		
	
	
	
}
