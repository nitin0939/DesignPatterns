package designpatterns.behavioral.interpreter;

/**
 * Client class that demonstrates the Interpreter pattern.
 * Parses postfix expressions into {@link Expression} trees and interprets
 * each one, including a nested case combining both operators.
 */
public class TestInterpreter {

    public static void main(String[] args) {
        run("5 3 +");
        run("10 4 -");
        run("5 3 + 2 -");
    }

    private static void run(String postfixExpression) {
        Expression expression = ExpressionParser.parse(postfixExpression);
        System.out.println(postfixExpression + " = " + expression.interpret());
    }
}
