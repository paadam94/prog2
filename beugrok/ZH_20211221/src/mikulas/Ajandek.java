package mikulas;

public class Ajandek implements Comparable<Ajandek> {
    protected String name;
    protected double tomeg;
    protected int price;

    public String getName() {
        return name;
    }

    public double getTomeg() {
        return tomeg;
    }

    public int getPrice() {
        return price;
    }

    public Ajandek(String name, float tomeg, int price) {
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
        int result;
        long temp;
        result = name.hashCode();
        temp = Double.doubleToLongBits(tomeg);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return String.format("%s (%f kg), %d Ft", this.name, this.tomeg, this.price);
    }

    @Override
    public int compareTo(Ajandek o) {
        if(this.getName().equals(o.getName())) {
            return this.getName().compareTo(o.getName());
        } else {
            return Long.compare(this.getPrice(), o.getPrice());
        }
    }
}
