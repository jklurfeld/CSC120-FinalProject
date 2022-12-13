/** Item class */
public class Item {
    /** Attributes */
    private boolean isFound;
    private int xCoordinate;
    private int yCoordinate;

    /** Constructor that takes no parameters */
    public Item(){
        isFound = false;
    }

    /** Constructor that takes x and y coordinates */
    public Item(int x, int y){
        isFound = false;
        xCoordinate = x;
        yCoordinate = y;
    }

    /** 
     * Getter for the isFound attribute
     * @return boolean isFound
     */
    public boolean getIsFound(){
        return isFound;
    }

    /**
     * Getter for the xCoordinate attribute 
     * @return int xCoordinate
     */
    public int getXCoordinate(){
        return xCoordinate;
    }
    
    /**
     * Getter for the yCoordinate attribute
     * @return int yCoordinate
     */
    public int getYCoordinate(){
        return yCoordinate;
    }

    /**
     * Setter for the isFound attribute
     * @param isFound what you want to change the attribute to
     */
    public void setIsFound(boolean isFound){
        this.isFound = isFound;
    }
}
