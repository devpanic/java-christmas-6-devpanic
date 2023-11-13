package christmas;

public class User {
    private int reservationDate;
//    private orderList;
    private int totalPurchase;
    private int discountDday;
    private int discountDessert;
    private int discountMainDish;
    private int discountChampange;
    private int totalDiscount;
    private boolean giveChampange;
    private String badge;

    public User(int reservationDate){
        this.reservationDate = reservationDate;
    }

    public void setBadge(String badge){
        this.badge = badge;
    }

    public String getBadge(){
        return badge;
    }
}
