public class Customer extends Person{

    private int customerNum;
    private boolean onMailingList;

    Customer(String name, String address, String telephone, int customerNum, boolean onMailingList) {
        super(name, address, telephone);
        this.customerNum = customerNum;
        this.onMailingList = onMailingList;
    }

    public int getCustomerNum() {
        return this.customerNum;
    }

    public boolean isOnMailingList() {
        return this.onMailingList;
    }

    public void setCustomerNum(int customerNum) {
        this.customerNum = customerNum;
    }

    public void setOnMailingList(boolean onMailingList) {
        this.onMailingList = onMailingList;
    }


}
