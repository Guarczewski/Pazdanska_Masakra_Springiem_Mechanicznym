package com.example.springwithsql;

import com.example.springwithsql.Database.Entity.Person;
import com.example.springwithsql.Database.Entity.Portions;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class TOther {
    public static void PersonGET(){
        try {
            System.out.println("!!! Starting Address Test !!!");

            RestTemplate restTemplate = new RestTemplate();
            String urlString = Config.URL + "Address/";
            ParameterizedTypeReference<List<Person>> parameterizedTypeReference = new ParameterizedTypeReference<>() {};
            ResponseEntity<List<Person>> responseEntity = restTemplate.exchange(urlString, HttpMethod.GET, null, parameterizedTypeReference);
            List<Person> tmpList = responseEntity.getBody();

            System.out.println("-> Success");

            if (Config.displayOutput)
                for (Person tmp : tmpList)
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
    public static void PortionGET(){
        try {
            System.out.println("!!! Starting Portion Test !!!");
            RestTemplate restTemplate = new RestTemplate();
            String urlString = Config.URL + "Portions/";
            ParameterizedTypeReference<List<Portions>> parameterizedTypeReference = new ParameterizedTypeReference<>() {};
            ResponseEntity<List<Portions>> responseEntity = restTemplate.exchange(urlString, HttpMethod.GET, null, parameterizedTypeReference);
            List<Portions> tmpList = responseEntity.getBody();

            System.out.println("-> Success");

            if (Config.displayOutput)
                for (Portions tmp : tmpList)
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
}
