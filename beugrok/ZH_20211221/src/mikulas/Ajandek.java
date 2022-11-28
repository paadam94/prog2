package mikulas;

public class Ajandek {
    protected String name;
    protected float tomeg;
    protected long price;

    public Ajandek(String name, float tomeg, long price) {
        this.name = name;
        this.tomeg = tomeg;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ajandek ajandek = (Ajandek) o;

        if (!this.name.equals(ajandek.name)) return false;
        return !(Math.abs(this.tomeg - ajandek.tomeg) > 2);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + (tomeg != 0.0f ? Float.floatToIntBits(tomeg) : 0);
        return result;
    }

    @Override
    public String toString() {
        return String.format("%s (%f kg), %d Ft", this.name, this.tomeg, this.price);
    }
}
