package designpatterns.behavioral.state;

import java.util.Random;

/**
 * Concrete State in the State pattern.
 * A quarter is in; turning the crank now has a small chance of transitioning
 * to {@link WinnerState} instead of the normal {@link SoldState}.
 */
public class HasQuarterState implements State {
    private final Random random = new Random();
    private final GumballMachine machine;

    public HasQuarterState(GumballMachine machine) {
        this.machine = machine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("You can't insert another quarter");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Quarter returned");
        machine.setState(machine.getNoQuarterState());
    }

    @Override
    public void turnCrank() {
        System.out.println("You turned...");
        if (random.nextInt(10) == 0 && machine.getCount() > 1) {
            machine.setState(machine.getWinnerState());
        } else {
            machine.setState(machine.getSoldState());
        }
    }

    @Override
    public void dispense() {
        System.out.println("No gumball dispensed");
    }
}
