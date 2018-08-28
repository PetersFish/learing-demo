package cn.peter.design.command;

/**
 * @author Peter Yu
 * @date 2018/5/8 19:36
 */
public class LightOffCommand implements Command {

    private Light light;

    public LightOffCommand(Light light){
        this.light = light;
    }

    public void execute() {
        light.off();
    }
}
