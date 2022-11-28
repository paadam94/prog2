package mikulas;

import java.util.Objects;

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

    public Ajandek(String name, double tomeg, int price) {
        this.name = name;
        this.tomeg = tomeg;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Ajandek ajandek = (Ajandek) o;
        if (!this.getName().equals(ajandek.getName())) return false;
        return Math.abs(this.getTomeg() - ajandek.getTomeg()) <= 1;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getTomeg());
    }

    @Override
    public String toString() {
        return String.format("%s (%.1f kg), %d Ft", this.name, this.tomeg, this.price);
    }

    @Override
    public int compareTo(Ajandek o) {
        if(this.getPrice() == o.getPrice()) {
            return this.getName().compareTo(o.getName());
        } else {
            return -Long.compare(this.getPrice(), o.getPrice());
        }
    }
}
