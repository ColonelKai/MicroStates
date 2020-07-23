package micronesiadevelopment.microstates;

import org.bukkit.entity.Player;
import org.bukkit.Bukkit;

import java.util.ArrayList;
import java.util.List;

public class State {

    //some variables for later, i guess, i have no idea what im doing.
    private String name;
    private String full_name;
    private String owner;
    private double balance;
    private int id;
    private List<String> citizen_list = new ArrayList<String>();
    private List<String> mod_list = new ArrayList<String>();
    private List<String> citizen_name_list = new ArrayList<String>();
    private List<String> mod_name_list = new ArrayList<String>();
    private String owner_name;

    //TODO add the citizen_name_list and mod_name_list to all the add/remove and savedata subjects.

    public State() {}
    public State(String stateName) {
    	@SuppressWarnings("unchecked")
		List<Object> dataArray = (List<Object>) MicroStates.getInstance().Data.getList(stateName);
    	name = (String) dataArray.get(0);
    	full_name = (String) dataArray.get(1);
    	owner = (String) dataArray.get(2);
    	balance = (double) dataArray.get(3);
    	id = (int) dataArray.get(4);
    	citizen_list = (List<String>) dataArray.get(5);
    	mod_list = (List<String>) dataArray.get(6);
    	citizen_name_list = (List<String>) dataArray.get(7);
    	mod_name_list = (List<String>) dataArray.get(8);
    	owner_name = (String) dataArray.get(9);
    }
    
    public void getFromFile(String stateName) {
    	@SuppressWarnings("unchecked")
		List<Object> dataArray = (List<Object>) MicroStates.getInstance().Data.getList(stateName);
    	name = (String) dataArray.get(0);
    	full_name = (String) dataArray.get(1);
    	owner = (String) dataArray.get(2);
    	balance = (double) dataArray.get(3);
    	id = (int) dataArray.get(4);
    	citizen_list = (List<String>) dataArray.get(5);
    	mod_list = (List<String>) dataArray.get(6);
        citizen_name_list = (List<String>) dataArray.get(7);
        mod_name_list = (List<String>) dataArray.get(8);
        owner_name = (String) dataArray.get(9);
    }
    
    public void getFromFile(List<Object> dataArray) {
    	name = (String) dataArray.get(1);
    	full_name = (String) dataArray.get(2);
    	owner = (String) dataArray.get(3);
    	balance = (double) dataArray.get(4);
    	id = (int) dataArray.get(5);
    	citizen_list = (List<String>) dataArray.get(6);
    	mod_list = (List<String>) dataArray.get(7);
        citizen_name_list = (List<String>) dataArray.get(7);
        mod_name_list = (List<String>) dataArray.get(8);
        owner_name = (String) dataArray.get(9);
    }
    
    // always pass this when you create a state. Dont forget this. Retard. You are a retard if you forget.
    public boolean setUpState(){
        balance = 0;
        full_name = "No name set";
        return true;
    }

    // --- CITIZEN/MOD LIST ADD/REMOVE GET FUNCTIONS
    // there probably is a cleaner way to do these, but hey, fuck you, future me.
    public boolean addCitizen(String playerid) { //add player to citizen
        if(citizen_list.contains(playerid)){return false;} //if already part, return false.
        else{citizen_list.add(playerid); citizen_name_list.add(Bukkit.getPlayer(playerid).getDisplayName()); return true;} // if not, add and return true.
    }

    public boolean removeCitizen(String playerid) { //remove player from citizen
        if (citizen_list.contains(playerid)) {
            citizen_list.remove(playerid); citizen_name_list.remove(Bukkit.getPlayer(playerid).getDisplayName()); return true;} //if part of it, remove and return true
        else {return false;} //if not part, return false
    }

    public List<String> getCitizenList(){return citizen_list;} //just give my boy the citizen list.

    public List<String> getCitizenNameList(){return citizen_name_list;}

    public boolean addMod(String playerid) { //add player to mod
        if(mod_list.contains(playerid)){return false;} //if already part, return false.
        else{mod_list.add(playerid); mod_name_list.add(Bukkit.getPlayer(playerid).getDisplayName()); return true;} // if not, add and return true.
    }

    public boolean removeMod(String playerid) { //remove player from mod
        if (mod_list.contains(playerid)) {
            mod_list.remove(playerid); mod_name_list.remove(Bukkit.getPlayer(playerid).getDisplayName()); return true;} //if part of it, remove and return true
        else {return false;} //if not part, return false
    }

    public List<String> getModList(){return mod_list;} //just give my boy the mod list.

    public List<String> getModNameList() {
        return mod_name_list;
    }

    //owner shit i guess idk
    public boolean setOwner(String playerid){
        if(owner == playerid){
            return false;
        }
        else{
            owner = playerid;
            owner_name = Bukkit.getPlayer(playerid).getDisplayName();
            return true;
        }
    }

    public String getOwner(){
        return owner;
    }

    public String getOwnerName(){
        return owner_name;
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

    public double getMoney(){
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

    public ArrayList<Object> getData() {
    	ArrayList<Object> dataArray = new ArrayList<Object>();

        dataArray.add((Object)name);;
        dataArray.add((Object)full_name);
        dataArray.add((Object)owner);
        dataArray.add((Object)balance);
        dataArray.add((Object)id);
        dataArray.add((Object)citizen_list);
        dataArray.add((Object)mod_list);
        dataArray.add((Object)citizen_name_list);
        dataArray.add((Object)mod_name_list);
        dataArray.add((Object)owner_name);
    	
    	
    	return dataArray;
    }
    
    public static boolean stateExsistsOnDisk(String stateName) {
    	if (MicroStates.getInstance().Data.getList(stateName) != null){
    		return true;
    	} else {
    		return false;
    	}
    }
    
    public void save() {
    	
    	MicroStates.getInstance().Data.set((String) this.getData().get(0), this.getData());
	    MicroStates.getInstance().SaveDataFile();
    }

}
