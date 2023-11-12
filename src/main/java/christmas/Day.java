package christmas;

import java.util.Arrays;

public enum Day {
    MONDAY(4),
    TUESDAY(5),
    WEDNESDAY(6),
    TURSDAY(0),
    FRIDAY(1),
    SATURDAY(2),
    SUNDAY(3),
    NOTHING(-1);

    private int date;

    Day(int date){
        this.date = date;
    }

    public boolean checkWhichDay(int date){
        return this.date == date;
    }

    public static Day findDay(int inputDate) {
        return Arrays.stream(Day.values())
                .filter(day -> day.checkWhichDay(inputDate))
                .findAny()
                .orElse(Day.NOTHING);
    }
}
