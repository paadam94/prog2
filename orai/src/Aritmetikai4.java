import java.util.Scanner;

public class Aritmetikai4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            Scanner sc2 = new Scanner(line);

            int a = sc2.nextInt();
            String op = sc2.next();
            int b = sc2.nextInt();

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
