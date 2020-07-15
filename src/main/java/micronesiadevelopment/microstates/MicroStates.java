package micronesiadevelopment.microstates;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

//import State.java


//Hello, the person reading this. Poor you.
//This is my first time let alone writing a plugin, but a java program.
//God bless your soul, my child.
//And good luck reading this hot mess.

    
    
public final class MicroStates extends JavaPlugin {
	private static MicroStates instance;
	
    public static MicroStates getInstance() {
        return instance;
    }
    
	File DataFile;
	FileConfiguration Data;

	public void createData() {
	    DataFile = new File(getDataFolder(), "data.yml");
	    if (!DataFile.exists()) {
	        DataFile.getParentFile().mkdirs();
	        saveResource("data.yml", false);
	    }
	    Data = YamlConfiguration.loadConfiguration(DataFile);
	}

	public void SaveDataFile() {
	    try {
	        Data.save(DataFile);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
    //TODO check for config files and if there isn't, create one.
    public void onEnable() {
    	instance = this;
    	createData();
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
