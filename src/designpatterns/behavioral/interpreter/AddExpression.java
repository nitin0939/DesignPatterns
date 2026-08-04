package designpatterns.behavioral.interpreter;

/**
 * Non-terminal Expression in the Interpreter pattern.
 * Combines two sub-expressions (which may themselves be numbers or further
 * operations) with addition.
 */
public class AddExpression implements Expression {
    private final Expression left;
    private final Expression right;

    public AddExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    /**
     * Recursively interprets both operands before combining them, so nested
     * expressions (e.g. an addition whose operand is itself a subtraction)
     * resolve correctly.
     */
    @Override
    public int interpret() {
        return left.interpret() + right.interpret();
    }
}
