package christmas;

import java.util.List;

public class User {
    private int reservationDate;
    private List<Order> orderMenuSet;
    private int totalPurchase;
    private int discountDday;
    private int discountDessert;
    private int discountMainDish;
    private int discountChampange;
    private int totalDiscount;
    private boolean giveChampange;
    private String badge;

    public User(){
    }

    public void makeReservation(List<Order> reservationMenuSet){
        this.orderMenuSet = reservationMenuSet;
    }

    public void reserveDate(int reservationDate){
        this.reservationDate = reservationDate;
    }

    public void setBadge(String badge){
        this.badge = badge;
    }

    public String getBadge(){
        return badge;
    }
}
