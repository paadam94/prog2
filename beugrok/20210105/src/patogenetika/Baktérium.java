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
        return String.join(super.toString(),
                "; ",
                this.tribe);
    }
}
