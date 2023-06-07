public class MultiSum extends Function {
    protected Function[] functions;

    /**
     * this function constructs the object Sum from the two or more received Functions
     *
     * @param function1 the first Function we construct Difference from
     * @param function2 the second Function we construct Difference from
     * @param functions the rest of the Functions we construct Difference from
     * @throws IllegalArgumentException if the number of functions is less than 2
     */
    public MultiSum(Function function1, Function function2, Function... functions) {
        this.functions = new Function[functions.length + 2];
        this.functions[0] = function1;
        this.functions[1] = function2;
        for (int i = 0; i < functions.length; i++) {
            this.functions[i + 2] = functions[i];
        }
    }

    /**
     * calculates the value of the sum of the functions at a given x
     *
     * @param x the x value we want to calculate the value of the sum of the functions at
     * @return the value of the sum of the functions at a given x
     */
    public double valueAt(double x) {
        double sum = 0;
        for (Function function : functions) {
            sum += function.valueAt(x);
        }
        return sum;
    }

    /**
     * returns a String representation of the sum of the functions
     *
     * @return a String representation of the sum of the functions
     */
    public String toString() {
        String startout = "(";
        boolean firstFunction = true;
        for (Function function : functions) {
            if (!firstFunction) {
                startout += " + ";
            }
            startout += function.toString();
            firstFunction = false;
        }
        return startout + ")";
    }

    /**
     * calculates the derivative of the sum of the functions using the chain rule
     * and the derivative of each function in the sum
     *
     * @return the derivative of the sum of the functions
     */
    @Override
    public Function derivative() {
        int minFunctions = Math.min(2, functions.length); // Determine the minimum number of  functions
        Function[] derivedFunctions = new Function[functions.length];
        for (int i = 0; i < functions.length; i++) {
            derivedFunctions[i] = functions[i].derivative();
        }
        Function[] derdFunctionsAfterMin = new Function[functions.length - minFunctions];
        for (int i = minFunctions; i < functions.length; i++) {
            derdFunctionsAfterMin[i - minFunctions] = derivedFunctions[i];
        }
        Function[] derivedFunctionsBeforeMinimum = new Function[minFunctions];
        System.arraycopy(derivedFunctions, 0, derivedFunctionsBeforeMinimum, 0, minFunctions);
        return new MultiSum(derivedFunctionsBeforeMinimum[0], derivedFunctionsBeforeMinimum[1], derdFunctionsAfterMin);
    }
}
