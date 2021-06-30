package model;

public class Address {

    private final String cityName;
    private final String streetName;
    private final int houseNumber;
    private  final int floor;

    public Address(String cityName, String streetName, int houseNumber, int floor) {

        this.cityName = cityName;
        this.streetName = streetName;
        this.houseNumber = houseNumber;
        this.floor = floor;
    }

    @Override
    public String toString() {
        return "Адрес: " +
                " город: " + cityName  +
                " улица: " + streetName +
                " дом: " + houseNumber +
                " этаж: " + floor;
    }
}
