package christmas;

import java.util.Arrays;

public enum Days {
    SUNDAY(3, true, false),
    MONDAY(4, true, false),
    TUESDAY(5, true, false),
    WEDNESDAY(6, true, false),
    TURSDAY(0, true, false),
    FRIDAY(1, false, true),
    SATURDAY(2, false, true),
    NOTHING(-1, false, false);

    private int date;
    private boolean dessertsDiscount;
    private boolean mainDishDiscount;

    Days(int date, boolean dessertsDiscount, boolean mainDishDiscount){
        this.date = date;
        this.dessertsDiscount = dessertsDiscount;
        this.mainDishDiscount = mainDishDiscount;
    }

    public boolean isDessertsDiscount(){
        return this.dessertsDiscount;
    }

    public boolean isMainDishDiscount(){
        return this.mainDishDiscount;
    }

    public boolean checkWhichDay(int date){
        return this.date == date;
    }

    public static Days findDay(int inputDate) {
        return Arrays.stream(Days.values())
                .filter(day -> day.checkWhichDay(inputDate))
                .findAny()
                .orElse(Days.NOTHING);
    }
}
