package p;
import java.util.*;
public class Store {
	private int N = 100;
	private List<Media> itemsInStore = new ArrayList<Media>();
	
	
	
	public void addMedia(Media a) {
		if (itemsInStore.size()>=N) {
			System.out.println("Store is full");
		}
		else {
			itemsInStore.add(a);
		}
	}
	
	public void removeMedia(Media a) {
		boolean check = itemsInStore.contains(a);
		if (check) {
			itemsInStore.remove(a);
		}
		else {
			System.out.println("Item not in store");
		}
		
	}
	
	
	
	public Media getMedia(int i) {
		return itemsInStore.get(i);
	}
	
	public void printStore() {
		System.out.println("***********************STORE***********************");
		System.out.println("Items: ");
		for (int i=0; i<itemsInStore.size(); i++) {
			System.out.println((i+1)+".DVD - "+ itemsInStore.get(i).toString());
			
		}
	}
	
	public void searchItemByTitle(String title_search) {
		
		for (int i=0; i<itemsInStore.size(); i++) {
			if (itemsInStore.get(i).getTitle().equals(title_search)) {
				System.out.println(itemsInStore.get(i).toString());
				return;
			}
		}
		System.out.println("Item not in store");
		
		
	}
	public int getItemByTitle(String title_search) {
		for (int i=0; i<itemsInStore.size(); i++) {
			if (itemsInStore.get(i).getTitle().equals(title_search)) {
				return i;
			}			
		}
		
		return -1;
		}

	
	
	
}
