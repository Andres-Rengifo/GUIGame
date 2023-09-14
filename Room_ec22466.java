package OOP.ec22954.MP;

class Room_ec22466 extends Room {
    static final Item apple = new Item("Apple");
    static final Item map = new Item("Map");
    static final Item coal = new Item("Coal");

    public Direction visit(Visitor visitor, Direction visitorDirection){
        char [] options = {'a', 'b', 'c', 'd'};
        visitor.tell("Creature:\n Hello traveller, you looking lost here.");
        visitor.tell("Creature:\n This is my shop, but usually nobody comes around :( .");
        visitor.tell("Creature:\n I know you wanna get something from my store so I'm gonna give you 4 options.");

        char choice = visitor.getChoice("Select from the following(1-4)\n - 1.Take a map of the forest (2 gold)| \n 2. Golden Apple (1 gold) get at South| \n 3. Choice from me(free) get at West| \n 4. Sell me your coat, it's freezing!", options);

        if (choice == 'a') {
            visitor.takeGold(2);
            visitor.giveItem(map);
            visitor.tell(" \nCreature: Here is a map of the forest, use it to navigate yourself around the forest \n");
        }

        else if (choice == 'b') {
            visitor.takeGold(1);
            visitor.giveItem(apple);
            visitorDirection = Direction.TO_SOUTH;
            visitor.tell("\n Creature: This apple will heal you if your critical moments. \n");
        }

        else if (choice == 'c') {
            visitor.giveItem(coal);
            visitorDirection = Direction.TO_WEST;
            visitor.tell(" \n Creature: Sorry someone told you weren't good this year. You deserve the coal \n");
        }

        else if (choice == 'd') {
            visitor.tell("\n Thanks for the jacket, this should keep me warm in the cold, take 6 pieces of gold \n");
            visitor.giveGold(6);
        }

        else {
            visitor.tell("\n Are you trying to steal from my shop, okay now I will steal from you! \n");
            visitor.takeGold(3);
            visitorDirection = Direction.opposite(visitorDirection);
        }

        return visitorDirection;


    }

}
