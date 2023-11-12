package christmas;

public class Dates {
    public Days calcDayOfWeek(int inputDate){
        return Days.findDay(inputDate % 7);
    }
}
