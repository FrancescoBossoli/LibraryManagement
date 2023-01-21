package management;

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
import exceptions.UnacceptableDateException;

public class Archive {
	
//	Temporary data input to memorize data		
//	Publication book1 = new Book("9788804711957", "Il Trono di Spade", 2019, 829, "George R. R. Martin", "Fantasy");
//	Publication book2 = new Book("9788821561573", "La Sacra Bibbia", 2008, 1968, "Conferenza episcopale italiana", "Religion");
//	Publication book3 = new Book("9788804746676", "Il Codice da Vinci", 2022, 516, "Dan Brown", "Mistery");
//					
//	Publication magazine1 = new Magazine("9788891290212", "Monster Deluxe Vol.2", 2019, 400, Periodicity.MONTHLY);
//	Publication magazine2 = new Magazine("9788862670999", "Heavy Metal", 2022, 128, Periodicity.MONTHLY);
//	Publication magazine3 = new Magazine("5000089506400", "The Burlington Magazine Vol.1308", 2012, 40, Periodicity.MONTHLY);
//
//	public List<Publication> fillCatalog() {
//
//	addPublication(book1);
//	addPublication(book2);
//	addPublication(book3);
//
//	addPublication(magazine1);
//	addPublication(magazine2);
//	addPublication(magazine3);
//
//	return catalogueList;			
//	}
	
	private List<Publication> catalogueList = new ArrayList<>();

	private static Scanner input = new Scanner(System.in);	
	
	private static File backup = new File("storage/catalogue.txt");	
	
	public void saveData() {
		String codedString = "";
		for (Publication pub : catalogueList) {
			if (pub instanceof Book) codedString += "#$";
			else codedString += "#§";
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
			catalogueList.clear();
			Publication.resetCatalog();
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
				
	public void addPublication(Publication x) {
		catalogueList.add(x);
	}		
			
	public void removePublication(Publication x) {
		catalogueList.remove(x);
	}
			
	public void removeByISBN(String code) {
		catalogueList = catalogueList.stream().filter(pub -> !pub.getISBNCode().equals(code)).collect(Collectors.toList());
		Publication.removeISBNfromCodeList(code);		
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
		if (list.isEmpty()) System.out.println("No result has been found");		
		list.forEach(System.out::println);
	}
		
	public void mainMenu() {
		System.out.println("""
                                   ------------------------------------------------- 
                                   Interactive Library Archive: 
                                   1. Browse the Catalogue 
                                   2. Search for a Publication 
                                   3. Add a new Publication to the Archive 
                                   4. Remove a Publication from the Archive 
                                   5. Create a Local Backup 
                                   6. Load the last available Backup 
                                    
                                   0. Turn Off the Interactive Archive 
                                   """);
			
		int selection = 10;
		outerloop:
		while (selection != 0) {
			try {
				selection = Integer.parseInt(input.nextLine());
				switch (selection) {
				case 1 -> printList(getCatalog());
				case 2 -> {
                                    searchMenu();
                                    selection = Integer.parseInt(input.nextLine());
                                    switch (selection) {
                                        case 1 -> {
                                            System.out.println("Input the ISBN Code");
                                            printList(searchByISBN(input.nextLine()));
                                        }
                                        case 2 -> {
                                            System.out.println("Input the Year of Publishing");
                                            printList(searchByYear(Integer.parseInt(input.nextLine())));
                                        }
                                        case 3 -> {
                                            System.out.println("Input the Author");
                                            printList(searchByAuthor(input.nextLine()));
                                        }
                                        case 9 -> {}
                                        case 0 -> {
                                            break outerloop;
                                        }
                                    }
                                }
				case 3 -> {
                                    addMenu();
                                    String code, title, author, genre;
                                    int year, pages;
                                    selection = Integer.parseInt(input.nextLine());
                                    switch (selection) {
                                        case 1 -> {
                                            System.out.println("Input the ISBN Code");
                                            code = input.nextLine();
                                            System.out.println("Input the Title");
                                            title = input.nextLine();
                                            System.out.println("Input the Year of Publishing");
                                            year = Integer.parseInt(input.nextLine());
                                            if (year < 1500) throw new UnacceptableDateException("The publishing year can't be too far in the past");
                                            else if (year > 2023) throw new UnacceptableDateException("The publishing year can't be in the future");
                                            System.out.println("Input the Number of Pages");
                                            pages = Integer.parseInt(input.nextLine());
                                            System.out.println("Input the Author");
                                            author = input.nextLine();
                                            System.out.println("Input the Genre");
                                            genre = input.nextLine();
                                            addPublication(new Book(code, title, year, pages, author, genre));
                                        }
                                        case 2 -> {
                                            System.out.println("Input the ISBN Code");
                                            code = input.nextLine();
                                            System.out.println("Input the Title");
                                            title = input.nextLine();
                                            System.out.println("Input the Year of Publishing");
                                            year = Integer.parseInt(input.nextLine());
                                            if (year < 1500) throw new UnacceptableDateException("The publishing year can't be too far in the past");
                                            else if (year > 2023) throw new UnacceptableDateException("The publishing year can't be in the future");
                                            System.out.println("Input the Number of Pages");
                                            pages = Integer.parseInt(input.nextLine());
                                            System.out.println("Input the periodicity");
                                            try {
                                                Periodicity period = Periodicity.valueOf(input.nextLine().toUpperCase());
                                                addPublication(new Magazine(code, title, year, pages, period));
                                            } catch (IllegalArgumentException e) {
                                                System.out.println("Periodicity can be only expressed as 'Weekly', 'Monthly' or 'Biannual'");
                                            }
                                        }
                                        case 9 -> {}
                                        case 0 -> {
                                            break outerloop;
                                        }
                                    }
                                }
				case 4 -> {
                                    System.out.println("Input the ISBN Code of the Publication you want to delete");
                                    removeByISBN(input.nextLine());
                                    System.out.println("Any publications with the specified code have been removed from the archive");
                                }
				case 5 -> saveData();
				case 6 -> printList(readData());
				case 0 -> {
                                    break outerloop;
                                }					
				}
				mainMenu();				
			} catch (NumberFormatException e) {
				System.out.println("You have to input a valid number");
				mainMenu();	
			} catch (UnacceptableDateException e) {
				System.out.println(e.getMessage());
				mainMenu();
			}
		}		
	}
		
	public void searchMenu() {
		System.out.println("""
                                   ------------------------------------------------- 
                                   What parameter do you want to use in your search? 
                                   1. ISBN Code 
                                   2. Year of Publishing 
                                   3. Author 
                                    
                                   9. Go Back 
                                   0. Turn Off the Interactive Archive 
                                   """);
	}
		
	public void addMenu() {
		System.out.println("""
                                   -------------------------------------------------
                                   What kind of Publication do you want to add? 
                                   1. Book 
                                   2. Magazine 
                                    
                                   9. Go Back 
                                   0. Turn Off the Interactive Archive 
                                   """);
	}	
}