
public class Location {

    private RoomKey north;
    private RoomKey south;
    private RoomKey east;
    private RoomKey west;
    
    /*
     * constructs a new Location, assigning the passed in roomKeys to the north, south, east, and west.
     * @param RoomKey north, RoomKey south, RoomKey east, RoomKey west
     */
    public Location(RoomKey north, RoomKey south, RoomKey east, RoomKey west){
        this.north = north;
        this.south = south;
        this.east = east;
        this.west = west;
    }

    /*
     * gets the RoomKey in the specified String direction
     * @param String direction
     * @return this.north or this.south or this.east or this.west or null
     */
    public RoomKey nextRoom(String direction){
        if (direction.equals("north")){
            return this.north;
        }
        if (direction.equals("south")){
            return this.south;
        }
        if (direction.equals("east")){
            return this.east;
        }
        if (direction.equals("west")){
            return this.west;
        }
        return null;

    }

    /*
     * overwritten toString return a string indicating the RoomKey to the north, south, east, and west.
     * @return String
     */
    public String toString(){
        return "North: " + this.north + ", South: " + this.south + ", East: " + this.east + ", West: " + this.west;
    }
}
