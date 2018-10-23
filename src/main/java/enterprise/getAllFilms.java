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


// this is getAllFilms Servlet which will give users the list of films in which ever format they want
@WebServlet("/getAllFilms")
public class getAllFilms extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// doGet method of servlet
public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		// it will create a String which we will return at the end
		String outputData = "";
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
		  if (format.equalsIgnoreCase("xml")) {
			  try {
				 /* it will call the method of factory class which returns the ReturnData object
				  * this is here we will use FACTORY DESIGN PATTERN
				  * and it will return an object of XMLData class and it will be ReturnData returnData = new XmlData();
				  */
				  ReturnData returnData = factory.checkedData(format);
				  // and it will assign the output to String method
				  outputData = returnData.generateData(filmCollectionMap);
				  // we will not use MVC design pattern but we will instead use factory design pattern
				//outputData = g.generateXml(filmCollectionMap);
			} catch (Exception e) {
				e.printStackTrace();
			}
			  // it will send the output in texarea blocks so, the user can easily read it 
			  out.print("<textarea>");
			  out.print(outputData);
			  out.print("</textarea>");
		  }
		  // this part is almost same as the previous for loop but it is for json instead of xml
		  else if(format.equalsIgnoreCase("json")) {
			  try {
				  // this will return JsonData object so it will be ReturnData returnData = new JsonData();
				  ReturnData returnData = factory.checkedData(format);
				  outputData = returnData.generateData(filmCollectionMap);
				//outputData = g.generateJson(filmCollectionMap);
			} catch (Exception e) {
				e.printStackTrace();
			}
			  
			  out.print("<textarea>");
			  out.print(outputData);
			  out.print("</textarea>");
		  }
		  // and else loop will be for the structured type
		  else if(format.equalsIgnoreCase("structured")) {
			  try {
				// this will return JsonData object so it will be ReturnData returnData = new StructuredData();
				  ReturnData returnData = factory.checkedData(format);
				  outputData = returnData.generateData(filmCollectionMap);
					//outputData = g.generateStructured(filmCollectionMap);
				} catch (Exception e) {
					e.printStackTrace();
				}
				  
				  out.print(outputData);
				 
			  }
		  // closes the PrintWriter
		  out.close();
		  }
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


