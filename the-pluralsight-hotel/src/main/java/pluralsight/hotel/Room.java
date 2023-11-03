package pluralsight.hotel;

public class Room {
    int number;
    boolean available;
    boolean isClean;
    RoomType roomType;

    public int getNumber() {
        return number;
    }

    public boolean isAvailable() {
        return available;
    }

    public boolean isClean() {
        return isClean;
    }

    public RoomType getRoomType() {
        return roomType;
    }
}
