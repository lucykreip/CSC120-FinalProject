public class CommandMove extends Command {
    private GameMap gameMap;
    
    public CommandMove(Player player, Game game, GameMap gameMap){
        super(player, game);
        this.gameMap = gameMap;
    }

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
