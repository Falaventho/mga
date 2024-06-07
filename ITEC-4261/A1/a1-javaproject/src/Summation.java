import static java.lang.Math.sqrt;

public class Summation {

    public static void main(String[] args) {
        double sum = 0.0;
        int target = 625;
        for (int i = 1; i < target; i++) {
            sum += 1 / (sqrt(i) + sqrt(i + 1));
        }
        System.out.println("The sum is " + sum);
    }

}
