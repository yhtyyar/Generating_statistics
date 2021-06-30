package view;

import controller.DuplicateAddressController;
import controller.FloorsOfInCityAddressController;
import repository.SaxParserForFloorsAddressRepository;
import repository.SaxParserGetAllAddressRepository;

import java.util.Scanner;

public class Views {

    private static final Scanner scanner = new Scanner(System.in);

    public static ViewAbstract getView() {


        System.out.println("Write the number of the request for which you want to get statistics\n" +
                "1. Display duplicate records, with the number of repetitions\n" +
                "2. Calculate how many in each city: 1,2,3,4 and 5 storey buildings\n" +
                "3. Exit");


        int type = scanner.nextInt();

        switch (type) {

            case 1:
                duplicateAddress();
                return AddressView.getInstance();

            case 2:
                floorsOfInCity();
                return AddressView.getInstance();


            case 3:
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

        SaxParserGetAllAddressRepository saxParser = new SaxParserGetAllAddressRepository();

        DuplicateAddressController duplicate = new DuplicateAddressController(saxParser);

        duplicate.getDuplicateEntries();

        System.out.println("\n=========================================================\n");

    }

    private static void floorsOfInCity() {

        System.out.println("Request processing ...");

        SaxParserForFloorsAddressRepository saxParserForFloor = new SaxParserForFloorsAddressRepository();

        FloorsOfInCityAddressController floors = new FloorsOfInCityAddressController(saxParserForFloor);

        floors.floorsOfInCity();

        System.out.println("\n=========================================================\n");
    }
}
