package OOP.ec22954.MP;

    class House_ec22954 extends House {

        Room r1;
        Room r2;
        Room r3;
        boolean close;

        House_ec22954() {

            r1 = new Room_ec22704();
            r2 = new Room_ec22954();
            r3 = new Room_ec22466();

        }

        public Direction visit(Visitor visitor, Direction direction) {
            char choices_yn = '0'; // get users choice yes or no (sub choices)
            char choices_la = '0'; // get users choice the letters (main choices)
            close = false; // default

            char[] visitorChoiceLa = { 'a', 'b', 'c', 'd' }; // create char array for letters options
            char[] visitorChoiceYn = { 'Y', 'N' }; // create char array for yes and no options

            while (!close) {

                direction = r1.visit(visitor, direction); // start my room

                choices_la = visitor.getChoice(
                        " You're out of the room do you want \n a) go to another room \nb) look around \nc) leave the house \nd)take a nap",
                        visitorChoiceLa); // the hallway

                if (choices_la == ('a')) {

                    direction = r3.visit(visitor, direction); // visting room 3

                }

                else if (choices_la == ('b')) {

                    visitor.tell(" It's such an old house, with alot of mistries don't you think that ");

                    choices_la = visitor.getChoice(" don yo want a) go to anthore room or b) leave the house ? ",
                            visitorChoiceLa); // the hallway

                    if (choices_la == ('a')) {

                        direction = r2.visit(visitor, direction); // visting room 2

                    }

                    else if (choices_la == 'b') {
                        close = true; // close is true, leave the house

                        break;
                    }

                    else {
                        visitor.tell("That is not one of the options you cheeky bugger \n i'll let you go though since you want to cheat your way around\n");

                        break;
                    }
                }

                if (choices_la == ('c')) { // close is true, leave the house
                    close = true;

                    break;

                } else if (choices_la == 'd'){

                    visitor.tell("\n You take a nap on the floor, for some reason... you're weird\n you wake up outside the house... \n The End? I guess...");
                    close = true;

                    break;
                }
            }
            return direction;

        }
    }

