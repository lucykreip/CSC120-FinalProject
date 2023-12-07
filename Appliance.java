public class Appliance extends Thing {
    private boolean fixed;

    public Appliance(String name){
        super(name);
        this.fixed = false; 

    }

    public boolean getFixed(){
        return this.fixed;
    }


}
