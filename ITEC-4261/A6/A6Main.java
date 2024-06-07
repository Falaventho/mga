import java.util.Scanner;

public class A6Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a name: ");
        String name = scanner.nextLine();
        System.out.print("Enter an address: ");
        String address = scanner.nextLine();
        System.out.print("Enter a telephone number: ");
        String telephone = scanner.nextLine();
        System.out.print("Enter customer number: ");
        int customerNumber = scanner.nextInt();
        System.out.print("Enter if the customer is on the mailing list (1 for yes, 0 for no): ");
        boolean onMailingList = scanner.nextInt() == 1;

        PreferredCustomer newCustomer = new PreferredCustomer(name, address, telephone, customerNumber, onMailingList);

        System.out.println("\n\nYou have created a customer with" +
                "\nName: " + newCustomer.getName() +
                "\nAddress: " + newCustomer.getAddress() +
                "\nTel Number: " + newCustomer.getTelephone() +
                "\nCustomer Number: " + newCustomer.getCustomerNum() +
                "\nWho is " + (newCustomer.isOnMailingList() ? "" : "not ") + "on the mailing list.");

        // part 1 above
        // part 2 below

        while (true) {
            System.out.print("\n\nEnter customer purchase value (0 to exit): ");
            double purchase = scanner.nextDouble();
            if (purchase == 0.0) {break;}
            newCustomer.addPurchaseAmount(purchase);
            System.out.print("This customer has a total of $" + newCustomer.getPurchaseTotal() + " in purchases and a discount percentage of " + newCustomer.getDiscount() + "%.");

        }


    }

}
