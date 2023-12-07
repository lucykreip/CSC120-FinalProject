import java.util.ArrayList;

public class House extends Building {

  private ArrayList<Room> rooms;
 
  /*
    * constructs a Cafe
    * @param name Assigns a String name to the house
    * @param address Assigns a String address to the house
    * @param nFloors Assigns an int number of floors to the house
    */
  public House(String name, String address, int nFloors, boolean hasDiningRoom) {
    super(name, address, nFloors);
    this.rooms = new ArrayList<Room>();
    System.out.println("You have built a house: 🏠");
  }

  public void enter(){

  }


  public static void main(String[] args) {
    House myHouse = new House("Lucy's House", "15 Maple St.", 4, true);
    System.out.println(myHouse);



  }

} 
