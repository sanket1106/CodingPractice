package com.grab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashSet;

import javax.net.ssl.HttpsURLConnection;

public class Main {

	// Externalize this to property file or configuration settings
	private static final String api = "https://api.github.com/zen";
	private static final String requestMethod = "GET";
	private static final String requestPropertyAcceptKey = "Accept";
	private static final String requestPropertyAcceptValue = "application/json";

	public static void main(String[] args) {
		HashSet<String> messageSet = new HashSet<>();
		while (messageSet.size() < 3) {
			// Call callAPI method to receive a message
			String message = callAPI();
			if (message != null) {
				boolean add = messageSet.add(message);
				if (add) {
					System.out.println("Message : " + message);
				}
			}
		}
	}

	/**
	 * This method will call an API and returns a string response
	 * 
	 * @return String
	 */
	private static String callAPI() {
		String output = null;
		try {
			URL url = new URL(api);
			HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
			conn.setRequestMethod(requestMethod);
			conn.setRequestProperty(requestPropertyAcceptKey, requestPropertyAcceptValue);
			if (conn.getResponseCode() != 200) {
				// TODO: Log errors to error logs
				System.out.println("Failed : HTTP error code : " + conn.getResponseCode());
				return output;
			}
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			while ((output = br.readLine()) != null) {
				return output;
			}
			conn.disconnect();
		} catch (IOException e) {
			// TODO: Log exceptions to exception logs
			System.out.println("Error in receiving response from API :" + e);
		}
		return output;
	}

}
