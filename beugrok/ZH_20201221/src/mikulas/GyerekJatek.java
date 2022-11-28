package mikulas;

public class GyerekJatek extends Ajandek {
    private final long ageLimit;

    public GyerekJatek(String name, double tomeg, int price, long ageLimit) {
        super(name, tomeg, price);
        this.ageLimit = ageLimit;
    }

    public long getAgeLimit() {
        return ageLimit;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(String.format(", %d eves kortol", this.getAgeLimit()));
        return sb.toString();
    }
}
