/**
 * Used to calculate monthly payments on a mortgage.
 *
 * @author Riley Simmons
 */
public class Mortgage {

    private double principal;
    private double mrate;
    private int months;

    public Mortgage(double p, double r, int m) {
        principal = p;
        mrate = (r / 12) * .01;
        months = m;
    }

    /**
     * Finds the monthly payment value.
     *
     * @return The monthly payment of the defined mortgage.
     */
    public double getMonthlyPayment() {
        return ((principal * mrate) / (1 - Math.pow(1 + mrate, -months)));
    }
}
