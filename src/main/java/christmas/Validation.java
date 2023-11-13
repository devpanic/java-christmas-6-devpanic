package christmas;

import christmas.view.ErrorMessages;

public class Validation {
    public void checkDateDomain(int toCheck){
        if(toCheck > 31 || toCheck < 1){
            throw new IllegalArgumentException(ErrorMessages.INPUT_DATE.getMessage());
        }
    }
}
