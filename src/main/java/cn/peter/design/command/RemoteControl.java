package cn.peter.design.command;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Peter Yu
 * @date 2018/5/8 18:56
 */
public class RemoteControl {

    List<Command> onSlots = new ArrayList<Command>();
    List<Command> offSlots = new ArrayList<Command>();

    public int setCommand(Command onCommand, Command offCommand){
        onSlots.add(onCommand);
        offSlots.add(offCommand);
        return offSlots.size()-1;
    }

    public void pressOnButton(int index){
        onSlots.get(index).execute();
    }

    public void pressOffButton(int index){
        offSlots.get(index).execute();
    }
}
