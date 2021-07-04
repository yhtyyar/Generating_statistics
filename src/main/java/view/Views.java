package view;

import controller.DuplicateAddressController;
import controller.FloorsOfInCityController;
import parser.XMLHandler;

import java.util.Scanner;

public class Views {

    private static final Scanner scanner = new Scanner(System.in);

    public static ViewAbstract getView() {


        System.out.println("Write the number of the request for which you want to get statistics\n\n" +
                "1. Display duplicate records, with the number of repetitions\n" +
                "2. Calculate how many in each city: 1,2,3,4 and 5 storey buildings\n" +
                "3. Exit\n");


        String type = scanner.nextLine();

        switch (type) {

            case "1":
                duplicateAddress();
                return AddressView.getInstance();

            case "2":
                floorsOfInCity();
                return AddressView.getInstance();

            case "3":
                exit();

            default:
                System.out.println("You entered an invalid request! try again");
                System.out.println("\n=========================================================\n");
                return getView();
        }
    }

    private static void exit() {
        System.exit(0);
    }


    private static void duplicateAddress() {

        System.out.println("Request processing ...");

        XMLHandler xmlHandler = new XMLHandler();
        DuplicateAddressController duplicate = new DuplicateAddressController(xmlHandler);
        duplicate.getDuplicateEntries();

        System.out.println("\n=========================================================\n");

    }

    private static void floorsOfInCity() {

        System.out.println("Request processing ...");

        XMLHandler xmlHandler = new XMLHandler();
        FloorsOfInCityController floors = new FloorsOfInCityController(xmlHandler);
        floors.floorsOfInCity();

        System.out.println("\n=========================================================\n");
    }
}
