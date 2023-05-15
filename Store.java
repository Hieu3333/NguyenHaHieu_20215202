package p;

public class Store {
	private int N = 100;
	private DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc[N];
	
	private int n = 0;
	public void addDVD(DigitalVideoDisc dvd) {
		if (n>=N) {
			System.out.println("Store is full");
		}
		else {
			itemsInStore[n] = dvd;
			n++;
		}
	}
	
	public void removeDVD(DigitalVideoDisc dvd) {
		for (int i=0; i<n; i++) {
			if (itemsInStore[i] == dvd) {
				for (int j=i; j<n; j++) {
					itemsInStore[j] = itemsInStore[j+1];
				}
				n--;
				return;
			}
		}
		System.out.println("DVD not in store");
	}
	
	public void printStore() {
		System.out.println("***********************STORE***********************");
		System.out.println("Items: ");
		for (int i=0; i<n; i++) {
			System.out.println((i+1)+".DVD - "+ itemsInStore[i].toString());
			
		}
	}
	
	
	
}
