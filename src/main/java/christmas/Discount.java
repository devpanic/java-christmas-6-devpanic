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

    public int dDayDiscount(int inputDate){
        if(inputDate < 25){
            int dailyDiscount = 900 + inputDate * 100;
            return dailyDiscount;
        }
        return 0;
    }

    public int specialDayDiscount(int inputDate){
        Dates calcDate = new Dates();
        if(calcDate.isSpecialDay(inputDate)){
            return 1000;
        }
        return 0;
    }
}
