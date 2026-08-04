package designpatterns.structural.bridge;

/**
 * Client class that demonstrates the Bridge pattern.
 * Shows the same {@link RemoteControl}/{@link AdvancedRemoteControl}
 * hierarchy working against two unrelated {@link Device} implementations,
 * and the refined abstraction's extra feature working regardless of which
 * device is plugged in underneath.
 */
public class TestBridge {

    public static void main(String[] args) {
        Device tv = new Tv();
        RemoteControl basicRemote = new RemoteControl(tv);
        basicRemote.togglePower();
        basicRemote.channelUp();
        basicRemote.volumeUp();

        System.out.println();

        Device radio = new Radio();
        AdvancedRemoteControl advancedRemote = new AdvancedRemoteControl(radio);
        advancedRemote.togglePower();
        advancedRemote.volumeUp();
        advancedRemote.mute();
    }
}
