package view;

import controller.DuplicateAddressController;
import controller.FloorsOfInCityAddressController;
import repository.SaxParserForFloorsAddressRepository;
import repository.SaxParserGetAllAddressRepository;

import java.util.Scanner;

public class Views {

    private static final Scanner scanner = new Scanner(System.in);

    public static ViewAbstract getView() {


        System.out.println("Напишите цифру запроса по которому хотите получить статистику\n" +
                "1. Отобразить дублирующие записи, с количеством повторений\n" +
                "2. Посчитать, сколько в каждом городе: 1,2,3,4 и 5 этажных зданий\n" +
                "3. Выход");


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
                System.out.println("Вы ввели неправильный запрос! Попробуйте еще раз");
                System.out.println("\n=========================================================\n");
                return getView();
        }
    }

    private static void exit() {

        System.exit(0);
    }


    private static void duplicateAddress() {

        System.out.println("Запрос обрабатывается...");

        SaxParserGetAllAddressRepository saxParser = new SaxParserGetAllAddressRepository();

        DuplicateAddressController duplicate = new DuplicateAddressController(saxParser);

        duplicate.getDuplicateEntries();

        System.out.println("\n=========================================================\n");

    }

    private static void floorsOfInCity() {

        System.out.println("Запрос обрабатывается...");

        SaxParserForFloorsAddressRepository saxParserForFloor = new SaxParserForFloorsAddressRepository();

        FloorsOfInCityAddressController floors = new FloorsOfInCityAddressController(saxParserForFloor);

        floors.floorsOfInCity();

        System.out.println("\n=========================================================\n");
    }
}
