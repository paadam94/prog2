package drink;

import java.util.Arrays;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Drink[] drinks = new Drink[20];
        int counter = 0;
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] tokens = line.split(";");
            if (tokens.length == 3) {
                drinks[counter] = new Drink(
                        tokens[0],
                        tokens[1],
                        Integer.parseInt(tokens[2])
                );
            } else {
                drinks[counter] = new AlcoholicDrink(
                        tokens[0],
                        tokens[1],
                        Integer.parseInt(tokens[2]),
                        Double.parseDouble(tokens[3])
                );
            }

            counter++;
        }

        Arrays.sort(drinks, 0, counter);
        for (int i = 0; i < counter; i++) {
            System.out.println(drinks[i]);
        }
    }
}
