package kutatóintézet;

import patogenetika.KórokozóTár;
import patogenetika.Kórokozó;
import patogenetika.Vírus;

import java.util.*;
import java.util.stream.Collectors;

public class Kutatólabor implements KórokozóTár {
    final private String name;
    private TreeSet<Kórokozó> kórokozók = new TreeSet<>();

    public Kutatólabor(String name) {
        this.name = name;
    }

    // hozzáadja a megkapott tömbben található kórokozókat a kórokozótárhoz
    public void hozzáad(Kórokozó[] kórokozók) {
        this.kórokozók.addAll(Arrays.stream(kórokozók).collect(Collectors.toSet()));
    }
    public void hozzáad(Collection<Kórokozó> kórokozók) {
        this.kórokozók.addAll(kórokozók);
    }
    // visszaadja egy listában a természetes rendezettségük sorrendjében azokat a
    // koronavírusokat, amelyek veszélyt jelentenek a megkapott gazdatestre nézve
    public java.util.List<Vírus> koronavírusokGazdában(String gazdatest) {
        java.util.List<Vírus> vírusok = new java.util.LinkedList<>();
        kórokozók.forEach(kórokozó -> {
            if (!(kórokozó instanceof Vírus)) return;
            Vírus virus = (Vírus) kórokozó;
            if (!virus.isCorona()) return;
            boolean flag = false;
            for(String victim: virus.getHosts()) {
                if (victim.equals(gazdatest)) {
                    flag = true;
                }
            }
            if (flag) vírusok.add(virus);
        });
        return vírusok;
    }
    // visszaadja lexikografikusan növekvő sorrendben a kórokozótárban szereplő
    // kórokozók által okozott összes betegséget úgy, hogy egy betegség csak egyszer
    // szerepel a kollekcióban (null értékek és üres sztringek nélkül!)
    public TreeSet betegségek() {
        TreeSet<String> set = new TreeSet<String>();
        kórokozók.forEach(kórokozó -> { set.add(kórokozó.getNameOfDisease()); });
        return set;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name)
                .append("\n\n");
        kórokozók.forEach(kórokozó -> {
            sb.append(kórokozó);
            sb.append("\n");
        });
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
