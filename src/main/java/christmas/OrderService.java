package christmas;

import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.ArrayList;
import java.util.List;

public class OrderService {
    private List<User> customers = new ArrayList<>();
    private User currentCustomer;
    Dates dateService = new Dates();
    Discount testDiscount;
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public OrderService(){}

    public void createUser(){
        this.currentCustomer = new User();
    }

    public void requestOrder(){
        // get readline data
        outputView.printWelcomeMessage();
        int reserveDate = inputView.inputDate();
        currentCustomer.reserveDate(reserveDate);

    }

    public void makeOrderItem(String menu, int menuCount){
        Order currentOrderItem = new Order(menu,menuCount);
        currentOrderItem.makeOrderInfo();
    }

    public void doOrder(){
        // Get Order from Console
        createUser();
        requestOrder();
    }
}
