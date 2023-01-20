package main;

public class LibraryCatalog {
	
	private static Archive archive = new Archive();	

	public static void main(String[] args) {
		
		//Temporary Data fill
		//System.out.println(a.fillCatalog());
		//a.saveData();		
		
		//data loading at session start
		archive.readData();
		
		archive.mainMenu();		
	}
}
