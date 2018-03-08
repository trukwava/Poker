/**
 * Deck.java 
 * class which models a deck of cards, 
 * to be used with PokerTest.java
 * 
 * COMS W1004
 * @author Trevor Rukwava (ttr2107)
 * 
 * Friday, November 3, 2017
 */


public class Deck {
	
	private Card[] cards;
	private int top; // the index of the top of the deck
    public final int NUMBER_OF_CARDS;
    public final int SHUFFLE_TIMES;
    public final int NUMBER_OF_SUITS;
    public final int NUMBER_OF_RANKS;
	
	public Deck(){
        NUMBER_OF_CARDS = 52;
        SHUFFLE_TIMES = 1000;
        NUMBER_OF_SUITS = 4;
        NUMBER_OF_RANKS = 13;
        cards = new Card[NUMBER_OF_CARDS];
        top = 0;
        make();
        shuffle();
		// makes a 52 card deck
	}
	
    
    
	public void shuffle(){
        // shuffles the deck by exchanging 2 random cards 1000 times
        int index1;
        int index2;
        Card temp;
            
        for (int i=0; i< SHUFFLE_TIMES; i++){    
            index1 = (int)(Math.random()*NUMBER_OF_CARDS);
            index2 = (int)(Math.random()*NUMBER_OF_CARDS);
            temp = cards[index1];
            cards[index1]=cards[index2];
            cards[index2]= temp;
        }
		
	}
	
	public Card deal(){
        top++;
        if (top >= NUMBER_OF_CARDS-1){   // reset the deck when empty
            shuffle();
            top=1;
        }
        return cards[top-1];  
		// deal the top card in the deck
	}

    public void make(){
        // generates a fresh deck of cards 
        int index = 0;
        for (int s=1; s < NUMBER_OF_SUITS+1; s++){
            for (int r=1; r < NUMBER_OF_RANKS + 1; r++){
                cards[index] = new Card(s, r);
                index++;
            }
        } 
    }
}
