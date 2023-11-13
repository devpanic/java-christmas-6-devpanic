package christmas;

import christmas.menu.AllMenu;
import christmas.view.ErrorMessages;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Validation {
    public void checkDateDomain(int toCheck){
        if(toCheck > 31 || toCheck < 1){
            throw new IllegalArgumentException(ErrorMessages.INPUT_DATE.getMessage());
        }
    }

    public void checkItemFormat(StringTokenizer toCheck){
        if(toCheck.countTokens() != 2){
            throw new IllegalArgumentException(ErrorMessages.INPUT_ORDER.getMessage());
        }
    }

    public void checkMenuExist(String toCheck){
        if(AllMenu.findAllMenu(toCheck) == AllMenu.NOTHING){
            throw new IllegalArgumentException(ErrorMessages.INPUT_ORDER.getMessage());
        }
    }

    public void checkMenuDuplicate(List<String> nameSet){
        Set<String> set = new HashSet<>(nameSet);

        if(set.size() != nameSet.size()){
            throw new IllegalArgumentException(ErrorMessages.INPUT_ORDER.getMessage());
        }
    }

    public void checkMenuCountPositive(int toCheck){
        if(toCheck <= 0){
            throw new IllegalArgumentException(ErrorMessages.INPUT_ORDER.getMessage());
        }
    }
}
