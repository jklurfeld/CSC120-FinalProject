public class Door {
    boolean isOpen;
    int xCoordinate;
    int yCoordinate;

    public Door(int x, int y){
        isOpen = false;
        xCoordinate = x;
        yCoordinate = y;
    }

    public boolean getIsOpen(){
        return isOpen;
    }

    public int getXCoordinate(){
        return xCoordinate;
    }
    
    public int getYCoordinate(){
        return yCoordinate;
    }
}
