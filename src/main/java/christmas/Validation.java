package christmas;

public class Validation {
    public void checkDateDomain(int toCheck){
        if(toCheck > 31 || toCheck < 1){
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }
}
