package model;

public interface Notifier {

    void registerCustomer(Auction auction, Customer customer);

    void unregisterCustomer(Auction auction, Customer customer);

    void notifyAboutNewBid(Auction auction, double price);
}
