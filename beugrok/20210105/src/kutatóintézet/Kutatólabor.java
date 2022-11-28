package kutatóintézet;

import patogenetika.KórokozóTár;
import patogenetika.Kórokozó;
import patogenetika.Vírus;

import java.util.*;

public class Kutatólabor implements KórokozóTár {
    private String name;
    private TreeSet<Kórokozó> kórokozók;

    public Kutatólabor(String name) {
        this.name = name;
    }

    // hozzáadja a megkapott tömbben található kórokozókat a kórokozótárhoz
    public void hozzáad(Kórokozó[] kórokozók) {
        this.hozzáad(kórokozók);
    }
    public void hozzáad(Collection<Kórokozó> kórokozók) {
        this.kórokozók.addAll(kórokozók);
    }
    // visszaadja egy listában a természetes rendezettségük sorrendjében azokat a
    // koronavírusokat, amelyek veszélyt jelentenek a megkapott gazdatestre nézve
    public java.util.List<Vírus> koronavírusokGazdában(String gazdatest) {
        java.util.List<Vírus> vírusok = new java.util.LinkedList<>();
        kórokozók.forEach(kórokozó -> {
            if (kórokozó instanceof Vírus) {
                Vírus virus = (Vírus) kórokozó;
                if (virus.isCorona()) {
                    vírusok.add(virus);
                }
            };

        });
        return vírusok;
    }
    // visszaadja lexikografikusan növekvő sorrendben a kórokozótárban szereplő
    // kórokozók által okozott összes betegséget úgy, hogy egy betegség csak egyszer
    // szerepel a kollekcióban (null értékek és üres sztringek nélkül!)
    public java.util.Collection<String> betegségek() {
        java.util.TreeSet set = new TreeSet<String>();
        kórokozók.forEach(kórokozó -> { set.add(kórokozó.getNameOfDisease()); });
        return set;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name)
                .append("\n");
        kórokozók.forEach(kórokozó -> { sb.append(kórokozó); });

        return sb.toString();
    }

}

class BetegsegComparator implements Comparator<Kórokozó> {

    @Override
    public int compare(Kórokozó o1, Kórokozó o2) {
        return o1.getNameOfDisease().compareTo(o2.getNameOfDisease());
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }
}
