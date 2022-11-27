package patogenetika;

import java.util.Objects;
import java.util.TreeMap;

public abstract class Kórokozó implements Comparable<Kórokozó> {
    private final char type;
    private final String name;
    private final String nameOfDisease;
    private final String[] victims;

    private static final TreeMap<Character, String> typeMap = new TreeMap<>();
    static {
        typeMap.put('P', "prion");
        typeMap.put('V', "virus");
        typeMap.put('B', "bacterium");
        typeMap.put('G', "gomba");
        typeMap.put('N', "noveny");
        typeMap.put('A', "allat");
    }

    static class IllegalArgumentException
            extends RuntimeException {
        public IllegalArgumentException(String message) {
            super(message);
        }
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
        this.victims = victims;
    }

    boolean typeValidator(char type) {
        return typeMap.containsKey(type);
    }

    boolean nameValidator(String name) {
        return !(name == null || name.isEmpty());
    }

    String typeToString() throws IllegalArgumentException {
        return switch (this.type) {
            case 'P' -> "prion";
            case 'V' -> "virus";
            case 'B' -> "bacterium";
            case 'G' -> "gomba";
            case 'N' -> "noveny";
            case 'A' -> "allat";
            default -> {
                String msg = String.format("Invalid type: {}", type);
                throw new IllegalArgumentException(msg);
            }
        };
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, name);
    }

    @Override
    public boolean equals(Object o) {
        Kórokozó p = (Kórokozó) o;
        return this.name.equals(p.name) && this.type == p.type;
    }

    @Override
    public String toString() {

        String nameOfDiseaseString = this.nameOfDisease.isEmpty()
                ? "-"
                : this.nameOfDisease;

        StringBuilder victimsStringBuilder = new StringBuilder();
        for(int i = 0; i < this.victims.length; ++i) {
            if(i != 0) victimsStringBuilder.append(", ");
            victimsStringBuilder.append(this.victims[i]);
        }
        String victimsString = victimsStringBuilder.toString();
        if (victimsString.isEmpty()) victimsString = "-";

        return String.join(this.typeMap.get(this.type), ": ",
                this.name, "; ",
                "name of disease: ", nameOfDiseaseString,
                "victims: ", victimsString
        );
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
