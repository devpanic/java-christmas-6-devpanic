package christmas;

public class Gift {
    private int totalPurchase;
    private int totalDiscount;

    public Gift(int totalPurchase, int totalDiscount){
        this.totalPurchase = totalPurchase;
        this.totalDiscount = totalDiscount;
    }

    public boolean giveChampagne(){
        if(totalPurchase >= 120000){
            return true;
        }
        return false;
    }

    public String giveBadge(){
        if(totalDiscount >= 20000){
            return "별";
        } else if (totalDiscount >= 10000){
            return "트리";
        } else if (totalDiscount >= 5000){
            return "산타";
        }
        return "";
    }
}
