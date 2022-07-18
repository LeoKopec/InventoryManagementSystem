package com.skillstorm.services;

public class URLParserService {
	
	public String extractNameFromURL(String url) {
		String[] splitString = url.split("/");
		return splitString[1];
	}
	public int extractNumFromURL(String url) {
		String[] splitString = url.split("/");
		return Integer.parseInt(splitString[1]);
	}
}
