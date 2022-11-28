package teszt;

import kutatóintézet.Kutatólabor;
import patogenetika.Baktérium;
import patogenetika.Kórokozó;
import patogenetika.KórokozóTár;
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

        // Part 7.
        Kutatólabor kutatólabor;
        if (args.length < 2) {
            kutatólabor = new Kutatólabor("DE Kutatólabor");
        } else {
            kutatólabor = new Kutatólabor(args[1]);
        }

        kutatólabor.hozzáad(kórokozók);

        // reading gazdatest
        Scanner inputScanner = new Scanner(System.in);
        String input = inputScanner.nextLine();

        // filter and print
        kutatólabor.koronavírusokGazdában(input).forEach(System.out::println);

        // Part 8.
        input = inputScanner.nextLine();
        KórokozóTár[] tarak = new KórokozóTár[] { kutatólabor };
        registerDisease(tarak, input);
        for(KórokozóTár tar: tarak) {
            System.out.println(tar);
        }
    }

    static void registerDisease(KórokozóTár[] arr, String nameOfDisease) {
        for(KórokozóTár tar: arr) {
            if (!tar.betegségek().contains(nameOfDisease)) {
                Baktérium[] b =
                        new Baktérium[]{
                                new Baktérium("új baci",
                                        nameOfDisease,
                                        new String[]{},
                                        "új törzs")
                        };
                tar.hozzáad(b);
            }
        }
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