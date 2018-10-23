package enterprise;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.factory.FactoryMethod;
import com.factory.ReturnData;


// this is the servlet which will get the user their searched film
@WebServlet("/getFilm")
public class getFilm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		 
		
		// it will create a String which we will return at the end
			String outputData = "";
			// it will pass the search parameter to String and Upper Case it
			 String searched = request.getParameter("search").toUpperCase();
			// it will get the request format and assign it to the string
			 String format = request.getParameter("format");
			 // it will create an object of FilmDAO class
			 FilmInfo filmDAO = new FilmDAO();
			// OutputGenerator g = new OutputGenerator();
			 // it will create an object of our FactoryMethod class
			 FactoryMethod factory = new FactoryMethod();
			 // it will create a hashMap and call the method of FilmDAO which will return the hashMap of all the films
			 LinkedHashMap<String,Film> filmCollectionMap = filmDAO.listFilm();
			 // an object of printWtiter class
			 PrintWriter out = response.getWriter();
				// the for loop will check if the request format is xml
		 if(searched.isEmpty()) {
			// this will set the status to 204 which means no content, for someone who is trying to hack the system 
			 response.setStatus(204);
			 out.println("Please make sure you add something in the search input.");
		 }
		 
		 else if(!(filmCollectionMap.containsKey(searched))) {
			
			 out.println("Unfortunately, we do not have "+ searched +" in the system yet.");
		 }
		 else {
			 LinkedHashMap<String,Film> searchedHashMap = filmDAO.searchFilm(searched);
			 if (format.equalsIgnoreCase("xml")) {
				  try {
					  /* it will call the method of factory class which returns the ReturnData object
						  * this is here we will use FACTORY DESIGN PATTERN
						  * and it will return an object of XMLData class and it will be ReturnData returnData = new XmlData();
						  */
						  ReturnData returnData = factory.checkedData(format);
						  // and it will assign the output to String method
						  outputData = returnData.generateData(searchedHashMap);
						  // we will not use MVC design pattern but we will instead use factory design pattern
						//outputData = g.generateXml(filmCollectionMap);
				} catch (Exception e) {
					e.printStackTrace();
				}
				  // sends the response back and add the response in text area so user can analyze it 
				  out.print("<textarea>");
				  out.print(outputData);
				  out.print("</textarea>");
			  }
			  else if(format.equalsIgnoreCase("json")) {
				  try {
					// this will return JsonData object so it will be ReturnData returnData = new JsonData();
					  ReturnData returnData = factory.checkedData(format);
					  outputData = returnData.generateData(searchedHashMap);
					//outputData = g.generateJson(filmCollectionMap);
				} catch (Exception e) {
					e.printStackTrace();
				}
				  // sends the response back and add the response in text area so user can analyze it 
				 out.print("<textarea>");
				  out.print(outputData);
				 out.print("</textarea>");
			  }
			  else if(format.equalsIgnoreCase("structured")) {
				  try {
					// this will return JsonData object so it will be ReturnData returnData = new StructuredData();
					  ReturnData returnData = factory.checkedData(format);
					  outputData = returnData.generateData(searchedHashMap);
						//outputData = g.generateStructured(filmCollectionMap);
					} catch (Exception e) {
						e.printStackTrace();
					}
					  
					  out.print(outputData);
					 
			  }
			  } 
		 out.close();
		 }	 
	}
