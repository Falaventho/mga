import java.util.Scanner;


public class Converter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the distance in meters: ");
        menu();
    }

    private static void menu() {

        boolean running = true;
        Scanner scanner = new Scanner(System.in);
        double meters = scanner.nextDouble();

        while(running) {

            System.out.print("1. Convert to kilometers\n" +
                    "2. Convert to inches\n" +
                    "3. Convert to feet\n" +
                    "4. Quit the program\n\n" +
                    "Enter your choice: ");

            switch(scanner.next()) {
                case "1":
                    showKilometers(meters);
                    break;
                case "2":
                    showInches(meters);
                    break;
                case "3":
                    showFeet(meters);
                    break;
                case "4":
                    System.out.println("Bye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice\n");
                    break;
            }
        }

        scanner.close();
    }

    private static void showKilometers(double meters) {
        System.out.println("The distance in kilometers is " + (meters * 0.001) + " kilometers.\n");
    }

    private static void showInches(double meters) {
        System.out.println("The distance in inches is " + (meters * 39.37) + " inches.\n");
    }

    private static void showFeet(double meters) {
        System.out.println("The distance in feet is " + (meters * 3.281) + " feet.\n");
    }

}
