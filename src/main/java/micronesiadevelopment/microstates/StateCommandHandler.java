package micronesiadevelopment.microstates;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.ChatColor;

public class StateCommandHandler implements CommandExecutor {

    //main command function -ColonelKai
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(args.length<=0){sender.sendMessage(ChatColor.BLUE + "[MicroStates]" + ChatColor.RED + " Unknown command, /state help for help.");}

        else if(args[0].equals("info")){sender.sendMessage(ChatColor.BLUE + "[MicroStates]" + ChatColor.WHITE + " Running Version Alpha 0.2");}

        else{sender.sendMessage(ChatColor.BLUE + "[MicroStates]" + ChatColor.RED + " Unknown command, /state help for help.");}

        //obligatory return
        return true;
    }
}
