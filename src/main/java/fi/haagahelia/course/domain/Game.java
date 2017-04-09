package fi.haagahelia.course.domain;

public class Game {
	private String title;
	private String publisher;
	private String genre;
	private String mode;
	private String platform;
	private int rating;
	
	public Game() {}
	
	public Game(String title, String publisher, String genre, String mode, String platform, int rating) {
		super();
		this.setTitle(title);
		this.setPublisher(publisher);
		this.setGenre(genre);
		this.setMode(mode);
		this.setPlatform(platform);
		this.setRating(rating);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
	
	@Override
	public String toString() {
		return "Game [title=" + title + ", publisher=" + publisher + ", genre=" + genre + ", mode=" + mode + ", platform=" + platform + ", rating=" + rating + "]";
	}
	
}
