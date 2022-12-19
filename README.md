- Reasonable design alternative:
I could have added a "name" attribute to the Item class and a toString() method and gotten rid of the the Flashlight and Kitten classes, because they at this point, they really don't have additional function so they don't need to be their own class. It's just something I added in the beginning and never really got rid of because they were already there, because at the beginning I thought I needed to have a different class for each type of item, when I really didn't. Another reason I kept these classes is because it is something that if I had more time I could build off of and add more functionality to each of these classes.

- What was your overall approach to tackling this project?
My overall approach was start early and work on it consistently, which wasn't hard because I felt like I had the tools to make this project and I had a motivation/excitement to create a text-based video game.

- What new thing(s) did you learn / figure out in completing this project?
I think I better understand classes now because it was a different experinece to basically start from scratch by myself. I think I understand classes and class relationships better now that I had to implement them myself and figure out what made sense in the context of my game.

- Is there anything that you wish you had implemented differently?
I don't think there remains anything in my code that I wish I had implemented differently, because I went back and changed a lot of things. For example, the way I was implementing the methods in Gameloop.java that were checking if the player is at a certain place wasn't uniform, so I changed them to be the same.

- If you had unlimited time, what additional features would you implement?
During the presentation day in class, I saw someone else had a timer implemented in their game, which added a fun race against the clock aspect to the game. It also opens up the possibility of losing the game– right now with my game you can win every time.

- What was the most helpful piece of feedback you received while working on your project? Who gave it to you?
The most helpful piece of feedback was from you on how to break up the main method in my Gameloop.java class into smaller methods. I was having trouble figuring out how to do this because I was forgetting that everything was an object, so you told me that I should make a Gameloop object in the main method and then call all of the methods on this object.

- If you could go back in time and give your past self some advice about this project, what hints would you give?
If I could go back in time and give my past self some advice, I would tell them to do the javadoc comments as they go. I would also tell them that not every different object in your game has to have a different class– you don't need to make a Bed class for the Bed if it doesn't have any additional functionality or attributes compared to a generic Item.