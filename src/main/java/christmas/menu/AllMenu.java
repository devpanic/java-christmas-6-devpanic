package christmas.menu;

import java.util.Arrays;

public enum AllMenu {
    MUSHROOM_SOUP("양송이수프"),
    TAPAS("타파스"),
    CAESAR_SALAD("시저샐러드"),
    CHOCO_CAKE("초코케이크"),
    ICE_CREAM("아이스크림"),
    ZERO_COKE("제로콜라"),
    RED_WINE("레드와인"),
    CHAMPAGNE("샴페인"),
    T_BONE_STAKE("티본스테이크"),
    BARBECUE("바비큐립"),
    SEA_FOOD_PASTA("해산물파스타"),
    NOTHING("");

    private String menu;

    AllMenu(String menu){
        this.menu = menu;
    }

    public boolean checkWhichMenu(String inputMenu){
        return this.menu.equals(inputMenu);
    }

    public static AllMenu findAllMenu(String inputMenu) {
        return Arrays.stream(AllMenu.values())
                .filter(menu -> menu.checkWhichMenu(inputMenu))
                .findAny()
                .orElse(AllMenu.NOTHING);
    }
}
