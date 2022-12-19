import java.util.ArrayList;

/** 
 * Cat class– represents a cat
 * @author Jessica Klurfeld
 */
public class Cat{

    /** Attributes */
    int xCoordinate;
    int yCoordinate;
    ArrayList<Object> inventory;
    String lastMethod = "";
    //int lastX;
    //int lastY;

    /** Constructor */
    public Cat(){
        xCoordinate = 1;
        yCoordinate = 2;
        inventory = new ArrayList<Object>();
    }


    /** Accessor for xCoordinate attribute
     * @return int xCoordinate of this Cat
     */
    public int getXCoordinate(){
        return xCoordinate;
    }

    /** Accessor for yCoordinate attribute
     * @return int yCoordinate of this Cat
     */
    public int getYCoordinate(){
        return yCoordinate;
    }

    /** Accessor for inventory
     * @return ArrayList inventory of this Cat
     */
    public ArrayList<Object> getInventory(){
        return inventory;
    }

    /** Prints the player/cat's inventory */
    public void printInventory(){
        //lastMethod = "printInventory";
        System.out.println("Your inventory contains the following items:");
        for (int i = 0; i < inventory.size(); i++){
            System.out.print("+ ");
            System.out.println(inventory.get(i));
        }
    }

    /** Grabs an item and puts it in the inventory
     * @param String item that you want to grab
     */
    public void grab(Item i){
        inventory.add(i);
        System.out.println("You have grabbed this " + i + " and it is now in your inventory.");
        lastMethod = "grab_" + i;
    }

    /** Makes the cat walk in the direction provided
     * @param String direction is the direction to the direction to be walked in
     * @return boolean returns true if the cat was able to sucessfully walk in the direction provided
     */
    public boolean walk(String direction){
        lastMethod = "walk";
        if (direction.equals("north")){
            if (yCoordinate != 3){
                yCoordinate += 1;
                System.out.println("You are now at (" + xCoordinate + ", " + yCoordinate + ").");
                //lastMethod = "walk_north";
                return true;
            }
            else {
                System.out.println("You have reached a wall. You can't go north anymore.");
                lastMethod = "";
                return false;
            }
        }
        else if (direction.equals("south")){
            if (yCoordinate > 0){
                yCoordinate -= 1;
                System.out.println("You are now at (" + xCoordinate + ", " + yCoordinate + ").");
                //lastMethod = "walk_south";
                return true;
            }
            else{
                System.out.println("You have reached a wall. You can't go south anymore.");
                lastMethod = "";
                return false;
            }
        }
        else if (direction.equals("east")){
            if (xCoordinate != 3){
                xCoordinate += 1;
                System.out.println("You are now at (" + xCoordinate + ", " + yCoordinate + ").");
                //lastMethod = "walk_east";
                return true;
            }
            else {
                System.out.println("You have reached a wall. You can't go east anymore.");
                lastMethod = "";
                return false;
            }
        }
        else if (direction.equals("west")){
            if (xCoordinate > 0){
                xCoordinate -= 1;
                System.out.println("You are now at (" + xCoordinate + ", " + yCoordinate + ").");
                //lastMethod = "walk_west";
                return true;
            }
            else {
                System.out.println("You have reached a wall. You can't go west anymore.");
                lastMethod = "";
                return false;
            }
        }
        else {
            System.err.println("Please enter a cardinal direction (north, south, east, west)");
            return false;
        }
    }

    /** Main method for testing */
    public static void main(String[] args){
        
    }
}
