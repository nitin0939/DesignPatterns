package designpatterns.behavioral.chainofresponsibility;

/**
 * Concrete Handler in the Chain of Responsibility pattern.
 * Handles moderately complex tickets that Level 1 couldn't.
 */
public class Level2Support extends SupportHandler {

    @Override
    protected boolean canHandle(SupportTicket ticket) {
        return ticket.getPriority() <= 2;
    }

    @Override
    protected void resolve(SupportTicket ticket) {
        System.out.println("Level2Support resolved: \"" + ticket.getDescription() + "\"");
    }
}
