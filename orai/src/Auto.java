import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Auto implements Comparable<Auto> {
    private String rendszam;
    private int teljesitmeny;
    private boolean automata;

    public Auto(String rendszam, int teljesitmeny,
                boolean automata) {
        this.rendszam = rendszam;
        this.teljesitmeny = teljesitmeny;
        this.automata = automata;
    }

    public String getRendszam() {
        return rendszam;
    }

    public int getTeljesitmeny() {
        return teljesitmeny;
    }

    public boolean isAutomata() {
        return automata;
    }

    /*
    @Override
    public String toString() {
        return "Auto{" +
                "rendszam='" + rendszam + '\'' +
                ", teljesitmeny=" + teljesitmeny +
                ", automata=" + automata +
                '}';
    }
     */

    /*
    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(", ");
        sj.add(this.rendszam);
        sj.add(String.valueOf(teljesitmeny));
        sj.add(String.valueOf(automata));
        return sj.toString();
    }
     */

    /*
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(rendszam);
        sb.append(", ");
        sb.append(teljesitmeny);
        sb.append(", ");
        sb.append(automata);
        return sb.toString();
    }

     */

    @Override
    public String toString() {
        return new StringBuilder()
                .append(rendszam)
                .append(", ")
                .append(teljesitmeny)
                .append(", ")
                .append(automata)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Auto auto = (Auto) o;
        return Objects.equals(rendszam, auto.rendszam);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rendszam);
    }

    @Override
    public int compareTo(Auto o) {
        /*
        if (this.teljesitmeny < o.teljesitmeny) {
            return -1;
        }
        if (this.teljesitmeny > o.teljesitmeny) {
            return 1;
        }
        return 0;
         */
        // return Integer.compare(this.teljesitmeny, o.teljesitmeny);
        // return -Integer.compare(this.teljesitmeny, o.teljesitmeny);
        return Integer.compare(o.teljesitmeny, this.teljesitmeny);
    }

    public boolean valodiRendszam() {
        if (rendszam.length() != 6) {
            return false;
        }

        for (int i = 0; i < 3; i++) {
            if (!Character.isUpperCase(rendszam.charAt(i))) {
                return false;
            }
        }
        for (int i = 3; i < 6; i++) {
            if (!Character.isDigit(rendszam.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    public static Teherauto[] nagyTeherautok(Auto[] autok) {
        int db = 0;
        for (Auto auto : autok) {
            if (auto instanceof Teherauto) {
                Teherauto teherauto = (Teherauto) auto;
                if (teherauto.getTeherbiras() >= 20) {
                    db++;
                }
            }
        }

        Teherauto[] teherautok = new Teherauto[db];
        db = 0;
        for (Auto auto : autok) {
            if (auto instanceof Teherauto) {
                Teherauto teherauto = (Teherauto) auto;
                if (teherauto.getTeherbiras() >= 20) {
                    teherautok[db] = teherauto;
                    db++;
                }
            }
        }

        return teherautok;
    }

    public static void main(String[] args) {
        Auto a1 = new Auto("AAA123",
                80, true);

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Auto[] autok = new Auto[n];
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] tokens = line.split(";");
            if (tokens.length == 3) {
                Auto auto = new Auto(
                        tokens[0],
                        Integer.parseInt(tokens[1]),
                        Boolean.parseBoolean(tokens[2])
                );
                autok[i] = auto;
            } else {
                Auto auto = new Teherauto(
                        tokens[0],
                        Integer.parseInt(tokens[1]),
                        Boolean.parseBoolean(tokens[2]),
                        Integer.parseInt(tokens[3])
                );
                autok[i] = auto;
            }
        }

        System.out.println(autok);
        System.out.println(Arrays.toString(autok));
        Arrays.sort(autok);
        for (Auto auto : autok) {
            System.out.println(auto);
        }
    }
}

class Teherauto extends Auto {
    private int teherbiras;

    public int getTeherbiras() {
        return teherbiras;
    }

    public Teherauto(String rendszam, int teljesitmeny,
                     boolean automata, int teherbiras) {
        super(rendszam, teljesitmeny, automata);
        this.teherbiras = teherbiras;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + teherbiras;
    }
}