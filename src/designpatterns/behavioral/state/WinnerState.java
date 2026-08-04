package designpatterns.behavioral.state;

/**
 * Concrete State in the State pattern.
 * The rare jackpot state: dispenses two gumballs instead of one.
 */
public class WinnerState implements State {
    private final GumballMachine machine;

    public WinnerState(GumballMachine machine) {
        this.machine = machine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("Please wait, we're already giving you a gumball");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Sorry, you already turned the crank");
    }

    @Override
    public void turnCrank() {
        System.out.println("Turning again doesn't get you another gumball");
    }

    /**
     * Releases two gumballs (if available) instead of the usual one, then
     * transitions like {@link SoldState} would.
     */
    @Override
    public void dispense() {
        System.out.println("YOU'RE A WINNER! You get two gumballs for your quarter");
        machine.releaseBall();
        if (machine.getCount() == 0) {
            machine.setState(machine.getSoldOutState());
        } else {
            machine.releaseBall();
            if (machine.getCount() > 0) {
                machine.setState(machine.getNoQuarterState());
            } else {
                machine.setState(machine.getSoldOutState());
            }
        }
    }
}
