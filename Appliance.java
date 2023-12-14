public class Appliance extends Thing {
    private boolean fixedStatus;
    private Tool expectedTool;

    public Appliance(String name, Tool expectedTool){
        super(name);
        this.fixedStatus = false; 
        this.expectedTool = expectedTool;
    }

    public boolean getFixedStatus(){
        return this.fixedStatus;
    }

    public Tool getExpectedTool(){
        return this.expectedTool;
    }
    
    public String toString(){
        return super.toString();
    }

    public static void main(String[] args) {
        Tool sponge = new Tool(ToolKey.SPONGE, "Sponge");
        Appliance wm = new Appliance("Washing Machine", sponge);
        System.out.println(wm);
        System.out.println(wm.getExpectedTool());
        System.out.println(wm.getExpectedTool()== sponge);
        System.out.println(wm.getExpectedTool()== null);

    }
}
