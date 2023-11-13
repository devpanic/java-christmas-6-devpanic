package christmas.view;

public class OutputView {
    public void printWelcomeMessage(){
        System.out.println(Messages.WELCOME.getMessage());
    }

    public void printTakeOrderMessage(){
        System.out.println(Messages.TAKE_ORDER.getMessage());
    }

    public String makeIntegerFormat(int totalPrice){
        String originTotalPrice = "" + totalPrice;
        int i;
        String returnString = "";

        for(i = originTotalPrice.length(); i > 3 ; i -= 3){
            returnString = "," + originTotalPrice.substring(i - 3, i) + returnString;
        }
        returnString = originTotalPrice.substring(0, i) + returnString;

        return returnString;
    }

    public void printTotalPriceTitleMessage(){
        System.out.println(Messages.TOTAL_PRICE_BEFORE.getMessage());
    }

    public void printTotalPriceContentMessage(int totalPrice){
        System.out.println(makeIntegerFormat(totalPrice) + "원");
    }
}
