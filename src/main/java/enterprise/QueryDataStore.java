package enterprise;

import java.util.LinkedHashMap;

import com.builder.FilmBuilder;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;

public class QueryDataStore {
/* Creates an object of DataStoreService and assign DatastoreServiceFactory to it, it is basically connecting us
 * to our DataStore
 */
	DatastoreService dataStore = DatastoreServiceFactory.getDatastoreService();
	
	// this method will return LinkedHashMap and take no parameter
	public LinkedHashMap<String, Film> getDataFromDataStore() {
		// creating a map to be returned at the end of the method
		LinkedHashMap<String, Film> filmCollectionMap = new LinkedHashMap<String,Film>();
		try {
			// Creating an object of Query class which uses the NomanFilms Entity
			Query query = new Query("NomanFilms");
			// Prepares the Query
			PreparedQuery pQuery = dataStore.prepare(query);
			// Iterate through each row one by one
			for (Entity e : pQuery.asIterable()) {
				// assign all the values to local variables one by one
				String filmId1 = e.getProperty("filmId").toString();
				long filmId = Long.valueOf(filmId1);
				String filmYear1 = e.getProperty("filmYear").toString();
				int filmYear = Integer.valueOf(filmYear1);
				String filmGross1 = e.getProperty("filmGross").toString();
				int filmGross = Integer.valueOf(filmGross1);
				String filmName = e.getProperty("filmName").toString();
				String filmCredits = e.getProperty("filmCredits").toString();
				String filmGenre = e.getProperty("filmGenre").toString();
				String filmCountry = e.getProperty("filmCountry").toString();
		/*
		 * Using BUILDER DESIGN PATTERN to create a film Object
		 */
	Film film = new FilmBuilder().setFilmId(filmId).setFilmYear(filmYear).setFilmGross(filmGross).setFilmName(filmName).setFilmCredits(filmCredits).setFilmGenre(filmGenre).setFilmCountry(filmCountry).getFilmValues();
	// adding current film object as value and filmName as the key in the hashMap		    
	filmCollectionMap.put(filmName,film);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		// returns LinkedHashMap
		return filmCollectionMap;
	}
	// this method will insert data in the DataStore it will take one paramter of Film object
public void insertDataToDataStore(Film film)  {
	  try {
		  // Creating new Entity for NomanFilms and passing Filmid as the main ID
		    Entity entity = new Entity("NomanFilms", film.getFilmId());
		    // and now setting all the properties of the row one by one
		    entity.setProperty("filmId", film.getFilmId());
		    entity.setProperty("filmYear", film.getFilmYear());
		    entity.setProperty("filmGross", film.getFilmGross());
		    entity.setProperty("filmName", film.getFilmName());
		    entity.setProperty("filmCredits", film.getFilmCredits());
		    entity.setProperty("filmGenre", film.getFilmGenre());
		    entity.setProperty("filmCountry", film.getFilmCountry());
		    // once all property are set it will put the data in the datastore
			dataStore.put(entity);
	  }// catching all sort of errors here
		catch(Exception e) {
			System.out.println(e);
		}
	}


	
}
