
public class Command {
    protected Player player;
    protected Game game;

    /*
     * constructs a command, passes through player and game
     * @param Player player, Game game
     */
    public Command(Player player, Game game){
        this.player = player;
        this.game = game;
    }

    /*
     * basic executeWork method to be overwritten by other Command subclasses
     * @param noun
     */
    public void executeWork(String noun){

    }
}










