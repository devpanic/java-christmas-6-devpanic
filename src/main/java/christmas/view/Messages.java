package christmas.view;

public enum Messages {
    WELCOME("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.\n"
            + "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"),
    TAKE_ORDER("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)"),
    TOTAL_MENU_INFO("<주문 메뉴>"),
    TOTAL_PRICE_BEFORE("<할인 전 총주문 금액>"),
    GIFT_CHAMPANGE_INFO("<증정 메뉴>"),
    DISCOUNT_INFO("<혜택 내역>"),
    DISCOUNT_DDAY("크리스마스 디데이 할인: -"),
    DISCOUNT_WEEKDAY("평일 할인: -"),
    DISCOUNT_WEEKEND("주말 할인: -"),
    DISCOUNT_SPECIAL("특별 할인: -"),
    DISCOUNT_GIFT("증정 이벤트: -"),
    DISCOUNT_TOTAL_INFO("<총혜택 금액>"),
    GIFT_CHAMPANGE("샴페인 1개"),
    NOTHING("없음");

    private String message;

    Messages(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
