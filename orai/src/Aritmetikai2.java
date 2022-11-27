import java.util.Scanner;

public class Aritmetikai2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int a = sc.nextInt();
            String op = sc.next();
            int b = sc.nextInt();

            System.out.println(switch (op) {
                case "+" -> a + b;
                case "-" -> a - b;
                case "*" -> a * b;
                case "/" -> a / b;
                default -> a % b;
            });
        }
    }
}
