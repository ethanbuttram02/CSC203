package calculator;

public class AddExpression
   extends BinaryExpression
{
   public AddExpression(Expression lft, Expression rht, String operation) {
      super(lft, rht, "+");
   }

   @Override
   public double _applyOperator(double leftVal, double rightVal) {
      return leftVal + rightVal;
   }
}
