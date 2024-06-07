import java.util.Scanner;
//import MonthDays
//import Temperature
// uncomment above if classes are not in default package.

public class A5Main {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("0 - MonthDays\n1 - Temperature\n2 - Exit\nSelection: ");
            int selection = scanner.nextInt();

            if (selection == 0) {
                int month;
                int year;

                System.out.print("Enter a month (1-12): ");
                month = scanner.nextInt();
                System.out.print("Enter a year: ");
                year = scanner.nextInt();

                MonthDays userMonthDay = new MonthDays(month, year);

                System.out.println(userMonthDay.numberOfDays() + " days\n\nPress enter to continue.");
                scanner.nextLine(); //clearing buffered newline from nextInt
                scanner.nextLine();

            } else if (selection == 1) {
                System.out.print("Enter a temperature in F: ");
                Temperature userTemp = new Temperature(scanner.nextInt());
                System.out.println("\nAt " + userTemp.getTemp() + " degrees F:\n\n" +
                        "Ethyl is " + (userTemp.isEthylFreezing() ? "" : "not ") + "freezing.\n" +
                        "Ethyl is " + (userTemp.isEthylBoiling() ? "" : "not ") + "boiling.\n\n" +
                        "Oxygen is " + (userTemp.isOxygenFreezing() ? "" : "not ") + "freezing.\n" +
                        "Oxygen is " + (userTemp.isOxygenBoiling() ? "" : "not ") + "boiling.\n\n" +
                        "Water is " + (userTemp.isWaterFreezing() ? "" : "not ") + "freezing.\n" +
                        "Water is " + (userTemp.isWaterBoiling() ? "" : "not ") + "boiling.\n\n" +
                        "Press enter to continue.");
                scanner.nextLine(); // clears the buffered newline from nextInt()
                scanner.nextLine();
                System.out.println("\n\n");
            } else if (selection == 2) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Unrecognized selection " + selection + "\nPress enter to continue.");
                scanner.next();
                System.out.println("\n\n");
            }
        }





    }

}
