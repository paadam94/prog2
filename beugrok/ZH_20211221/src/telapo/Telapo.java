package telapo;

import mikulas.Ajandek;
import mikulas.AjandekCsomag;
import mikulas.GyerekJatek;
import mikulas.Puttony;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class Telapo {
    public static void main(String[] args) {
        TreeSet<Ajandek> ajadekok = new TreeSet<>();
        try {
            File file = new File(args[0]);
            Scanner fileRead = new Scanner(file);
            while (fileRead.hasNextLine()) {
                Scanner tokenizer = new Scanner(fileRead.nextLine());
                tokenizer.useDelimiter(";");
                String name = tokenizer.next();
                String floatStr = tokenizer.next();
                // convert , separator to .
                float tomeg = Float.parseFloat(floatStr.replace(',','.'));
                int price = tokenizer.nextInt();
                if(tokenizer.hasNext()) {
                    ajadekok.add(new GyerekJatek(name, tomeg, price, tokenizer.nextLong()));
                } else {
                    ajadekok.add(new Ajandek(name, tomeg, price));
                }
            }

            Puttony puttony;
            try {
                puttony = new Puttony(args[1], ajadekok.toArray(new Ajandek[0]));
            } catch (ArrayIndexOutOfBoundsException e) {
                puttony = new Puttony("a vilag osszes gyereke", ajadekok.toArray(new Ajandek[0]));
            }

            System.out.println(puttony);
            Collection<GyerekJatek> gyerekJatekok = puttony.gyerekjatekok();
            Optional<GyerekJatek> legDragabb = gyerekJatekok.stream().max(Comparator.comparing(Ajandek::getPrice));
            if (legDragabb.isPresent()) {
                System.out.println(legDragabb.get());
            } else {
                System.out.println("Nincs gyerekjáték a puttonyban.");
            }

            Scanner inputScanner = new Scanner(System.in);
            try {
                Collection<GyerekJatek> jatekokAboveAge = puttony.gyerekJatekokAboveAge(inputScanner.nextInt());
                jatekokAboveAge.forEach(System.out::println);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            AjandekCsomag[] ajandekCsomagok = new AjandekCsomag[] {
                    puttony,
                    null
            };
            System.out.println(Arrays.toString(csomagArrToAvg(ajandekCsomagok)));

        } catch (FileNotFoundException e) {
            System.err.printf("File nem talalhato: %s\n", args[0]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Adja meg az inputfile nevet argumentumkent");
        }
    }

    static double[] csomagArrToAvg(AjandekCsomag[] ajandekCsomagok) {
        return Arrays.stream(ajandekCsomagok)
                .mapToDouble(csomag -> {
                    if(csomag == null) return 0;
                    else return csomag.atlagErtek();
                })
                .toArray();
    }
}
