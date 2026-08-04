package designpatterns.structural.bridge;

/**
 * Implementor in the Bridge pattern.
 * (Head First Design Patterns only covers Bridge briefly, in its "leftover
 * patterns" chapter, without a fully worked example — this is a book-style
 * example built for this repo, not a verbatim one.)
 * Declares the low-level operations any controllable device must support,
 * completely independent of how a remote control chooses to expose them.
 */
public interface Device {

    boolean isEnabled();

    void enable();

    void disable();

    int getVolume();

    void setVolume(int percent);

    int getChannel();

    void setChannel(int channel);
}
