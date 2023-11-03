package pluralsight.hotel;

public class Charge {
    double amount;
    String description;

    public Charge() {
    }

    public Charge(double amount, String description) {
        this.amount = amount;
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }
}
