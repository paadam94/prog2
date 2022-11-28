package patogenetika;

import java.util.Objects;
import java.util.TreeMap;

public abstract class Kórokozó implements Comparable<Kórokozó> {
    private final char type;
    private final String name;
    private final String nameOfDisease;
    private final String[] hosts;

    public String getNameOfDisease() {
        return nameOfDisease;
    }

    public String[] getHosts() {
        return hosts;
    }

    private static final TreeMap<Character, String> typeMap = new TreeMap<>();
    static {
        typeMap.put('P', "prion");
        typeMap.put('V', "virus");
        typeMap.put('B', "bacterium");
        typeMap.put('G', "gomba");
        typeMap.put('N', "noveny");
        typeMap.put('A', "allat");
    }


    public Kórokozó(char type,
                    String name,
                    String nameOfDisease,
                    String[] victims)
            throws IllegalArgumentException {

        if (!typeValidator(type)) {
            String msg = String.format("Invalid type: %c", type);
            throw new IllegalArgumentException(msg);
        }

        if (!nameValidator(name)) {
            String msg = String.format("Invalid name: %s", name);
            throw new IllegalArgumentException(msg);
        }

        this.type = type;
        this.name = name;
        this.nameOfDisease = nameOfDisease;
        this.hosts = victims;
    }

    boolean typeValidator(char type) {
        return typeMap.containsKey(type);
    }

    boolean nameValidator(String name) {
        return !(name == null || name.isEmpty());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kórokozó kórokozó = (Kórokozó) o;
        return type == kórokozó.type && name.equals(kórokozó.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, name);
    }

    @Override
    public String toString() {

        String nameOfDiseaseString = this.nameOfDisease.isEmpty()
                ? "-"
                : this.nameOfDisease;

        StringBuilder victimsStringBuilder = new StringBuilder();
        for(int i = 0; i < this.hosts.length; ++i) {
            if(i != 0) victimsStringBuilder.append(", ");
            victimsStringBuilder.append(this.hosts[i]);
        }
        String victimsString = victimsStringBuilder.toString();
        if (victimsString.isEmpty()) victimsString = "-";

        StringBuilder sb = new StringBuilder();
        sb.append(typeMap.get(this.type))
                .append(": ")
                .append(this.name)
                .append("; name of disease: ")
                .append(nameOfDiseaseString)
                .append("; victims: ")
                .append(victimsString);
        return sb.toString();
    }

    @Override
    public int compareTo(Kórokozó o) {
        if (this.type != o.type) {
            return Character.compare(this.type, o.type);
        } else {
            return this.name.compareTo(o.name);
        }

    }
}
