package designpatterns.behavioral.state;

/**
 * Client class that demonstrates the State pattern.
 * Drives a {@link GumballMachine} through several quarter/crank cycles and
 * an edge case (turning the crank with no quarter inserted), showing the
 * machine's behavior change entirely based on its current state — with no
 * conditional logic in {@link GumballMachine} itself.
 */
public class TestState {

    public static void main(String[] args) {
        GumballMachine machine = new GumballMachine(5);

        machine.insertQuarter();
        machine.turnCrank();

        System.out.println();
        machine.turnCrank();

        System.out.println();
        machine.insertQuarter();
        machine.ejectQuarter();
        machine.turnCrank();

        System.out.println("\nGumballs remaining: " + machine.getCount());
    }
}
