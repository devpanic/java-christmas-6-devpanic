package christmas;

import java.util.List;
import org.mockito.internal.matchers.Or;

public class User {
    private int reservationDate;
    private List<Order> orderMenuSet;
    private Dates dateService;
    private Discount discountService;
    private int totalOrderPrice;
    private int discountDday;
    private int discountDessert;
    private int discountMainDish;
    private int discountChampange;
    private int totalDiscount;
    private boolean giveChampange;
    private String badge;

    public User(){
        this.totalOrderPrice = 0;
    }

    public void setBadge(String badge){
        this.badge = badge;
    }

    public String getBadge(){
        return badge;
    }

    public List<Order> getOrderMenuSet(){
        return orderMenuSet;
    }

    public void reserveDate(int reservationDate){
        this.reservationDate = reservationDate;
    }

    public void makeReservation(List<Order> reservationMenuSet){
        this.dateService = new Dates(reservationDate);
        this.discountService = new Discount(reservationDate, dateService.calcDayOfWeek(reservationDate));
        for(Order order : reservationMenuSet){
            order.makeOrderInfo();
            order.makeDiscountInfo(discountService.dayDessertDiscount(), discountService.dayMainDishDiscount());
        }
        this.orderMenuSet = reservationMenuSet;
    }

    public int calcOrderVanillaPrice(){
        for(Order order : orderMenuSet){
            totalOrderPrice += order.getPerOrderPrice();
        }
        return totalOrderPrice;
    }
}
