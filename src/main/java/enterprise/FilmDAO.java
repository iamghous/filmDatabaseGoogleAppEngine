package enterprise;
import java.util.LinkedHashMap;


// FilmDAO implements FilmInfo which means it gets all of his methods implemented in this class
public class FilmDAO implements FilmInfo {

	// creates a global linkedHashMap variable which will hold all the film objects and use film name
	// to find the film object
	private LinkedHashMap<String,Film> filmCollectionMap =new LinkedHashMap<String,Film>();
	
	
	// this method will call the Method of queryDataStore class which will return the list of all films
	@Override
	public LinkedHashMap<String, Film> listFilm() {
		// Creating a variable of our QueryDataStore class which manages all the dataStore queries
		QueryDataStore queryDataStore = new QueryDataStore(); 
		
		try {
			// calling the method of QueryDataStore class which returns a hash with ceollection of all the movies
			filmCollectionMap = queryDataStore.getDataFromDataStore();
		}
		// catching all kind of exceptions here
		catch (Exception e) {
			
			e.printStackTrace();
		}
		// and this will return LinkedHashMap 
		return filmCollectionMap;
	}

	// this method will insert film in the dataStore
	@Override
	public void addFilm(Film film) {
		// we will create an object of our QueryDataStore class
		QueryDataStore queryDataStore = new QueryDataStore();
		  try {
			  /* it will call the insertDatatoDataStore method of QueryDataStore class which will take
			   * a paramter of Film object and insert data in the dataStore
			   */
			  queryDataStore.insertDataToDataStore(film);	
				} 
		  // catching all the errors here nicely
		  catch (Exception e) {			
					e.printStackTrace();
				}
	}

	//  This method will return LinkedHashMap and take a string parameter it will be used to search the film
	// from the collection
	@Override
	public LinkedHashMap<String, Film> searchFilm(String searchStr) {
		// it will create a new LinkedHashMap
		LinkedHashMap<String, Film> searchedFilmMap = new LinkedHashMap<String, Film>();
		// this if statement will find the given film name from teh global linkedHasMap just to check if key exist
		if(filmCollectionMap.containsKey(searchStr)) {
			// if it does then will assign the film Object using linkedHaspmap.get method
			Film film = filmCollectionMap.get(searchStr);
			// and it will put the searched film into the new hashMap which we created earlier
			searchedFilmMap.put(searchStr, film);
		}
		// if the Map is empty it will print no data found
		if (searchedFilmMap.isEmpty()) { 
			System.out.println("No data Found"); }
		// if not then it will pass the the map value to the Film Object, just to show the output to console
		else {
			Film film =searchedFilmMap.get(searchStr);
			// it will call the method of Film class and assign the value to String
			String output = film.toString();
			// it will print out the searched film
			System.out.println("Searched "+ output );
		}
		// and finally it will return the searchedFilmMap
		return searchedFilmMap;
		
		
	}	
}
