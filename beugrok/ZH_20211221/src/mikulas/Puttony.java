package mikulas;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Puttony implements AjandekCsomag {
    private final String cimzett;
    private final java.util.TreeSet<Ajandek> ajandekok = new TreeSet<>();

    public Puttony(String cimzett, Ajandek[] ajandekok) {
        this.cimzett = cimzett;
        this.ajandekok.addAll(Arrays.asList(ajandekok));
    }

    public Collection<GyerekJatek> gyerekJatekokAboveAge(long ageLimit) throws IllegalArgumentException {
        if (ageLimit < 0) throw new IllegalArgumentException("Negativ eletkor!");
        return this.gyerekjatekok().stream()
                .filter(gyerekJatek -> gyerekJatek.getAgeLimit() > ageLimit)
                .collect(Collectors.toList());
    }

    @Override
    public int osszErtek() {
        return ajandekok.stream().mapToInt(Ajandek::getPrice).sum();
    }

    @Override
    public int nehezekSzama(double t) {
        return (int) ajandekok.stream().filter(ajandek -> ajandek.getTomeg() > t).count();
    }

    @Override
    public Collection<GyerekJatek> gyerekjatekok() {
        Collection<GyerekJatek> gyerekJatekok = new TreeSet<>();
        this.ajandekok.stream()
                .filter(ajandek -> ajandek instanceof GyerekJatek)
                .forEach(gyerekjatek -> gyerekJatekok.add((GyerekJatek) gyerekjatek));
        return gyerekJatekok;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(String.format("%s\n\n", this.cimzett));
        this.ajandekok.forEach(ajandek -> {
            sb.append(ajandek.toString());
            sb.append("\n");
        });
        return sb.toString();
    }

    public double atlagErtek() {
        try {
            return this.ajandekok.stream()
                    .mapToDouble(ajandek -> ajandek.getTomeg())
                    .average()
                    .getAsDouble();
        } catch (NullPointerException e) {
            return 0;
        }
    }
}
