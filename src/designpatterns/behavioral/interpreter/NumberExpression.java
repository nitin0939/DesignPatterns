package designpatterns.behavioral.interpreter;

/**
 * Terminal Expression in the Interpreter pattern.
 * The base case of the recursion: a plain literal number, requiring no
 * further interpretation.
 */
public class NumberExpression implements Expression {
    private final int number;

    public NumberExpression(int number) {
        this.number = number;
    }

    @Override
    public int interpret() {
        return number;
    }
}
