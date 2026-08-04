package designpatterns.behavioral.mediator;

/**
 * Mediator in the Mediator pattern.
 * (Head First Design Patterns only covers Mediator briefly, in its "leftover
 * patterns" chapter, without a fully worked example — this is a book-style
 * example built for this repo, not a verbatim one.)
 * Colleagues report events here instead of calling each other directly, so
 * none of them needs a reference to any other colleague.
 */
public interface SmartHomeMediator {

    void notify(Object sender, String event);
}
