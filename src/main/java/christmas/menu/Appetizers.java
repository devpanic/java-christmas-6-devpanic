package christmas.menu;

import java.util.Arrays;

public enum Appetizers {
    MUSHROOM_SOUP("양송이수프(6,000)", "양송이수프", 6000),
    TAPAS("타파스(5,500)", "타파스", 5500),
    CAESAR_SALAD("시저샐러드(8,000)", "시저샐러드", 8000),
    NOTHING("","",0);

    private String consoleMessage;
    private String menu;
    private int price;

    Appetizers(String consoleMessage, String menu, int price){
        this.consoleMessage = consoleMessage;
        this.menu = menu;
        this.price = price;
    }

    public boolean checkWhichAppetizer(String inputMenu){
        return this.menu == menu;
    }

    public static Appetizers findAppetizer(String inputAppetizer) {
        return Arrays.stream(Appetizers.values())
                .filter(appetizer -> appetizer.checkWhichAppetizer(inputAppetizer))
                .findAny()
                .orElse(Appetizers.NOTHING);
    }
}
