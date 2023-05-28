package p;

public class Track implements Playable {
	private String title;
	private int length;
	
	public Track(String title, int length) {
		super();
		this.title = title;
		this.length = length;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public Track() {
		// TODO Auto-generated constructor stub
	}
	public void play() { 

		System.out.println("Playing DVD: " + this.getTitle()); 

		System.out.println("DVD length: " + this.getLength()); 

		} 
	
	@Override
	public boolean equals (Object o) {
		if (!(o instanceof Track)) {
			return false;
		}
		Track a = (Track) o;
		return (this.title == a.title && this.length == a.length);
	}

}