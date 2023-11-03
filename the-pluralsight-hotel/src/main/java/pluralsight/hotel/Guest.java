package pluralsight.hotel;

public class Guest {
    String name;
    String address;

    public Guest(String name, String address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Guest{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
