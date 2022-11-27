package drink;

public class AlcoholicDrink
        extends Drink {
    private double ratio;

    public AlcoholicDrink(String name, String unit,
                          int price, double ratio) {
        super(name, unit, price);
        this.ratio = ratio;
    }

    public double getRatio() {
        return ratio;
    }

    public void setRatio(double ratio) {
        this.ratio = ratio;
    }

    @Override
    public String toString() {
        return this.ratio + " % V/V " + super.toString();
    }
}
