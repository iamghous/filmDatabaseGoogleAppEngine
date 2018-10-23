package com.factory;

import java.util.LinkedHashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import enterprise.Film;

public class JsonData implements ReturnData{

	@Override
	public String generateData(LinkedHashMap<String, Film> hash){

		// creates JSONArray class object
		JSONArray jsonArray = new JSONArray();
		// for loop which will go through the whole hashMap one by one
		for (Film film : hash.values()) {
			// will assign the data in the local variables for the easier use ahead
			long filmId1 = film.getFilmId();
			String filmId = String.valueOf(filmId1);
			int filmYear1 = film.getFilmYear();
			String filmYear = String.valueOf(filmYear1);
		    int filmGross1 = film.getFilmGross();
		    String filmGross = String.valueOf(filmGross1);
			 String filmName = film.getFilmName();
			String filmCredits = film.getFilmCredits();
			String filmGenre = film.getFilmGenre();
			String filmCountry = film.getFilmCountry();
			// will create a new JSON object 
			JSONObject jsonObject = new JSONObject();
			// insert into JSON object the current values
			
				try {
				jsonObject.put("filmId", filmId);
				jsonObject.put("filmYear", filmYear);
				jsonObject.put("filmGross", filmGross);
				jsonObject.put("filmName", filmName);
				jsonObject.put("filmCredits", filmCredits);
				jsonObject.put("filmGenre", filmGenre);
				jsonObject.put("filmCountry", filmCountry);
				// insert this JSON object into JSONarray
				jsonArray.put(jsonObject);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				}
		// returns the String
		return jsonArray.toString();
		
	}


}
