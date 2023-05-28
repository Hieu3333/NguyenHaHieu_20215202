package p;
import java.util.*;
public class CompactDisc extends Disc implements Playable {
	private String artist;
	private List<Track> tracks = new ArrayList<Track>();
	
	
	public CompactDisc() {
		// TODO Auto-generated constructor stub
	}
	
	
	public CompactDisc(String title, String category, float cost, String director,String artist, List<Track> tracks) {
		super(title,category,cost,director);
		this.artist = artist;
		this.tracks = tracks;
	}


	public String getArtist() {
		return artist;
	}
	
	public void addTrack(Track a) {
		boolean check = tracks.contains(a);
		if (check) {
			System.out.println("Track already in list");
		}
		else {
			tracks.add(a);
		}
	}
	
	public void removeTrack (Track a) {
		boolean check = tracks.contains(a);
		if (check) {
			tracks.remove(a);
		}
		else {
			System.out.println("Track not in list");
		}
	}
	
	@Override
	public int getLength() {
		int l = 0;
		for (int i=0; i<tracks.size(); i++) {
			l += tracks.get(i).getLength();
		}
		return l;
	}
	
	public void play() {
		for (int i=0; i<tracks.size(); i++) {
			tracks.get(i).play();
		}
	}
	
	
	

}
