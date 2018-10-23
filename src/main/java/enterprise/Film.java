package enterprise;

public class Film {

	// declaring all the fields required
    private long filmId;
    private int  filmYear,filmGross;
	private String filmName,filmCredits,filmGenre,filmCountry ="";
	
	
	// the main constructor which changes the value of the fields with given parameters
	public Film(long filmId, int filmYear, int filmGross, String filmName, String filmCredits, String filmGenre,
			String filmCountry) {
		this.filmId = filmId;
		this.filmYear = filmYear;
		this.filmGross = filmGross;
		this.filmName = filmName;
		this.filmCredits = filmCredits;
		this.filmGenre = filmGenre;
		this.filmCountry = filmCountry;
	}
	

	// all the getters and setters for all the fields
	public long getFilmId() {
		return filmId;
	}
	public void setFilmId(long filmId) {
		this.filmId = filmId;
	}
	public int getFilmYear() {
		return filmYear;
	}
	public void setFilmYear(int filmYear) {
		this.filmYear = filmYear;
	}
	public int getFilmGross() {
		return filmGross;
	}
	public void setFilmGross(int filmGross) {
		this.filmGross = filmGross;
	}
	public String getFilmName() {
		return filmName;
	}
	public void setFilmName(String filmName) {
		this.filmName = filmName;
	}
	public String getFilmCredits() {
		return filmCredits;
	}
	public void setFilmCredits(String filmCredits) {
		this.filmCredits = filmCredits;
	}
	public String getFilmGenre() {
		return filmGenre;
	}
	public void setFilmGenre(String filmGenre) {
		this.filmGenre = filmGenre;
	}
	public String getFilmCountry() {
		return filmCountry;
	}
	public void setFilmCountry(String filmCountry) {
		this.filmCountry = filmCountry;
	}
	// the to String method for this class
	@Override
	public String toString() {
		return "Film [filmId=" + filmId + ", filmYear=" + filmYear + ", filmGross=" + filmGross + ", filmName="
		+ filmName + ", filmCredits=" + filmCredits + ", filmGenre=" + filmGenre + ", filmCountry="
		+ filmCountry + "]";
	}

	
}
