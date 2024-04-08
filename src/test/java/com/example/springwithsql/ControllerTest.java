package com.example.springwithsql;

import com.example.springwithsql.Database.Entity.*;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.Scanner;

import org.springframework.core.ParameterizedTypeReference;


public class ControllerTest {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("| TEST SELECT MENU: ");
            System.out.println("| [1] -> Food API GET Test");
            System.out.println("| [11] -> Food API POST Test");
            System.out.println("| [12] -> Food API PUT Test");
            System.out.println("| [13] -> Food API PUT Test");
            System.out.println("| [2] -> Portion API Test");
            System.out.println("| [3] -> Horse API Test");
            System.out.println("| [4] -> Address API Test");
            System.out.println("| [5] -> Person API Test");
            System.out.println("| [6] -> All APIs Test");
            System.out.println("| SETTINGS: ");
            System.out.println("| Display Output: " + Config.displayOutput);
            System.out.println("| API URL: " + Config.URL);
            System.out.println("| [9] -> On/Off Display");
            System.out.println("| [0] -> Close");

            switch (scanner.nextInt()) {
                case 1: FoodGetTest(); break;
                case 11: FoodPostTest(); break;
                case 12: FoodPutTest(); break;
                case 13: FoodDeleteTest(); break;
                case 2: PortionTest(); break;
                case 3: HorseTest(); break;
                case 4: AddressTest(); break;
                case 5: PersonTest(); break;
                case 6: TestAll(); break;
                case 9: Config.displayOutput = !Config.displayOutput; break;
                default: return;
            }


        }
    }

    public static void TestAll(){
        FoodGetTest();
        PortionTest();
        HorseTest();
        AddressTest();
        PersonTest();
    }
    // Start All Food Tests
    public static void FoodGetTest(){
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
    public static void FoodPostTest(){
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
    public static void FoodPutTest(){
        try {
            System.out.println("!!! Starting Food POST Test !!!");
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
    public static void FoodDeleteTest(){
        try {
            System.out.println("!!! Starting Food Delete Test !!!");
            RestTemplate restTemplate = new RestTemplate();
            int idToBeRemoved = 8;
            String urlString = Config.URL + "Food/" + idToBeRemoved;
            ParameterizedTypeReference<String> parameterizedTypeReference = new ParameterizedTypeReference<>() {};
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
    public static void PortionTest(){
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
    public static void HorseTest(){
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
    public static void AddressTest(){
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
    public static void PersonTest(){
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

}
