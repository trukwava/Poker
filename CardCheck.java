/**
 * CardCheck.java 
 * performs checks on card objects to find their poker values, 
 * to be used with PokerTest.java
 * 
 * COMS W1004
 * @author Trevor Rukwava (ttr2107)
 * 
 * Friday, November 3, 2017
 */ 

import java.util.ArrayList;

public class CardCheck {
    
    private ArrayList<Card> hand;
    public final int HAND_SIZE;
    
    // constructor to test 5 card hand
    public CardCheck(ArrayList<Card> testHand){
        HAND_SIZE = 5;               // 5 cards per hand
        hand = new ArrayList<Card>();
        hand = testHand;
        
    }
    // performs a series of tests on hand
    public String checkHand(){
        
        if (royalFlush()){
			return "You have a royal flush!";
		}
		else if (straight() && flush()){
			return "You have a straight flush!";
		}
		else if (fourOfaKind()){
			return "You have four of a kind!";
		}
		else if (fullHouse()){
			return "You have a full house!";
		}
		else if (flush()){
			return "You have a flush!";
		}
		else if (straight()){
			return "You have a straight!";
		}
		else if (triple()){
			return "You have three of a kind!";
		}
		else if (twoPairs()){
			return "You have two pairs!";
		}
		else if (pair()){
			return "You have a pair!";
		}
		else{
			return "Unfortunately, you have no pair.";
		}
	}
    
	// checks for a royal flush
	int check=0;
	public boolean royalFlush(){
        // checks if ace, then 10, Jack, Queen, then King
        if (!(((hand.get(0)).getRank()) == 1 && (hand.get(1)).getRank() == 10
              && (hand.get(2)).getRank() == 11 && (hand.get(3)).getRank() == 12
              && (hand.get(4)).getRank() == 13)){
            return false;
        }
        //checks if all are spades
     /*   for (Card test: hand){
            if  (test.getSuit() == 4){
               check++;
            }
        }
        if (check == 5){
            return true;
        }  */
        return true;
    }   

	public boolean fourOfaKind(){
        
        int check = 0;
        for (int j=0; j < HAND_SIZE; j++){
            check = 0;
            for(int i = 0; i < HAND_SIZE; i++){
                if ((hand.get(j)).getRank() == (hand.get(i)).getRank()){
                    check++;
                }   // checks if there are 
            }
            if (check==4){
                return true;
            }
        }
        
        int comparison=0;
        if ((hand.get(0)).getRank() == (hand.get(1)).getRank()){
            for (int i = 1; i < HAND_SIZE; i++){
                if ((hand.get(0)).getRank() == (hand.get(i)).getRank())
                comparison++;
            }
        }
        else {
            for (int i = 1; i < HAND_SIZE-1; i++){
                if ((hand.get(HAND_SIZE-1)).getRank()==(hand.get(i)).getRank())
                comparison++;
            }
        }
            
		if (comparison == 4){
			return true;
		}
		else{
			return false;
		}
    }
	
	// checks for full house
	public boolean fullHouse(){

	return (((hand.get(0)).getRank() == (hand.get(1)).getRank() && 
             (hand.get(1)).getRank() == (hand.get(2)).getRank() &&
             (hand.get(3)).getRank()== (hand.get(4)).getRank())||
             ((hand.get(4)).getRank() == (hand.get(3)).getRank() &&
             (hand.get(3)).getRank() == (hand.get(2)).getRank() && 
             (hand.get(1)).getRank()== (hand.get(0)).getRank()));
    }       
	
	// checks for flush
	public boolean flush(){
		for (int i = 1; i < HAND_SIZE; i++){
			if ((hand.get(0)).getSuit() != (hand.get(i)).getSuit()){
				return false;
			}
		}
		return true;
	}
	
	// check for straight
	public boolean straight(){
		for (int i = 0; i < HAND_SIZE-1; i++){
            if (hand.get(0).getRank()==0 && hand.get(1).getRank()==10 && 
                hand.get(2).getRank()==11 && hand.get(3).getRank()==12 &&
                hand.get(4).getRank()==13){
                return true;
            }
			if ((hand.get(i)).getRank() != ((hand.get(i+1)).getRank() - 1)){
				return false;
			}		
		}
		return true;
	}
	
	// checks for triple
	public boolean triple(){
        for (int i=0; i<3; i++){
            if (hand.get(i).getRank()==hand.get(i+1).getRank() && 
                hand.get(i+1).getRank()==hand.get(i+2).getRank()){
                return true;
            }
        }
        return false;
    }
        
	// checks for two pairs
	public boolean twoPairs(){
		int check = 0;
		for(int i = 0; i < HAND_SIZE - 1; i++){
			if ((hand.get(i)).getRank() == (hand.get(i+1)).getRank()){
				check++;
			}
		}
		if (check == 2){
			return true;
		}
		else{
			return false;
		}
	}
	
	// check for one pair
	public boolean pair(){
		int check = 0;
		for(int i = 0; i < HAND_SIZE-1; i++){
			if ((hand.get(i)).getRank() == (hand.get(i+1)).getRank()){
				check++;
			}
		}
		if (check == 1){
			return true;
		}
		else{
			return false;
		}
	}	

    public int odds(){
        // returns the odds associated with each hand 
        // in order to calculate winnings
        if (royalFlush()){
			return 250;
		}
		else if (straight() && flush()){
			return 50;
		}
		else if (fourOfaKind()){
			return 25;
		}
		else if (fullHouse()){
			return 6;
		}
		else if (flush()){
			return 5;
		}
		else if (straight()){
			return 4;
		}
		else if (triple()){
			return 3;
		}
		else if (twoPairs()){
			return 2;
		}
		else if (pair()){
			return 1;
		}
		else{
			return 0;
		}
    }
}
    
    
