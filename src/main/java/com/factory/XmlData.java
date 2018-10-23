package com.factory;

import java.io.StringWriter;
import java.util.LinkedHashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import enterprise.Film;

public class XmlData implements ReturnData {

	@Override
	public String generateData(LinkedHashMap<String, Film> hash) {
          String xmlString = "";
			try{
			
			DocumentBuilderFactory dbFactory =
					DocumentBuilderFactory.newInstance();
			
			// intialize new DocumentBuilder object and assign it DocumentBuilderFactory new Document
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			// creates new Document object
			
			Document doc = dBuilder.newDocument();
			
			// create new root element and name it data
			Element rootElement = doc.createElement("filmData");
			
			// add the element in the document
			doc.appendChild(rootElement);
			
			// loops through the database data
			  
		for (Film film : hash.values()) {
			
				// gets all the values and assign them to the local variables for easier use
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
	
		 // create sub element and call it values
		 Element values = doc.createElement("film");
		 // and append it in the root Element which is "filmData"
		 rootElement.appendChild(values);

		 // create new element and call it filmId
		 Element eFilmId = doc.createElement("filmId");
		 // add String "filmId" to the value of the element 
		 eFilmId.appendChild(doc.createTextNode(filmId));
		 // append the element filmID to its parent element values
		 values.appendChild(eFilmId);
		 
		// create new element and call it filmYear
				 Element eFilmYear = doc.createElement("filmYear");
				 // add String "filmYear" to the value of the element 
				 eFilmYear.appendChild(doc.createTextNode(filmYear));
				 // append the element filmYear to its parent element values
				 values.appendChild(eFilmYear);
		 
				 Element eFilmGross = doc.createElement("filmGross");
				 // add String "filmGross" to the value of the element 
				 eFilmGross.appendChild(doc.createTextNode(filmGross));
				 // append the element filmGross to its parent element values
				 values.appendChild(eFilmGross);
				 
				// create new element and call it filmName
				 Element eFilmName = doc.createElement("filmName");
				 // add String "filmName" to the value of the element 
				 eFilmName.appendChild(doc.createTextNode(filmName));
				 // append the element filmName to its parent element values
				 values.appendChild(eFilmName);
				 
					// create new element and call it filmCredits
				 Element eFilmCredits = doc.createElement("filmCredits");
				 // add String "filmCredits" to the value of the element 
				 eFilmCredits.appendChild(doc.createTextNode(filmCredits));
				 // append the element filmCredits to its parent element values
				 values.appendChild(eFilmCredits);
				 
					// create new element and call it filmGenre
				 Element eFilmGenre = doc.createElement("filmGenre");
				 // add String "filmGenre" to the value of the element 
				 eFilmGenre.appendChild(doc.createTextNode(filmGenre));
				 // append the element filmGenre to its parent element values
				 values.appendChild(eFilmGenre);
				 
					// create new element and call it filmCountry
				 Element eFilmCountry = doc.createElement("filmCountry");
				 // add String "filmCountry" to the value of the element 
				 eFilmCountry.appendChild(doc.createTextNode(filmCountry));
				 // append the element filmCountry to its parent element values
				 values.appendChild(eFilmCountry);


			}
			// create new object of Transformer class
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			// create new object of StreamResult
			StreamResult result = new StreamResult(new StringWriter());
			// create new Object of DOMSource and assign it the Document  
			DOMSource source = new DOMSource(doc);
			// transform the whole document using this method transform()
			transformer.transform(source, result);
			
			// assign the whole document to the string
			xmlString = result.getWriter().toString();
		   
	}

		catch(Exception e)
		{
		System.out.println(e);
		}
		//  return the String
		return xmlString; 
		}
}
