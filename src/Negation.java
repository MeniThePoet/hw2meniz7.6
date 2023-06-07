public class Negation extends Function {

    protected Function function;
    protected Constant Negi;

    /**
     * Constructor of Negation function
     *
     * @param function the function we want to negate
     * @return the negation of the function
     */
    public Negation(Function function) {
        this.function = function;
        this.Negi = new Constant(-1);
    }

    /**
     * calculates the value of the negation of a function at x
     */
    public double valueAt(double x) {
        double Val = function.valueAt(x);
        return Negi.valueAt(x) * Val;
    }

    /**
     * calculates the derivative of the negation of a function
     *
     * @return the derivative of the negation of a function
     */
    public Function derivative() {
        return new Negation(function.derivative());
    }

    /**
     * the representation of the negation of a function
     *
     * @return the representation of the negation of a function
     */
    public String toString() {
        return "(-" + function + ")" ;
    }

}
