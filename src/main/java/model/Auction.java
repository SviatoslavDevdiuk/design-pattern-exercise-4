package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Auction {
    private int id;
    private String item;
    private String description;
    private LocalDateTime dueDate;
    private Customer seller;
    private double highestBid;
    private Customer buyer;
    protected List<Customer> listOfCustomers;

    public void showInfo() {
        System.out.println("Auction{" +
                "id=" + id +
                ", item='" + item + '\'' +
                ", description='" + description + '\'' +
                ", dueDate=" + dueDate +
                ", seller=" + seller.getFullName() +
                ", highestBid=" + highestBid +
                ", buyer=" + buyer.getFullName() +
                '}');
    }

    public Auction(int id, String item, String description, LocalDateTime dueDate, Customer seller, double highestBid, Customer buyer) {
        this.id = id;
        this.item = item;
        this.description = description;
        this.dueDate = dueDate;
        this.seller = seller;
        this.highestBid = highestBid;
        this.buyer = buyer;
    }

    public Auction() {
    }

    public void setListOfCustomers(List<Customer> listOfCustomers) {
        this.listOfCustomers = listOfCustomers;
    }

    public List<Customer> getListOfCustomers() {
        return listOfCustomers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public Customer getSeller() {
        return seller;
    }

    public void setSeller(Customer seller) {
        this.seller = seller;
    }

    public double getHighestBid() {
        return highestBid;
    }

    public void setHighestBid(double highestBid) {
        this.highestBid = highestBid;
    }

    public Customer getBuyer() {
        return buyer;
    }

    public void setBuyer(Customer buyer) {
        this.buyer = buyer;
    }

    // the method add participating customer to the list
    public void registerCustomer(Customer customer) {
        this.listOfCustomers.add(customer);
    }

    public static class AuctionBuilder {
        public AuctionBuilder() {
        }

        private int id;
        private String item;
        private String description;
        private LocalDateTime dueDate;
        private Customer seller;
        private double highestBid;
        private Customer buyer;
        protected List<Customer> listOfCustomers = new ArrayList<>();

        public AuctionBuilder withID(int id) {
            this.id = id;
            return this;
        }

        public AuctionBuilder withItem(String item) {
            this.item = item;
            return this;
        }

        public AuctionBuilder withDescription(String description) {
            this.description = description;
            return this;
        }

        public AuctionBuilder withDueDate(LocalDateTime dueDate) {
            this.dueDate = dueDate;
            return this;
        }

        public AuctionBuilder withSeller(Customer seller) {
            this.seller = seller;
            return this;
        }

        public AuctionBuilder withHighestBid(double highestBid) {
            this.highestBid = highestBid;
            return this;
        }

        public AuctionBuilder withBuyer(Customer buyer) {
            this.buyer = buyer;
            return this;
        }

        public Auction create() {
            Auction auction = new Auction();
            auction.setListOfCustomers(this.listOfCustomers);
            auction.setBuyer(this.buyer);
            auction.setHighestBid(this.highestBid);
            auction.setDescription(this.description);
            auction.setDueDate(this.dueDate);
            auction.setId(this.id);
            auction.setItem(this.item);
            auction.setSeller(this.seller);
            auction.registerCustomer(this.buyer);
            auction.registerCustomer(this.seller);
            return auction;
        }
    }
}
