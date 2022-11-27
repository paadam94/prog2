import patogenetika.Baktérium;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        try {
            File file = new File(args[0]);
            System.out.println(file.getAbsolutePath());
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String data = sc.nextLine();
                System.out.println(data);
            }
        } catch (FileNotFoundException e) {
            System.err.printf("Error during opening: %s\n",e.getMessage());
        }
    }
}