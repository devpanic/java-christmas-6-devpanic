package christmas;

import christmas.menu.Appetizers;
import christmas.menu.Desserts;
import christmas.menu.Drinks;
import christmas.menu.MainDishes;

public class Order {
    private String menu;
    private String menuCategory;
    private Enum menuInfo;
    private int menuCount;
    private int perPrice;
    private int perOrderPrice;
    private int perOrderDiscount;
    private int perDiscount;

    public Order(String menu, int menuCount){
        this.menu = menu;
        this.menuCount = menuCount;
        this.perDiscount = 0;
    }

    public String getMenu(){
        return menu;
    }

    public String getMenuCategory(){
        return menuCategory;
    }

    public int getMenuCount(){
        return menuCount;
    }

    public int getPerOrderPrice(){
        return perOrderPrice;
    }

    public int getPerOrderDiscount(){
        return perOrderDiscount;
    }

    public void isAppetizer(){
        Appetizers currentMenu = Appetizers.findAppetizer(menu);

        if(currentMenu != Appetizers.NOTHING){
            this.menuInfo = currentMenu;
            this.perPrice = currentMenu.getPrice();
            this.menuCategory = this.menuInfo.getDeclaringClass().getSimpleName();
        }
    }

    public void isDesserts(){
        Desserts currentMenu = Desserts.findDessert(menu);

        if(currentMenu != Desserts.NOTHING){
            this.menuInfo = currentMenu;
            this.perPrice = currentMenu.getPrice();
            this.menuCategory = this.menuInfo.getDeclaringClass().getSimpleName();
        }
    }

    public void isDrinks(){
        Drinks currentMenu = Drinks.findDrink(menu);

        if(currentMenu != Drinks.NOTHING){
            this.menuInfo = currentMenu;
            this.perPrice = currentMenu.getPrice();
            this.menuCategory = this.menuInfo.getDeclaringClass().getSimpleName();
        }
    }

    public void isMainDishes(){
        MainDishes currentMenu = MainDishes.findMainDish(menu);

        if(currentMenu != MainDishes.NOTHING){
            this.menuInfo = currentMenu;
            this.perPrice = currentMenu.getPrice();
            this.menuCategory = this.menuInfo.getDeclaringClass().getSimpleName();
        }
    }

    public void makeDiscountInfo(int dessertDiscount, int mainDishDiscount){
        if(menuCategory.equals("Desserts")){
            this.perDiscount = dessertDiscount;
        } else if(menuCategory.equals("MainDishes")){
            this.perDiscount = mainDishDiscount;
        }
        this.perOrderPrice = perPrice * menuCount;
        this.perOrderDiscount = perDiscount * menuCount;
    }

    public void makeOrderInfo(){
        isAppetizer();
        isDesserts();
        isDrinks();
        isMainDishes();
    }
}
