package pkg1;


public class Customer {
    private int customerId;
    private String name;
    private int busId;

    public Customer(int customerId, String name, int busId) {
        this.customerId = customerId;
        this.name = name;
        this.busId = busId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public int getBusId() {
        return busId;
    }

    public String toString() {
        return "Customer ID: " + customerId + ", Name: " + name + ", Booked Bus ID: " + busId;
    }
}
