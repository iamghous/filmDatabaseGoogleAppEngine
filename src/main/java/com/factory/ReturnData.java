package com.factory;

import java.util.LinkedHashMap;

import enterprise.Film;

public interface ReturnData {
	// this method returns the String and gets LinkedHashMap in the parameter
	public String generateData(LinkedHashMap<String, Film> hash);

}
