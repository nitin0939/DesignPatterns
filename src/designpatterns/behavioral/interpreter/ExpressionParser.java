package designpatterns.behavioral.interpreter;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Builds an {@link Expression} tree out of a postfix (Reverse Polish
 * Notation) expression string, e.g. {@code "5 3 + 2 -"} for {@code (5 + 3) - 2}.
 * Not itself part of the classic Interpreter roles — this is the "parser"
 * that produces the sentence (the expression tree) the pattern then interprets.
 */
public class ExpressionParser {

    /**
     * Parses a space-separated postfix expression into an {@link Expression} tree.
     * Numbers push a {@link NumberExpression}; operators pop the two most
     * recent expressions off the stack and combine them into a new node,
     * which is then pushed back on.
     */
    public static Expression parse(String postfixExpression) {
        Deque<Expression> stack = new ArrayDeque<>();

        for (String token : postfixExpression.split("\\s+")) {
            switch (token) {
                case "+" -> {
                    Expression right = stack.pop();
                    Expression left = stack.pop();
                    stack.push(new AddExpression(left, right));
                }
                case "-" -> {
                    Expression right = stack.pop();
                    Expression left = stack.pop();
                    stack.push(new SubtractExpression(left, right));
                }
                default -> stack.push(new NumberExpression(Integer.parseInt(token)));
            }
        }

        return stack.pop();
    }
}
