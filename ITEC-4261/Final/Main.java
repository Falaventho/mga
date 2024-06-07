/****************************************
 * Student Name: Nicholas Gray
 * Date Due: 1 May 2024
 * Date Submitted: 12 April 2024
 * Program Name: MGA Marketplace
 * Program Description: An emulated terminal-based marketplace system that allows users to buy and sell smartphones.
 ****************************************/


import java.util.Scanner;

public class Main {

    static final String REGFILE = "marketplace.dat";

    static Scanner scanner = new Scanner(System.in);
    static Registry registry = new Registry();
    static User currentUser;

    private static void accessLoop() {
        boolean running = true;
        boolean loggedIn = loginMenu() == Code.SUCCESS;
        while (running) {
            if (loggedIn) {
                mainMenu();
            } else {
                loggedIn = login() == Code.SUCCESS;
            }
        }
    }

    private static Code loginMenu() {
        boolean loggedIn = false;

        while (!loggedIn) {
            System.out.println("Welcome to the MGA Marketplace!\n\n1. Login\n2. Register\n3. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    loggedIn = login() == Code.SUCCESS;
                    break;
                case 2:
                    loggedIn = register() == Code.SUCCESS;
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    exit();
                    break;
                default:
                    System.out.println("Invalid choice, exiting.");
                    exit();
                    break;
            }
        }
        return Code.SUCCESS;
    }

    private static Code login() {
        System.out.println("Enter your username: ");
        String username = scanner.nextLine();

        if (username.equals("admin")) {
            currentUser = new User("admin", "admin", "admin", "admin", "admin", Role.ADMIN);
            System.out.println("Welcome, admin!");
            return Code.SUCCESS;
        }

        if (registry.hasUser(username)) {
            currentUser = registry.getUser(username);
            System.out.println("Welcome, " + currentUser.firstName + "!");
            return Code.SUCCESS;
        } else {
            System.out.println("User not found.");
            return Code.FAILURE;
        }
    }

    private static void mainMenu() {

        switch (currentUser.role) {
            case SELLER:
                sellerMenu();
                break;
            case BUYER:
                buyerMenu();
                break;
            case ADMIN:
                adminMenu();
                break;
            default:
                System.out.println("Invalid role, exiting.");
                break;
        }
    }

    private static void sellerMenu() {
        while (true) {
            System.out.println("1. Add Phone\n2. Update Phone\n3. Remove Phone\n4. List Phones\n5. List Users\n6. Logout\n");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    addPhone();
                    break;
                case 2:
                    updatePhone();
                    break;
                case 3:
                    removePhone();
                    break;
                case 4:
                    registry.listPhones();
                    break;
                case 5:
                    registry.listUsers();
                    break;
                case 6:
                    System.out.println("Goodbye!");
                    exit();
                    break;
                default:
                    System.out.println("Invalid choice, exiting.");
                    exit();
                    break;
            }
        }

    }

    private static void buyerMenu() {

        while (true) {
            System.out.println("1. List Phones\n2. Buy Phones\n3. List Users\n4. Logout\n");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    registry.listPhones();
                    break;
                case 2:
                    buyPhones();
                    break;
                case 3:
                    registry.listUsers();
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    exit();
                    break;
                default:
                    System.out.println("Invalid choice, exiting.");
                    exit();
                    break;
            }
        }


    }

    private static void adminMenu() {

        while (true) {
            System.out.println("1. List Phones\n2. List Users\n3. Remove Listing\n4. Remove User\n5. Logout\n");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    registry.listPhones();
                    break;
                case 2:
                    registry.listUsers();
                    break;
                case 3:
                    removePhone();
                    break;
                case 4:
                    System.out.println("Enter the username of the user you would like to remove:");
                    String username = scanner.nextLine();
                    registry.removeUser(username);
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    exit();
                    break;
                default:
                    System.out.println("Invalid choice " + choice + ".");
                    break;
            }
        }
    }

    private static void buyPhones() {
        registry.listPhones();
        System.out.println("How many phones would you like to buy?");
        int count = scanner.nextInt();
        scanner.nextLine();
        int[] registrationNumbers = new int[count];
        System.out.println("Enter the registration numbers of the phones you would like to buy. Separate each number with a space:");
        String[] numbers = scanner.nextLine().split(" ");
        for (int i = 0; i < count; i++) {
            registrationNumbers[i] = Integer.parseInt(numbers[i]);
        }
        System.out.println("\n\nUsername: " +
                currentUser.username + ",\tRole: Buyer\tName: " + currentUser.firstName + " " + currentUser.lastName +
                "\nThe smartphones to purchase are as below:" +
                "\n\nListing Number\t\tModel\t\tManufacturer\t\tPrice\tSeller\n");
        for (Phone phone : registry.getPhonesByRegistrationNumber(registrationNumbers)) {
            System.out.println(phone.registrationNumber +
                    "\t" + phone.model +
                    "\t" + phone.manufacturer +
                    "\t" + phone.price +
                    "\t" + phone.seller);
        }

        System.out.println("Would you like to proceed with the purchase? (Y/N)");
        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("Y")) {
            registry.removePhones(registrationNumbers);
            System.out.println("Purchase successful.");
        } else {
            System.out.println("Purchase cancelled.");
        }
    }

    private static void updatePhone() {
        registry.listPhones();
        System.out.println("Enter the registration number of the phone you would like to update:");
        int registrationNumber = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the new price of the phone:");
        double price = scanner.nextDouble();
        scanner.nextLine();
        System.out.println(registry.updatePrice(registrationNumber, price) == Code.SUCCESS ? "Update successful." : "Phone not found.");
    }

    private static void removePhone() {
        registry.listPhones();
        System.out.println("Enter the registration number of the phone you would like to remove:");
        int registrationNumber = scanner.nextInt();
        scanner.nextLine();
        Phone[] phones = registry.getPhonesByRegistrationNumber(new int[]{registrationNumber});
        if (phones.length == 0) {
            System.out.println("Phone not found.");
        } else if (phones[0].seller.equals(currentUser.username) || currentUser.role == Role.ADMIN) {
            registry.removePhone(registrationNumber);
            System.out.println("Phone removed.");
        } else {
            System.out.println("You do not have permission to remove this phone listing.");
        }
    }


    private static void addPhone() {
        System.out.println("Enter the model of the phone:");
        String model = scanner.nextLine();
        System.out.println("Enter the manufacturer of the phone:");
        String manufacturer = scanner.nextLine();
        System.out.println("Enter the price of the phone:");
        double price = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Is the information above correct? (Y/N)");
        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("Y")) {
            registry.addPhone(model, manufacturer, price, currentUser.username);}
        else {
            System.out.println("Phone registration cancelled.");
        }
    }



    private static Code register() {
        boolean registered = false;
        while(!registered) {
            System.out.println("Enter your desired username:");
            String username = scanner.nextLine();
            if (registry.hasUser(username)) {
                System.out.println("Username already exists.");
            } else {
                System.out.println("Enter your first name:");
                String firstName = scanner.nextLine();
                System.out.println("Enter your last name:");
                String lastName = scanner.nextLine();
                System.out.println("Enter your telephone number:");
                String telephone = scanner.nextLine();
                System.out.println("Enter your email address:");
                String email = scanner.nextLine();
                System.out.println("Choose your role:\n1. Buyer\n2. Seller");
                int choice = scanner.nextInt();
                scanner.nextLine();
                Role role = choice == 1 ? Role.BUYER : Role.SELLER;
                System.out.println("Is the information above correct? (Y/N)");
                String confirm = scanner.nextLine();
                if (confirm.equalsIgnoreCase("Y")) {
                    registry.addUser(firstName, lastName, telephone, email, username, role);
                    currentUser = registry.getUser(username);
                    System.out.println("Registration successful.");
                    registered = true;
                    return Code.SUCCESS;
                } else {
                    System.out.println("Registration cancelled.");
                }
            }
        }
        return Code.FAILURE;
    }

    private static void exit() {
        registry.saveToFile(REGFILE);
        System.exit(0);
    }


    public static void main(String[] args) {

        // Attempt to load the registry from file
        registry.loadFromFile(REGFILE);

        // Main Loop
        accessLoop();

        // Exit and Save
        exit();

    }

}