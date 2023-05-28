package p;
import java.util.*;

public class Cart {
	public static final int MAX_NUMBER_ORDERED=20;
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	
	public void addMedia(Media a) {
		boolean check = itemsOrdered.contains(a);
		if (check) {
			System.out.println("Item already in cart");
		}
		else {
			itemsOrdered.add(a);
		}
	}
	
	public void removeMedia(Media a) {
		boolean check = itemsOrdered.contains(a);
		if (check) {
			itemsOrdered.remove(a);
		}
		else {
			System.out.println("Item not in cart");
		}
	}
	
	public void removeMedia(int i) {
		if (i<itemsOrdered.size()) {
			itemsOrdered.remove(i-1);
		}
	}
	
	public float totalCost() {
		float cost=0f;
		for (int i=0; i<itemsOrdered.size(); i++) {
			cost += itemsOrdered.get(i).getCost();
		}
		return cost;
	}
	
	public void printOrder() {
		System.out.println("***********************CART***********************");
		System.out.println("Ordered items: ");
		for (int i=0; i<itemsOrdered.size(); i++) {
			System.out.println((i+1)+".DVD - "+ itemsOrdered.get(i).toString());
			
		}
		System.out.println("Total cost: "+totalCost() );
	}
	
	public void searchID (int id_search) {
		for (int i=0; i<itemsOrdered.size(); i++) {
			if (itemsOrdered.get(i).getId() == id_search) {
				System.out.println("Item found:");
				System.out.println(itemsOrdered.get(i).toString());
				return;
			}
		}
		System.out.println("Item not found");
	}
	
	public void searchTitle( String title_search) {
		for (int i=0 ; i<itemsOrdered.size(); i++) {
			if (itemsOrdered.get(i).getTitle().equals(title_search)) {
				System.out.println("Item found:");
				System.out.println(itemsOrdered.get(i).toString());
				return;
			}
		}
		System.out.println("Item not found");
	}
	
	public void sortByTitleCost() {
		Comparator<Media> compareByTitleCost = Comparator.comparing(Media::getTitle).thenComparing(Media::getCost,Comparator.reverseOrder());
		Collections.sort(itemsOrdered,compareByTitleCost);
		printOrder();
	}
	
	public void sortByCostTitle() {
		Comparator<Media> compareByCostTitle = Comparator.comparing(Media::getCost,Comparator.reverseOrder()).thenComparing(Media::getTitle);
		Collections.sort(itemsOrdered,compareByCostTitle);
		printOrder();
	}
	
	public Media getMedia(int i) {
		return itemsOrdered.get(i);
	}
	
	public void emptyCart() {
		itemsOrdered.clear();
	}
}

