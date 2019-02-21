package model;

public class Customer implements Observer {

    private String fullName;

    public String getFullName() {
        return fullName;
    }

    public Customer(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public void update(double price) {
        System.out.println(fullName + " a new price is: " + price);
    }
}
