package com.grybakar.stockportfoliomanager.service;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ApiConnectionService {

  private static final String API_URL = "https://www.alphavantage.co/query?function=GLOBAL_QUOTE&symbol=";
  private static final String API_KEY = "GR81NY8IBPERD5UI";

  /**
   * Creates the API URL used to make a request to Alpha Vantage API
   *
   * @param symbol - the stock symbol to get data for
   * @return API URL
   */
  private String createApiUrl(String symbol) {
    return API_URL + symbol + "&apikey=" + API_KEY;
  }

  /**
   * Makes a request to the Alpha Vantage API and retrieves the response as a string
   *
   * @param symbol - the stock symbol to get data for
   * @return API response as a string
   */
  public String getGlobalQuote(String symbol) {
    String apiUrl = createApiUrl(symbol);
    String jsonString = null;

    try {
      URL url = new URL(apiUrl);
      HttpURLConnection connection = (HttpURLConnection) url.openConnection();
      setConnectionProperties(connection);

      if (connection.getResponseCode() != 200) {
        throw new IOException(
          "Failed to retrieve data from Alpha Vantage. HTTP status: " + connection.getResponseCode());
      }

      InputStream inStream = connection.getInputStream();
      jsonString = streamToString(inStream);

    } catch (IOException | NullPointerException e) {
      e.printStackTrace();
    }

    return jsonString;
  }

  private static void setConnectionProperties(HttpURLConnection connection) throws IOException {
    connection.setDoOutput(true);
    connection.setInstanceFollowRedirects(false);
    connection.setRequestMethod("GET");
    connection.connect();
  }

  /**
   * Converts an input stream to a string
   *
   * @param inputStream - the input stream to convert
   * @return input stream as a string
   */
  private String streamToString(InputStream inputStream) {
    return new Scanner(inputStream, StandardCharsets.UTF_8).useDelimiter("\\Z").next();
  }

  /**
   * Retrieves the current price for a stock symbol
   *
   * @param symbol - the stock symbol to get the price for
   * @return current price for the stock symbol
   */
  public Double getPrice(String symbol) {
    String globalQuoteJsonString = getGlobalQuote(symbol);
    JSONObject globalQuoteJsonObject = new JSONObject(globalQuoteJsonString);
    return globalQuoteJsonObject
      .getJSONObject("Global Quote")
      .getDouble("05. price");
  }
}
