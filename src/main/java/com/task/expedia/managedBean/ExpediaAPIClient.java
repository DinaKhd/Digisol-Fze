package com.task.expedia.managedBean;

import com.task.expedia.controller.ExpediaController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class ExpediaAPIClient {

    public static void main(String[] args) {
//        try {
//            String urlString = "https://offersvc.expedia.com/offers/v2/getOffers?scenario=deal-finder&page=foo&uid=test&productType=Package&clientId=test";
//            URL url = new URL(urlString);
//            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//            connection.setRequestMethod("GET");
//
//            int responseCode = connection.getResponseCode();
//
//            if (responseCode == HttpURLConnection.HTTP_OK) {
//                // Handle successful response
//                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//                String inputLine;
//                StringBuilder content = new StringBuilder();
//
//                while ((inputLine = in.readLine()) != null) {
//                    content.append(inputLine);
//                }
//                in.close();
//
//                // Output the response
//                System.out.println(content.toString());
//            } else {
//                // Handle the error response (400 Bad Request in this case)
//                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
//                String inputLine;
//                StringBuilder errorContent = new StringBuilder();
//
//                while ((inputLine = in.readLine()) != null) {
//                    errorContent.append(inputLine);
//                }
//                in.close();
//
//                System.out.println("Error Response: " + errorContent.toString());
//                // You can log the error or handle it as needed
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        ExpediaController expediaController = new ExpediaController();
        expediaController.getExpediaOffers("New York", "San Francisco","highDiscount");
	}
}