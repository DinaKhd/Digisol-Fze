package com.task.expedia.service;

import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Map;

@Slf4j
@Service
public class ExpediaService {

	private static final String EXPEDIA_API_URL = "https://offersvc.expedia.com/offers/v2/getOffers?"
			+ "scenario=deal-finder&page=foo&uid=test1&productType=Package&clientId=Test";

	public String fetchOffers(String origin, String destination, String filter) {
		String apiUrl = EXPEDIA_API_URL
				+ "&originCity=" + origin + "&destinationCity=" + destination  + "&filter=" + filter;

		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(apiUrl, String.class);
	}

	public Map<String, Object> getPackageDeals(String origin, String destination, String filter) {
		OkHttpClient client = new OkHttpClient();
		String url = EXPEDIA_API_URL
				+ "&originCity=" + origin + "&destinationCity=" + destination + "&filter=" + filter;

		Request request = new Request.Builder()
				.url(url)
				.get()
				.build();

		try (Response response = client.newCall(request).execute()) {
			return Map.of("data", response.body().string());
		} catch (IOException e) {
			log.error("Error calling Expedia API", e);
		}

		return Map.of("error", "Could not retrieve packages");
	}

	public static void main(String[] args) {
		ExpediaService expediaService = new ExpediaService();
		System.out.println(expediaService.getPackageDeals("New York", "San Francisco","directFlights"));
	}
}
