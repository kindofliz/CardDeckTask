import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class PlayingCards {

    enum Suits {
        Hearts,
        Spades,
        Clubs,
        Diamonds
    }

    enum CardValues {
        Two,
        Three,
        Four,
        Five,
        Six,
        Seven,
        Eight,
        Nine,
        Ten,
        Jack,
        Queen,
        King,
        Ace
    }
    public static void main(String[] args) {
        //Define a new card deck array and its supposed length
        //This is where the card suits and values will be combined
        String[] cardDeck = new String[52];

        //to build the deck array
        int counter = 0;

        //Add .values method to transform an enum into an array
        for (int i = 0; i < Suits.values().length; i++) {
            for (int j = 0; j < CardValues.values().length; j++) {

                //building one deck array out of two arrays, using a counter
                cardDeck[counter] = String.format("%s %s", Suits.values()[i], CardValues.values()[j]);
                System.out.println(cardDeck[counter]);
                counter++;

            }
        }

        //SHUFFLE THE DECK (SIMPLE) using math random


        //SELECT ONE RANDOM CARD (but those can repeat)
        String randomCard = cardDeck[(int)(Math.random() * 51d)];
        System.out.println("We got a RANDOM FIRST CARD: " + randomCard);


        //SHUFFLING CARDS PROPERLY
        Random rnd = ThreadLocalRandom.current();
        for (int i = cardDeck.length - 1; i > 0; i--) {

            int index = rnd.nextInt(i + 1);
            //simple swap
            String a = cardDeck[index];
            cardDeck[index] = cardDeck[i];
            cardDeck[i] = a;

        }

        for (int i = 0; i < 6; i++) {
            System.out.println("We got 6 REALLY SHUFFLED RANDOM CARDS: " + cardDeck[i]);
        }


    }
}
