import java.util.ArrayList;
import java.util.Hashtable;

public class Room {
    private String name;
    private ArrayList<Thing> thingsWithin;
    private Hashtable< Appliance, Boolean> appliancesWithin;
    //location 


    public Room(String name){
        this.name = name;
        this.thingsWithin = new ArrayList<Thing>();
        this.appliancesWithin = new Hashtable<Appliance, Boolean>();
    }

    public String getName(){
        return this.name;
    }

    public void addThing(Thing t){
        this.thingsWithin.add(t);
    }

    public void removeThing(Thing t){
        this.thingsWithin.remove(t);
    }

    public void addAppliance(Appliance a){
        this.appliancesWithin.put(a, a.getFixed());
    } 

    public void listThings(){
        for ( Thing t: this.thingsWithin){
            System.out.println("- " + t.getName());
        }
    }

    public String toString(){
        return this.name + " contains: " ;
    }
}
