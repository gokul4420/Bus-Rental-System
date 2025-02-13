package pkg1;

public class Bus {
	private int busId;
    private String driverName;
    private int capacity;
    private int availableSeats;

    public Bus(int busId, String driverName, int capacity) {
        this.busId = busId;
        this.driverName = driverName;
        this.capacity = capacity;
        this.availableSeats = capacity;
    }

    public int getBusId() {
        return busId;
    }

    public String getDriverName() {
        return driverName;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public boolean isAvailable() {
        return availableSeats > 0;
    }

    public boolean bookSeat() {
        if (availableSeats > 0) {
            availableSeats--;
            return true;
        }
        return false;
    }

    public void cancelSeat() {
        if (availableSeats < capacity) {
            availableSeats++;
        }
    }

    
    public String toString() {
        return "Bus ID: " + busId + ", Driver: " + driverName +
               ", Capacity: " + capacity + ", Available Seats: " + availableSeats;
    }
}


