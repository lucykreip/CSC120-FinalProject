public class CommandMove extends Command {
    private GameMap gameMap;
    
    /*
     * constructs a move command 
     * @param Player player, Game game, GameMap gameMap
     */
    public CommandMove(Player player, Game game, GameMap gameMap){
        super(player, game);
        this.gameMap = gameMap;
    }

    /*
     * checks if the player's current location can go the user inputted direction and if not null, changes the player's location to the room in that direction.
     * @param String noun
     */
    public void executeWork(String noun){
        Room room = this.player.getLocation();
        RoomKey nextRoom = this.gameMap.canGo(room.getID(), noun);
        if (nextRoom != null){
            Room newRoom = this.player.setLocation(this.game.getRoomFromKey(nextRoom));
            System.out.println("You are in the " + newRoom + " room.");
        }
        else{
            System.out.println("There is no room to the " + noun + ".");
        }
    }

}
