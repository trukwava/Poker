/**
 * Player.java 
 * class which models a player, 
 * to be used with PokerTest.java
 * 
 * COMS W1004
 * @author Trevor Rukwava (ttr2107)
 * 
 * Friday, November 3, 2017
 */

import java.util.ArrayList;

public class Player {
	
		
	private ArrayList<Card> hand; // the player's cards
	private int bankroll;   // the number of tokens the player has
    private int bet;       // how many tokens the player bets
    private int winning;  // how many tokens the player has most recently won
    public final int HAND_SIZE;
		
	public Player(){
        HAND_SIZE= 5;
        bankroll = 100;
        bet = 1;
        hand = new ArrayList<Card>();
        winning= 0;
        
	    // create a player here
	}

	public void addCard(Card c){
        hand.add(c);
	    // add the card c to the player's hand
	}

	public void removeCard(Card c){
        hand.remove(c);
	    // remove the card c from the player's hand
        }
		
    public void bets(int amt){
        bet = amt;
        bankroll= bankroll-bet;
            // player makes a bet
        }

    public void winnings(int odds){
        winning = odds*bet;
        bankroll= bankroll + winning;
            //	adjust bankroll if player wins
    }
    
    public int getWin(){ 
        return winning;
        // return how many tokens were won
    }

    public int getBankroll(){
        return bankroll;
            // return current balance of bankroll
    }

    public String toString(){
        String theHand="";
        
        theHand = (hand.get(0)).toString();
        for (int i=1; i < HAND_SIZE; i++){
            theHand = theHand + ", " + (hand.get(i)).toString();
        }
        return theHand;
   }
     
    public ArrayList<Card> getHand(){
        return hand;
        // returns the cards which the has been dealt
    }
}


