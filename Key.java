/** 
 * Key class a subclass of Item 
 * @author Jessica Klurfeld
*/

public class Key extends Item{
    /** Attributes */
    String color;
    
    /** Constructor */
    public Key(String c, int x, int y){
        super(x,y);
        color = c;
    }

    /** 
     * Logically converts the object into a string
     * @return String the String representation of the object
     */
    public String toString(){
        return color + " key";
    }
}
