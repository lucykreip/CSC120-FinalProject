public class CommandList extends Command {
    
    public CommandList(Player player, Game game){
        super(player, game);
    }

    public void executeWork(String noun){
        if (noun.equals("inventory")){
            this.player.printInventory();
        }
        else{
            System.out.println("You cannot list \"" + noun + "\". You can list your inventory.");
        }
    }
}
