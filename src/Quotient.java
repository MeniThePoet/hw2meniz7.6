public class Quotient extends Function {
    private Function denoFunc;//mecane - denominator
    private Function numFunc;//mone - numerator

    /**
     * constructor for the quotient of two functions
     *
     * @param denoFunc denominator function of the quotient
     * @param numFunc  numerator function of the quotient
     */
    public Quotient(Function numFunc, Function denoFunc) {
        this.numFunc = numFunc;
        this.denoFunc = denoFunc;
    }

    /**
     * the representation the quotient of two functions
     *
     * @return the representation the quotient of two functions
     */
    public String toString() {
        return "(" + numFunc + " / " + denoFunc + ")";
    }

    /**
     * calculates the value of the quotient of two functions at x
     *
     * @param x the value of the point x
     * @return the value of the quotient of two functions at x
     */
    public double valueAt(double x) {
        return numFunc.valueAt(x) / denoFunc.valueAt(x);
    }

    /**
     * calculates the derivative of the quotient of two functions by
     * using the quotient rule of differentiation (f/g)' = (f'g - fg')/g^2
     *
     * @return the derivative of the quotient of two functions
     */
    public Function derivative() {
        Product numfirsfunc = new Product(numFunc.derivative(), denoFunc);
        Product numsecfunc = new Product(denoFunc.derivative(), numFunc);
        Power denofunc = new Power(denoFunc, 2);
        Difference numfunc = new Difference(numfirsfunc, numsecfunc);
        return new Quotient(numfunc, denofunc);
    }
}
