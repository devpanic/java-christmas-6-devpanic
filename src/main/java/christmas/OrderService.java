package christmas;

import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.ArrayList;
import java.util.List;

public class OrderService {
    private List<User> customers = new ArrayList<>();
    private User currentCustomer;
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public OrderService(){}

    public void createUser(){
        this.currentCustomer = new User();
    }

    public void requestOrder(){
        outputView.printWelcomeMessage();
        currentCustomer.reserveDate(inputView.inputDate());

        outputView.printTakeOrderMessage();
        while(true){
            try{
                currentCustomer.makeReservation(inputView.inputAllOrder());
                return;
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void requestOrderInfo(){
        outputView.printOrderInfoMessage();
        outputView.printOrderMenuSetMessage(currentCustomer.getOrderMenuSet());
        outputView.printSpace();
    }

    public void requestTotalPriceInfo(){
        outputView.printTotalPriceTitleMessage();
        outputView.printPriceContentMessage(currentCustomer.calcOrderVanillaPrice());
        outputView.printSpace();
    }

    public void requestGiftInfo(){
        outputView.printGiftTitleMessage();
        if(currentCustomer.makeGiftInfo()){
            outputView.printGiftContentMessage();
            outputView.printSpace();
            return;
        }
        outputView.printNothing();
        outputView.printSpace();
    }

    public void requestDdayDiscountInfo(){
        if(currentCustomer.calcDdayDiscount() != 0){
            outputView.printDiscountDdayMessage();
            outputView.printPriceContentMessage(currentCustomer.calcDdayDiscount());
        }
    }

    public void requestWeekDiscountInfo(){
        if(currentCustomer.getIsWeekday() && currentCustomer.isWeekdayDiscountExist()){
            outputView.printDiscountWeekdayMessage();
            outputView.printPriceContentMessage(currentCustomer.getDiscountWeekday());
        } else if(!currentCustomer.getIsWeekday() && currentCustomer.isWeekendDiscountExist()){
            outputView.printDiscountWeekendMessage();
            outputView.printPriceContentMessage(currentCustomer.getDiscountWeekend());
        }
    }

    public void requestSpecialDiscountInfo(){
        if(currentCustomer.getDiscountSpecial() == 1000){
            outputView.printDiscountSpecialMessage();
            outputView.printPriceContentMessage(currentCustomer.getDiscountSpecial());
        }
    }

    public void requestGiftDiscountInfo(){
        if(currentCustomer.getDiscountChampange() == 25000){
            outputView.printDiscountGiftMessage();
            outputView.printPriceContentMessage(currentCustomer.getDiscountChampange());
        }
    }

    public void requestDiscountInfo(){
        outputView.printDiscountTitleMessage();
        if(currentCustomer.getTotalOrderPrice() < 10000){
            outputView.printNothing();
            outputView.printSpace();
            return;
        }
        requestDdayDiscountInfo();
        requestWeekDiscountInfo();
        requestSpecialDiscountInfo();
        requestGiftDiscountInfo();
        outputView.printSpace();
    }

    public void requestTotalDiscountInfo(){
        outputView.printDiscountTotalTitleMessage();
        outputView.printDiscountTotalContentMessage(currentCustomer.getTotalDiscountPrice());
        outputView.printSpace();
    }

    public void requestFinalPriceInfo(){
        outputView.printFinalPriceTitleMessage();
        outputView.printPriceContentMessage(currentCustomer.getFinalPrice());
        outputView.printSpace();
    }

    public void requestBadgeInfo(){
        outputView.printBadgeTitleMessage();
        outputView.printBadgeContentMessage(currentCustomer.getBadge());
    }

    public void doOrder(){
        createUser();
        requestOrder();
        requestOrderInfo();
        requestTotalPriceInfo();
        requestGiftInfo();
        requestDiscountInfo();
        requestTotalDiscountInfo();
        requestFinalPriceInfo();
        requestBadgeInfo();
    }

    // TODO : for next year promotion
    public int calcChristmasTotalSellingPrice(){
        int totalSellingPrice = 0;
        for(User user: customers){
            totalSellingPrice += user.getFinalPrice();
        }
        return totalSellingPrice;
    }
}
