import java.util.ArrayList;

public class Player {
    private ArrayList<Tool> inventory;
    private Room location;

    /*
     * Player constructor, initializes inventory arraylist
     * @param location
     */
    public Player(Room location){
        this.inventory = new ArrayList<Tool>();
        this.location = location;
    }

    /*
     * accessor to get Player location
     * @return location
     */
    public Room getLocation(){
        return this.location;
    }

    /*
     * sets the player's current location to the specified room
     * @param Room r
     * @return Room r
     */
    public Room setLocation(Room r){
        this.location = r;
        return r;
    }

    /*
     * tries to add the specified tool to the player inventory, catches exception if thrown
     * @param Tool t
     * @return boolean 
     */
    public boolean pickUpTool(Tool t){
        try{
            this.inventory.add(this.location.removeTool(t));
            return true;
        }
        catch(Exception e){
            System.out.println("This tool is not in this room.");
            return false;
        }
    }

    public boolean dropTool(Tool t){
       if (this.inventory.contains(t)){
           this.inventory.remove(this.location.addTool(t));
           this.location.computeCompleted();
           return true;
        }
        else{
            return false;
        }
    }

    /*
     * if inventory is empty prints a message stating so, otherwise prints contents of inventory
     */
    public void printInventory(){
        if (this.inventory.isEmpty() == true){
            System.out.println("There is nothing in your inventory. Go explore.");
        }
        else{
            for (Tool t : this.inventory){
            System.out.println("- " + t.getName());
            }
        }
    }

    /*
     * prints out the player's location and room contentss
     */
    public void explore(){
        System.out.println("You are in the " + this.location + ", containing:");
        this.location.listThings();
    }


}
