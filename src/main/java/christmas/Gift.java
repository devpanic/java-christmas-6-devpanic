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

    public void giveBadge(User user){
        user.setBadge("-");

        if(isGiveSanta()){
            user.setBadge("산타");
        } else if (isGiveTree()){
            user.setBadge("트리");
        } else if (isGiveStar()){
            user.setBadge("별");
        }
    }
}
