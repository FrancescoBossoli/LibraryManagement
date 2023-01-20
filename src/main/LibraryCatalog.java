package main;



import java.util.List;
import java.util.Scanner;

import abstracts.Publication;

public class LibraryCatalog {
	
	private static Scanner input = new Scanner(System.in);	
	private static Archive archive = new Archive();
	
	private static void printList(List<Publication> list) {
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
							String selection2 = input.nextLine();
							printList(archive.searchByISBN(selection2));
							break;
					 }
				}
				archive.mainMenu();
				
			} catch (NumberFormatException e) {
				System.out.println("You have to input a valid selection number");
			} 
		}
		
		
	}

}
