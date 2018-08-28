package cn.peter.design.command;

/**
 * @author Peter Yu
 * @date 2018/5/8 19:06
 */
public class GarageDoorOpenCommand implements Command {

    private GarageDoor garageDoor;

    public GarageDoorOpenCommand(GarageDoor garageDoor){
        this.garageDoor = garageDoor;
    }

    public void execute() {
        garageDoor.open();
    }
}
