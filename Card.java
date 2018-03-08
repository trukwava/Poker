/**
 * Card.java 
 * class which models a card, 
 * to be used with PokerTest.java
 * 
 * COMS W1004
 * @author Trevor Rukwava (ttr2107)
 * 
 * Friday, November 3, 2017
 */ 

public class Card implements Comparable<Card>{
     
	private int suit; // uses integers 1-4 to encode the suit
	private int rank; // uses integers 1-13 to encode the rank
	
	public Card(int s, int r){
        //constructor makes a card with suit s and value v
        suit = s;
        rank = r;
	}
	
	public int compareTo(Card c){
        //this method to compares cards so they 
		// may be easily sorted
        if (c.rank < rank){
            return 1;
        }
        if (c.rank > rank){
            return -1;
        }
        if (c.rank == rank && c.suit < suit){
            return 1;
        }
        if (c.rank == rank && c.suit > suit){
            return -1;
        }
        if (c.rank == rank && c.suit == suit){
            return -1;
        }
        else {
            return 0;
        }


	}
	
	public String toString(){
        //this method easily prints a Card object
        String cardName = "";
        String cardSuit = "";
        String cardRank = "";
        
        if (suit==1){
            cardSuit= "Clubs";   
        }
        if (suit==2){
            cardSuit= "Diamonds";
        }
        if (suit==3){
            cardSuit= "Hearts";
        }
        if (suit==4){
            cardSuit= "Spades";
        }
            
        if (rank==1){
            cardRank= "Ace";
        }
        else if (rank==11){
            cardRank= "Jack";
        }
        else if (rank==12){
            cardRank= "Queen";
        }
        else if (rank==13){
            cardRank= "King";
        }
        else {
            cardRank = ""+rank;
        }
        
        cardName = cardRank+ " of "+ cardSuit;
        return cardName;
		
	}
    
    public int getRank(){
        //returns the card's rank
        return rank;
    }
    
    public int getSuit(){
        //returns the card's suit
        return suit;
    }
}
