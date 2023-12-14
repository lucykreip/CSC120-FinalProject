public class CommandDrop extends Command{

    public CommandDrop(Player player, Game game){
        super(player, game);
    }

    public void executeWork(String noun){
        // System.out.println("CommandDrop");
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
//try catch business 
        }
        else{
            System.out.println("This tool does not exist.");
        }
        //TODO check if tool in the inventory, 
    }
}