package micronesiadevelopment.microstates;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class StateCommandHandler implements CommandExecutor {

    //main command function -ColonelKai
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(args.length<=0){sender.sendMessage(ChatColor.BLUE + "[MicroStates]" + ChatColor.RED + " Unknown command, /state help for help.");}

        else if(args[0].equals("info")){sender.sendMessage(ChatColor.BLUE + "[MicroStates]" + ChatColor.WHITE + " Running Version Alpha 0.4");}


        //this is where the suffering begins.
        //piece of code that will create and save a state.
        else if(args[0].equals("create")){
            if(args.length == 3){
                //Create Stuff. I guess. I don't fucking know.
            	String state_name = args[1];
            	State newstate = new State();

                if(sender.hasPermission("states.admin")){
                    if (!State.stateExsistsOnDisk(state_name)) {
                        Player owner = Bukkit.getPlayerExact(args[2]);

                        //Hehe lets get this boi going. This sets up some values that needs to be set.
                        newstate.setOwner(owner.getUniqueId());
                        newstate.changeName(state_name);
                        newstate.setUpState();
                        sender.sendMessage(ChatColor.BLUE + "[MicroStates] " + ChatColor.WHITE + "Registered State: " + state_name);
                    } else {
                        newstate.getFromFile(state_name);
                        sender.sendMessage(ChatColor.BLUE + "[MicroStates] " + ChatColor.RED + "A state with that name already exists.");
                    }
                    newstate.save();
                } else {
                    sender.sendMessage(ChatColor.BLUE + "[MicroStates] " + ChatColor.RED + "You dont have permission to do that.");
                }

            } else {
                sender.sendMessage(ChatColor.BLUE + "[MicroStates] " + ChatColor.RED + "Usage: /state create [state name] [owner]");
                }
            }

        else if(args[0].equals("show")){
            if(args.length == 2){
                State stateobj = new State();
                stateobj.getFromFile(args[1]);

                sender.sendMessage(ChatColor.BLUE + "[MicroStates] " + ChatColor.WHITE + "State Information:");
                sender.sendMessage(ChatColor.BLUE + "Name: " + ChatColor.WHITE + stateobj.getName());
                sender.sendMessage(ChatColor.BLUE + "Full Name: " + ChatColor.WHITE + stateobj.getFullName());
                sender.sendMessage(ChatColor.BLUE + "Owner: " + ChatColor.WHITE + stateobj.getOwnerName());
                sender.sendMessage(ChatColor.BLUE + "Balance: " + ChatColor.WHITE + stateobj.getMoney());
                sender.sendMessage(ChatColor.BLUE + "Number of Mods: " + ChatColor.WHITE + stateobj.getModList().size());
                sender.sendMessage(ChatColor.BLUE + "Number of Citizen: " + ChatColor.WHITE + stateobj.getCitizenList().size() + "\n");
            }

        }


        else{sender.sendMessage(ChatColor.BLUE + "[MicroStates] " + ChatColor.RED + " Unknown command, /state help for help.");}

        //obligatory return
        return true;
    }
}
