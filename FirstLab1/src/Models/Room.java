public class Room {
    private String type;
    private int bedCount;
    private int roomNumber;
    private String amenities;

    public Room(String type, int bedCount, int roomNumber, String amenities) {
        this.type = type;
        this.bedCount = bedCount;
        this.roomNumber = roomNumber;
        this.amenities = amenities;
    }

    // Getters and setters

    @Override
    public String toString() {
        return "Room{" +
                "type='" + type + '\'' +
                ", bedCount=" + bedCount +
                ", roomNumber=" + roomNumber +
                ", amenities='" + amenities + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return bedCount == room.bedCount &&
                roomNumber == room.roomNumber &&
                type.equals(room.type) &&
                amenities.equals(room.amenities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, bedCount, roomNumber, amenities);
    }
}
