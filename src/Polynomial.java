public class Polynomial extends Function {
    protected double[] coefficients; // the coefficients of the polynomial in protected so that there will be no need for getters and setters

    /**
     * Constructor
     *
     * @param coefficients The coefficients of the polynomial
     */
    public Polynomial(double... coefficients) {
        this.coefficients = coefficients;
    }

    /**
     * Calculates the value of the polynomial at x
     *
     * @param x The value of the point x
     * @return The value of the polynomial at x
     */
    public double valueAt(double x) {
        double value = 0;
        for (int i = 0; i < coefficients.length; i++) {
            value += coefficients[i] * Math.pow(x, i);
        }
        return value;
    }

    /**
     * Returns the representation of the function as a string
     *
     * @return The representation of the function as a string
     */
    @Override
    public String toString() {
        String startout = "(";
        boolean firstCoefficient = true;
        for (int i = 0; i < coefficients.length; i++) {
            if (coefficients[i] == 0) {
                continue;
            } else if (coefficients[i] > 0 && !firstCoefficient) {
                startout += " + ";
            } else if (coefficients[i] < 0 && !firstCoefficient) {
                startout += " - ";
            } else if (coefficients[i] < 0 && firstCoefficient) {
                startout += "-";
            }
            firstCoefficient = false;
            startout += CoefficientsOut(coefficients[i], i);
            if (i > 1) {
                startout += "x^" + i;
            }
            if (i == 1) {
                startout += "x";
            }
        }
        if (startout.equals("(")) {
            startout += "0";
        }
        return startout + ")";
    }

    /**
     * This function returns a String representation of the coefficient
     *
     * @param coefficient the coefficient to print
     * @param i           the index of the coefficient
     * @return a String representation of the coefficient
     */
    private String CoefficientsOut(double coefficient, int i) {
        if ((coefficient == 1 || coefficient == -1) && i != 0) {
            return "";
        }

        coefficient = Math.abs(coefficient);
        if (coefficient == (int) coefficient) {
            return Integer.toString((int) coefficient);
        }
        return Double.toString(coefficient);
    }

    /**
     * calculate the derivative of the POLYNOMIAL
     *
     * @return the derivative of the function
     */
    public Function derivative() {
        double[] coefficients = this.coefficients;
        if (coefficients.length == 1 || coefficients.length == 0)
            return new Constant(0);
        double[] derivative_coefficients = new double[coefficients.length - 1];
        for (int i = 1; i < this.coefficients.length; i++)
            derivative_coefficients[i - 1] = coefficients[i] * i;
        return new Polynomial(derivative_coefficients);
    }
}

