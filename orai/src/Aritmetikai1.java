import java.util.Scanner;

public class Aritmetikai1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            String op = sc.next();
            int b = sc.nextInt();

            /*
            //  if(op.equals("+"))
            if (Objects.equals(op, "+")) {
                System.out.println(a + b);
            }else if()

             */

            /*
            switch (op){
                case "+":
                    System.out.println(a + b);
                    break;
                case "-":
                    System.out.println(a - b);
                    break;
            }

             */

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
