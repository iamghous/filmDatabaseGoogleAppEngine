package enterprise;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.TimeZone;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.builder.FilmBuilder;


// this servlet will allow the user to insert films into the database
@WebServlet("/insertFilm")
public class insertFilm extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");
		 // create an object of printWriter class
		 PrintWriter out = response.getWriter();
		 // create an object of FilmDAO class
		 FilmInfo filmDAO = new FilmDAO();
		 // create a linked hashMap and pass it the method of filmDAO class which returns all the movies in Hash
		 LinkedHashMap<String,Film> filmCollectionMap = filmDAO.listFilm(); ;
		/*
		 * this will get all the parameters and put them in the string
		 */
		 String filmYear = request.getParameter("filmYear");
		 String filmGross = request.getParameter("filmGross");
		 String filmName = request.getParameter("filmName").toUpperCase();
		 String filmCredits = request.getParameter("filmCredits");
		 String filmGenre = request.getParameter("filmGenre");
		 String filmCountry = request.getParameter("filmCountry");
		 
		 // this for loop will check if the user have left any field empty
		 if(filmYear.isEmpty() ||  filmGross.isEmpty() || filmName.isEmpty() || filmCredits.isEmpty() || filmGenre.isEmpty() || 
				 filmCountry.isEmpty())
		 {
			 out.println("Please make sure you enter all the details");
		 }
		 // this for loop will check if the movie already exist in the system and if it does, user cannot enter it again
		 else if(filmCollectionMap.containsKey(filmName)) {
			 out.println("This movie already exists in the system, please enter a different one!");
		 }
	    else {
	    	// and finally if everything is right user will be able to add the film
	    	// converting parameters to integer
			 int filmYear1 = Integer.valueOf(filmYear);
			 int filmGross1 = Integer.valueOf(filmGross);
			// this little method from Calender class will give us 13 digit unique id whenever the user insertFilm
			 
			 Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
			 // so it basically gets the time in miliseconds and however it is always unique
			 // it will be assigned to long because int data type cannot handle 13 digit number
				long filmId = calendar.getTimeInMillis();
				/* here we are using BUILDER DESIGN PATTERN technique
				 * we will call our FilmBuilder class which is in com.builder package 
				 *  rather than using film class constructor and passing all the values which are required but instead we
				 *  will  use FilmBuilder class which allows us	not pass all the values which is a bit of relief in most cases			 
				 */ 		
	Film film = new FilmBuilder().setFilmId(filmId).setFilmYear(filmYear1).setFilmGross(filmGross1).setFilmName(filmName).setFilmCredits(filmCredits).setFilmGenre(filmGenre).setFilmCountry(filmCountry).getFilmValues();
	
	/* we can also use our old style technique but for this part of the assignment i will just
	 * use the builder design pattern
	 */				
		// Film film = new Film(filmId, filmYear1,filmGross1,filmName,filmCredits,filmGenre,filmCountry);
	// and it will simply call the method of filmDAO class which will take film object paramter
		 filmDAO.addFilm(film);
		 
		 // once it is done the user will get the success message
		out.println("Successfully added the "+filmName +" into the System!");

		 // closes the printWeiter
		out.close();
		 }
		 
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
