/****************************************
 * Student Name: Nicholas Gray
 * Date Due: 1 May 2024
 * Date Submitted: 12 April 2024
 * Program Name: MGA Marketplace
 * Program Description: An emulated terminal-based marketplace system that allows users to buy and sell smartphones.
 ****************************************/
import java.io.*;
import java.util.ArrayList;

public class Registry {

    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<Phone> phones = new ArrayList<>();
    private int registrationCount = 0;

    public void loadFromFile(String filename) {
        try {
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);
            SaveFile save = (SaveFile) in.readObject();
            users = save.users;
            phones = save.phones;
            registrationCount = save.registrationCount;
            System.out.println("Marketplace file loaded successfully.");
        } catch (Exception e) {
            System.out.println("Failed to load marketplace file.");
        }
    }

    public void saveToFile(String filename) {

        try {
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);
            SaveFile save = createSave();
            out.writeObject(save);
        } catch (Exception e) {
            System.out.println("An error occurred while saving the marketplace file.");
            e.printStackTrace();
        }
    }

    private SaveFile createSave() {
        SaveFile save = new SaveFile();
        save.users = users;
        save.phones = phones;
        save.registrationCount = registrationCount;
        return save;
    }

    public int getRegistrationNumber() {
        this.registrationCount += 1;
        return this.registrationCount;
    }

    public ArrayList<User> getUsers() {
        return this.users;
    }

    public ArrayList<Phone> getPhones() {
        return this.phones;
    }

    public User getUser(String username) {
        for (User user : users) {
            if (user.username.equals(username)) {
                return user;
            }
        }
        return null;
    }

    public boolean hasUser(String username) {
        for (User user : users) {
            if (user.username.equals(username)) {
                return true;
            }
        }
        return false;
    }

    public Phone[] getPhonesByRegistrationNumber(int[] registrationNumbers) {
        Phone[] result = new Phone[registrationNumbers.length];
        for (int i = 0; i < registrationNumbers.length; i++) {
            for (Phone phone : phones) {
                if (phone.registrationNumber == registrationNumbers[i]) {
                    result[i] = phone;
                }
            }
        }
        return result;
    }

    public Code updatePrice(int registrationNumber, double price) {
        for (Phone phone : phones) {
            if (phone.registrationNumber == registrationNumber) {
                phone.setPrice(price);
                return Code.SUCCESS;
            }
        }
        return Code.FAILURE;
    }

    public void removePhone(int registrationNumber) {
        for (Phone phone : phones) {
            if (phone.registrationNumber == registrationNumber) {
                phones.remove(phone);
                break;
            }
        }
    }

    public void removePhones(int[] registrationNumbers) {
        for (int registrationNumber : registrationNumbers) {
            for (Phone phone : phones) {
                if (phone.registrationNumber == registrationNumber) {
                    phones.remove(phone);
                    break;
                }
            }
        }
    }

    public void removeUser(String username) {
        for (User user : users) {
            if (user.username.equals(username)) {
                users.remove(user);
                break;
            }
        }
    }

    public void addPhone(String model, String manufacturer, double price, String seller) {
        int registrationNumber = getRegistrationNumber();
        Phone phone = new Phone(registrationNumber, model, manufacturer, price, seller);
        phones.add(phone);
    }

    public void addUser(String firstName, String lastName, String telephone, String email, String username, Role role) {
        User user = new User(firstName, lastName, telephone, email, username, role);
        users.add(user);
    }

    public void listUsers() {
        System.out.println("Users:\n");
        for (User user : users) {
            System.out.println(user.username +
                    "\t" + user.firstName + " " + user.lastName +
                    "\t" + user.role +
                    "\t" + user.telephone +
                    "\t" + user.email);
        }
        System.out.println("\n");
    }

    public void listPhones() {
        System.out.println("Phones:");
        System.out.println("#\tModel\tMake\tPrice\tSeller");
        for (Phone phone : phones) {
            System.out.println(phone.registrationNumber +
                    "\t" + phone.model +
                    "\t" + phone.manufacturer +
                    "\t" + phone.price +
                    "\t" + phone.seller);
        }
        System.out.println("\n");
    }

}
