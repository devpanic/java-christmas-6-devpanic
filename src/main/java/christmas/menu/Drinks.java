package christmas.menu;

import java.util.Arrays;

public enum Drinks {
    ZERO_COKE("제로콜라(3,000)", "제로콜라", 3000),
    RED_WINE("레드와인(60,000)", "레드와인", 60000),
    CHAMPAGNE("샴페인(25,000)", "샴페인", 25000),
    NOTHING("","",0);

    private String consoleMessage;
    private String menu;
    private int price;

    Drinks(String consoleMessage, String menu, int price){
        this.consoleMessage = consoleMessage;
        this.menu = menu;
        this.price = price;
    }

    public boolean checkWhichDrink(String inputMenu){
        return this.menu == menu;
    }

    public static Drinks findDrink(String inputDrink) {
        return Arrays.stream(Drinks.values())
                .filter(drink -> drink.checkWhichDrink(inputDrink))
                .findAny()
                .orElse(Drinks.NOTHING);
    }
}
