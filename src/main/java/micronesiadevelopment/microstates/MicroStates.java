package micronesiadevelopment.microstates;

import org.bukkit.plugin.java.JavaPlugin;

//import State.java
import micronesiadevelopment.microstates.StateCommandHandler;

public final class MicroStates extends JavaPlugin {

    //TODO check for config files and if there isn't, create one.
    public void onEnable() {
        //state command defining
        this.getCommand("state").setExecutor(new StateCommandHandler());


    }
    //TODO idk, find a reason to use this.
    public void onDisable() {
    }
}
