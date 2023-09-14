package OOP.ec22954.MP;

class Room_ec22704 extends Room {
    private  Item LONG_THING = new Item("Long Object");
    private  Item CANDLE = new Item("Candle");
    private Item TORCH = new Item("Torch");
    private Item FLAME_THROWER = new Item("Flame Thrower");

    boolean generatorSwitch = false;
    
    //takes gold and welcomes them

    public Direction visit(Visitor visitor, Direction from) {

        if (from == Direction.FROM_EAST) {
            visitor.tell("You arrived from east. \n");
        } else if (from == Direction.FROM_NORTH) {
            visitor.tell("You arrived from north \n");
        } else if (from == Direction.FROM_WEST ) {
            visitor.tell("You arrived from west. \n");
        } else if (from == Direction.FROM_SOUTH) {
            visitor.tell("You arrived from south. \n");
        }


        visitor.tell("Welcome to ec22704's room in the house! \n");
        visitor.tell("You must pay 2 gold to enter \n");
        visitor.takeGold(2);


        String navigationOption = ("What would you like to do in my room?\n a) Look around, \nb) Turn on the generator, \nc) Check the drawer \nd) check your pockets");
        char[] options = {'a', 'b', 'c', 'd'};
        char userOption = visitor.getChoice(navigationOption, options);

        if (userOption == 'a') {
            visitor.tell("You're looking around my room... be careful where you step! \n");
            String itemOptions = ("You found some things in my room... Which one would you like to take?  \n a) Torch, \nb) Candle, \nc) Flame Thrower \nd) Nothing(feeling Brave)");
            char userItemOption = visitor.getChoice(itemOptions, options);

            if (userItemOption == 'a') {
                visitor.giveItem(TORCH);
            } else if (userItemOption == 'b') {
                visitor.giveItem(CANDLE);
            } else if (userItemOption == 'c') {
                visitor.giveItem(FLAME_THROWER);
            }else if (userItemOption == 'd') {
                visitor.tell("you sure are brave, alright then. \n");
            }
        } else if (userOption == 'b') {

            if (!generatorSwitch)
            {
                visitor.tell("You turned on the generator... Thanks! Here's some gold for your kindness. \n");
                visitor.giveGold(3);
                generatorSwitch = true;
            } else if (generatorSwitch) {

                String generatorChoices = ("Generator Is Already On, Do You Want To.. \na) Switch Off, \nb) Leave It Switch On \n");
                char[] generatorOptions = {'a', 'b'};

                char userGeneratorOption = visitor.getChoice(generatorChoices, generatorOptions);

                if (userGeneratorOption == 'a') {
                    visitor.tell("Lol You're Spooky\n");
                    visitor.takeGold(1);
                    generatorSwitch = false;
                } else if (userGeneratorOption == 'b') {
                    visitor.tell("Thank God You're Keeping It On Thank You! \n");
                    visitor.giveGold(2);
                } else{
                    visitor.tell("Okay I didn't Get That? You're Waffling \n");
                }



            }


        } else if (userOption == 'c') {
            visitor.tell("Hey, what are you doing? You shouldn't go through my things! \n But... what is that in your hand? You must have dropped some gold, give it to me!\n");
            visitor.giveItem(LONG_THING);
            visitor.takeGold(2);
        }
        else if (userOption == 'd') {
            visitor.tell("\n Seriously? I meant it as a joke you know... \n");
            visitor.takeGold(1);
        }
        else
        {
            visitor.tell("NOT VALID OPTION \n");
        }

        char[] compassOptions = new char[]{'n', 'w', 's', 'e'};


        boolean validChoice = false;
        while (!validChoice) {
            char leaveRoom = visitor.getChoice("Which direction would you wish to leave my room \n [N](a) North or [E](b) East or [S](c) South or [W](d) West? \n", options);

            if (leaveRoom == 'a') {
                visitor.tell("Leaving via North \n");
                return Direction.TO_NORTH;
            } else if (leaveRoom == 'c') {
                visitor.tell("Leaving via South \n");
                return Direction.TO_SOUTH;
            } else if (leaveRoom == 'd') {
                visitor.tell("Blocked: West is currently unavailable. \n");
            } else if (leaveRoom == 'b') {
                visitor.tell("Blocked: East is currently unavailable. \n");
            } else {
                visitor.tell("Invalid choice. \n");
            }
            // Set validChoice to true if the input is either 'n' or 's'
            validChoice = (leaveRoom == 'n' || leaveRoom == 's');
        }




        return null;
    }
}
