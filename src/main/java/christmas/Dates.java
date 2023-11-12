package christmas;

public class Dates {
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
