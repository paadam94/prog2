package mikulas;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

public class Puttony implements AjandekCsomag {
    private final String cimzett;
    private final java.util.LinkedList<Ajandek> ajandekok = new LinkedList<>();

    Puttony(String cimzett, Ajandek[] ajandekok) {
        this.cimzett = cimzett;
        this.ajandekok.addAll(Arrays.asList(ajandekok));
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
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(String.format("%s\n\n", this.cimzett));
        this.ajandekok.forEach(ajandek -> sb.append(ajandek.toString()));
        return sb.toString();
    }
}
