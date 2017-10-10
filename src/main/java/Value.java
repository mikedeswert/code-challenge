/**
 * User: mdeswert, Date: 10/10/2017.
 */
public class Value implements Operand {
    private double value;

    public Value(String value) {
        this.value = Double.valueOf(value.trim());
    }

    @Override
    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "" + value;
    }
}
