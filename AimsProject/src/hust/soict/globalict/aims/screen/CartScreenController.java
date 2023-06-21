package hust.soict.globalict.aims.screen;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import p.*;
import javafx.scene.control.cell.PropertyValueFactory;
public class CartScreenController {

	private Cart cart;
	
	@FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;
    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

	
	@FXML 
	private ToggleGroup filterCategory;
	

    @FXML
    private TableView<Media> tblMedia;
    
    
    public CartScreenController(Cart cart) {
    	super();
    	this.cart = cart;
    }
    

	
	
	  @FXML private void initialize() { colMediaTitle.setCellValueFactory(new
	  PropertyValueFactory<Media,String>("title"));
	  colMediaCategory.setCellValueFactory(new
	  PropertyValueFactory<Media,String>("category"));
	  colMediaCost.setCellValueFactory(new
	  PropertyValueFactory<Media,Float>("cost"));
	  tblMedia.setItems(this.cart.getItemsOrdered());
	  
	  btnPlay.setVisible(false);
	  btnRemove.setVisible(false);
	  tblMedia.getSelectionModel().selectedItemProperty().addListener(
			  new ChangeListener<Media>() {
				  @Override
				  public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
					  if (newValue != null) {
						  updateButtonBar(newValue);
					  }
				  }
				  void updateButtonBar(Media media) {
					  btnRemove.setVisible(true);
					  if(media instanceof Playable) {
						  btnPlay.setVisible(true);
					  }
					  else {
						  btnPlay.setVisible(false);
					  }
				  }
			  });
	  
	  }
	  
	  
	  
	  @FXML
	    void btnRemovePressed(ActionEvent event) {
		  Media media = tblMedia.getSelectionModel().getSelectedItem();
		  cart.removeMedia(media);
	    }
	 
	  @FXML
	    void btnPlayPressed(ActionEvent event) {
	    	Media media = tblMedia.getSelectionModel().getSelectedItem();
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


