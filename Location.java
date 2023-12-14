
public class Location {

    private RoomKey north;
    private RoomKey south;
    private RoomKey east;
    private RoomKey west;
    
    public Location(RoomKey north, RoomKey south, RoomKey east, RoomKey west){
        this.north = north;
        this.south = south;
        this.east = east;
        this.west = west;
    }

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


    // public String myLocation(){
    //     return this.
    // }
    /*
     * get valid directions: booleans, n s e w, 
     */

    public String toString(){
        return "North: " + this.north + ", South: " + this.south + ", East: " + this.east + ", West: " + this.west;
    }
}
