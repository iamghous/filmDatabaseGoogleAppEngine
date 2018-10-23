package com.factory;
/*
 * This class will be used to provide ReturnData class the right class 
 *
 */
public class FactoryMethod {
   
	/*
	 * this method will be used to determine which class the user wants, it is hidden so that it cannot be seen
	 * from outside, it will be passed the string parameter and it will determine which class it wants
	 */
	public ReturnData checkedData(String format) {
		// if format is xml it will return XmlDATA class
		if(format.equalsIgnoreCase("xml")) {
			return new XmlData();
		}
		// if format is json it will return JsonDATA class
		else if (format.equalsIgnoreCase("json")) {
			return new JsonData();
		}
		// if it is structured it will return StructuredData class
		else if(format.equalsIgnoreCase("structured")) {
			return new StructuredData();
		}// and else it will return StructuredData class 
		else {
			return new StructuredData();
		}
		
		
	}
	
	
	
}
