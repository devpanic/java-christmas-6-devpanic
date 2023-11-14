package christmas.view;

import christmas.Order;
import java.util.List;

public class OutputView {
    public void printSpace(){
        System.out.println("");
    }

    public void printNothing(){
        System.out.println(Messages.NOTHING.getMessage());
    }

    public void printWelcomeMessage(){
        System.out.println(Messages.WELCOME.getMessage());
    }

    public void printTakeOrderMessage(){
        System.out.println(Messages.TAKE_ORDER.getMessage());
    }

    public void printOrderInfoMessage(){
        System.out.println(Messages.TOTAL_MENU_INFO.getMessage());
    }

    public void printOrderMenuSetMessage(List<Order> orderMenuSet){
        for(Order orderMenu : orderMenuSet){
            System.out.println(orderMenu.getMenu() + " " + orderMenu.getMenuCount() + "개");
        }
    }

    public String makeIntegerFormat(int totalPrice){
        String originTotalPrice = "" + totalPrice;
        int i;
        String returnString = "";

        for(i = originTotalPrice.length(); i > 3 ; i -= 3){
            returnString = "," + originTotalPrice.substring(i - 3, i) + returnString;
        }
        returnString = originTotalPrice.substring(0, i) + returnString;

        return returnString;
    }

    public void printTotalPriceTitleMessage(){
        System.out.println(Messages.TOTAL_PRICE_BEFORE.getMessage());
    }

    public void printPriceContentMessage(int totalPrice){
        System.out.println(makeIntegerFormat(totalPrice) + "원");
    }

    public void printGiftTitleMessage(){
        System.out.println(Messages.GIFT_CHAMPANGE_INFO.getMessage());
    }

    public void printGiftContentMessage(){
        System.out.println(Messages.GIFT_CHAMPANGE.getMessage());
    }

    public void printDiscountTitleMessage(){
        System.out.println(Messages.DISCOUNT_INFO.getMessage());
    }

    public void printDiscountDdayMessage(){
        System.out.print(Messages.DISCOUNT_DDAY.getMessage());
    }

    public void printDiscountWeekdayMessage(){
        System.out.print(Messages.DISCOUNT_WEEKDAY.getMessage());
    }

    public void printDiscountWeekendMessage(){
        System.out.print(Messages.DISCOUNT_WEEKEND.getMessage());
    }

    public void printDiscountSpecialMessage(){
        System.out.print(Messages.DISCOUNT_SPECIAL.getMessage());
    }

    public void printDiscountGiftMessage(){
        System.out.print(Messages.DISCOUNT_GIFT.getMessage());
    }

    public void printDiscountTotalTitleMessage(){
        System.out.println(Messages.DISCOUNT_TOTAL_INFO.getMessage());
    }

    public void printDiscountTotalContentMessage(int totalDiscount){
        if(totalDiscount != 0){
            System.out.println("-" + makeIntegerFormat(totalDiscount));
        } else if(totalDiscount == 0){
            System.out.println("0원");
        }
    }

    public void printFinalPriceTitleMessage(){
        System.out.println(Messages.FINAL_PRICE.getMessage());
    }

    public void printBadgeTitleMessage(){
        System.out.println(Messages.BADGE.getMessage());
    }

    public void printBadgeContentMessage(String badge){
        System.out.println(badge);
    }
}
