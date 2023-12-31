package christmas;

import java.util.List;

public class User {
    private int reservationDate;
    private List<Order> orderMenuSet;
    private Dates dateService;
    private Discount discountService;
    private int totalOrderPrice;
    private int discountDday;
    private int discountWeekday;
    private int discountWeekend;
    private int discountSpecial;
    private int discountChampange;
    private int totalDiscount;
    private boolean giveChampange;
    private String badge;
    Validation validator;

    public User(){
        this.totalOrderPrice = 0;
    }

    public List<Order> getOrderMenuSet(){
        return orderMenuSet;
    }

    public int getTotalOrderPrice(){
        return totalOrderPrice;
    }

    public int getTotalDiscountPrice(){
        calcTotalDiscount();
        return totalDiscount;
    }

    public int getFinalPrice(){
        return totalOrderPrice - totalDiscount;
    }

    public boolean getIsWeekday(){
        return discountService.getIsWeekday();
    }

    public int getDiscountWeekday(){
        return discountWeekday;
    }

    public int getDiscountWeekend(){
        return discountWeekend;
    }

    public int getDiscountChampange(){
        return discountChampange;
    }

    public int getDiscountSpecial(){
        calcSpecialDiscount();
        return discountSpecial;
    }

    public String getBadge(){
        calcBadge();
        return badge;
    }

    public boolean isWeekdayDiscountExist(){
        calcWeekdayDiscount();
        return discountWeekday != 0;
    }

    public boolean isWeekendDiscountExist(){
        calcWeekendDiscount();
        return discountWeekend != 0;
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

        validator = new Validation();
        validator.checkOnlyDrink(reservationMenuSet);
    }

    public boolean makeGiftInfo(){
        Gift giftService = new Gift(totalOrderPrice);
        this.giveChampange = giftService.giveChampagne();

        if(this.giveChampange){
            this.discountChampange = 25000;
            return true;
        }
        this.discountChampange = 0;
        return false;
    }

    public int calcOrderVanillaPrice(){
        for(Order order : orderMenuSet){
            totalOrderPrice += order.getPerOrderPrice();
        }
        return totalOrderPrice;
    }

    public int calcDdayDiscount(){
        this.discountDday = discountService.dDayDiscount();
        return discountDday;
    }

    public int calcWeekdayDiscount(){
        if(discountService.getIsWeekday()){
            for(Order order : orderMenuSet){
                this.discountWeekday += order.getPerOrderDiscount();
            }
        }
        return discountWeekday;
    }

    public int calcWeekendDiscount(){
        if(!discountService.getIsWeekday()){
            for(Order order : orderMenuSet){
                this.discountWeekend += order.getPerOrderDiscount();
            }
        }
        return discountWeekend;
    }

    public int calcSpecialDiscount(){
        this.discountSpecial = discountService.specialDayDiscount();
        return discountSpecial;
    }

    public int calcTotalDiscount(){
        this.totalDiscount += discountDday;
        this.totalDiscount += discountSpecial;
        this.totalDiscount += discountWeekday;
        this.totalDiscount += discountWeekend;
        this.totalDiscount += discountChampange;
        return totalDiscount;
    }

    public String calcBadge(){
        Gift giftService = new Gift(totalOrderPrice, totalDiscount);
        this.badge = giftService.giveBadge();
        return badge;
    }
}
