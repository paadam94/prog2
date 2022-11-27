package patogenetika;

import java.util.TreeMap;

public abstract class Kórokozó implements Comparable<Kórokozó> {
    private char type;
    private String name;
    private String nameOfDisease;
    private String[] victims;

    private static TreeMap<Character, String> typeMap = new TreeMap<>();
    static {
        typeMap.put('P', "prion");
        typeMap.put('V', "virus");
        typeMap.put('B', "bacterium");
        typeMap.put('G', "gomba");
        typeMap.put('N', "noveny");
        typeMap.put('A', "allat");
    }

    class IllegalArgumentException
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
            String msg = String.format("Invalid type: {}", type);
            throw new IllegalArgumentException(msg);
        }

        if (!nameValidator(name)) {
            String msg = String.format("Invalid name: {}", name);
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
        if (name == null || name.isEmpty()) {
            return false;
        }
        return true;
    }

    String typeToString() throws IllegalArgumentException {
        String msg;
        switch (this.type) {
            case 'P':
                msg = "prion";
                break;
            case 'V':
                msg = "virus";
                break;
            case 'B':
                msg = "bacterium";
                break;
            case 'G':
                msg = "gomba";
                break;
            case 'N':
                msg = "noveny";
                break;
            case 'A':
                msg = "allat";
                break;
            default:
                msg = String.format("Invalid type: {}", type);
                throw new IllegalArgumentException(msg);
        }
        return msg;
    }

    @Override
    public boolean equals(Object o) {
        Kórokozó p = (Kórokozó) o;
        if (this.name == p.name && this.type == p.type) return true;
        return false;
    };

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
        if (!(this.type != o.type)) {
            return Character.compare(this.type, o.type);
        } else {
            return this.name.compareTo(o.name);
        }

    }
}
