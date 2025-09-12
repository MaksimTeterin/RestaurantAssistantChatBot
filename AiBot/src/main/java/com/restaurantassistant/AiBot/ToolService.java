package com.restaurantassistant.AiBot;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.ai.tool.annotation.Tool;
import java.util.Scanner;

import java.net.HttpURLConnection;
import java.net.URL;


public class ToolService {
    @Tool(description = "Find all bookings")
    public JSONPObject findAllBookings(){
        try{

            URL url = new URL("http://localhost:8080/api/bookings");

            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.connect();

            int responseCode = con.getResponseCode();

            if(responseCode != HttpURLConnection.HTTP_OK){
                throw new RuntimeException("Failed : HTTP error code : "+ responseCode);
            }
            else {
                String inline = "";

                Scanner scanner = new Scanner(url.openStream());

                while(scanner.hasNext()){
                    inline += scanner.nextLine();
                }

                scanner.close();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }



}
