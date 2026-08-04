package designpatterns.behavioral.chainofresponsibility;

/**
 * Concrete Handler in the Chain of Responsibility pattern.
 * The end of the chain in this example — handles anything that made it this
 * far, regardless of priority.
 */
public class ManagerSupport extends SupportHandler {

    @Override
    protected boolean canHandle(SupportTicket ticket) {
        return true;
    }

    @Override
    protected void resolve(SupportTicket ticket) {
        System.out.println("ManagerSupport resolved: \"" + ticket.getDescription() + "\"");
    }
}
