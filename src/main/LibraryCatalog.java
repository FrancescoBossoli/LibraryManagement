package main;



import java.util.List;
import java.util.Scanner;

import abstracts.Publication;
import classes.Book;
import classes.Magazine;
import enums.Periodicity;

public class LibraryCatalog {
	
	private static Scanner input = new Scanner(System.in);	
	private static Archive archive = new Archive();
	
	private static void printList(List<Publication> list) {
		if (list.size() == 0) System.out.println("No result has been found");		
		list.forEach(System.out::println);
	}

	public static void main(String[] args) {
		
		//System.out.println(a.fillCatalog());
		//a.saveData();
		
		//printList(a.readData());
		
		//data loading at session start
		archive.readData();
		
		archive.mainMenu();
		int selection = 10;
		outerloop:
		while (selection != 0) {
			try {
				selection = Integer.parseInt(input.nextLine());
				switch (selection) {
				case 1:
					printList(archive.getCatalog());
					break;
				case 2:
					 archive.searchMenu();
					 selection = Integer.parseInt(input.nextLine());
					 switch (selection) {
						case 1:
							System.out.println("Input the ISBN Code");
							printList(archive.searchByISBN(input.nextLine()));
							break;
						case 2:
							System.out.println("Input the Year of Publishing");
							printList(archive.searchByYear(Integer.parseInt(input.nextLine())));
							break;
						case 3:
							System.out.println("Input the Author");
							printList(archive.searchByAuthor(input.nextLine()));
							break;						
						case 9:
							break;
						case 0:
							break outerloop;
					 }
					 break;
				case 3:
					archive.addMenu();
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
							archive.addPublication(new Book(code, title, year, pages, author, genre));
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
							archive.addPublication(new Magazine(code, title, year, pages, period));
							break;
						case 9:
							break;
						case 0:
							break outerloop;
					}
					break;
				case 4:
					System.out.println("Input the ISBN Code of the Publication you want to delete");
					archive.removeByISBN(input.nextLine());
					System.out.println("Any publications with the specified code have been removed from the archive");
					break;
				case 5: 
					archive.saveData();
					break;
				case 6:
					printList(archive.readData());
					break;
				case 0:
					break outerloop;					
				}
				archive.mainMenu();				
			} catch (NumberFormatException e) {
				System.out.println("You have to input a valid selection number");
			} 
		}		
	}
}
