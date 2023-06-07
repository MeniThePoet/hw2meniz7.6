public class Difference extends Function {
    private Function fun1;
    private Function fun2;

    /**
     * this function constructs the object Difference from the two received Functions
     *
     * @param fun1 the first Function we construct Difference from
     * @param fun2 the second Function we construct Difference from
     */
    public Difference(Function fun1, Function fun2) {
        this.fun1 = fun1;
        this.fun2 = fun2;
    }

    /**
     * calculates the value of the difference function at a given point
     *
     * @param x the x coordinate value we want to calculate the value function at
     * @return
     */
    public double valueAt(double x) {
        return fun1.valueAt(x) - fun2.valueAt(x);
    }

    /**
     * returns a String representation of the current function
     *
     * @return
     */
    public String toString() {
        return "(" + fun1.toString() + " - " + fun2.toString() + ")";
    }

    /**
     * returns a Function object representing the derivative of the current function
     *
     * @return
     */
    public Function derivative() {
        return new Difference(fun1.derivative(), fun2.derivative());
    }
}


