package p;

import hust.soict.globalict.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable{
	private static int nbDigitalVideoDiscs = 0;
	
	public DigitalVideoDisc(String title) {
		super(title);
		nbDigitalVideoDiscs += 1;
		this.setId(nbDigitalVideoDiscs);
		
	}
	public DigitalVideoDisc(String title, String category, float cost) {
		super(title,category,cost);
		nbDigitalVideoDiscs += 1;
		this.setId(nbDigitalVideoDiscs);
		
	}
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super(title,category,cost);
		nbDigitalVideoDiscs += 1;
		this.setId(nbDigitalVideoDiscs);
		
		
		
	}
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super(title,category,cost);
		nbDigitalVideoDiscs += 1;
		this.setId(nbDigitalVideoDiscs);
		this.setDirector(director);
		this.setLength(length);
	
	}
	
	public String toString() {
		return this.getTitle() +" - " + this.getCategory()+" - "+this.getDirector()+" - "+this.getLength()+" - "+this.getCost()+"$";
	}
	
	public int getID() {
		return this.getId();
	}
	
	public void play() throws PlayerException { 
		if (this.getLength()>0) {
		System.out.println("Playing DVD: " + this.getTitle()); 

		System.out.println("DVD length: " + this.getLength()); 
		}
		else {
			throw new PlayerException("ERROR: DVD length is non-positive");
		}

		} 
	
}
