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
        this.toolsLookup.put("hammer",  toolsTable.get(ToolKey.HAMMER));
        this.toolsLookup.put("hammer",  toolsTable.get(ToolKey.HAMMER));
        this.toolsLookup.put("hammer",  toolsTable.get(ToolKey.HAMMER));
        // this.toolsTable.put(ToolKey.BROOM, new Tool(ToolKey.BROOM, "broom"));
        // this.toolsTable.put(ToolKey.SPONGE, new Tool(ToolKey.SPONGE, "sponge"));
        // this.toolsTable.put(ToolKey.SCREWDRIVER, new Tool(ToolKey.SCREWDRIVER, "screwdriver"));

        this.appliancesTable = new Hashtable<ApplianceKey, Appliance>();
        this.appliancesTable.put(ApplianceKey.TOILET, new Appliance("toilet", toolsTable.get(ToolKey.PLUNGER)));
        this.appliancesTable.put(ApplianceKey.BED, new Appliance("bed", toolsTable.get(ToolKey.SHEETS)));
        this.appliancesTable.put(ApplianceKey.TABLE, new Appliance("table", toolsTable.get(ToolKey.HAMMER)));
        this.appliancesTable.put(ApplianceKey.RUG, new Appliance("rug", toolsTable.get(ToolKey.BROOM)));
        this.appliancesTable.put(ApplianceKey.STOVE, new Appliance("stove", toolsTable.get(ToolKey.SPONGE)));
        this.appliancesTable.put(ApplianceKey.LIGHT, new Appliance("light", toolsTable.get(ToolKey.SCREWDRIVER)));
        
        this.roomsTable = new Hashtable<RoomKey, Room>();
        this.roomsTable.put(RoomKey.BATH, new Room(RoomKey.BATH, "bathroom", appliancesTable.get(ApplianceKey.TOILET)));
        this.roomsTable.put(RoomKey.BEDROOM, new Room(RoomKey.BEDROOM, "bedroom", appliancesTable.get(ApplianceKey.BED)));
        this.roomsTable.put(RoomKey.DINING, new Room(RoomKey.DINING, "dining room", appliancesTable.get(ApplianceKey.TABLE)));
        this.roomsTable.put(RoomKey.LIVING, new Room(RoomKey.LIVING, "living room", appliancesTable.get(ApplianceKey.RUG)));
        this.roomsTable.put(RoomKey.KITCHEN, new Room(RoomKey.KITCHEN, "kitchen", appliancesTable.get(ApplianceKey.STOVE)));
        this.roomsTable.put(RoomKey.ENTRY, new Room(RoomKey.ENTRY, "entryway", appliancesTable.get(ApplianceKey.LIGHT)));

        this.roomsLookup = new Hashtable <String, RoomKey>();
        this.roomsLookup.put("bathroom", RoomKey.BATH);
        this.roomsLookup.put("bedroom", RoomKey.BEDROOM);
        this.roomsLookup.put("dining room", RoomKey.DINING);
        this.roomsLookup.put("living room", RoomKey.LIVING);
        this.roomsLookup.put("kitchen", RoomKey.KITCHEN);
        this.roomsLookup.put("entryway", RoomKey.ENTRY);

        this.roomsTable.get(RoomKey.ENTRY).addTool(this.toolsTable.get(ToolKey.PLUNGER));

        this.player = new Player(roomsTable.get(RoomKey.ENTRY));

        this.gameMap = new GameMap();

        this.scan = new Scanner(System.in);

        this.numCompletedRooms = 0;

        this.commands = new Hashtable<String, Command>();
        this.commands.put("grab", new CommandGrab(this.player, this));
        this.commands.put("drop", new CommandDrop(this.player, this));
        this.commands.put("move", new CommandMove(this.player, this, this.gameMap));

        
        /*
         * command class (Player player)
         * pass through response parsed 0 for the verb --> commands hashtable, get value for the string key
         * pass through the response parsed 1 for the noun --> to the proper command that needs it
         */

    }

    public void scanAndRunCommand(){
        String userResponse = this.scan.nextLine();
        String[] responseParsed = userResponse.split(" ");
        String verb = responseParsed[0];
        String noun = responseParsed[1];
        Command c = this.commands.get(verb);
        c.executeWork(noun); 
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

    public String addCompletedRoom(int compRoom){
        this.numCompletedRooms += compRoom;
        return "You have " + this.numCompletedRooms + " completed room(s)";
    }

    public static void main(String[] args) {
        Game myGame = new Game();
        Command c = myGame.commands.get("move");
        Command c2 = myGame.commands.get("grab");
        Command c3 = myGame.commands.get("drop");
        // c.executeWork("east");
        // c.executeWork("north");
        // c.executeWork("north");
        // c.executeWork("west");
        // c.executeWork("north");
        // c.executeWork("west");
        // c.executeWork("south");
        // c.executeWork("north");
        // c.executeWork("north");
        c2.executeWork("plunger");
        c3.executeWork("plunger");
        c3.executeWork("plunger");


        

    }

}
