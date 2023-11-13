package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.Validation;

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
}
