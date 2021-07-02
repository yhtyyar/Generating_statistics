package controller;

import parser.XMLHandler;

import java.util.*;

public class FloorsOfInCityAddressController {

    private final XMLHandler xmlHandler;


    private final Set<String> addressSet = new TreeSet<>();
    private final List<String> cityNameList = new LinkedList<>();
    private final List<Integer> floorList = new LinkedList<>();


    public FloorsOfInCityAddressController(XMLHandler xmlHandler) {
        this.xmlHandler = xmlHandler;
    }

    public void floorsOfInCity() {

        cityNameList.addAll(xmlHandler.getCityNameList());
        floorList.addAll(xmlHandler.getFloors());
        addressSet.addAll(cityNameList);

        int oneStory;
        int twoStory;
        int threeStory;
        int fourStory;
        int fiveStory;
        int floor;

        StringBuilder stringBuilder;

        for (String str : addressSet) {

            oneStory = 0;
            twoStory = 0;
            threeStory = 0;
            fourStory = 0;
            fiveStory = 0;

            stringBuilder = new StringBuilder();

            System.out.println("The number of 1,2,3,4 and 5 storey buildings in the city " + str);

            Iterator<String> iteratorCityName = cityNameList.iterator();

            while (iteratorCityName.hasNext()) {

                if (iteratorCityName.next().equals(str)) {

                    floor = 0;

                    try {

                        floor = floorList.get(cityNameList.indexOf(iteratorCityName.next()));
                    } catch (NoSuchElementException e) {

                        // в конце списка возвращет исключение NoSuchElementException потому что, след элемента нет
                        System.out.print("");
                    }


                    if (floor == 1) {
                        oneStory++;

                    } else if (floor == 2) {
                        twoStory++;

                    } else if (floor == 3) {
                        threeStory++;

                    } else if (floor == 4) {
                        fourStory++;

                    } else if (floor == 5) {
                        fiveStory++;
                    }

                }
            }

            stringBuilder.append("One-story houses: ").append(oneStory).append(" | ")
                    .append("Two-story houses: ").append(twoStory).append(" | ")
                    .append("Three-story houses: ").append(threeStory).append(" | ")
                    .append("Four-story houses: ").append(fourStory).append(" | ")
                    .append("Five-story houses: ").append(fiveStory).append(" | ");

            System.out.println(stringBuilder + "\n\n");

        }

    }


    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }else if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        return false;
    }

}
