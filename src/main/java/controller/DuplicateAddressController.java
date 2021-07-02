package controller;

import parser.XMLHandler;

import java.util.*;
import java.util.stream.Collectors;

public class DuplicateAddressController {

    private final XMLHandler xmlHandler;

    private final List<String> addressList = new ArrayList<>();

    public DuplicateAddressController(XMLHandler xmlHandler) {
        this.xmlHandler = xmlHandler;
    }


    public void getDuplicateEntries() {

        addressList.addAll(xmlHandler.getAllInList());

        String[] array = new String[addressList.size()];
        addressList.toArray(array);

        Set<String> allItems = new HashSet<>();

        List<String> duplicates = Arrays.stream(array)
                .filter(n -> !allItems.add(n))  // при добавлении в HashSet одинаковых значений вернет false
                .collect(Collectors.toList());

        Set<String> resultDuplicates = new HashSet<>(duplicates);

        int copy;

        for (String result : resultDuplicates) {
            copy = 0;

            for (String str : duplicates) {
                if (str.equals(result)) {
                    copy++;
                }
            }

            System.out.println(result + " | Number of repetitions: " + copy);
        }
    }

}
