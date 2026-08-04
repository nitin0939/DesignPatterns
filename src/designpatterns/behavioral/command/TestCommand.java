package designpatterns.behavioral.command;

/**
 * Client class that demonstrates the Command pattern.
 * Wires up receivers and their commands, loads them into the
 * {@link RemoteControl}, and exercises the undo button across two different
 * receiver types.
 */
public class TestCommand {

    public static void main(String[] args) {
        RemoteControl remote = new RemoteControl(2);

        Light livingRoomLight = new Light("Living Room");
        LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
        LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLight);
        remote.setCommand(0, livingRoomLightOn, livingRoomLightOff);

        CeilingFan ceilingFan = new CeilingFan("Living Room");
        CeilingFanHighCommand ceilingFanHigh = new CeilingFanHighCommand(ceilingFan);
        CeilingFanOffCommand ceilingFanOff = new CeilingFanOffCommand(ceilingFan);
        remote.setCommand(1, ceilingFanHigh, ceilingFanOff);

        remote.onButtonPushed(0);
        remote.offButtonPushed(0);
        System.out.println("--undo--");
        remote.undoButtonPushed();

        System.out.println();
        remote.onButtonPushed(1);
        System.out.println("--undo--");
        remote.undoButtonPushed();
    }
}
