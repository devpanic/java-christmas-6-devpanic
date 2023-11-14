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
        currentCustomer.makeReservation(inputView.inputAllOrder());
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
        outputView.printDiscountDdayMessage();
        outputView.printPriceContentMessage(currentCustomer.calcDdayDiscount());
    }

    public void requestWeekDiscountInfo(){
        if(currentCustomer.getIsWeekday()){
            outputView.printDiscountWeekdayMessage();
            outputView.printPriceContentMessage(currentCustomer.calcWeekdayDiscount());
        } else if(!currentCustomer.getIsWeekday()){
            outputView.printDiscountWeekendMessage();
            outputView.printPriceContentMessage(currentCustomer.calcWeekendDiscount());
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
    }

    public void doOrder(){
        createUser();
        requestOrder();
        requestOrderInfo();
        requestTotalPriceInfo();
        requestGiftInfo();
        requestDiscountInfo();
        requestTotalDiscountInfo();
    }
}
