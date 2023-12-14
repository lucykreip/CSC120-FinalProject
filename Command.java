
public class Command {
    protected Player player;
    protected Game game;

    public Command(Player player, Game game){
        this.player = player;
        this.game = game;
    }

    public void executeWork(String noun){
        System.out.println("Command");

    }
}










