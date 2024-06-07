public class PreferredCustomer extends Customer{

    private double purchaseTotal = 0;
    private int discount = 0;

    PreferredCustomer(String name, String address, String telephone, int customerNum, boolean onMailingList) {
        super(name, address, telephone, customerNum, onMailingList);
    }

    public void addPurchaseAmount(double purchaseAmount) {
        this.purchaseTotal += purchaseAmount;
        this.updateDiscount();
    }

    public void addPurchaseAmount(int purchaseAmount) {
        this.purchaseTotal += purchaseAmount;
        this.updateDiscount();
    }

    public double getPurchaseTotal() {
        return this.purchaseTotal;
    }

    public double getDiscount() {
        return this.discount;
    }

    private void updateDiscount() {
        if (this.purchaseTotal >= 2000.0) {
            this.discount = 10;
        } else if (this.purchaseTotal >= 1500.0) {
            this.discount = 7;
        } else if (this.purchaseTotal >= 1000.0) {
            this.discount = 6;
        } else if (this.purchaseTotal >= 500) {
            this.discount = 5;
        }
    }

}
