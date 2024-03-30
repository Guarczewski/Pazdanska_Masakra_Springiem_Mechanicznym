package com.example.springwithsql;

import com.example.springwithsql.Database.Entity.*;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.Scanner;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;


public class ControllerTest {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("| TEST SELECT MENU: ");
            System.out.println("| [1] -> Food API Test");
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
                case 1: FoodTest(); break;
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
        FoodTest();
        PortionTest();
        HorseTest();
        AddressTest();
        PersonTest();
    }
    public static void FoodTest(){
        try {
            System.out.println("!!! Starting Food Test !!!");
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
