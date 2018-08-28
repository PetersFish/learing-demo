package cn.peter.design.command;

/**
 * @author Peter Yu
 * @date 2018/5/8 18:52
 */
public class LightOnCommand implements Command {

    private Light light;

    public LightOnCommand(Light light){
        this.light = light;
    }

    public void execute() {
        light.on();
    }

}
