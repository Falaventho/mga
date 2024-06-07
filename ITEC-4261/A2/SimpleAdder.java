import java.util.Scanner;

public class SimpleAdder {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a list of numbers seperated by comma: ");
        String input = scanner.nextLine();

        try {
            String[] numbers = input.split(",");
            int sum = 0;
            for (String number : numbers) {
                sum += Integer.parseInt(number);
            }
            System.out.println("The total of the numbers is " + sum + ".");
        } catch(Exception e) {
            System.out.println("Invalid input");
            return;
        }

    }
}
