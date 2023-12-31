package christmas;

public class Discount {
    private int inputDate;
    private Days inputDay;
    private boolean isWeekday;

    public Discount(int inputDate, Days inputDay){
        this.inputDate = inputDate;
        this.inputDay = inputDay;
    }

    public boolean getIsWeekday(){
        return this.isWeekday;
    }

    public int dayDessertDiscount(){
        if(inputDay.isDessertsDiscount()){
            this.isWeekday = true;
            return 2023;
        }
        return 0;
    }

    public int dayMainDishDiscount(){
        if(inputDay.isMainDishDiscount()){
            this.isWeekday = false;
            return 2023;
        }
        return 0;
    }

    public boolean isBeforeChristmas(){
        if(inputDate <= 25){
            return true;
        }
        return false;
    }

    public int calcDailyDiscount(){
        return inputDate * 100 + 900;
    }

    public int dDayDiscount(){
        if(isBeforeChristmas()){
            int dailyDiscount = calcDailyDiscount();
            return dailyDiscount;
        }
        return 0;
    }

    public int specialDayDiscount(){
        Dates calcDate = new Dates(inputDate);
        if(calcDate.isSpecialDay(inputDate)){
            return 1000;
        }
        return 0;
    }
}
