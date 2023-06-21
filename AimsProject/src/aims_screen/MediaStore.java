package aims_screen;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import p.*;

public class MediaStore extends JPanel {
	private Media media;
	private Cart cart;
	
	public MediaStore(Media media, Cart cart) {
		this.media = media;
		this.cart = cart;
		
		ButtonListener btnListener = new ButtonListener();
		
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		JLabel title =  new JLabel(media.getTitle());
		title.setFont(new Font(title.getFont().getName(),Font.PLAIN,20));
		title.setAlignmentX(CENTER_ALIGNMENT);
		
		JLabel cost = new JLabel(""+media.getCost()+" $");
		cost.setAlignmentX(CENTER_ALIGNMENT);
		
		JPanel container = new JPanel();
		container.setLayout(new FlowLayout(FlowLayout.CENTER));
		JButton addToCart = new JButton("Add to cart");
		addToCart.addActionListener(btnListener);
		container.add(addToCart);
		
		if (media instanceof Playable) {
			JButton play = new JButton("Play");
			play.addActionListener(btnListener);
			container.add(play);
		}
		
		this.add(Box.createVerticalGlue());
		this.add(title);
		this.add(cost);
		this.add(Box.createVerticalGlue());
		this.add(container);
		
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		
	}
	
	public class ButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String button = e.getActionCommand();
			if (button.equals("Add to cart")) {
				cart.addMedia(media);
			}
			else {
				JDialog d = new JDialog();
				JPanel panel = new JPanel();
				
				JLabel lname = new JLabel("Playing DVD:"+media.getTitle());
				panel.add(lname);
				
				if (media instanceof DigitalVideoDisc) {
					DigitalVideoDisc dvd = (DigitalVideoDisc) media;
					JLabel lLength = new JLabel("Length: "+ dvd.getLength());
					panel.add(lLength);
				}
				if (media instanceof CompactDisc) {
					CompactDisc cd = (CompactDisc) media;
					JLabel lLength = new JLabel("Length: "+cd.getLength());
					panel.add(lLength);
				}
				
				
				 
				
				d.add(panel);
				d.setSize(200,100);
				d.setVisible(true);
				
				
			}
			
		}
	}
	

}
