//import java.security.AllPermission;
import java.util.Hashtable;
import java.util.Scanner;

public class Game {
    // hashtable of rooms, 
    // create rooms- hashtable of roomKeys, rooms
    private Hashtable<RoomKey, Room> roomsTable;
    private Hashtable<String, RoomKey> roomsLookup;
    //
    // create appliances- hashtable of applianceKeys, appliances
    private Hashtable<ApplianceKey, Appliance> appliancesTable;
    // create tools- hashtable of toolKeys, tools
    private Hashtable<ToolKey, Tool> toolsTable;

    private Hashtable<String, Tool> toolsLookup;
    // create player- track his location 

    private Hashtable<String, Command> commands;

    private Player player;
    // adding the preliminary tools to each room
    private GameMap gameMap;
    private Scanner scan;
    private int numCompletedRooms;

    public Game(){
        this.toolsTable = new Hashtable<ToolKey, Tool>();
        this.toolsTable.put(ToolKey.PLUNGER, new Tool(ToolKey.PLUNGER, "plunger"));
        this.toolsTable.put(ToolKey.SHEETS, new Tool(ToolKey.SHEETS, "sheets"));
        this.toolsTable.put(ToolKey.HAMMER, new Tool(ToolKey.HAMMER, "hammer"));
        this.toolsTable.put(ToolKey.BROOM, new Tool(ToolKey.BROOM, "broom"));
        this.toolsTable.put(ToolKey.SPONGE, new Tool(ToolKey.SPONGE, "sponge"));
        this.toolsTable.put(ToolKey.SCREWDRIVER, new Tool(ToolKey.SCREWDRIVER, "screwdriver"));

        this.toolsLookup = new Hashtable<String, Tool>();
        this.toolsLookup.put("plunger", toolsTable.get(ToolKey.PLUNGER));
        this.toolsLookup.put("sheets",  toolsTable.get(ToolKey.SHEETS));
        this.toolsLookup.put("hammer",  toolsTable.get(ToolKey.HAMMER));
        this.toolsLookup.put("broom",  toolsTable.get(ToolKey.BROOM));
        this.toolsLookup.put("sponge",  toolsTable.get(ToolKey.SPONGE));
        this.toolsLookup.put("screwdriver",  toolsTable.get(ToolKey.SCREWDRIVER));

        this.appliancesTable = new Hashtable<ApplianceKey, Appliance>();
        this.appliancesTable.put(ApplianceKey.TOILET, new Appliance("clogged toilet", toolsTable.get(ToolKey.PLUNGER)));
        this.appliancesTable.put(ApplianceKey.BED, new Appliance("messy bed", toolsTable.get(ToolKey.SHEETS)));
        this.appliancesTable.put(ApplianceKey.TABLE, new Appliance("broken table", toolsTable.get(ToolKey.HAMMER)));
        this.appliancesTable.put(ApplianceKey.RUG, new Appliance("dusty rug", toolsTable.get(ToolKey.BROOM)));
        this.appliancesTable.put(ApplianceKey.STOVE, new Appliance("dirty stove", toolsTable.get(ToolKey.SPONGE)));
        this.appliancesTable.put(ApplianceKey.LIGHT, new Appliance("flickering light", toolsTable.get(ToolKey.SCREWDRIVER)));
        
        this.roomsTable = new Hashtable<RoomKey, Room>();
        this.roomsTable.put(RoomKey.BATH, new Room(RoomKey.BATH, "bathroom", appliancesTable.get(ApplianceKey.TOILET)));
        this.roomsTable.put(RoomKey.BEDROOM, new Room(RoomKey.BEDROOM, "bedroom", appliancesTable.get(ApplianceKey.BED)));
        this.roomsTable.put(RoomKey.DINING, new Room(RoomKey.DINING, "dining", appliancesTable.get(ApplianceKey.TABLE)));
        this.roomsTable.put(RoomKey.LIVING, new Room(RoomKey.LIVING, "living", appliancesTable.get(ApplianceKey.RUG)));
        this.roomsTable.put(RoomKey.KITCHEN, new Room(RoomKey.KITCHEN, "kitchen", appliancesTable.get(ApplianceKey.STOVE)));
        this.roomsTable.put(RoomKey.ENTRY, new Room(RoomKey.ENTRY, "entryway", appliancesTable.get(ApplianceKey.LIGHT)));

        this.roomsLookup = new Hashtable <String, RoomKey>();
        this.roomsLookup.put("bathroom", RoomKey.BATH);
        this.roomsLookup.put("bedroom", RoomKey.BEDROOM);
        this.roomsLookup.put("dining", RoomKey.DINING);
        this.roomsLookup.put("living", RoomKey.LIVING);
        this.roomsLookup.put("kitchen", RoomKey.KITCHEN);
        this.roomsLookup.put("entryway", RoomKey.ENTRY);

        this.roomsTable.get(RoomKey.BATH).addTool(this.toolsTable.get(ToolKey.SPONGE));
        this.roomsTable.get(RoomKey.BEDROOM).addTool(this.toolsTable.get(ToolKey.HAMMER));
        this.roomsTable.get(RoomKey.DINING).addTool(this.toolsTable.get(ToolKey.BROOM));
        this.roomsTable.get(RoomKey.LIVING).addTool(this.toolsTable.get(ToolKey.SCREWDRIVER));
        this.roomsTable.get(RoomKey.KITCHEN).addTool(this.toolsTable.get(ToolKey.SHEETS));
        this.roomsTable.get(RoomKey.ENTRY).addTool(this.toolsTable.get(ToolKey.PLUNGER));

        this.player = new Player(roomsTable.get(RoomKey.ENTRY));

        this.gameMap = new GameMap();

        this.scan = new Scanner(System.in);

        this.numCompletedRooms = 0;

        this.commands = new Hashtable<String, Command>();
        this.commands.put("grab", new CommandGrab(this.player, this));
        this.commands.put("drop", new CommandDrop(this.player, this));
        this.commands.put("move", new CommandMove(this.player, this, this.gameMap));
        this.commands.put("explore", new CommandExplore(this.player, this));
        this.commands.put("list", new CommandList(this.player, this));

        
        /*
         * command class (Player player)
         * pass through response parsed 0 for the verb --> commands hashtable, get value for the string key
         * pass through the response parsed 1 for the noun --> to the proper command that needs it
         */

    }

    //returns false until game is done
    public void scanAndRunCommand(){
        String userResponse = this.scan.nextLine();
        //String userResponse = "move north";
        String[] responseParsed = userResponse.split(" ");
        String verb = responseParsed[0];
        if (this.commands.containsKey(verb)){
            try{
                String noun = responseParsed[1];
                Command c = this.commands.get(verb);
                c.executeWork(noun); 
            }
            catch(Exception e){
                System.out.println("You need to write a noun. Indicate the direction(north, south, east, west), tool or room, for example.");
            }
        }
        else{
            System.out.println("That verb is not known. Try: move, grab, drop, explore, list.");
        }
    }

    public void gameLoop(){
        System.out.println();
        System.out.println("You are standing in the entryway room of a house. There are doors to the north, east, and west.");
        System.out.println("Each room has a broken appliance that needs to be fixed to rennovate the house.");
        System.out.println("Explore the rooms to identify the appliance and reason what the needed tool is from elsewhere in the house.");
        System.out.println("To complete the rennovation, make sure that each appliance has it's corresponding tool in the same room.");
        while (this.numCompletedRooms < this.roomsTable.size()){
            System.out.print("> ");
            this.scanAndRunCommand();

        }
        System.out.println("Your house is rennovated! Enjoy!");
        scan.close();
    }

    public Tool lookupTool(String noun){
        return this.toolsLookup.get(noun);
    }

    public RoomKey lookupRoom(String noun){
        return this.roomsLookup.get(noun);
    }

    public Room getRoomFromKey(RoomKey r){
        return this.roomsTable.get(r);
    }

    public boolean containsRoom(String noun){
        return this.roomsLookup.containsKey(noun);
    }

    public String addCompletedRoom(int compRoom){
        this.numCompletedRooms += compRoom;
        return "You have " + this.numCompletedRooms + " completed room(s)";
    }

    public static void main(String[] args) {
        Game myGame = new Game();
        // Command c = myGame.commands.get("move");
        // Command c2 = myGame.commands.get("grab");
        // Command c3 = myGame.commands.get("drop");
        // c.executeWork("east");
        // c.executeWork("north");
        // c.executeWork("north");
        // c.executeWork("west");
        // c.executeWork("north");
        // c.executeWork("west");
        // c.executeWork("south");
        // c.executeWork("north");
        // // c.executeWork("north");
        // c2.executeWork("plunger");
        // c3.executeWork("plunger");
        // c3.executeWork("plunger");
        // c3.executeWork("blah");
        myGame.gameLoop();



        

    }

}
