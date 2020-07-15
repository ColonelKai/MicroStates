package micronesiadevelopment.microstates;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class State {

    //some variables for later, i guess, i have no idea what im doing.
    private String name;
    private String full_name;
    private UUID owner;
    private double balance;
    private int id;
    private List<Player> citizen_list = new ArrayList<Player>();
    private List<UUID> mod_list = new ArrayList<UUID>();

    public State() {}
    public State(String stateName) {
    	@SuppressWarnings("unchecked")
		List<Object> dataArray = (List<Object>) MicroStates.getInstance().Data.getList(stateName);
    	name = (String) dataArray.get(0);
    	full_name = (String) dataArray.get(1);
    	owner = (UUID) dataArray.get(2);
    	balance = (double) dataArray.get(3);
    	id = (int) dataArray.get(4);
    	citizen_list = (List<Player>) dataArray.get(5);
    	mod_list = (List<UUID>) dataArray.get(6);
    }
    
    public void getFromFile(String stateName) {
    	@SuppressWarnings("unchecked")
		List<Object> dataArray = (List<Object>) MicroStates.getInstance().Data.getList(stateName);
    	name = (String) dataArray.get(0);
    	full_name = (String) dataArray.get(1);
    	owner = (UUID) dataArray.get(2);
    	balance = (double) dataArray.get(3);
    	id = (int) dataArray.get(4);
    	citizen_list = (List<Player>) dataArray.get(5);
    	mod_list = (List<UUID>) dataArray.get(6);
    }
    
    public void getFromFile(List<Object> dataArray) {
    	name = (String) dataArray.get(1);
    	full_name = (String) dataArray.get(2);
    	owner = (UUID) dataArray.get(3);
    	balance = (double) dataArray.get(4);
    	id = (int) dataArray.get(5);
    	citizen_list = (List<Player>) dataArray.get(6);
    	mod_list = (List<UUID>) dataArray.get(7);
    }
    
    // always pass this when you create a state. Dont forget this. Retard. You are a retard if you forget.
    public boolean setUpState(){
        balance = 0;
        return true;
    }

    // --- CITIZEN/MOD LIST ADD/REMOVE GET FUNCTIONS
    // there probably is a cleaner way to do these, but hey, fuck you, future me.
    public boolean addCitizen(Player player) { //add player to citizen
        if(citizen_list.contains(player)){return false;} //if already part, return false.
        else{citizen_list.add(player); return true;} // if not, add and return true.
    }

    public boolean removeCitizen(Player player) { //remove player from citizen
        if (citizen_list.contains(player)) {citizen_list.remove(player); return true;} //if part of it, remove and return true
        else {return false;} //if not part, return false
    }

    public List<Player> getCitizenList(){return citizen_list;} //just give my boy the citizen list.

    public boolean addMoU(UUID player) { //add player to mod
        if(mod_list.contains(player)){return false;} //if already part, return false.
        else{mod_list.add(player); return true;} // if not, add and return true.
    }

    public boolean removeMod(UUID player) { //remove player from mod
        if (mod_list.contains(player)) {mod_list.remove(player); return true;} //if part of it, remove and return true
        else {return false;} //if not part, return false
    }

    public List<UUID> getModList(){return mod_list;} //just give my boy the mod list.

    //owner shit i guess idk
    public boolean setOwner(UUID player){
        if(owner == player){
            return false;
        }
        else{
            owner = player;
            return true;
        }
    }

    public UUID getOwner(){
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

    public double getMoney(double amount){
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
    }

}
