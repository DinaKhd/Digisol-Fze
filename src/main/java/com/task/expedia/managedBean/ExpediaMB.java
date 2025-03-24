package com.task.expedia.managedBean;

import com.task.expedia.data.ExpediaPackage;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Named
@RequestScoped
public class ExpediaMB {
	private String originCity;
	private String destinationCity;
	private List<ExpediaPackage> packages = new ArrayList<>();

	public void fetchPackages() {
		try {
			String apiUrl = "https://offersvc.expedia.com/offers/v2/getOffers?scenario=deal-finder&page=foo&uid=test&productType=Package&clientId=test"
					+ "&originCity=" + originCity
					+ "&destinationCity=" + destinationCity;

			// Create connection
			URL url = new URL(apiUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			// Read response
			Scanner scanner = new Scanner(url.openStream());
			StringBuilder jsonResponse = new StringBuilder();
			while (scanner.hasNext()) {
				jsonResponse.append(scanner.nextLine());
			}
			scanner.close();

			// Parse JSON response
			JsonReader reader = jakarta.json.Json.createReader(new StringReader(jsonResponse.toString()));
			JsonObject responseJson = reader.readObject();
			reader.close();

			// Extract package offers
			packages.clear();
			if (responseJson.containsKey("offers")) {
				JsonObject offers = responseJson.getJsonObject("offers");
				if (offers.containsKey("Package")) {
					JsonArray packageArray = offers.getJsonArray("Package");

					for (int i = 0; i < packageArray.size(); i++) {
						JsonObject pkg = packageArray.getJsonObject(i);
						String packageId = pkg.getString("packageId", "N/A");
						String packageName = pkg.getString("packageName", "No Name Available");
						packages.add(new ExpediaPackage(packageId, packageName));
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Getters and Setters
	public String getOriginCity() { return originCity; }
	public void setOriginCity(String originCity) { this.originCity = originCity; }
	public String getDestinationCity() { return destinationCity; }
	public void setDestinationCity(String destinationCity) { this.destinationCity = destinationCity; }
	public List<ExpediaPackage> getPackages() { return packages; }

	public static void main(String[] args) {
		ExpediaMB expediaMB = new ExpediaMB();
		expediaMB.fetchPackages();
		System.out.println(expediaMB.getPackages());
	}
}
