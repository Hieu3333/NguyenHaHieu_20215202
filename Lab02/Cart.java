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
	
	public float totalCost() {
		float cost=0f;
		for (int i=0; i<qtyOrdered; i++) {
			cost += itemsOrdered[i].getCost();
		}
		return cost;
	}
	
}

