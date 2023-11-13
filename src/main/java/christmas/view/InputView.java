package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.Order;
import christmas.Validation;
import christmas.menu.AllMenu;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class InputView {
    Validation validator = new Validation();

    public int inputDate(){
        String userInput;
        int reserveDate;
        while(true){
            userInput = Console.readLine();
            try{
                reserveDate = Integer.parseInt(userInput);
                validator.checkDateDomain(reserveDate);
                return reserveDate;
            } catch(NumberFormatException e){
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Order> inputAllOrder(){
        List<String> menuSet = new ArrayList<>();
        List<Order> orderSet = new ArrayList<>();
        Order currentOrder;
        while(true){
            try{
                StringTokenizer orderTokenizer = new StringTokenizer(Console.readLine(), ",");
                while(orderTokenizer.hasMoreTokens()){
                    currentOrder = parseEachItem(orderTokenizer.nextToken());
                    menuSet.add(currentOrder.getMenu());
                    validator.checkMenuDuplicate(menuSet);
                    orderSet.add(currentOrder);
                }
                return orderSet;
            } catch(NumberFormatException e){
                System.out.println(ErrorMessages.INPUT_ORDER.getMessage());
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public Order parseEachItem(String toParse){
        StringTokenizer itemTokenizer = new StringTokenizer(toParse, "-");
        String currentMenu;
        int currentMenuCount;

        validator.checkItemFormat(itemTokenizer);

        currentMenu = itemTokenizer.nextToken();
        validator.checkMenuExist(currentMenu);

        currentMenuCount = Integer.parseInt(itemTokenizer.nextToken());
        validator.checkMenuCountPositive(currentMenuCount);

        Order item = new Order(currentMenu, currentMenuCount);
        return item;
    }
}
