package designpatterns.structural.bridge;

/**
 * Refined Abstraction in the Bridge pattern.
 * Extends {@link RemoteControl} with an extra feature, without needing any
 * changes to the {@link Device} hierarchy — proving the two hierarchies vary
 * independently.
 */
public class AdvancedRemoteControl extends RemoteControl {

    public AdvancedRemoteControl(Device device) {
        super(device);
    }

    /**
     * A feature only this remote has — mutes by remembering the current
     * volume isn't needed here since setting to 0 is enough for the demo.
     */
    public void mute() {
        device.setVolume(0);
    }
}
