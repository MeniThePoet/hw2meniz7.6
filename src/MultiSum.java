public class MultiSum extends Function{
    protected Function[] functions;
    /**
     * this function constructs the object Sum from the two or more received Functions
     * @param function1 the first Function we construct Difference from
     * @param function2 the second Function we construct Difference from
     * @param functions the rest of the Functions we construct Difference from
     * @throws IllegalArgumentException if the number of functions is less than 2
     */
    public MultiSum(Function function1, Function function2, Function... functions) {
        this.functions = new Function[functions.length+2];
        this.functions[0] = function1;
        this.functions[1] = function2;
        for (int i = 0; i < functions.length; i++) {
            this.functions[i+2] = functions[i];
        }
    }
    /**
     * calculates the value of the sum of the functions at a given x
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
     * @return a String representation of the sum of the functions
     */
    public String toString () {
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
     * @return the derivative of the sum of the functions
     */
    public Function derivative() {
        Function[] derivatives = new Function[functions.length];

        for (int i = 0; i < functions.length; i++) {
            Function derivativeProduct = null;

            for (int j = 0; j < functions.length; j++) {
                if (i != j) {
                    Function derivative = functions[i].derivative();
                    if (derivativeProduct == null) {
                        derivativeProduct = derivative;
                    } else {
                        derivativeProduct = new Product(derivativeProduct, functions[j]);
                    }
                }
            }

            derivatives[i] = derivativeProduct;
        }

        if (derivatives.length == 2) {
            return new Sum(derivatives[0], derivatives[1]);
        }

        Function[] newFunctions = new Function[functions.length - 2];
        System.arraycopy(derivatives, 2, newFunctions, 0, newFunctions.length);

        return new MultiSum(derivatives[0], derivatives[1], newFunctions);
    }

}

