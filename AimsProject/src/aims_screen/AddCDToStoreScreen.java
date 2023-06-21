package aims_screen;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


import p.*;

public class AddCDToStoreScreen extends JFrame {

	private Store store;
    private Cart cart;
    private JTextField inputName = new JTextField(10);
    private JTextField inputCategory = new JTextField(10);
    private JTextField inputCost = new JTextField(10);
    private JButton add = new JButton("Add");
	public AddCDToStoreScreen(Store store, Cart cart) {
		this.store = store;
		this.cart = cart;
		
		ButtonListener btnListener = new ButtonListener();
		Container cp = getContentPane();
		cp.setLayout(new GridLayout(5,2));
		cp.add(new JLabel("Name:"));
		cp.add(inputName);
		
		
		cp.add(new JLabel("Category:"));
		cp.add(inputCategory);
		
		
		cp.add(new JLabel("Cost:"));
		cp.add(inputCost);
		
		cp.add(add);
		add.addActionListener(btnListener);
		
		setTitle("Add CD");
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
			
			
			
		    CompactDisc b = new CompactDisc(name,category,cost);
			
			store.addMedia(b);
			dispose();
			new StoreScreen(store,cart);
			}
			
		}
	}


}
