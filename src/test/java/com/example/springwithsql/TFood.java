package com.example.springwithsql;

import com.example.springwithsql.Database.Entity.Food;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class TFood {

    public static void GET(){
        try {
            System.out.println("!!! Starting Food Get Test !!!");
            RestTemplate restTemplate = new RestTemplate();
            String urlString = Config.URL + "Food/";
            ParameterizedTypeReference<List<Food>> parameterizedTypeReference = new ParameterizedTypeReference<>() {};
            ResponseEntity<List<Food>> responseEntity = restTemplate.exchange(urlString, HttpMethod.GET, null, parameterizedTypeReference);
            List<Food> tmpList = responseEntity.getBody();

            System.out.println("-> Success");

            if (Config.displayOutput)
                for (Food tmp : tmpList)
                    System.out.println("->-> " + tmp.toString());

        }
        catch (Exception e) {
            System.out.println("-> Fail:");
            System.out.println("->-> " + e.getMessage());
        }
        finally {
            System.out.println("=== ### === ### === ### ===");
        }
    }
    public static void POST(){
        try {
            System.out.println("!!! Starting Food POST Test !!!");
            HttpHeaders httpHeaders = new HttpHeaders();
            RestTemplate restTemplate = new RestTemplate();
            String urlString = Config.URL + "Food/";

            httpHeaders.setContentType(MediaType.APPLICATION_JSON);

            String jsonString = "{\"name\": \"Example\", \"price\": 3.99}";
            HttpEntity<String> httpEntity = new HttpEntity<>(jsonString, httpHeaders);
            ResponseEntity<String> responseEntity = restTemplate.exchange(urlString, HttpMethod.POST, httpEntity, String.class);

            String result = responseEntity.getBody();
            System.out.println("->-> " + result);

        }
        catch (Exception e) {
            System.out.println("-> Fail:");
            System.out.println("->-> " + e.getMessage());
        }
        finally {
            System.out.println("=== ### === ### === ### ===");
        }
    }
    public static void PUT(){
        try {
            System.out.println("!!! Starting Food PUT Test !!!");
            HttpHeaders httpHeaders = new HttpHeaders();
            RestTemplate restTemplate = new RestTemplate();
            int idToBeChanged = 1;
            String urlString = Config.URL + "Food/" + idToBeChanged;

            httpHeaders.setContentType(MediaType.APPLICATION_JSON);

            String jsonString = "{\"name\": \"Example\", \"price\": 3.99}";
            HttpEntity<String> httpEntity = new HttpEntity<>(jsonString, httpHeaders);
            ResponseEntity<String> responseEntity = restTemplate.exchange(urlString, HttpMethod.PUT, httpEntity, String.class);

            String result = responseEntity.getBody();
            System.out.println("->-> " + result);

        }
        catch (Exception e) {
            System.out.println("-> Fail:");
            System.out.println("->-> " + e.getMessage());
        }
        finally {
            System.out.println("=== ### === ### === ### ===");
        }
    }
    public static void DELETE(){
        try {
            System.out.println("!!! Starting Food Delete Test !!!");
            RestTemplate restTemplate = new RestTemplate();
            int idToBeRemoved = 8;
            String urlString = Config.URL + "Food/" + idToBeRemoved;
            ResponseEntity<String> responseEntity = restTemplate.exchange(urlString, HttpMethod.DELETE, null, String.class);
            String response = responseEntity.getBody();

            System.out.println("-> Success");

            System.out.println("->-> " + response);

        }
        catch (Exception e) {
            System.out.println("-> Fail:");
            System.out.println("->-> " + e.getMessage());
        }
        finally {
            System.out.println("=== ### === ### === ### ===");
        }
    }

}
