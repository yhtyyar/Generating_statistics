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
        return "Address: " +
                " city: " + cityName  +
                " street: " + streetName +
                " house: " + houseNumber +
                " floor: " + floor;
    }
}
