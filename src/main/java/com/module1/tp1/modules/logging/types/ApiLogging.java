package com.module1.tp1.modules.logging.types;

import com.module1.tp1.modules.logging.Logging;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class ApiLogging extends Logging {
  private static final String API_URL = "http://www.sd-bo.com/log.php?log_value=";

  @Override
  public void log(String message) {
    try {
      String encodedMessage = URLEncoder.encode(message, StandardCharsets.UTF_8);

      URL url = new URL(API_URL + encodedMessage);
      HttpURLConnection connection = (HttpURLConnection) url.openConnection();
      connection.setRequestMethod("GET");
      connection.setRequestProperty("Accept", "application/json");

      int responseCode = connection.getResponseCode();
      if (responseCode == HttpURLConnection.HTTP_OK) {
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
          response.append(inputLine);
        }
        in.close();
        System.out.println("Response: " + response.toString());
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
