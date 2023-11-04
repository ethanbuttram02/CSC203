package calculator;

public abstract class BinaryExpression implements Expression {

    private final Expression lft;
    private final Expression rht;
    private final String operation;

    public BinaryExpression(Expression lft, Expression rht, String operation) {
        this.lft = lft;
        this.rht = rht;
        this.operation = operation;

    }

    public String toString() {
        return operation.equals("+") ? ("(" + this.lft + "+" + this.rht + ")") : ("(" + this.lft + "-" + this.rht + ")");
    }


    public void evaluate(final Bindings bindings)
    {
        _applyOperator(lft.evaluate(bindings), rht.evaluate(bindings));
    }

    protected abstract double _applyOperator(double leftVal, double rightVal);
}
