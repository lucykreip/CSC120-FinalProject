public class CommandExplore extends Command {
    
    public CommandExplore(Player player, Game game){
        super(player, game);
    }

    public void executeWork(String noun){
        Room room = this.player.getLocation();
        if (this.game.containsRoom(noun)){
            if (room.getName().equals(noun)){
                room.listThings();
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
