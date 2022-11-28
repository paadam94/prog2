package patogenetika;

public class Baktérium extends Kórokozó {
    protected String tribe;
    public Baktérium(String name,
                     String nameOfDisease,
                     String[] victims,
                     String tribe) {
        super('B', name, nameOfDisease, victims);
        this.tribe = tribe;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString())
                .append("; ")
                .append(this.tribe);
        return sb.toString();
    }
}
