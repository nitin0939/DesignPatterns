package designpatterns.structural.bridge;

/**
 * Concrete Implementor in the Bridge pattern.
 * A second, unrelated device type — proving the same remote control
 * hierarchy works against any {@link Device}, not just a TV.
 */
public class Radio implements Device {
    private boolean enabled;
    private int volume = 20;
    private int channel = 88;

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public void enable() {
        enabled = true;
        System.out.println("Radio: turning on");
    }

    @Override
    public void disable() {
        enabled = false;
        System.out.println("Radio: turning off");
    }

    @Override
    public int getVolume() {
        return volume;
    }

    @Override
    public void setVolume(int percent) {
        volume = Math.max(0, Math.min(100, percent));
        System.out.println("Radio: volume set to " + volume);
    }

    @Override
    public int getChannel() {
        return channel;
    }

    @Override
    public void setChannel(int channel) {
        this.channel = channel;
        System.out.println("Radio: tuned to " + channel + " FM");
    }
}
