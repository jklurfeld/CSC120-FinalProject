public class Door extends Item{
    /** Attributes */
    boolean isOpen;

    /** Constructor */
    public Door(int x, int y){
        super(x,y);
        isOpen = false;
    }

    /**
     * Getter for the isOpen attribute
     * @return boolean isOpen
     */
    public boolean getIsOpen(){
        return isOpen;
    }

    /**
     * Setter for the isOpen attribute
     * @param isOpen what you want to change the attribute to
     */
    public void setIsOpen(boolean isOpen){
        this.isOpen = isOpen;
    }
}
