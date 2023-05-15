package p;

public class Cart {
	public static final int MAX_NUMBER_ORDERED=20;
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBER_ORDERED]; 
	private int qtyOrdered =0;
	
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered>=MAX_NUMBER_ORDERED) {
			System.out.println("Reached max number ordered");
		}
		else {
			itemsOrdered[qtyOrdered] = disc;
			qtyOrdered++;
			if (qtyOrdered==MAX_NUMBER_ORDERED) {
				System.out.println("The cart is almost full");
			}
			else {
				System.out.println("The disk has been added");
			}
		}
	}
	
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		for (int i=0; i<qtyOrdered;i++) {
			if (itemsOrdered[i] == disc) {
				for (int j=i; j<qtyOrdered; j++) {
					itemsOrdered[j]=itemsOrdered[j+1];
				}
				qtyOrdered--;
				System.out.println("Disk removed. Number of disks remained: "+qtyOrdered);
				return;
			}
		}
		System.out.println("DVD not in cart");
		
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList) {
		int length = dvdList.length;
		if ((qtyOrdered + length) >= MAX_NUMBER_ORDERED) {
			System.out.println("Can't add to cart");
		}
		else {
			for (int i=0; i<length; i++) {
				itemsOrdered[qtyOrdered+i] = dvdList[i]; 
			}
			qtyOrdered += length;
			System.out.print(length+" disks added. ");
			System.out.println("Number of disks:"+qtyOrdered);
		}
		
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc dvd1,DigitalVideoDisc dvd2) {
		if ((qtyOrdered+2)>=MAX_NUMBER_ORDERED) {
			System.out.println("Can't add to cart");
		}
		else {
			itemsOrdered[qtyOrdered] = dvd1;
			itemsOrdered[qtyOrdered+1] = dvd2;
			qtyOrdered+=2;
			System.out.println("Number of disks:"+qtyOrdered);
		}
	}
	
	public float totalCost() {
		float cost=0f;
		for (int i=0; i<qtyOrdered; i++) {
			cost += itemsOrdered[i].getCost();
		}
		return cost;
	}
	
	public void printOrder() {
		System.out.println("***********************CART***********************");
		System.out.println("Ordered items: ");
		for (int i=0; i<qtyOrdered; i++) {
			System.out.println((i+1)+".DVD - "+ itemsOrdered[i].toString());
			
		}
		System.out.println("Total cost: "+totalCost() );
	}
	
	public void searchID (int id_search) {
		for (int i=0; i<qtyOrdered; i++) {
			if (itemsOrdered[i].getID() == id_search) {
				System.out.println("Item found:");
				System.out.println(itemsOrdered[i].toString());
				return;
			}
		}
		System.out.println("Item not found");
	}
	
	public void searchTitle( String title_search) {
		for (int i=0 ; i<qtyOrdered; i++) {
			if (itemsOrdered[i].getTitle().equals(title_search)) {
				System.out.println("Item found:");
				System.out.println(itemsOrdered[i].toString());
				return;
			}
		}
		System.out.println("Item not found");
	}
}

