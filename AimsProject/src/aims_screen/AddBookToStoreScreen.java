package aims_screen;

import p.*;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;



public class AddBookToStoreScreen extends JFrame {
    private Store store;
    private Cart cart;
    private JTextField inputName = new JTextField(10);
    private JTextField inputCategory = new JTextField(10);
    private JTextField inputCost = new JTextField(10);
    private JTextField inputAuthor= new JTextField(10);
    private JButton add = new JButton("Add");
	public AddBookToStoreScreen(Store store, Cart cart) {
		this.store = store;
		this.cart = cart;
		
		ButtonListener btnListener = new ButtonListener();
		Container cp = getContentPane();
		cp.setLayout(new GridLayout(5,2));
		cp.add(new JLabel("Name:"));
		cp.add(inputName);
		//inputName.addActionListener(btnListener);
		
		cp.add(new JLabel("Category:"));
		cp.add(inputCategory);
		//inputCategory.addActionListener(btnListener);
		
		cp.add(new JLabel("Cost:"));
		cp.add(inputCost);
		//inputCost.addActionListener(btnListener);
		
		cp.add(new JLabel("Author:"));
		cp.add(inputAuthor);
		//inputAuthor.addActionListener(btnListener);
		
		cp.add(add);
		add.addActionListener(btnListener);
		
		setTitle("Add Book");
		setSize(350,120);
		setVisible(true);
		 
		
		
	}
	
	public class ButtonListener implements ActionListener{
		
		@Override
		public void actionPerformed(java.awt.event.ActionEvent e) {
			String button = e.getActionCommand();
			if (button.equals("Add")) {
			String name = inputName.getText();
			String category = inputCategory.getText();
			float cost = Float.parseFloat(inputCost.getText());
			String author = inputAuthor.getText();
			
			
		    Book b = new Book(name,category,cost);
			b.addAuthor(author);
			store.addMedia(b);
			dispose();
			new StoreScreen(store,cart);
			}
			
		}
	}


}
