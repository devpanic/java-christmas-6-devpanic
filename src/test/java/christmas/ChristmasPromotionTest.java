package christmas;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ChristmasPromotionTest extends NsTest{
    @ParameterizedTest
    @DisplayName("일자를 입력하면 요일을 가지고 올 수 있는지 확인")
    @CsvSource(value = {"1, FRIDAY", "2, SATURDAY", "3, SUNDAY", "4, MONDAY",
            "5, TUESDAY", "6, WEDNESDAY", "7, TURSDAY", "-1, NOTHING"})
    void calcDayOfWeekTest(int input, Days expected) {
        // given
        Dates testDates = new Dates(input);

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
        Dates testDates = new Dates(input);
        Discount testDiscount = new Discount(input, testDates.calcDayOfWeek(input));

        // when
        int dessertDiscount = testDiscount.dayDessertDiscount();
        int mainDishDiscount = testDiscount.dayMainDishDiscount();

        // then
        assertEquals(expectedDessertDiscount, dessertDiscount);
        assertEquals(expectedMainDishDiscount, mainDishDiscount);
    }

    @ParameterizedTest
    @DisplayName("입력 일자의 최대 할인 폭 계산 테스트")
    @CsvSource(value = {"24, 6323", "1, 3023", "25, 6423"})
    void calcDiscountLimitTest(int input, int expectedDessertDiscount){
        // given
        Dates testDates = new Dates(input);
        Discount testDiscount = new Discount(input, testDates.calcDayOfWeek(input));

        // when
        int dDayDiscount = testDiscount.dDayDiscount();
        int specialDiscount = testDiscount.specialDayDiscount();
        int dessertDiscount = testDiscount.dayDessertDiscount();
        int mainDishDiscount = testDiscount.dayMainDishDiscount();

        int totalDiscount = dDayDiscount + specialDiscount + dessertDiscount + mainDishDiscount;

        // then
        assertEquals(expectedDessertDiscount, totalDiscount);
    }

    @ParameterizedTest
    @DisplayName("일자별 디저트, 메인메뉴 주문 테스트")
    @CsvSource(value = {"3, 티본스테이크, 2, 110000", "3, 바비큐립, 1, 54000"
            ,"1, 초코케이크, 1, 15000", "1, 제로콜라, 1, 3000"
            ,"3, 제로콜라, 1, 3000", "1, 양송이수프, 1, 6000", "3, 양송이수프, 1, 6000"})
    void orderCategoryTest(int inputDate, String menu, int menuCount, int expectedPerOrderPrice){
        // given
        Order testOrder = new Order(menu, menuCount);
        Dates testDates = new Dates(inputDate);
        Discount testDiscount = new Discount(inputDate, testDates.calcDayOfWeek(inputDate));

        // when
        int dessertDiscount = testDiscount.dayDessertDiscount();
        int mainDishDiscount = testDiscount.dayMainDishDiscount();
        testOrder.makeOrderInfo();
        testOrder.makeDiscountInfo(dessertDiscount, mainDishDiscount);

        // then
        assertEquals(expectedPerOrderPrice,testOrder.getPerOrderPrice());
    }

    @Test
    @DisplayName("음료만 주문 시 예외 테스트")
    void checkOnlyDrinkTest(){
        assertSimpleTest(() -> {
            runException("3", "제로콜라-1,샴페인-2,레드와인-3");
            assertThat(output()).contains("[ERROR] 음료만 주문할 수 없습니다.");
        });
    }

    @Test
    @DisplayName("평일 할인 적용 여부 테스트")
    void weekdayDessertTest(){
        assertSimpleTest(() -> {
            run("4", "티본스테이크-1,초코케이크-2,제로콜라-1");
            assertThat(output()).contains(
                    "크리스마스 디데이 할인: -1,300원",
                    "평일 할인: -4,046원"
            );
        });
    }

    @Test
    @DisplayName("주말 할인 적용 여부 테스트")
    void weekendMainDishTest(){
        assertSimpleTest(() -> {
            run("1", "티본스테이크-1,초코케이크-2,제로콜라-1");
            assertThat(output()).contains(
                    "크리스마스 디데이 할인: -1,000원",
                    "주말 할인: -2,023원"
            );
        });
    }

    @Test
    @DisplayName("특별 할인 적용 여부 테스트")
    void specialDiscountTest(){
        assertSimpleTest(() -> {
            run("3", "티본스테이크-1,초코케이크-2,제로콜라-1");
            assertThat(output()).contains(
                    "크리스마스 디데이 할인: -1,200원",
                    "평일 할인: -4,046원",
                    "특별 할인: -1,000원"
            );
        });
    }

    @Test
    @DisplayName("샴페인 증정 여부 및 총혜택 금액 반영 테스트")
    void giftChampangeTest(){
        assertSimpleTest(() -> {
            run("3", "티본스테이크-2,초코케이크-2,제로콜라-1");
            assertThat(output()).contains(
                    "샴페인 1개",
                    "크리스마스 디데이 할인: -1,200원",
                    "평일 할인: -4,046원",
                    "특별 할인: -1,000원",
                    "증정 이벤트: -25,000원"
            );
        });
    }

    @Test
    @DisplayName("크리스마스 이후 디데이 이벤트 종료 테스트")
    void afterChristmasTest(){
        assertSimpleTest(() -> {
            run("26", "티본스테이크-2,초코케이크-2,제로콜라-1");
            assertThat(output()).contains(
                    "샴페인 1개",
                    "평일 할인: -4,046원",
                    "증정 이벤트: -25,000원",
                    "113,954원"
            );
        });
    }

    @Test
    @DisplayName("산타 배지 출력 테스트")
    void badgeSantaTest(){
        assertSimpleTest(() -> {
            run("26", "티본스테이크-2,초코케이크-2,제로콜라-1");
            assertThat(output()).contains("산타");
        });
    }

    @Test
    @DisplayName("트리 배지 출력 테스트")
    void badgeTreeTest(){
        assertSimpleTest(() -> {
            run("3", "초코케이크-4");
            assertThat(output()).contains("트리");
        });
    }

    @Test
    @DisplayName("별 배지 출력 테스트")
    void badgeStarTest(){
        assertSimpleTest(() -> {
            run("4", "초코케이크-3");
            assertThat(output()).contains("별");
        });
    }

    @Test
    @DisplayName("배지 없음 출력 테스트")
    void badgeNothingTest(){
        assertSimpleTest(() -> {
            run("4", "초코케이크-1");
            assertThat(output()).contains("<12월 이벤트 배지>\r\n없음");
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
