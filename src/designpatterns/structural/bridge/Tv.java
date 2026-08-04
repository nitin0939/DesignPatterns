package designpatterns.structural.bridge;

/**
 * Concrete Implementor in the Bridge pattern.
 */
public class Tv implements Device {
    private boolean enabled;
    private int volume = 30;
    private int channel = 1;

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public void enable() {
        enabled = true;
        System.out.println("TV: turning on");
    }

    @Override
    public void disable() {
        enabled = false;
        System.out.println("TV: turning off");
    }

    @Override
    public int getVolume() {
        return volume;
    }

    @Override
    public void setVolume(int percent) {
        volume = Math.max(0, Math.min(100, percent));
        System.out.println("TV: volume set to " + volume);
    }

    @Override
    public int getChannel() {
        return channel;
    }

    @Override
    public void setChannel(int channel) {
        this.channel = channel;
        System.out.println("TV: switched to channel " + channel);
    }
}
