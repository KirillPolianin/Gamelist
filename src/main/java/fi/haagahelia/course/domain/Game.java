package fi.haagahelia.course.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Game {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "title")
	private String title;
	
	@Column(name = "year")
	private int year;

	@Column(name = "publisher")
	private String publisher;
	
	@Column(name = "genre")
	private String genre;
	
	@Column(name = "mode")
	private String mode;
	
	@Column(name = "rating")
	private int rating;
	
	public Game() {}
	
	public Game(String title, int year, String publisher, String genre, String mode, int rating) {
		super();
		this.setTitle(title);
		this.setYear(year);
		this.setPublisher(publisher);
		this.setGenre(genre);
		this.setMode(mode);
		this.setRating(rating);
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
	
	@Override
	public String toString() {
		return "Game [id =" + id + ", title=" + title + ", year=" + year + ", publisher=" + publisher + ", genre=" + genre + ", mode=" + mode + ", rating=" + rating + "]";
	}
	
}
