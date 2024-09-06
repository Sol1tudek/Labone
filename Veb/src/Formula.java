import java.util.HashSet;
import java.util.Set;

public class Formula implements Valid {
    private double r;
    private double x;
    private double y;

    public Formula(double r, double x, double y) {
        this.r = r;
        this.x = x;
        this.y = y;
    }

    public boolean isSquare() {
        return (x <= 0) && (y <= 0) && (y >= -r) && (x >= -r);
    }

    public boolean isTriangle() {
        double s_abc = (0.5 * (Math.abs(0 * (0 - r) + (-r / 2) * (r - 0) + 0 * (0 - 0))));
        double s_abp = (0.5 * (Math.abs(0 * (0 - y) + (-r / 2) * (y - 0) + x * (0 - 0))));
        double s_bcp = (0.5 * (Math.abs((-r / 2) * (r - y) + 0 * (y - 0) + x * (0 - 0))));
        double s_cap = (0.5) * Math.abs(0 * (y - r) + 0 * (r - 0) + x * (0 - 0));
        return (s_abc == s_abp + s_bcp + s_cap) && ((x <= 0) && (x >= (-r / 2)) && ((y >= 0) && (y <= r)));
    }

    public boolean isCicrle() {
        return ((x * x + y * y) < ((r) * (r))) && ((y <= 0) && (y >= -r) && (x >= 0) && (x <= r));


    }


    public boolean isPoint() {
        return isTriangle() || isSquare() || isCicrle();
    }


    @Override
    public void valid() throws IllegalArgumentException {
        if (!(x >= -3 && x <= 3)) {
            throw new IllegalArgumentException("x не валиден");
        }
        if (!(y >= -4 && y <= 4) || (y != (int) y)) {
            throw new IllegalArgumentException("y не валиден .Y должен быть целочисленным в промежутке от -4 до 4");
        }
        Set<Double> validRValues = new HashSet<>();
        validRValues.add(1.0);
        validRValues.add(1.5);
        validRValues.add(2.0);
        validRValues.add(2.5);
        validRValues.add(3.0);

        if (!validRValues.contains(r)) {
            throw new IllegalArgumentException("r не валиден. Допустимые значения: 1, 1.5, 2, 2.5, 3");
        }
    }

}