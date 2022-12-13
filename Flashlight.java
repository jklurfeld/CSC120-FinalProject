/** Flashlight class, which is a subclass of Item */

public class Flashlight extends Item{
    
    /** Flashlight constructor */
    public Flashlight(int x, int y){
        super(x,y);
    }

    /** 
     * Logically converts the object into a string
     * @return String the String representation of the object
     */
    public String toString(){
        return "flashlight";
    }
}
