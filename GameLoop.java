import java.util.Scanner;

public class GameLoop {
    /** Attributes */
    Cat cat = new Cat();
    Door closet = new Door(0, 0);
    Door fridge = new Door(3,0);
    Kitten mittens = new Kitten("Mittens");
    Kitten fluffy = new Kitten("Fluffy");
    Kitten scruffy = new Kitten("Scruffy");
    Kitten boots = new Kitten ("Boots");
    Item bed = new Item(3,2);
    Key redKey = new Key("red", 3,3);
    Key blueKey = new Key("blue", 2,1);
    Flashlight flashlight = new Flashlight(0,2);
    Door box = new Door(1,3);

    boolean endOfGame = false;
    boolean wordFound = false;

    /**
     * Checks if the user input contains "grab" and executes the proper methods as a result
     * @param dialogue the user's input
     */
    public void containsGrab(String dialogue){
        if (dialogue.contains("grab")){
            wordFound = true;
            cat.lastMethod = "";
            if (dialogue.contains("key")){
                if (dialogue.contains("red") || (cat.getXCoordinate() == redKey.getXCoordinate() && cat.getYCoordinate() == redKey.getYCoordinate())){
                    if (!redKey.getIsFound()){
                        cat.grab(redKey);
                    }
                    else {
                        System.out.println("The red key is already in your inventory.");
                    }
                }
                else if (dialogue.contains("blue") || (cat.getXCoordinate() == blueKey.getXCoordinate() && cat.getYCoordinate() == blueKey.getYCoordinate())){
                    if (!blueKey.getIsFound()){
                        cat.grab(blueKey);
                    }
                    else {
                        System.out.println("The blue key is already in your inventory.");
                    }
                }
                else {
                    System.out.println("Please enter \"grab key\" and the color of the key in order to grab it.");
                }
            }
            else if (dialogue.contains("flashlight") || (cat.getXCoordinate() == flashlight.getXCoordinate() && cat.getYCoordinate() == flashlight.getYCoordinate())){
                if (!flashlight.getIsFound()){
                    cat.grab(flashlight);
                }
                else {
                    System.out.println("The flashlight is already in your inventory.");
                }
            }
            else if (dialogue.contains("fluffy")){
                cat.grab(fluffy);
            }
            else if (dialogue.contains("scruffy")){
                cat.grab(scruffy);
            }
            else if (dialogue.contains("mittens")){
                cat.grab(mittens);
            }
            else if (dialogue.contains("boots")){
                cat.grab(boots);
            }
            else {
                System.out.println("Please enter \"grab\" and the name of the thing you want to grab in order to grab it.");
            }
        }
    }

    public void containsWalk(String dialogue){
        if (dialogue.contains("walk")){
            wordFound = true;
            if (dialogue.contains("north") || dialogue.contains("up")){
                cat.walk("north");
            }
            else if (dialogue.contains("south") || dialogue.contains("down")){
                cat.walk("south");
            }
            else if (dialogue.contains("east") || dialogue.contains("right")){
                cat.walk("east");
            }
            else if (dialogue.contains("west") || dialogue.contains("left")){
                cat.walk("west");
            }
            else {
                System.out.println("Please enter \"walk\" and a direction in order to walk around.");
            }
        }
    }

    public void containsUseKey(String dialogue){
        if (dialogue.contains("use") && dialogue.contains("key")){
            wordFound = true;
            cat.lastMethod = "";
            if (dialogue.contains("red") && cat.inventory.contains(redKey) && cat.getXCoordinate() == fridge.getXCoordinate() && cat.getYCoordinate() == fridge.getYCoordinate()){
                fridge.isOpen = true;
                System.out.println("The key unlocks the fridge door. You see Scruffy inside! Grab him!");
            }
            else if (dialogue.contains("blue") && cat.inventory.contains(blueKey) && cat.getXCoordinate() == closet.getXCoordinate() && cat.getYCoordinate() == closet.getYCoordinate()){
                closet.isOpen = true;
                System.out.println("The key unlocks the closet door. You see Mittens inside! Grab her!");
            }
            else if (dialogue.contains("red") && cat.getXCoordinate() == closet.getXCoordinate() && cat.getYCoordinate() == closet.getYCoordinate()){
                System.out.println("This red key does not fit into the blue closet door.");
            }
            else if (dialogue.contains("blue") && cat.getXCoordinate() == fridge.getXCoordinate() && cat.getYCoordinate() == fridge.getYCoordinate()){
                System.out.println("This blue key does not fit into the red fridge door.");
            }
            else {
                cat.lastMethod = "";
                System.out.println("Please enter \"use key\" and specify the key's color in order to use it.");
            }
        }
    }

    public void containsUseFlashlight(String dialogue){
        if (dialogue.contains("use") && dialogue.contains("flashlight")){
            wordFound = true;
            cat.lastMethod = "";
            if (cat.inventory.contains(flashlight)){
                if (cat.getXCoordinate() == bed.getXCoordinate() && cat.getYCoordinate() == bed.getYCoordinate()){
                    System.out.println("You turn on the flashlight and look under the bed. There's Boots! Grab him!");
                    bed.setIsFound(true);
                }
                else{
                    System.out.println("You turn on the flashlight. It's daylight so you don't see anything new.");
                }
            }
            else {
                System.out.println("You do not have a flashlight in your inventory.");
            }
        }
    }

    public void containsOpen(String dialogue){
        if (dialogue.contains("open")){
            wordFound = true;
            cat.lastMethod = "";
            if (dialogue.contains("box")){
                if (cat.getXCoordinate() == box.getXCoordinate() && cat.getYCoordinate() == box.getYCoordinate()){
                    if (box.getIsOpen() == false){
                        box.isOpen = true;
                        System.out.println("You see Fluffy inside the box. Grab her!");
                        fluffy.setIsFound(true);
                    }
                }
            }
            else if (dialogue.contains("closet") || dialogue.contains("fridge") || dialogue.contains("door")){
                System.out.println("This door is locked. Try looking around for a key.");
            }
        }
    }

    public void atCloset(String dialogue){
        if (cat.lastMethod.equals("walk") && cat.getXCoordinate() == closet.getXCoordinate() && cat.getYCoordinate() == closet.getYCoordinate()){
            //if the closet is locked then just print that you've reached the closet and it's locked
            if (closet.getIsOpen() == false){
                System.out.println("You have reached a blue closet door. It is locked.");
            }

            //else (the closet is unlocked)
            else {
                if (cat.inventory.contains(mittens) == false){
                    System.out.println("You see Mittens inside the closet! Grab her!");
                    mittens.setIsFound(true);
                }
                else {
                    System.out.println("You have reached a closet. It's empty.");
                }
            }
        }
    }

    public void atFridge(String dialogue){
        if (cat.lastMethod.equals("walk") && cat.getXCoordinate() == fridge.getXCoordinate() && cat.getYCoordinate() == fridge.getYCoordinate()){
            //if the fridge is locked then just print that you've reached the fridge and it's locked
            if (fridge.getIsOpen() == false){
                System.out.println("You have reached a red fridge door. It is locked.");
            }
            //else (the fridge is unlocked)
            else {
                if (cat.inventory.contains(scruffy) == false){
                    scruffy.setIsFound(true);
                    System.out.println("You see Scruffy inside the fridge! Grab him!");
                }
                else {
                    System.out.println("You have reached a fridge. It's empty.");
                }
            }
        }
    }

    public void atBed(String dialogue){
        if (cat.lastMethod.equals("walk") && cat.getXCoordinate() == bed.getXCoordinate() && cat.getYCoordinate() == bed.getYCoordinate()){
            //if the bed has not been illuminated via flashlight
            if (bed.getIsFound() == false){
                System.out.println("You have reached a bed. It's too dark to see under it but you hear meows.");
            }
            //else (the bed has been previously illuminated)
            else {
                if (!cat.inventory.contains(boots)){
                    boots.setIsFound(true);
                    System.out.println("You see Boots under the bed! Grab him!");
                }
                else {
                    System.out.println("You have reached a bed. It's is quiet.");
                }
            }
        }
    }

    public void atBox(String dialogue){
        if (cat.lastMethod.equals("walk") && cat.getXCoordinate() == box.getXCoordinate() && cat.getYCoordinate() == box.getYCoordinate()){
            if (!box.isOpen){
                System.out.println("You have reached a box. You hear meowing coming from the inside.");
            }
            else {
                if (cat.inventory.contains(fluffy)){
                    System.out.println("You have reached a box. It is empty.");
                }
                else{
                    System.out.println("You see Fluffy inside. Grab her!");
                }
            }
        }
    }

    public static void main (String[] args){
        GameLoop g = new GameLoop();

        Scanner input = new Scanner(System.in);

        System.out.println("You are a tired cat mom and you've just awoken from your nap. \nOh no! Your four kittens: Mittens, Fluffy, Scruffy, and Boots are gone! You have to find them!");
        System.out.println("Start by walking around to try to find them. Type \"help\" at any point for a list of commands.");
        
        while (!g.endOfGame){
            String dialogue = input.nextLine().toLowerCase();

            //calls the grab function on the specified object if user input contains "grab"
            g.containsGrab(dialogue);

            //calls the walk function on the cat if the user inputs the word "walk"
            g.containsWalk(dialogue);

            //uses the specified key to open the corresponding door if user input contains "use key"
            g.containsUseKey(dialogue);

            //uses the flashlight to illuminate the bed if user input contains "use flashlight"
            g.containsUseFlashlight(dialogue);

            //responds to the user input "open"
            g.containsOpen(dialogue);

            //prints the user's inventory
            if (dialogue.contains("print inventory")){
                g.wordFound = true;
                g.cat.printInventory();
            }
            
            //responds to the user input "help"
            if (dialogue.contains("help")){
                g.wordFound = true;
                g.cat.lastMethod = "";
                System.out.println("The following are a list of available commands:");
                System.out.println("- grab <name of item>");
                System.out.println("- walk <direction>");
                System.out.println("- use <item>");
                System.out.println("- open <name of thing to be opened>");
                System.out.println("- print inventory");
            }

            //tells the user if they're at the closet
            g.atCloset(dialogue);

            //tells the user if they're at the fridge
            g.atFridge(dialogue);

            //tells the user if they're at the bed
            g.atBed(dialogue);

            //tells user if they're at the box
            g.atBox(dialogue);

            //tells the user if they've found the red key
            if (g.cat.getXCoordinate() == g.redKey.getXCoordinate() && g.cat.getYCoordinate() == g.redKey.getYCoordinate() && !g.cat.inventory.contains(g.redKey)){
                System.out.println("You have come across a red key.");
            }

            //tells the user if they've found the blue key
            if (g.cat.getXCoordinate() == g.blueKey.getXCoordinate() && g.cat.getYCoordinate() == g.blueKey.getYCoordinate() && !g.cat.inventory.contains(g.blueKey)){
                System.out.println("You have come across a blue key.");
            }

            //tells the user if they've found the flashlight
            if (g.cat.getXCoordinate() == g.flashlight.getXCoordinate() && g.cat.getYCoordinate() == g.flashlight.getYCoordinate() && !g.cat.inventory.contains(g.flashlight)){
                System.out.println("You have come across a flashlight.");
            }

            //if the user doesn't input a known commands, tells them they don't know the command
            if (!g.wordFound){
                System.out.println("I don't know this command. Type \"help\" for a list of commands.");
            }

            //if you've found all of your kittens and put them in your inventory, then you win the game, which breaks the while loop immediately
            if (g.cat.inventory.contains(g.mittens) && g.cat.inventory.contains(g.fluffy) && g.cat.inventory.contains(g.scruffy) && g.cat.inventory.contains(g.boots)){
                g.endOfGame = true;
            }
            g.wordFound = false;
        }

        System.out.println("Congratulations! You have found all of your kittens!");
        System.out.println("****THE END****");
        input.close();
    }
}
