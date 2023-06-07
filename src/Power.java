public class Power extends Function {
    protected Function base; // the base function of the power function
    protected int PowerOf;

    /**
     * constructor for the power of two functions
     *
     * @param base    the base function of the power
     * @param PowerOf the exponent function of the power
     */
    public Power(Function base, int PowerOf) {
        this.base = base;
        this.PowerOf = PowerOf;
    }

    /**
     * calculates the value of the power of two functions at x
     * by using the formula a^b = e^(b*ln(a))
     *
     * @param x the value of the point x
     * @return the value of the power of two functions at x
     */
    public double valueAt(double x) {
        return Math.pow(base.valueAt(x), PowerOf);
    }

    /**
     * the representation the power of two functions
     *
     * @return the representation the power of two functions
     */
    public String toString() {
        if (PowerOf == 1)
            return "(" + base + ")";
        else
            return "(" + base + "^" + PowerOf + ")";
    }

    /**
     * calculates the derivative of the power function
     *
     * @return the derivative of the power of two functions
     */
    public Function derivative() {
        if (PowerOf == 1)
            return base.derivative();
        else
            return new MultiProduct(new Constant(PowerOf), new Product(new Power(base, PowerOf - 1), base.derivative()));
    }

    /**
     * calculates the nth derivative of the power function
     *
     * @param n the number of times we want to derive the function
     * @return the nth derivative of the power function
     */
    public Function highDerivative(int n) {
        Function currentDerivative = (new Power(base, PowerOf)).derivative();
        for (int i = 1; i < n; i++) {
            currentDerivative = currentDerivative.derivative();
        }
        return currentDerivative;
    }
}