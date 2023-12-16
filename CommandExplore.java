public class CommandExplore extends Command {
    
    /*
     * contructs an explore command
     * @param Player player, Game game
     */
    public CommandExplore(Player player, Game game){
        super(player, game);
    }

    /*
     * gets player current location, checks that the user input room exists, lists the contents of the room if the room is the same as the player's location
     * @param String noun
     */
    public void executeWork(String noun){
        Room room = this.player.getLocation();
        if (this.game.containsRoom(noun)){
            if (room.getName().equals(noun)){
                this.player.explore();
            }
            else{
                System.out.println("You are not in the " + noun + " room. Move there to explore its contents.");
            }
        }
        else{
            System.out.println("Room \"" + noun + "\" does not exist.");
        }
    }
}
