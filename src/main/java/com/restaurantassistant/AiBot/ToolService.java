package com.restaurantassistant.AiBot;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Scanner;

import java.net.HttpURLConnection;
import java.net.URL;


@Service
public class ToolService {

    @Tool(description = "Get the current date and time in the user's timezone")
    String getCurrentDateTime() {
        return LocalDateTime.now().atZone(LocaleContextHolder.getTimeZone().toZoneId()).toString();
    }

//    @Tool(description = "Find all bookings")
//    public JSONPObject findAllBookings(){
//        try{
//
//            URL url = new URL("http://localhost:8080/api/bookings");
//
//            HttpURLConnection con = (HttpURLConnection) url.openConnection();
//            con.setRequestMethod("GET");
//            con.connect();
//
//            int responseCode = con.getResponseCode();
//
//            if(responseCode != HttpURLConnection.HTTP_OK){
//                throw new RuntimeException("Failed : HTTP error code : "+ responseCode);
//            }
//            else {
//                String inline = "";
//
//                Scanner scanner = new Scanner(url.openStream());
//
//                while(scanner.hasNext()){
//                    inline += scanner.nextLine();
//                }
//
//                scanner.close();
//            }
//        }
//        catch(Exception e){
//            e.printStackTrace();
//        }
//        return null;
//    }



}
