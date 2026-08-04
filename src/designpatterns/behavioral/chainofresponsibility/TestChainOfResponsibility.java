package designpatterns.behavioral.chainofresponsibility;

/**
 * Client class that demonstrates the Chain of Responsibility pattern.
 * Submits tickets of increasing priority into the front of the chain and
 * shows each one escalating only as far as necessary to get resolved.
 */
public class TestChainOfResponsibility {

    public static void main(String[] args) {
        SupportHandler level1 = new Level1Support();
        SupportHandler level2 = new Level2Support();
        SupportHandler manager = new ManagerSupport();

        level1.setNext(level2).setNext(manager);

        level1.handle(new SupportTicket("Forgot password", 1));
        System.out.println();
        level1.handle(new SupportTicket("Application crashing on startup", 2));
        System.out.println();
        level1.handle(new SupportTicket("Billing dispute over $10,000 invoice", 3));
    }
}
