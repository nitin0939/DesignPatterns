package designpatterns.behavioral.interpreter;

/**
 * Abstract Expression in the Interpreter pattern.
 * (Head First Design Patterns only covers Interpreter briefly, in its
 * "leftover patterns" chapter, without a fully worked example — this is a
 * book-style example built for this repo, not a verbatim one.)
 * Every node of the parsed expression tree — a single number or an
 * operation combining two sub-expressions — knows how to evaluate itself.
 */
public interface Expression {

    int interpret();
}
