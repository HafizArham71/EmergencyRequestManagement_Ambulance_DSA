package Requests;

public class Location {

    // Attributes
    private String place;
    private String area;
    private String city;
    private String country;

    // Constructor
    public Location(String place, String area, String city, String country) {
        this.place = place;
        this.area = area;
        this.city = city;
        this.country = country;
    }

    // Methods
    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String toString() {
        return String.format(place + ", " + area + ", " + city + ", " + country);
    }
}
