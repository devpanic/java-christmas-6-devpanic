package christmas;

public class Dates {
    public Day calcDayOfWeek(int inputDate){
        return Day.findDay(inputDate % 7);
    }
}
