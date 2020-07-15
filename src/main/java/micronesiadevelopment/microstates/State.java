package micronesiadevelopment.microstates;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class State implements CommandExecutor {

    //main command function -ColonelKai
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        //some placeholder code for now.

        sender.sendMessage("&4This command is under work, please try again later.");

        //obligatory return
        return true;
    }
}
