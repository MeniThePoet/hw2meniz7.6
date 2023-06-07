
public class Polynomial extends Function {
    private double[] coefficients;

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
            startout += coefficientToPrint(coefficients[i], i);
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
     */
    private String coefficientToPrint (double coefficient, int i) {
        if ((coefficient == 1 || coefficient == -1) && i!=0) {
            return "";
        }

        coefficient = Math.abs(coefficient);
        if (coefficient == (int) coefficient) {
            return Integer.toString((int) coefficient);
        }
        return Double.toString(coefficient);
    }



    /**
     * gives the derivative of the function
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

//    @Override
//    public Polynomial taylorPolynomial(int n) {
//        double[] coefficients = this.coefficients;
//        double[] taylor_coefficients = new double[n + 1];
//        for (int i = 0; i < coefficients.length && i < n + 1; i++)
//            taylor_coefficients[i] = this.derivative().valueAt(0) / factorial(i);
//        return new Polynomial(taylor_coefficients);
//    }

    /**
     * gives the taylor polynomial of the function
     *
     * @return the taylor polynomial of the function
     */
//    public Polynomial negate() {
//        double[] coefficients = this.getValues();
//        double[] negated_coefficients = new double[coefficients.length];
//        for (int i = 0; i < coefficients.length; i++)
//            negated_coefficients[i] = coefficients[i] * (-1);
//        return new Polynomial(negated_coefficients);
//    }

    /**
     * gives the taylor polynomial of the function
     *
     * @param polynomial the polynomial to divide by
     * @return the taylor polynomial of the function
     */
//    public Polynomial divide(Polynomial polynomial) {
//        double[] coefficients = this.getValues();
//        double[] polynomialCoefficients = polynomial.getValues();
//        if (coefficients.length - polynomialCoefficients.length + 1 <= 0)
//            return new Polynomial(0);
//        double[] quotientCoefficients = new double[coefficients.length - polynomialCoefficients.length + 1];
//        double[] remainderCoefficients = new double[polynomialCoefficients.length - 1];
//
//        for (int i = 0; i < Math.min(coefficients.length, quotientCoefficients.length); i++) {
//            quotientCoefficients[i] = coefficients[i];
//        }
//        for (int i = 0; i < Math.min(polynomialCoefficients.length, remainderCoefficients.length); i++) {
//            remainderCoefficients[i] = polynomialCoefficients[i];
//        }
//        for (int i = 0; i < quotientCoefficients.length; i++) {
//            if (quotientCoefficients[i] != 0) {
//                for (int j = 0; j < Math.min(remainderCoefficients.length, quotientCoefficients.length ); j++) {
//                    quotientCoefficients[i + j] -= remainderCoefficients[j];
//                }
//            }
//        }
//        return new Polynomial(quotientCoefficients);
//    }


}

