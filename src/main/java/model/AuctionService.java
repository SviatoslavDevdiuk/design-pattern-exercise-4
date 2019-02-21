package model;


public class AuctionService implements Notifier {
    public boolean bid(Auction auction, Customer buyer, double amount) {
        if (auction.getHighestBid() < amount) {
            auction.setHighestBid(amount);
            registerCustomer(auction, buyer);
            notifyAboutNewBid(auction, amount);
            auction.setBuyer(buyer);
            return true;
        }
        return false;
    }

    public static AuctionService instance;

    private AuctionService() {

    }

    public static AuctionService getInstance() {
        if (instance == null) {
            synchronized (AuctionService.class) {
                if (instance == null) {
                    instance = new AuctionService();
                }
            }
        }
        return instance;
    }

    @Override
    public void registerCustomer(Auction auction, Customer customer) {
        auction.registerCustomer(customer);
    }

    @Override
    public void unregisterCustomer(Auction auction, Customer customer) {
        auction.getListOfCustomers().remove(customer);
    }

    @Override
    public void notifyAboutNewBid(Auction auction, double price) {

        auction.getListOfCustomers().forEach(customer -> customer.update(price));
    }

}
