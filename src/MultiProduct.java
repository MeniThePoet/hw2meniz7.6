public class MultiProduct extends Function {
    protected Function[] functions;

    /**
     * constructor for the MultiProduct class
     *
     * @param functions the functions to be multiplied
     */
    public MultiProduct(Function function1, Function function2, Function... functions) {
        this.functions = new Function[functions.length + 2];
        this.functions[0] = function1;
        this.functions[1] = function2;
        for (int i = 0; i < functions.length; i++) {
            this.functions[i + 2] = functions[i];
        }
    }

    /**
     * calculates the value of the product of the functions at x
     *
     * @param x the value of the point x
     * @return the value of the product of the functions at x
     */
    public double valueAt(double x) {
        double product = 1;
        for (Function function : functions) {
            product *= function.valueAt(x);//product = product * function.valueAt(x);
        }
        return product;
    }

    /**
     * the representation the product of the functions
     *
     * @return the representation the product of the functions
     */
    @Override
    public String toString() {
        String startout = "(";
        boolean firstFunction = true;
        for (Function function : functions) {
            if (!firstFunction) {
                startout += " * ";
            }
            startout += function.toString();
            firstFunction = false;
        }
        return startout + ")";
    }

    /**
     * calculates the derivative of the product of the functions
     *
     * @return the derivative of the product of the functions
     */
    public Function derivative() {
            Function[] derivatives = new Function[functions.length];
            for (int i = 0; i < functions.length; i++) {
                Function temp = functions[i].derivative();
                for (int j = 0; j < functions.length; j++) {
                    if (i != j) {
                        temp = new Product(temp, functions[j]);
                    }
                }
                derivatives[i] = temp;
            }
        if (derivatives.length == 2)
            return new Sum(derivatives[0], derivatives[1]);
        Function[] newFunctions = new Function[functions.length - 2];
        for (int i = 0; i < newFunctions.length; i++) {
            newFunctions[i] = derivatives[i + 2];
        }
        return new MultiSum(derivatives[0], derivatives[1], newFunctions);
    }
}
