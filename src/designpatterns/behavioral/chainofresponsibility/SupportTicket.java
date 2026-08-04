package designpatterns.behavioral.chainofresponsibility;

/**
 * The request object passed along the chain in the Chain of Responsibility pattern.
 * (Head First Design Patterns only covers this pattern briefly, in its
 * "leftover patterns" chapter, without a fully worked example — this is a
 * book-style example built for this repo, not a verbatim one.)
 */
public class SupportTicket {
    private final String description;
    private final int priority;

    public SupportTicket(String description, int priority) {
        this.description = description;
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }
}
