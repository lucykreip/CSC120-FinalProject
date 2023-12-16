import java.util.Hashtable;

public class GameMap{
    private Hashtable<RoomKey, Location> locations;

    /*
     * constructs a GameMap, initializing all the RoomKeys in a hashtable and sets the RoomKeys to the north, south, east, and west. 
     */
    public GameMap(){
        this.locations = new Hashtable<RoomKey, Location>();
        this.locations.put(RoomKey.LIVING, new Location(null, RoomKey.ENTRY, RoomKey.BATH, RoomKey.KITCHEN));
        this.locations.put(RoomKey.KITCHEN, new Location(null, RoomKey.DINING, RoomKey.LIVING, null));
        this.locations.put(RoomKey.BEDROOM, new Location(RoomKey.BATH, null, null, RoomKey.ENTRY));
        this.locations.put(RoomKey.BATH, new Location(null, RoomKey.BEDROOM, null, RoomKey.LIVING));
        this.locations.put(RoomKey.ENTRY, new Location(RoomKey.LIVING, null, RoomKey.BEDROOM, RoomKey.DINING));
        this.locations.put(RoomKey.DINING, new Location(RoomKey.KITCHEN, null, RoomKey.ENTRY, null));
    }

    /*
     * returns the location of the given RoomKey
     * @param RoomKey room
     * @return Location
     */
    public Location getLocation(RoomKey room){
        return this.locations.get(room);
    }
    
    /*
     * returns the RoomKey to the inputted direction
     * @param RoomKey room, String direction
     * @return RoomKey
     */
    public RoomKey canGo(RoomKey room, String direction){
        Location myLocation = this.getLocation(room);
        return myLocation.nextRoom(direction);
    }
}