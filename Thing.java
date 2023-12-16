public class Thing {
    private String name;

    /*
     * constructs a thing with a given name
     * @param String name
     */
    public Thing(String name){
        this.name = name;
    }

    /*
     * accessor for the thing's name
     * @return String this.name
     */
    public String getName(){
        return this.name;
    }

}
