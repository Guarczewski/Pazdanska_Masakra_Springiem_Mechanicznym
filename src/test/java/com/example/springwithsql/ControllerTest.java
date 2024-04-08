package com.example.springwithsql;

import java.util.Scanner;
public class ControllerTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {

            System.out.println("||================||");
            System.out.println("||  SELECT MENU   ||");
            System.out.println("||================||=============||==============||=============||================||");
            System.out.println("|| -> Food:       || [10] -> GET || [11] -> POST || [12] -> PUT || [13] -> DELETE ||");
            System.out.println("|| -> Horse:      || [20] -> GET ||              ||             ||                ||");
            System.out.println("|| -> Address:    || [30] -> GET ||              ||             ||                ||");
            System.out.println("|| -> Person:     || [40] -> GET ||              ||             ||                ||");
            System.out.println("|| -> Portion:    || [50] -> GET ||              ||             ||                ||");
            System.out.println("||================||=============||==============||=============||================||");
            System.out.println("|| -> All:        || [60] -> GET ||              ||             ||                ||");
            System.out.println("||================||=============||==============||=============||================||");
            System.out.println("|| -> SETTINGS    || [9] -> On/Off Display       || [0] -> Exit ||                ||");
            System.out.println("||================||=============||==============||=============||================||");
            System.out.println("|| CURRENT CONFIG ||             ||              ||             ||                ||");
            System.out.println("||================||=============||==============||=============||================||");
            System.out.println("|| -> Output ON   || " + Config.displayOutput);
            System.out.println("|| -> API URL     || " + Config.URL);
            System.out.println("||================||");

            switch (scanner.nextInt()) {
                // Food Test
                case 10: TFood.GET(); break;
                case 11: TFood.POST(); break;
                case 12: TFood.PUT(); break;
                case 13: TFood.DELETE(); break;
                // Horse Test
                case 20: THorse.GET(); break;
                // Address Test
                case 30: TAddress.GET(); break;
                // Person Test
                case 40: TOther.PersonGET(); break;
                // Portion Test
                case 50: TOther.PortionGET(); break;
                // All Test
                case 60: TestAll(); break;
                case 9: Config.displayOutput = !Config.displayOutput; break;
                default: return;
            }
        }
    }
    public static void TestAll(){
        TFood.GET();
        THorse.GET();
        TAddress.GET();
        TOther.PersonGET();
        TOther.PortionGET();
    }
}
