package christmas.view;

public enum ErrorMessages {
    INPUT_DATE("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    INPUT_ORDER("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."),
    INPUT_ONLY_DRINK("[ERROR] 음료만 주문할 수 없습니다.");

    private String message;

    ErrorMessages(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
