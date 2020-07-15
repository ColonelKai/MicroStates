package micronesiadevelopment.microstates;

import org.bukkit.plugin.java.JavaPlugin;

//import State.java
import micronesiadevelopment.microstates.StateCommandHandler;

//Hello, the person reading this. Poor you.
//This is my first time let alone writing a plugin, but a java program.
//God bless your soul, my child.
//And good luck reading this hot mess.


public final class MicroStates extends JavaPlugin {

    //TODO check for config files and if there isn't, create one.
    public void onEnable() {
        //state command defining
        //i literally have no idea why this gave an error earlier, i only
        //know that it doesnt anymore, and that makes me happy.
        //if it works, it works.
        this.getCommand("state").setExecutor(new StateCommandHandler());


    }
    //TODO idk, find a reason to use this.
    public void onDisable() {
    }
}
