import java.util.ArrayList;
import java.util.List;

// Client code
public class Task11_RemoteControlClient {
    public static void main(String[] args) {
        RemoteControl remoteControl = new RemoteControl();

        // Create electronic devices
        TV tv = new TV();
        Stereo stereo = new Stereo();

        // Create commands
        Command turnOnTV = new TurnOnCommand(tv);
        Command turnOffTV = new TurnOffCommand(tv);
        Command increaseVolume = new IncreaseVolumeCommand(stereo);
        Command decreaseVolume = new DecreaseVolumeCommand(stereo);

        // Set commands for remote buttons
        remoteControl.setCommand(0, turnOnTV, turnOffTV);
        remoteControl.setCommand(1, increaseVolume, decreaseVolume);

        // Press remote buttons
        remoteControl.pressButton(0); // Turns on the TV
        remoteControl.pressButton(1); // Increases stereo volume
        remoteControl.pressButton(1); // Increases stereo volume
        remoteControl.pressButton(0); // Turns off the TV
    }
}

// Receiver: Electronic devices
class TV {
    public void turnOn() {
        System.out.println("TV is on.");
    }

    public void turnOff() {
        System.out.println("TV is off.");
    }
}

class Stereo {
    private int volume = 0;

    public void increaseVolume() {
        volume++;
        System.out.println("Stereo volume increased to " + volume);
    }

    public void decreaseVolume() {
        volume--;
        System.out.println("Stereo volume decreased to " + volume);
    }
}

// Command interface
interface Command {
    void execute();
}

// Concrete Command to turn on a TV
class TurnOnCommand implements Command {
    private TV tv;

    public TurnOnCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.turnOn();
    }
}

// Concrete Command to turn off a TV
class TurnOffCommand implements Command {
    private TV tv;

    public TurnOffCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.turnOff();
    }
}

// Concrete Command to increase volume on a stereo
class IncreaseVolumeCommand implements Command {
    private Stereo stereo;

    public IncreaseVolumeCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    @Override
    public void execute() {
        stereo.increaseVolume();
    }
}

// Concrete Command to decrease volume on a stereo
class DecreaseVolumeCommand implements Command {
    private Stereo stereo;

    public DecreaseVolumeCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    @Override
    public void execute() {
        stereo.decreaseVolume();
    }
}

// Invoker: Remote control
class RemoteControl {
    private List<Command> onCommands;
    private List<Command> offCommands;

    public RemoteControl() {
        onCommands = new ArrayList<>();
        offCommands = new ArrayList<>();
    }

    public void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands.add(slot, onCommand);
        offCommands.add(slot, offCommand);
    }

    public void pressButton(int slot) {
        onCommands.get(slot).execute();
    }
}
