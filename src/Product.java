public class Product extends MultiProduct {

    /**
     * constructor for the product of two functions
     *
     * @param fun1
     * @param fun2
     */
    public Product(Function fun1, Function fun2) {
        super(fun1, fun2);

    }
    /**
     * derivative of the product of two functions according to the formula (f*g)' = f'*g + f*g'
     * @return the derivative of the product of two functions
     */
    @Override
    public Function derivative() {
        Product left = new Product((this.functions[0]).derivative(), this.functions[1]);
        Product right = new Product((this.functions[1]).derivative(), this.functions[0]);
        return new Sum(left, right);
    }
}



