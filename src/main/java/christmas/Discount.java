package christmas;

public class Discount {
    public int dayDessertDiscount(Days inputDay){
        if(inputDay.isDessertsDiscount()){
            return 2023;
        }
        return 0;
    }

    public int dayMainDishDiscount(Days inputDay){
        if(inputDay.isMainDishDiscount()){
            return 2023;
        }
        return 0;
    }
}
