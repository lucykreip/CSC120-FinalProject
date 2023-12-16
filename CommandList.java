public class CommandList extends Command {
    
    /*
     * constructs a list command
     * @param Player player, Game game
     */
    public CommandList(Player player, Game game){
        super(player, game);
    }

    /*
     * if the user input noun equals inventory, the player's inventory is printed. Otherwise a message is printed to indicate what can and cannot be printed. 
     * @param String noun
     */
    public void executeWork(String noun){
        if (noun.equals("inventory")){
            this.player.printInventory();
        }
        else{
            System.out.println("You cannot list \"" + noun + "\". You can list your inventory.");
        }
    }
}
