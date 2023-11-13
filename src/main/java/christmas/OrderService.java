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
        outputView.printTotalPriceContentMessage(currentCustomer.calcOrderVanillaPrice());
        outputView.printSpace();
    }

    public void doOrder(){
        createUser();
        requestOrder();
        requestOrderInfo();
        requestTotalPriceInfo();
    }
}
