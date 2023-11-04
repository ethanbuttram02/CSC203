package calculator;

public class SubtractExpression
   extends BinaryExpression
   {
   public SubtractExpression(Expression lft, Expression rht, String operation) {
      super(lft, rht, "-");
   }

   @Override
   public double _applyOperator(double leftVal, double rightVal) {
      return leftVal - rightVal;
   }
}

