package p;

import hust.soict.globalict.aims.exception.PlayerException;

public abstract class Media {
	
	private int id;
	private String title;
	private String category;
	private float cost;

	public Media() {
		// TODO Auto-generated constructor stub
		
	}

	
	public Media(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
	}


	public Media(String title) {
		super();
		this.title = title;
	}
	public Media(String title, String category) {
		super();
		this.title = title;
		this.category = category;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	@Override
	public boolean equals(Object obj) {
	    if (this == obj) {
	        return true;
	    }
	    if (obj == null || getClass() != obj.getClass()) {
	        return false;
	    }
	    Media otherMedia = (Media) obj;
	    try {
	        return title.equals(otherMedia.title);
	    } catch (NullPointerException e) {
	        return false;
	    } catch (ClassCastException e) {
	        return false;
	    }
	}


	public void play() throws PlayerException {
	
		
	}
	
	
	
	
	
	
	
	
	
	
}
