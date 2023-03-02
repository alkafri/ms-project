package com.example.msproject.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.json.JSONObject;


@Entity
@NoArgsConstructor
@Setter
@Getter

public class GetRout implements Cloneable {
    @Id
    private int lengthInMeters;
    private int travelTimeInSeconds;
    private int trafficDelayInSeconds;
    private int trafficLengthInMeters;
    private String departureTime;
    private String arrivalTime;

    public String GetRoutFromAzure(String dLocation, String aLocation) {

        try {
            String endpointUrl = "https://tomtom-mapcrud.azuremicroservices.io/search/abbe/";
            String departureLocation = dLocation;
            String arrivalLocation = aLocation;

            // Encode the parameters
            departureLocation = URLEncoder.encode(departureLocation, "UTF-8");
            arrivalLocation = URLEncoder.encode(arrivalLocation, "UTF-8");

            // Add the parameters to the endpoint URL
            endpointUrl +=  departureLocation + "/" + arrivalLocation;

            URL url = new URL(endpointUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("x-api-key", "2033732");


            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String response = "";
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response += inputLine;
            }
            in.close();

            /**
             * Extract Data here
             */
            GetRout getRout = new GetRout();
            JSONObject jsonObject = new JSONObject(response);


            lengthInMeters = jsonObject.getJSONArray("routes")
                    .getJSONObject(0)
                    .getJSONObject("summary")
                    .getInt("lengthInMeters");
            getRout.setLengthInMeters(lengthInMeters);

            travelTimeInSeconds = jsonObject.getJSONArray("routes")
                    .getJSONObject(0)
                    .getJSONObject("summary")
                    .getInt("travelTimeInSeconds");
            getRout.setTravelTimeInSeconds(travelTimeInSeconds);

            trafficDelayInSeconds = jsonObject.getJSONArray("routes")
                    .getJSONObject(0)
                    .getJSONObject("summary")
                    .getInt("trafficDelayInSeconds");
            getRout.setTrafficDelayInSeconds(trafficDelayInSeconds);

            trafficLengthInMeters = jsonObject.getJSONArray("routes")
                    .getJSONObject(0)
                    .getJSONObject("summary")
                    .getInt("trafficLengthInMeters");
            getRout.setTrafficLengthInMeters(trafficLengthInMeters);

            departureTime = jsonObject.getJSONArray("routes")
                    .getJSONObject(0)
                    .getJSONObject("summary")
                    .getString("departureTime");
            getRout.setDepartureTime(departureTime);

            arrivalTime = jsonObject.getJSONArray("routes")
                    .getJSONObject(0)
                    .getJSONObject("summary")
                    .getString("arrivalTime");
            getRout.setArrivalTime(arrivalTime);
            /**
             * End of data Extraction
             */

            return response;
        } catch (Exception e) {
            return "Error - Invalid Route";
        }
    }
}

