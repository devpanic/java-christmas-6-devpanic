package christmas;

public class Gift {
    private int totalPurchase;
    private int totalDiscount;

    public Gift(int totalPurchase){
        this.totalPurchase = totalPurchase;
    }

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

    public boolean isGiveSanta(){
        if(totalDiscount >= 20000){
            return true;
        }
        return false;
    }

    public boolean isGiveTree(){
        if(totalDiscount >= 10000){
            return true;
        }
        return false;
    }

    public boolean isGiveStar(){
        if(totalDiscount >= 5000){
            return true;
        }
        return false;
    }

    public String giveBadge(){
        if(isGiveSanta()){
            return "산타";
        } else if (isGiveTree()){
            return "트리";
        } else if (isGiveStar()){
            return "별";
        }
        return "없음";
    }
}
