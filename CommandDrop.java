public class CommandDrop extends Command{

    /*
     * constructs a new drop command
     * @param Player player, Game game
     */
    public CommandDrop(Player player, Game game){
        super(player, game);
    }

    /*
     * finds tool associated with the String name noun, check if it is in player inventory, and calculate state of room completion
     * @param String noun
     */
    public void executeWork(String noun){
        Tool t = this.game.lookupTool(noun); //getting a tool back
        if (t != null){
            boolean previous = this.player.getLocation().getCompletedOrNot();
            if (this.player.dropTool(t)){
                System.out.println("You no longer have " + noun);
                boolean current = this.player.getLocation().getCompletedOrNot();
                if(current == true && previous == false){
                    String message = this.game.addCompletedRoom(1);
                    System.out.println(message);
                }
                if(current == false && previous == true){
                    String message = this.game.addCompletedRoom(-1);
                    System.out.println(message);
                }
            }
            else{
                System.out.println("You do not have that tool in your inventory! List inventory to check what you have!");
            }
        }
        else{
            System.out.println("This tool does not exist.");
        }
    }
}