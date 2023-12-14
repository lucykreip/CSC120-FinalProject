import java.util.ArrayList;

public class Player {
    private ArrayList<Tool> inventory;
    private Room location;

    public Player(Room location){
        this.inventory = new ArrayList<Tool>();
        this.location = location;
    }

    public Room getLocation(){
        return this.location;
    }

    public Room setLocation(Room r){
        this.location = r;
        return r;
    }

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
        this.inventory.remove(this.location.addTool(t));
        this.location.computeCompleted();
        return true;
        //try catch it baby
    }

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

    public void explore(){
        System.out.println("You are in the " + this.location + ", containing:");
        this.location.listThings();
    }

    public static void main(String[] args) {
        Tool hammer = new Tool(ToolKey.HAMMER, "hammer");
        Appliance table = new Appliance("Table", hammer);
        Room r = new Room(RoomKey.DINING,"Dining Room", table);
        Tool a = new Tool(ToolKey.SCREWDRIVER, "screwdriver");
        Player me = new Player(r);
        me.pickUpTool(a);
        me.printInventory();
        me.dropTool(a);
        me.printInventory();
        Tool sponge = new Tool(ToolKey.SPONGE, "sponge");
        me.pickUpTool(sponge);
        Appliance wm = new Appliance("Washing Machine", sponge);
        System.out.println(wm);
        me.printInventory();
        r.addTool(hammer);
        r.computeCompleted();
        me.explore();
        System.out.println(r.getCompletedOrNot());
    }


}
