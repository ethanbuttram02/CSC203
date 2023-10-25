package calculator;

abstract class BinaryExpression {

    private final Expression lft;
    private final Expression rht;
    private final String operation;

    public BinaryExpression(){}

    public BinaryExpression(Expression lft, Expression rht, String operation) {
        this.lft = lft;
        this.rht = rht;
        this.operation = operation;
    }

    public String toString()
    {
        if (this.operation.equals("-")) {
            return "(" + lft + " - " + rht + ")";
        }

        return "(" + lft + " + " + rht + ")";
    }

    public void evaluate(final Bindings bindings)
    {
        if (this.operation.equals("-")) {
            _applyOperator(lft.evaluate(bindings) - rht.evaluate(bindings));
        }
        else {
            _applyOperator(lft.evaluate(bindings) + rht.evaluate(bindings));
        }
    }

    protected abstract double _applyOperator(double result);
}
