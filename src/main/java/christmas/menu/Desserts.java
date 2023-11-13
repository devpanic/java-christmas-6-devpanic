package christmas.menu;

import java.util.Arrays;

public enum Desserts {
    CHOCO_CAKE("초코케이크(15,000)", "초코케이크", 15000),
    ICE_CREAM("아이스크림(5,000)", "아이스크림", 5000),
    NOTHING("","",0);

    private String consoleMessage;
    private String menu;
    private int price;

    Desserts(String consoleMessage, String menu, int price){
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

    public boolean checkWhichDessert(String inputMenu){
        return this.menu.equals(inputMenu);
    }

    public static Desserts findDessert(String inputDessert) {
        return Arrays.stream(Desserts.values())
                .filter(dessert -> dessert.checkWhichDessert(inputDessert))
                .findAny()
                .orElse(Desserts.NOTHING);
    }
}
