/****************************************
 * Student Name: Nicholas Gray
 * Date Due: 1 May 2024
 * Date Submitted: 12 April 2024
 * Program Name: MGA Marketplace
 * Program Description: An emulated terminal-based marketplace system that allows users to buy and sell smartphones.
 ****************************************/
import java.io.Serializable;

public class User implements Serializable {

    public String firstName;
    public String lastName;
    public String telephone;
    public String email;
    public final String username;
    public final Role role;


    User(String firstName, String lastName, String telephone, String email, String username, Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephone = telephone;
        this.email = email;
        this.username = username;
        this.role = role;
    }

}
