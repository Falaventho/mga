import java.util.Scanner;

public class Grades {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // prompt the user to enter the total number of students
        System.out.print("Enter the number of students: ");
        int num_students = scanner.nextInt();
        int[] scores = new int[num_students];
        int best = 0;

        // prompt the user to enter the number of scores equal to the number of students
        System.out.print("Enter " + num_students + " scores: ");
        for (int i = 0; i < num_students; i++) {
            int x = scanner.nextInt();
            scores[i] = x;
            if (x > best) {
                best = x;
            }
        }

        // display grades for each student
        for (int i = 0; i < num_students; i++) {
            if (scores[i] >= best - 10) {
                System.out.println("Student " + i + " score is " + scores[i] + " and grade is A");
            } else if (scores[i] >= best - 20) {
                System.out.println("Student " + i + " score is " + scores[i] + " and grade is B");
            } else if (scores[i] >= best - 30) {
                System.out.println("Student " + i + " score is " + scores[i] + " and grade is C");
            } else if (scores[i] >= best - 40) {
                System.out.println("Student " + i + " score is " + scores[i] + " and grade is D");
            } else {
                System.out.println("Student " + i + " score is " + scores[i] + " and grade is F");
            }
        }

    }

}
