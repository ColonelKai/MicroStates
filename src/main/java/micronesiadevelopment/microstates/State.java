package micronesiadevelopment.microstates;

import com.google.gson.internal.bind.util.ISO8601Utils;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class State {

    //some variables for later, i guess, i have no idea what im doing.
    private String name;
    private String full_name;
    private Player owner;
    private int balance;
    private int id;
    private List<Player> citizen_list = new ArrayList<Player>();
    private List<Player> mod_list = new ArrayList<Player>();

    // --- CITIZEN/MOD LIST ADD/REMOVE GET FUNCTIONS

    public boolean addCitizen(Player player) { //add player to citizen
        if(citizen_list.contains(player)){return false;} //if already part, return false.
        else{citizen_list.add(player); return true;} // if not, add and return true.
    }

    public boolean removeCitizen(Player player) { //remove player from citizen
        if (citizen_list.contains(player)) {citizen_list.remove(player); return true;} //if part of it, remove and return true
        else {return false;} //if not part, return false
    }

    public ArrayList getCitizenList(){return (ArrayList) citizen_list;} //just give my boy the citizen list.

    public boolean addMod(Player player) { //add player to mod
        if(mod_list.contains(player)){return false;} //if already part, return false.
        else{mod_list.add(player); return true;} // if not, add and return true.
    }

    public boolean removeMod(Player player) { //remove player from mod
        if (mod_list.contains(player)) {mod_list.remove(player); return true;} //if part of it, remove and return true
        else {return false;} //if not part, return false
    }

    public ArrayList getModList(){return (ArrayList) mod_list;} //just give my boy the mod list.

    //owner shit i guess idk
    public boolean setOwner(Player player){
        if(owner == player){
            return false;
        }
        else{
            owner = player;
            return true;
        }
    }

    public Player getOwner(){
        return owner;
    }

    // --- FUNCTIONS TO SET DETAILS (Such as name, balance, etc.)


    public boolean setID(int newid){
        id = newid;
        return true;
    }

    public int getID(){return id;}

    public boolean addMoney(int amount){
        balance += amount;
        return true;
    }

    public boolean reduceMoney(int amount){
        if(balance < amount){return false;}
        else{balance -= amount; return true;}
    }

    public int getMoney(int amount){
        return balance;
    }

    public boolean changeName(String newname){
        if(!newname.isEmpty()){name = newname; return true;}
        else{return false;}
    }

    public boolean changeFullName(String newfullname){
        if(!newfullname.isEmpty()){full_name = newfullname; return true;}
        else{return false;}
    }

    public String getName(){return name;}

    public String getFullName(){return full_name;}


}
