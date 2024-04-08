package com.example.springwithsql;

import com.example.springwithsql.Database.Entity.Horse;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class THorse {
    public static void GET(){
        try {
            System.out.println("!!! Starting Address Test !!!");

            RestTemplate restTemplate = new RestTemplate();
            String urlString = Config.URL + "Address/";
            ParameterizedTypeReference<List<Horse>> parameterizedTypeReference = new ParameterizedTypeReference<>() {};
            ResponseEntity<List<Horse>> responseEntity = restTemplate.exchange(urlString, HttpMethod.GET, null, parameterizedTypeReference);
            List<Horse> tmpList = responseEntity.getBody();

            System.out.println("-> Success");

            if (Config.displayOutput)
                for (Horse tmp : tmpList)
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
