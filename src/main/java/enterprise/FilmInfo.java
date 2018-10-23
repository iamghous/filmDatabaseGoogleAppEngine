package enterprise;
import java.util.LinkedHashMap;

public interface FilmInfo {
	
	// this method has no return and it will take a parameter of Film class Object
	public void addFilm (Film finfo);			
	// this method will have return type of LinkedHashMap because simple HashMap returns the data not 
	// in ordered format but LinkedHashMap Does it will take no parameter
	public LinkedHashMap<String,Film> listFilm ();			
	// this will return hashMap as well and it will have one parameter which will be a String variable
	public LinkedHashMap<String,Film> searchFilm(String searchStr);	
	
	}


