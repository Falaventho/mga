/****************************************
 * Student Name: Nicholas Gray
 * Date Due: 1 May 2024
 * Date Submitted: 12 April 2024
 * Program Name: MGA Marketplace
 * Program Description: An emulated terminal-based marketplace system that allows users to buy and sell smartphones.
 ****************************************/
import java.io.Serializable;

public class Phone implements Serializable {

    public final int registrationNumber;
    public final String model;
    public final String manufacturer;
    public double price;
    public final String seller;


    Phone(int registrationNumber, String model, String manufacturer, double price, String seller) {
        this.registrationNumber = registrationNumber;
        this.model = model;
        this.manufacturer = manufacturer;
        this.price = price;
        this.seller = seller;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
