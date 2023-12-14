import java.util.ArrayList;

public class Room {
    private RoomKey id;
    private String name;
    private Appliance applianceInRoom;
    private boolean completedOrNot;
    private ArrayList<Thing> thingsWithin;
    // private Hashtable< Appliance, Tool> appliancesWithin;
    //location 


    public Room(RoomKey id, String name, Appliance applianceInRoom){
        this.id = id;
        this.name = name;
        this.applianceInRoom = applianceInRoom;
        this.completedOrNot = false;
        this.thingsWithin = new ArrayList<Thing>();
        this.thingsWithin.add(applianceInRoom);
    }

    public String getName(){
        return this.name;
    }

    public RoomKey getID(){
        return this.id;
    }

    public Appliance getApplianceInRoom(){
        return this.applianceInRoom;
    }

    public boolean getCompletedOrNot(){
        return this.completedOrNot;
    }

    public Tool addTool(Tool t){
        if (! this.thingsWithin.contains(t)){
            this.thingsWithin.add(t);
        }
        else{
            System.out.println("Woah...this tool is already here...");
        }
        return t;
    }

    public Tool removeTool(Tool t){
        if (this.thingsWithin.contains(t)){
            this.thingsWithin.remove(t);
            return t;
        }
        else{
            throw new RuntimeException("Tool not here.");
        }
    }

    public void listThings(){
        if (this.thingsWithin.isEmpty() == true){
            System.out.println("There are no things in this room");
        }
        else{
            for ( Thing t: this.thingsWithin){
                System.out.println("- " + t.getName());
            }
        }
    }

    public boolean computeCompleted(){
        Tool t = this.applianceInRoom.getExpectedTool();
        this.completedOrNot = this.thingsWithin.contains(t);
        return this.completedOrNot;
    }

    public String toString(){
        return this.name;
    }
}
