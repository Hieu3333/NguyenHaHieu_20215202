package aims_screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.naming.LimitExceededException;
import javax.swing.*;

import p.*;
import hust.soict.globalict.aims.screen.*;

public class StoreScreen extends JFrame{
	private Store store;
	private Cart cart;
	
	public StoreScreen(Store store, Cart cart) {
		this.store= store;
		this.cart= cart;
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		
		cp.add(createNorth(),BorderLayout.NORTH);
		cp.add(createCenter(),BorderLayout.CENTER);
		
		this.setVisible(true);
		this.setTitle("Store");
		this.setSize(1024,768);
	}
	
	
	
	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north,BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
	
		return north;
	}
	
	
	JMenuBar createMenuBar(){
		JMenu menu = new JMenu("Options");
		ButtonListener btnListener = new ButtonListener();
		
		JMenu smUpdateStore = new JMenu("Update Store");
		JMenuItem addBook = new JMenuItem("Add Book");
		addBook.addActionListener(btnListener);
		smUpdateStore.add(addBook);
		
		JMenuItem addDVD = new JMenuItem("Add DVD");
		addDVD.addActionListener(btnListener);
		smUpdateStore.add(addDVD);
		
		JMenuItem addCD = new JMenuItem("Add CD");
		addCD.addActionListener(btnListener);
		smUpdateStore.add(addCD);
		
		menu.add(smUpdateStore);
		menu.add(new JMenuItem("View Store"));
		menu.add(new JMenuItem("View Cart"));
		
		JMenuBar menuBar = new  JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);
		
		return menuBar;
	}
	
	JPanel createHeader() {
		ButtonListener btnListener = new ButtonListener();
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header,BoxLayout.X_AXIS));
		
		JLabel title = new JLabel("AIMS");
		title.setFont(new Font(title.getFont().getName(),Font.PLAIN,50));
		title.setForeground(Color.CYAN);
		
		JButton cart =  new JButton("View cart");
		cart.addActionListener(btnListener);
		cart.setPreferredSize(new Dimension(100,50));
		cart.setMaximumSize(new Dimension(100,50));
		
		header.add(Box.createRigidArea(new Dimension(10,10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(cart);
		header.add(Box.createRigidArea(new Dimension(10,10)));
		return header;
		
	}
	
	JPanel createCenter() {
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(3,3,2,2));
		
		ArrayList<Media> mediaInStore = store.getItemsInStore();
		for (int i=0; i<store.getItemsInStore().size(); i++) {
			MediaStore cell =  new MediaStore(mediaInStore.get(i),cart);
			center.add(cell);
		}
		return center;
	}
	
	public static void main(String[] args) {
	
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
		
		Book b = new Book("Dune","Sci-Fi",10f);
		store.addMedia(b);
		
		try {
		cart.addMedia(b);
		cart.addMedia(dvd1);
		}catch (LimitExceededException e) {
			e.printStackTrace();
		}
		
		new StoreScreen(store,cart);
	}
	
	
	public class ButtonListener implements ActionListener{
		@Override 
		public void actionPerformed(ActionEvent e) {
			String button = e.getActionCommand();
			if (button.equals("View cart")) {
				new CartScreen(cart);
			}
			
			if (button.equals("Add Book")) {
				new AddBookToStoreScreen(store,cart);
				
			}
			if (button.equals("Add DVD")) {
				new AddDVDToStoreScreen(store,cart);
			}
			if (button.equals("Add CD")) {
				new AddCDToStoreScreen(store,cart);
			}
			if (button.equals("View Store")) {
				new StoreScreen(store,cart);
			}
			
		}
	}
	
	
	

}
