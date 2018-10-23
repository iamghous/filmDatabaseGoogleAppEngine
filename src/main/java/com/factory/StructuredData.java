package com.factory;

import java.util.LinkedHashMap;

import enterprise.Film;

public class StructuredData implements ReturnData {

	@Override
	public String generateData(LinkedHashMap<String, Film> hash) {
		// will create an empty string which will be returned later in the method 
		String data = "";
		// append html data into the string
		data += "<table border='1'>";
		data += " <tr><th>Film_ID</th><th>Film_Name</th><th>Film_Year</th><th>Film_Credits</th>"
				+ "<th>Film_Genre</th><th>Film_Gross</th><th>Film_Country</th></tr> ";
		
		// for each hash values
		for (Film film : hash.values()) {
		// put the data nicely in the local variables		
			long filmId = film.getFilmId();
			int filmYear = film.getFilmYear();
		    int filmGross = film.getFilmGross();
			String filmName = film.getFilmName();
			String filmCredits = film.getFilmCredits();
			String filmGenre = film.getFilmGenre();
			String filmCountry = film.getFilmCountry();
			// append the data in the string one by one
			data+= " <tr><td>"+filmId +"</td><td>"+filmName +"</td><td>"+filmYear +"</td><td>"+filmCredits +"</td><td>"
					+ ""+filmGenre +"</td><td>&#163;"+filmGross +"</td><td>" + filmCountry+"</td></tr>  ";		
					}
		// add the final closing tag to the string	
		data +="</table> ";
		// return the data String
		return data;
	}

}
