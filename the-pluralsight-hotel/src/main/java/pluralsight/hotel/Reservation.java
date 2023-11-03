package pluralsight.hotel;

import java.time.LocalDate;
import java.util.List;

public class Reservation {
    public Reservation() {
    }

    public Reservation(LocalDate start, LocalDate end, Guest guest, RoomType roomType, int numberOfNights, boolean isWeekend, Charge charge) {
        this.start = start;
        this.end = end;
        this.requestedType = roomType;
        this.guest = guest;
        this.numberOfNights = numberOfNights;
        this.isWeekend = isWeekend;
        this.charge = charge;
    }

    LocalDate start;
    LocalDate end;
    Guest guest;
    RoomType requestedType;

    int numberOfNights;

    boolean isWeekend;

    Charge charge;

    public RoomType getRequestedType() {
        return requestedType;
    }

    public void setRequestedType(RoomType requestedType) {
        this.requestedType = requestedType;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

    public void setNumberOfNights(int numberOfNights) {
        this.numberOfNights = numberOfNights;
    }

//    public Charge getCharge() {
//        return charge;
//    }

    public boolean isWeekend() {
        return isWeekend;
    }

    public void setWeekend(boolean weekend) {
        isWeekend = weekend;
    }

    public double getReservationTotal(){
        // Charge if king and number of nights = total
        Charge charge1 = new Charge();
        RoomType roomType = new RoomType();
        String roomType2 = String.valueOf(roomType.getRoomType().contains("King"));
//        double price
        // if roomType = king == price $139
        // number of nights
        // Charge if double and number of nights = total
//        Charge charge1
        return 0;
    }

    public static void main(String[] args) {

        Reservation r = new Reservation(null, null, new Guest("Paul", "123 Somewhere Street"), new RoomType("King"), 5, true, new Charge(500.00, "It's a vacation") );
        System.out.println(r);
    }

    // The following fields are assigned when the guest checks in
    Room room = null;
    Folio folio = null;
    List<RoomKey> keys = null;

    @Override
    public String toString() {
        return "Reservation{" +
                "guest=" + guest +
                ", requestedType=" + requestedType +
                ", numberOfNights=" + numberOfNights +
                ", isWeekend=" + isWeekend +
                ", charge=" + charge +
                '}';
    }
}
