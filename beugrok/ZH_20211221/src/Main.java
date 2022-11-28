import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File(args[0]);
        Scanner fileRead = new Scanner(file);
        while(fileRead.hasNextLine()) {
            System.out.println(fileRead.nextLine());
        }
    }
}