public class CommandGrab extends Command{

    /*
     * constructs a grab command
     * @param Player player, Game game
     */
    public CommandGrab(Player player, Game game){
        super(player, game);
    }

    /*
     * looks up corresponding tool to the String noun from the user. If the tool exists in the game, it is added to the player inventory and a confirmation message printed. 
     * @param String noun
     */
    public void executeWork(String noun){
        Tool t = this.game.lookupTool(noun); //getting a tool back
        if (t != null){
            if (this.player.pickUpTool(t)){
                System.out.println("The " + noun + " is in your inventory.");
            }
        }
        else{
            System.out.println("This tool does not exist.");
        }
    }
}
