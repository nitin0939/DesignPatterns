package designpatterns.behavioral.chainofresponsibility;

/**
 * Handler (abstract) in the Chain of Responsibility pattern.
 * Each handler decides for itself whether it can resolve a {@link SupportTicket};
 * if not, it passes the ticket to the next handler in the chain — the sender
 * never needs to know which handler will end up resolving a given ticket, or
 * how many links the chain even has.
 */
public abstract class SupportHandler {
    private SupportHandler next;

    /**
     * Links another handler after this one, returning it so calls can be chained
     * (e.g. {@code level1.setNext(level2).setNext(manager)}).
     */
    public SupportHandler setNext(SupportHandler next) {
        this.next = next;
        return next;
    }

    /**
     * Tries to resolve the ticket itself; if it can't, forwards it to the
     * next handler (if any is left).
     */
    public void handle(SupportTicket ticket) {
        if (canHandle(ticket)) {
            resolve(ticket);
        } else if (next != null) {
            System.out.println(getClass().getSimpleName() + " escalating: \"" + ticket.getDescription() + "\"");
            next.handle(ticket);
        } else {
            System.out.println("No handler in the chain could resolve: \"" + ticket.getDescription() + "\"");
        }
    }

    protected abstract boolean canHandle(SupportTicket ticket);

    protected abstract void resolve(SupportTicket ticket);
}
