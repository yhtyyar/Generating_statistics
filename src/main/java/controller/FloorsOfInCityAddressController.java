package controller;

import repository.SaxParserForFloorsAddressRepository;

import java.util.*;

public class FloorsOfInCityAddressController {

    private final SaxParserForFloorsAddressRepository saxParserForFloorsAddressRepository;


    private static final Set<String> addressSet = new TreeSet<>();
    private static final List<String> cityNameList = new LinkedList<>();
    private static final List<Integer> floorList = new LinkedList<>();


    public FloorsOfInCityAddressController(SaxParserForFloorsAddressRepository saxParserForFloorsAddressRepository) {

        this.saxParserForFloorsAddressRepository = saxParserForFloorsAddressRepository;
    }

    public void floorsOfInCity() {

        cityNameList.addAll(saxParserForFloorsAddressRepository.getCityNameList());
        floorList.addAll(saxParserForFloorsAddressRepository.getFloorsOfInCity());

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

            System.out.println("Количество 1,2,3,4 и 5 этажных зданий в городе " + str);

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

            stringBuilder.append("Одноэтажных домов: ").append(oneStory).append(" | ")
                    .append("Двухэтажных домов: ").append(twoStory).append(" | ")
                    .append("Трехэтажных домов: ").append(threeStory).append(" | ")
                    .append("Четырехэтажных домов: ").append(fourStory).append(" | ")
                    .append("Пятиэтажных домов: ").append(fiveStory).append(" | ");

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
