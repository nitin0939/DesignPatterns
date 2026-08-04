package designpatterns.behavioral.state;

/**
 * State in the State pattern (Head First's Gumball Machine example).
 * Declares one method per action the machine can be asked to perform;
 * each concrete state decides what actually happens for that action,
 * including which state to transition to next.
 */
public interface State {

    void insertQuarter();

    void ejectQuarter();

    void turnCrank();

    void dispense();
}
