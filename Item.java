public class Item {
    private boolean isFound;
    private int xCoordinate;
    private int yCoordinate;

    public Item(){
        isFound = false;
    }

    public Item(int x, int y){
        isFound = false;
        xCoordinate = x;
        yCoordinate = y;
    }

    public boolean getIsFound(){
        return isFound;
    }

    public int getXCoordinate(){
        return xCoordinate;
    }
    
    public int getYCoordinate(){
        return yCoordinate;
    }

    public void setIsFound(boolean isFound){
        this.isFound = isFound;
    }
}
