package com.example.springwithsql;

import com.example.springwithsql.Database.Entity.Address;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class TAddress {
    public static void GET(){
        try {
            System.out.println("!!! Starting Address Test !!!");

            RestTemplate restTemplate = new RestTemplate();
            String urlString = Config.URL + "Address/";
            ParameterizedTypeReference<List<Address>> parameterizedTypeReference = new ParameterizedTypeReference<>() {};
            ResponseEntity<List<Address>> responseEntity = restTemplate.exchange(urlString, HttpMethod.GET, null, parameterizedTypeReference);
            List<Address> tmpList = responseEntity.getBody();

            System.out.println("-> Success");

            if (Config.displayOutput)
                for (Address tmp : tmpList)
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
