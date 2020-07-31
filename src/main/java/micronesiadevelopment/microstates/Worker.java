package micronesiadevelopment.microstates;

import org.bukkit.entity.Player;

public class Worker {

    public static String getUUIDString(String player) {
        return  MicroStates.getInstance().uuid.getString(player.toLowerCase());
    }
    public static String getPlayer(String uuid) {
        return  MicroStates.getInstance().uuid.getString(uuid);
    }

    public static void setPlayerUuidData(Player player) {
        MicroStates.getInstance().uuid.set(player.getUniqueId().toString(), player.getName());
        MicroStates.getInstance().uuid.set(player.getName().toLowerCase(), player.getUniqueId().toString());
        MicroStates.getInstance().SaveUUIDFile();
    }

}
