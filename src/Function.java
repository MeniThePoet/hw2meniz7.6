public abstract class Function {

    /**
     * this function returns the value of the function at a given point x.
     *
     * @param x the value we want to calculate the function at.
     * @return returns the value of the function at x.
     */
    abstract double valueAt(double x);

    /**
     * this function returns a String representation of the current function.
     *
     * @return a String representation of the current function.
     */
    @Override
    abstract public String toString();

    /**
     * this function returns a Function  representing the derivative of the current function.
     *
     * @return returns a Function derivative of the current function.
     */
    abstract Function derivative();

    /**
     * this function returns a Function representing the integral of the current function.
     *
     * @param n the number of times we want to derive the function.
     * @return returns a Function representing the integral of the current function.
     */
    public Function DevHigh(int n) {
        Function SetDerivative = derivative();
        for (int i = 1; i < n; i++) {
            SetDerivative = SetDerivative.derivative();
        }
        return SetDerivative;
    }

    /**
     * this function receives a natural integer i and returns its factorial.
     *
     * @param i the integer we want to calculate the factorial of.
     * @return returns a double representing the factorial of the received "n".
     */
    public double factorial(int i) {
        double factorial = 1;
        while (i != 0) {
            factorial *= i;
            i--;
        }
        return factorial;
    }

    /**
     * this function gets an estimate of the square root of the function in the segment [a,b],
     * for given two real numbers a,b and with a maximum error margin of the given epsilon.
     *
     * @param a       the left most end of the segment we want to calculate the square root for.
     * @param b       the right most end of the segment we want to calculate the square root for.
     * @param epsilon the maximum error margin for the square root calculation.
     * @return returns the square root of the function in [a,b] with error margin epsilon.
     */
    public double bisectionMethod(double a, double b, double epsilon) {
        double left = a, right = b; // would just use a and b, but I think instructions prohibit it
        while (right - left > epsilon) {
            double mid = (left + right) / 2;

            if (valueAt(left) * valueAt(mid) > 0) {
                left = mid;
            } else {
                right = mid;
            }
        }

        return (left + right) / 2;
    }

    /**
     * this function gets an estimate of the square root of the function in the segment [a,b],
     * for given two real numbers a,b and with a maximum error margin of 0.00001
     * used as default epsilon value for the bisection method.
     *
     * @param a the left most end of the segment we want to calculate the square root for.
     * @param b the right most end of the segment we want to calculate the square root for.
     * @return returns the square root of the function in [a,b] with error margin 0.00001.
     */
    public double bisectionMethod(double a, double b) {
        return bisectionMethod(a, b, 0.00001);
    }

    /**
     * this function gets an estimate of the square root of the function at a given point "a",
     * with a maximum error margin of the given epsilon. epsilon and "a" are real numbers.
     *
     * @param a       the value we want to calculate the square root at.
     * @param epsilon the maximum error margin for the square root calculation.
     * @return returns an estimate of the square root of the function at "a" with error max margin epsilon.
     */
    public double newtonRaphsonMethod(double a, double epsilon) {
        while (Math.abs(valueAt(a)) >= epsilon) {
            a = a - (valueAt(a) / (this.derivative()).valueAt(a));
        }
        return a;
    }

    /**
     * this function gets an estimate of the square root of the function at a given point "a",
     * with a maximum error margin of 0.00001. "a" is a real numbers.
     * used as default epsilon value for the newtonRaphsonMethod method.
     *
     * @param a the value we want to calculate the square root at.
     * @return returns an estimate of the square root of the function at "a" with error max margin of 0.00001.
     */
    public double newtonRaphsonMethod(double a) {
        return newtonRaphsonMethod(a, 0.00001);
    }

    /**
     * this function receives a natural integer "n" returns the taylor polynomial of order "n" at x=0
     * i.e f(x)=f(0)+f'(0)x+f''(0)x^2/2!+...+f^(n)(0)x^n/n! - aka the maclaurin polynomial
     *
     * @param n a natural integer representing the order of the taylor polynomial we want to calculate.
     * @return returns the taylor polynomial of the received order "n" at x=0.
     */
    public Function taylorPolynomial(int n) {
        double[] taylorPolynomialCoefficients = new double[n + 1];
        for (int i = 0; i <= n; i++) {
            if (i == 0) {
                taylorPolynomialCoefficients[0] = valueAt(0);
            } else if (i == 1) {
                taylorPolynomialCoefficients[1] = derivative().valueAt(0);
            } else {
                taylorPolynomialCoefficients[i] = DevHigh(i).valueAt(0) / factorial(i);
            }
        }
        return new Polynomial(taylorPolynomialCoefficients);

    }
}