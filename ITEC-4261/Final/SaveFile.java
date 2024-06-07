/****************************************
 * Student Name: Nicholas Gray
 * Date Due: 1 May 2024
 * Date Submitted: 12 April 2024
 * Program Name: MGA Marketplace
 * Program Description: An emulated terminal-based marketplace system that allows users to buy and sell smartphones.
 ****************************************/
import java.io.Serializable;
import java.util.ArrayList;

public class SaveFile implements Serializable {

    public ArrayList<User> users;
    public ArrayList<Phone> phones;
    public int registrationCount;

}
