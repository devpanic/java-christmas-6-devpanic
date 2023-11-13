package christmas;

public class Dates {
    int date;

    Dates(int date){
        this.date = date;
    }

    public Days calcDayOfWeek(int inputDate){
        return Days.findDay(inputDate % 7);
    }

    public boolean isSpecialDay(int inputDate){
        Days inputDay = calcDayOfWeek(inputDate);
        if(inputDay == Days.SUNDAY || inputDate == 25){
            return true;
        }
        return false;
    }
}
