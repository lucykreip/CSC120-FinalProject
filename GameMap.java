import java.util.Hashtable;

public class GameMap{
    private Hashtable<RoomKey, Location> locations;

    public GameMap(){
        this.locations = new Hashtable<RoomKey, Location>();
        this.locations.put(RoomKey.LIVING, new Location(null, RoomKey.ENTRY, RoomKey.BATH, RoomKey.KITCHEN));
        this.locations.put(RoomKey.KITCHEN, new Location(null, RoomKey.DINING, RoomKey.LIVING, null));
        this.locations.put(RoomKey.BEDROOM, new Location(RoomKey.BATH, null, null, RoomKey.ENTRY));
        this.locations.put(RoomKey.BATH, new Location(null, RoomKey.BEDROOM, null, RoomKey.LIVING));
        this.locations.put(RoomKey.ENTRY, new Location(RoomKey.LIVING, null, RoomKey.BEDROOM, RoomKey.DINING));
        this.locations.put(RoomKey.DINING, new Location(RoomKey.KITCHEN, null, RoomKey.ENTRY, null));
    }

    public Location getLocation(RoomKey room){
        return this.locations.get(room);
    }

    public RoomKey canGo(RoomKey room, String direction){
        Location myLocation = this.getLocation(room);
        return myLocation.nextRoom(direction);
    }


    public static void main(String[] args) {
        GameMap myGame = new GameMap();
        System.out.println(myGame.getLocation(RoomKey.LIVING));
        System.out.println(myGame.canGo(RoomKey.LIVING, "north"));
        System.out.println(myGame.canGo(RoomKey.LIVING, "south"));
        System.out.println(myGame.canGo(RoomKey.LIVING, "east"));
        System.out.println(myGame.canGo(RoomKey.LIVING, "west"));
    }
    
}