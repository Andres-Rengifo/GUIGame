package OOP.ec22954.MP;// ec22904 ShoutOut

class Room_ec22954 extends Room {

    private boolean LanternOn = false;
    public Direction visit(Visitor v, Direction d){
        v.tell("You have entered the room from " + d);
        if (LanternOn) {
            v.tell("The light is on. \n");
        }
        else {
            v.tell("it is gone dark... \n");
        }

        boolean SecretButton = false;
        while (!SecretButton) {
            v.tell("\n There seems to be a button here \n");
            char choice = v.getChoice("What would you like to do?\n" +
                    "a. Turn on the lights\n" +
                    "b. Turn off the lights\n" +
                    "c. Take a book off the shelf\n" +
                    "d. Leave the room \n", new char[]{'a', 'b', 'c', 'd'});


            if (choice == 'a') {
                LanternOn = true;
                v.tell("You turn on the lights. \n");
            } else if (choice == 'b') {
                if(LanternOn==false){
                    v.tell("The light was already off. \n");
                }else if(LanternOn==true){
                    LanternOn = false;
                    v.tell("You turn off the lights. It's dark. \n");
                }
            }  else if (choice == 'c') {
                v.tell("You take a book off the shelf. \n");
                Item book = new Item("Book");
                v.giveItem(book);
                SecretButton = true;
            } else {
                v.tell("Invalid \n");
            }
        }

        return Direction.opposite(d);
    }
}
