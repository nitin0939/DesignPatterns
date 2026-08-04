package designpatterns.behavioral.chainofresponsibility;

/**
 * Concrete Handler in the Chain of Responsibility pattern.
 * Handles the routine, low-priority tickets, and lets everything else escalate.
 */
public class Level1Support extends SupportHandler {

    @Override
    protected boolean canHandle(SupportTicket ticket) {
        return ticket.getPriority() <= 1;
    }

    @Override
    protected void resolve(SupportTicket ticket) {
        System.out.println("Level1Support resolved: \"" + ticket.getDescription() + "\"");
    }
}
