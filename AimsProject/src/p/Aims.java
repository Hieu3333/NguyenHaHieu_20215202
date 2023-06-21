package p;
import java.util.*;

import javax.naming.LimitExceededException;

import hust.soict.globalict.aims.exception.PlayerException;
public class Aims {
	
	private static Scanner input = new Scanner(System.in);
	
	public static void showMenu() { 

		System.out.println("AIMS: "); 

		System.out.println("--------------------------------"); 

		System.out.println("1. View store"); 

		System.out.println("2. Update store"); 

		System.out.println("3. See current cart"); 

		System.out.println("0. Exit"); 

		System.out.println("--------------------------------"); 

		System.out.println("Please choose a number: 0-1-2-3"); 

		} 
	
	public static void storeMenu() { 

		System.out.println("Options: "); 

		System.out.println("--------------------------------"); 

		System.out.println("1. See a media’s details"); 

		System.out.println("2. Add a media to cart"); 

		System.out.println("3. Play a media"); 

		System.out.println("4. See current cart"); 

		System.out.println("0. Back"); 

		System.out.println("--------------------------------"); 

		System.out.println("Please choose a number: 0-1-2-3-4"); 
	} 
	
	public static void mediaDetailsMenu() { 

		System.out.println("Options: "); 

		System.out.println("--------------------------------"); 

		System.out.println("1. Add to cart"); 

		System.out.println("2. Play"); 

		System.out.println("0. Back"); 

		System.out.println("--------------------------------"); 

		System.out.println("Please choose a number: 0-1-2"); 

		} 
	
	public static void cartMenu() { 

		System.out.println("Options: "); 

		System.out.println("--------------------------------"); 

		System.out.println("1. Filter medias in cart"); 

		System.out.println("2. Sort medias in cart"); 

		System.out.println("3. Remove media from cart"); 

		System.out.println("4. Play a media"); 

		System.out.println("5. Place order"); 

		System.out.println("0. Back"); 

		System.out.println("--------------------------------"); 

		System.out.println("Please choose a number: 0-1-2-3-4-5"); 

		} 
	
	
	
	
	public static void main(String[] args) throws LimitExceededException, PlayerException {
		Store store = new Store();
		Cart cart = new Cart();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
				"Animation","Roger Allers",87, 19.95f);
		store.addMedia(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", 
				"Science fiction", "George Lucas",87, 24.95f);
		store.addMedia(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin","Animation",18.99f);
		store.addMedia(dvd3);
		
		int command;
		// Main menu
		do {
		showMenu();
		command = input.nextInt();
		switch (command) { 
		case 1:{  //View store
			storeMenu();
			command = input.nextInt();
			if (command ==1) {    //See media detail
				System.out.println("Enter title:");
				input.nextLine();
				String t = input.nextLine();
				store.searchItemByTitle(t);
				int item = store.getItemByTitle(t);
				if (item == -1) {
					break;
				}
				mediaDetailsMenu();
				command = input.nextInt();
				if (command == 1) { // Add to cart
				
					try {
						cart.addMedia(store.getMedia(item));
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				if (command == 2) { //Play
					store.getMedia(item).play();
				}
				if (command == 0) {
					command = -1;
					break;
				}
				break;
			}
			
			if (command == 2) { //Add a media to cart
				System.out.println("Enter title:");
				input.nextLine();
				String t = input.nextLine();
				int item = store.getItemByTitle(t);
				cart.addMedia(store.getMedia(item));
				break;
			}
			
			if (command == 3) {
				input.nextLine();
				System.out.println("Enter title:");
				String t = input.nextLine();
				int item = store.getItemByTitle(t);
				try {
				store.getMedia(item).play();
				}catch (PlayerException e) {
					e.printStackTrace();
				}
				break;
			}
			
			if (command == 4) {
				cart.printOrder();
				break;
			}
			if (command == 0) {
				command = -1;
				break;
			}
			break;
		}
		
		case 2:{  //Update store
			System.out.println("1.Add media");
			System.out.println("2.Remove media");
			command = input.nextInt();
			if (command == 1) {
				System.out.println("1.DVD");
				System.out.println("2.Book");
				command = input.nextInt();
				if (command == 1) {
					System.out.println("Enter title:");
					input.nextLine();
					String title = input.nextLine();
					System.out.println("Enter category:");
					input.nextLine();
					String category = input.nextLine();
					System.out.println("Enter cost:");
					float cost = input.nextFloat();
					DigitalVideoDisc dvd = new DigitalVideoDisc(title,category,cost);
					store.addMedia(dvd);
				}
				if (command == 2) {
					input.nextLine();
					System.out.println("Enter title:");
					String title = input.nextLine();
					input.nextLine();
					System.out.println("Enter category:");
					String category = input.nextLine();
					System.out.println("Enter cost:");
					float cost = input.nextFloat();
					Book b = new Book(title,category,cost);
					store.addMedia(b);
				}
				
			}
			else {
				System.out.println("Enter id you want to remove:");
				int id = input.nextInt();
				store.removeMedia(store.getMedia(id-1));
				
			}
			break;
		}
		
		case 3:{ //See current card
			cart.printOrder();
			cartMenu();
			command = input.nextInt();
			if (command == 0 ) {
				command = -1;
				break;
			}
			if (command == 1) {
				System.out.println("1.Filter by title");
				System.out.println("2.Filter by id");
				command = input.nextInt();
				if (command==1) {
					System.out.println("Title:");
					input.nextLine();
					String t = input.nextLine();
					cart.searchTitle(t);
				}
				else {
					System.out.println("ID:");
					command = input.nextInt();
					cart.searchID(command);
				}
			}
			if (command == 2) {
				System.out.println("1.Sort by title");
				System.out.println("2.Sort by cost");
				command = input.nextInt();
				if (command ==1 ) {
					cart.sortByTitleCost();
				}
				else {
					cart.sortByCostTitle();
				}
			}
			if (command == 3) {
				System.out.println("Remove ID:");
				command = input.nextInt();
				cart.removeMedia(command);
			}
			if (command == 4) {
				System.out.println("Choose media to play:");
				command = input.nextInt();
				cart.getMedia(command).play();
				break;
			}
			if (command == 5) {
				System.out.println("An order is created");
				cart.emptyCart();
			}
			break;
		}
		
		case 0: 
			break;
		} 
		
		}while(command != 0);
		

	}

}
