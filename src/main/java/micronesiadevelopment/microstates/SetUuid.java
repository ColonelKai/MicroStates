package micronesiadevelopment.microstates;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class SetUuid  implements Listener {

    public void onJoin (PlayerJoinEvent event) {
        Worker.setPlayerUuidData(event.getPlayer());
    }

}
