public class JoeStocks {

    public static void main(String[] args) {
        int purchasedShares = 1000;
        double purchasePrice = 32.87;
        double commission = 0.2;

        int soldShares = 1000;
        double sellPrice = 33.92;

        double purchaseTotal = purchasedShares * purchasePrice;
        double purchaseCommission = purchasedShares * purchasePrice * commission;
        double sellTotal = soldShares * sellPrice;
        double sellCommission = soldShares * sellPrice * commission;
        double profit = sellTotal - (sellCommission + purchaseTotal + purchaseCommission);


        System.out.println("Joe paid $" + (purchaseTotal) + " for the stocks.");
        System.out.println("Joe paid a $" + (purchaseCommission) + " commission to his broker for the purchase.");
        System.out.println("Joe sold the stock for $" + (sellTotal) + ".");
        System.out.println("Joe paid a $" + (sellCommission) + " commission to his broker for the sale.");

        if (profit >= 0) {
            System.out.println("Joe made a profit of $" + (profit) + ".");
        } else {
            System.out.println("Joe lost $" + (profit * -1) + ".");
        }
    }

}
