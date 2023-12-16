import java.util.ArrayList;

public class Room {
    private RoomKey id;
    private String name;
    private Appliance applianceInRoom;
    private boolean completedOrNot;
    private ArrayList<Thing> thingsWithin;

    /*
     * constructs a new room, initializes the arraylist housing the things within it, and adds the appliance in the room to the list. 
     * @param RoomKey id, String name, Appliance applianceInRoom 
     */
    public Room(RoomKey id, String name, Appliance applianceInRoom){
        this.id = id;
        this.name = name;
        this.applianceInRoom = applianceInRoom;
        this.completedOrNot = false;
        this.thingsWithin = new ArrayList<Thing>();
        this.thingsWithin.add(applianceInRoom);
    }

    /*
     * accessor for the room's name
     * @return String this.name
     */
    public String getName(){
        return this.name;
    }

    /*
     * accessor or the room's RoomKey id
     * @return RoomKey this.id
     */
    public RoomKey getID(){
        return this.id;
    }

    /*
     * accessor for the appliance in the room
     * @return Appliance this.applianceInRoom
     */
    public Appliance getApplianceInRoom(){
        return this.applianceInRoom;
    }

    /*
     * gets the status of the room's completion
     * @return boolean this.completedOrNot
     */
    public boolean getCompletedOrNot(){
        return this.completedOrNot;
    }

    /*
     * adds the specified tool to the room's thingsWithin arraylist, only if the tool isn't already there. Returns the specified tool.
     * @param Tool t
     * @return Tool t
     */
    public Tool addTool(Tool t){
        if (! this.thingsWithin.contains(t)){
            this.thingsWithin.add(t);
        }
        else{
            System.out.println("Woah...this tool is already here...");
        }
        return t;
    }

    /*
     * removes the specified tool from the room's thingsWithin arraylist, only if the list contains the tool. Returns the specified tool.
     * @param Tool t
     * @return Tool t
     */
    public Tool removeTool(Tool t){
        if (this.thingsWithin.contains(t)){
            this.thingsWithin.remove(t);
            return t;
        }
        else{
            throw new RuntimeException("Tool not here.");
        }
    }

    /*
     * lists the contents of the room, and a message if there is nothing. 
     */
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

    /*
     * determines if the room is completed or not by seeing if the room's arraylist contains the expected tool
     * @return boolean this.completedOrNot
     */
    public boolean computeCompleted(){
        Tool t = this.applianceInRoom.getExpectedTool();
        this.completedOrNot = this.thingsWithin.contains(t);
        return this.completedOrNot;
    }
}
