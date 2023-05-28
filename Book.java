package p;
import java.util.*;

public class Book extends Media {
    public List<String> authors = new ArrayList<String>(); 
	
	public List<String> getAuthors() {
		return authors;
	}
	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}
	
	public Book(String name, String category, float cost) {
		super(name,category,cost);
	}
	

	public void addAuthor(String authorName) {
		boolean check = authors.contains(authorName);
		if (check) {
			System.out.println("Author already added");
		}
		else {
			authors.add(authorName);
		}
	}
	
	public void removeAuthor(String authorName) {
		boolean check = authors.contains(authorName);
		if (check) {
			authors.remove(authorName);
		}
		else {
			System.out.println("Author not in the list");
		}
	}
	
	public String toString() {
		return this.getTitle() +" - " + this.getCategory()+" - "+this.getCost()+"$";
	}
	
}
