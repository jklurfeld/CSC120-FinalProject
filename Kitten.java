/** 
 * Kitten class, a subclass of Item 
 * @author Jessica Klurfeld
*/

public class Kitten extends Item{
    /** Attributes */
    String name;

    /** Constructor */
    public Kitten(String n){
        super();
        name = n;
    }

    /** 
     * Logically converts the object into a string
     * @return String the String representation of the object
     */
    public String toString(){
        return name;
    }
}
