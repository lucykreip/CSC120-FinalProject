public class Tool extends Thing { 
    private ToolKey id;
    
    /*
     * constructs a tool with a given id and name
     * @param ToolKey id, String name
     */
    public Tool(ToolKey id, String name){
        super(name);
        this.id = id;
    }

    /*
     * accessor for the tool's id
     * @return ToolKey this.id
     */
    public ToolKey getID(){
        return this.id;
    }
}
