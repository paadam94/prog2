import java.util.Scanner;

public class Aritmetikai3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] tokens = line.split(" ");

            int a = Integer.parseInt(tokens[0]);
            String op = tokens[1];
            int b = Integer.parseInt(tokens[2]);

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
