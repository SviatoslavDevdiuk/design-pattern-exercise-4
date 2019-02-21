package main;

import model.Auction;
import model.AuctionService;
import model.Customer;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        AuctionService auctionService = AuctionService.getInstance();
        Auction auction1 = new Auction.AuctionBuilder().withBuyer(new Customer("Sviatoslav Devdiuk"))
                .withDescription("very interesting thing").withID(43).withItem("Tesla tower mini")
                .withDueDate(LocalDateTime.of(2019, 03, 25, 18, 30, 00))
                .withSeller(new Customer("Toys Store \"Wonderwolrd\"")).create();

        auctionService.bid(auction1, new Customer("Alberto Fillani"), 250);
        auctionService.bid(auction1, new Customer("Mihalis Zambidis"), 300);
        auctionService.bid(auction1, new Customer("Robert Martin"), 500);
    }
}
