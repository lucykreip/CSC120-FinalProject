public class Appliance extends Thing {
    private Tool expectedTool;

    /*
     * constructs a new appliance with a name and assigns the expected tool needed to 'fix' it. sets the 
     * @param String name, Tool expectedTool
     */
    public Appliance(String name, Tool expectedTool){
        super(name);
        this.expectedTool = expectedTool;
    }

    /*
     * gets the tool needed to 'fix' the appliance
     * @return Tool expectedTool
     */
    public Tool getExpectedTool(){
        return this.expectedTool;
    }
    
}
