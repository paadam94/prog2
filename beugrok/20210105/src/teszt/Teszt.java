package teszt;

import patogenetika.Baktérium;
import patogenetika.Kórokozó;
import patogenetika.Vírus;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class Teszt {
    public static void main(String[] args) {
        java.util.List<Kórokozó> kórokozók = new LinkedList<>();
        try {
            File file = new File(args[0]);
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                String data = sc.nextLine();
                try {
                    kórokozók.add(Reader.lineToObject(data));
                } catch (IllegalArgumentException e) {
                    System.err.printf("Error: %s\n", e.getMessage());
                }
            }

        } catch (FileNotFoundException e) {
            System.err.printf("Error: %s\n",e.getMessage());
        }
        kórokozók.forEach(System.out::println);
    }
}

class Reader {
    static public Kórokozó lineToObject(String line) throws IllegalArgumentException {
        Scanner sc = new Scanner(line);
        sc.useDelimiter(":");
        if (!sc.hasNext()) {
            throw new IllegalArgumentException(String.format("Invalid format %s", line));
        }
        return switch(sc.next().charAt(0)) {
            case 'V' -> {
                String name = sc.next();
                String nameOfDisease = sc.next();
                java.util.List<String> victims = new LinkedList<>();
                Scanner vsc = new Scanner(sc.next());
                vsc.useDelimiter(",");
                while(vsc.hasNext()) victims.add(vsc.next());
                boolean isCorona = (sc.next().charAt(0) == 'K');
                yield new Vírus(name, nameOfDisease, victims.toArray(new String[0]), isCorona);
            }
            case 'B' -> {
                String name = sc.next();
                String nameOfDisease = sc.next();
                java.util.List<String> victims = new LinkedList<>();
                Scanner vsc = new Scanner(sc.next());
                vsc.useDelimiter(",");
                while(vsc.hasNext()) victims.add(vsc.next());
                yield new Baktérium(name, nameOfDisease, victims.toArray(new String[0]), sc.next());
            }
            default -> throw new IllegalArgumentException(
                    String.format("Csak virusokat es bakteriumokat olvasok be. Talalt: `%s'", (line)));
        };
    }
}