package cn.peter.design.command;

/**
 * @author Peter Yu
 * @date 2018/5/8 19:09
 */
public class MainDemo {

    public static void main(String[] args) {
        RemoteControl remoteControl = new RemoteControl();
        Light light = new Light();
        GarageDoor garageDoor = new GarageDoor();
        LightOnCommand lightOnCommand = new LightOnCommand(light);
        LightOffCommand lightOffCommand = new LightOffCommand(light);
        GarageDoorOpenCommand garageDoorOpenCommand = new GarageDoorOpenCommand(garageDoor);
        GarageDoorCloseCommand garageDoorCloseCommand = new GarageDoorCloseCommand(garageDoor);

        int lightIndex = remoteControl.setCommand(lightOnCommand, lightOffCommand);
        int garageIndex = remoteControl.setCommand(garageDoorOpenCommand, garageDoorCloseCommand);

        remoteControl.pressOnButton(lightIndex);
        remoteControl.pressOnButton(garageIndex);

        remoteControl.pressOffButton(lightIndex);
        remoteControl.pressOffButton(garageIndex);

    }
}
