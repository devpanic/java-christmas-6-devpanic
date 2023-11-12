package christmas;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class ApplicationTest extends NsTest {
    private static final String LINE_SEPARATOR = System.lineSeparator();

    @Test
    void 모든_타이틀_출력() {
        assertSimpleTest(() -> {
            run("3", "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
            assertThat(output()).contains(
                "<주문 메뉴>",
                "<할인 전 총주문 금액>",
                "<증정 메뉴>",
                "<혜택 내역>",
                "<총혜택 금액>",
                "<할인 후 예상 결제 금액>",
                "<12월 이벤트 배지>"
            );
        });
    }

    @Test
    void 혜택_내역_없음_출력() {
        assertSimpleTest(() -> {
            run("26", "타파스-1,제로콜라-1");
            assertThat(output()).contains("<혜택 내역>" + LINE_SEPARATOR + "없음");
        });
    }

    @Test
    void 날짜_예외_테스트() {
        assertSimpleTest(() -> {
            runException("a");
            assertThat(output()).contains("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        });
    }

    @Test
    void 주문_예외_테스트() {
        assertSimpleTest(() -> {
            runException("3", "제로콜라-a");
            assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        });
    }

    @ParameterizedTest
    @DisplayName("일자를 입력하면 요일을 가지고 올 수 있는지 확인")
    @CsvSource(value = {"1, FRIDAY", "2, SATURDAY", "3, SUNDAY", "4, MONDAY",
                        "5, TUESDAY", "6, WEDNESDAY", "7, TURSDAY", "-1, NOTHING"})
    void calcDayOfWeekTest(int input, Days expected) {
        // given
        Dates testDates = new Dates();

        // when
        Days currentDay = testDates.calcDayOfWeek(input);

        // then
        assertEquals(expected,currentDay);
    }

    @ParameterizedTest
    @DisplayName("요일별 할인 정보 제공 테스트")
    @CsvSource(value = {"1, 0, 2023", "2, 0, 2023", "3, 2023, 0", "4, 2023, 0",
            "5, 2023, 0", "6, 2023, 0", "7, 2023, 0", "-1, 0, 0"})
    void dayDiscountTest(int input, int expectedDessertDiscount, int expectedMainDishDiscount){
        // given
        Discount testDiscount = new Discount();
        Dates testDates = new Dates();

        // when
        int dessertDiscount = testDiscount.dayDessertDiscount(testDates.calcDayOfWeek(input));
        int mainDishDiscount = testDiscount.dayMainDishDiscount(testDates.calcDayOfWeek(input));

        // then
        assertEquals(expectedDessertDiscount, dessertDiscount);
        assertEquals(expectedMainDishDiscount, mainDishDiscount);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
