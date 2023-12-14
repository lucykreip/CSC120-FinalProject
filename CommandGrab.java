public class CommandGrab extends Command{

    public CommandGrab(Player player, Game game){
        super(player, game);
    }

    public void executeWork(String noun){
        System.out.println("CommandGrab");
        Tool t = this.game.lookupTool(noun); //getting a tool back
        if (t != null){
            if (this.player.pickUpTool(t)){
                System.out.println(noun + " is in your inventory.");
            }
        }
        else{
            System.out.println("This tool does not exist.");
        }
        //print out inventory, confirmation message, list inventory
    }
}
