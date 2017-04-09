package fi.haagahelia.course.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "genreId")
	private Genre genre;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "modeId")
	private Mode mode;
	
	@Column(name = "rating")
	private int rating;
	
	public Game() {}
	
	public Game(String title, int year, String publisher, Genre genre, Mode mode, int rating) {
		super();
		this.setTitle(title);
		this.setYear(year);
		this.setPublisher(publisher);
		this.genre = genre;
		this.mode = mode;
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

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public Mode getMode() {
		return mode;
	}

	public void setMode(Mode mode) {
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
		if (this.mode != null & this.genre != null)
			return "Game [id=" + id + ", title=" + title + ", year=" + year
					+ ", publisher=" + publisher + ", genre=" + genre + ", mode="
					+ mode + ", rating=" + rating + "]";
		else
			return "Game [id=" + id + ", title=" + title + ", year=" + year
					+ ", publisher=" + publisher + ", rating=" + rating + "]";
	}
	
}
