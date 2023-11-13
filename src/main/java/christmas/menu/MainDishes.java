package christmas.menu;

import java.util.Arrays;

public enum MainDishes {
    T_BONE_STAKE("티본스테이크(55,000)", "티본스테이크", 55000),
    BARBECUE("바비큐립(54,000)", "바비큐립", 54000),
    SEA_FOOD_PASTA("해산물파스타(35,000)", "해산물파스타", 35000),
    NOTHING("","",0);

    private String consoleMessage;
    private String menu;
    private int price;

    MainDishes(String consoleMessage, String menu, int price){
        this.consoleMessage = consoleMessage;
        this.menu = menu;
        this.price = price;
    }

    public String getConsoleMessage(){
        return consoleMessage;
    }

    public String getMenu(){
        return menu;
    }

    public int getPrice(){
        return price;
    }

    public boolean checkWhichMainDish(String inputMenu){
        return this.menu.equals(inputMenu);
    }

    public static MainDishes findMainDish(String inputMainDish) {
        return Arrays.stream(MainDishes.values())
                .filter(mainDish -> mainDish.checkWhichMainDish(inputMainDish))
                .findFirst()
                .orElse(MainDishes.NOTHING);
    }
}
