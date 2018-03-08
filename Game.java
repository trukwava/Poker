/**
 * Game.java 
 * class which models a poker game, 
 * to be used with PokerTest.java
 * 
 * COMS W1004
 * @author Trevor Rukwava (ttr2107)
 * 
 * Friday, November 3, 2017
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class Game {
	
	private Player p;
	private Deck cards;
    private String[] testHand;
	private ArrayList<Card> hand;
    private boolean interfacedGame;
    private int again;
    
    public final int HAND_SIZE;
		
	public Game(String[] testHand){  // testHand is a commandline argument
        interfacedGame = false;   //this instructs the game to 
                                //only evaluate command-line args
        HAND_SIZE=5;     // player gets 5 cards per turn

        this.testHand= testHand;
        
        p = new Player();
        Card c;
        hand = new ArrayList<Card>();

        // This constructor is to help test code
		// uses the contents of testHand to
		// make a hand for the player
		// uses the following encoding for cards
		// c = clubs
		// d = diamonds
		// h = hearts
		// s = spades
		// 1-13 correspond to ace - king
		// example: s1 = ace of spades
		// example: testhand = {s1, s13, s12, s11, s10} = royal flush
    }
     
    public Game(){
        interfacedGame = true; //this instructs the game to launch full game
        HAND_SIZE=5;
        again = 1;    // again is set to zero in order to leave the game
        ArrayList<Card> hand = new ArrayList<Card>();
        cards = new Deck();
        p = new Player();
		// This no-argument constructor is to actually play a normal game
		
	}
    
	public void play(){ // this calls the 2 different play methods
        if (interfacedGame){
            playThat();        // for normal play
        }
        else {
            playThis();      // for testing code
        }
    }
	
     public void playThis(){
        int suit=0;
        int rank=0;
        // parses the testHand command-line args 
        // and converts to cards for processing
        try {
            for (String theCard: testHand){
                if ((theCard.substring(0,1)).equals("c")){
                suit=1;
                }
                if ((theCard.substring(0,1)).equals("d")){
                suit=2;
                }
                if ((theCard.substring(0,1)).equals("h")){
                suit=3;
                }
                if ((theCard.substring(0,1)).equals("s")){
                suit=4;
                }
                else{
                    NumberFormatException n=new NumberFormatException();
                    throw n;
                }
                
                int r=Integer.parseInt(theCard.substring(1,theCard.length()));
                if (r<1||r>13){
                    NumberFormatException n2= new NumberFormatException();
                    throw n2;
                }
                else {
                    rank=r;
                }
                
                Card c = new Card(suit, rank);
                p.addCard(c);
            }
            
            hand = p.getHand();
            Collections.sort(hand);     //this sorts the hand 
            System.out.println(hand);
            CardCheck cardCheck = new CardCheck(hand); 
             //sends the constructed ArrayList<Card> hand to CardCheck
             // in order to evaluate the hand
            System.out.println(cardCheck.checkHand()); 
            // prints out value of hand
        }
        catch (NumberFormatException n){
            System.out.println("The format of your input is wrong.\n"+
               "Please enter cards as follows:\n"+
               "First letter of suit followed by the number of rank.\n"+
               "e.g. s1 is Ace of Spades, h2 is Two of Hearts, "+
               "and c13 is King of Clubs");
        }  
        
    }
        
    
	public void playThat(){      //normal game
        cards = new Deck();
        while (again==1 && p.getBankroll()>0){
            System.out.println("\n \n♤ ♡ ♢ ♧ ♤ ♥ ♢ ♧ Welcome to Video Poker!"+
                               " ♤ ♡ ♢ ♧ ♤ ♥ ♢ ♧ \n \n");
            Card temp; 
            for (int i=0; i < HAND_SIZE; i++){
                temp = cards.deal();  // get cards from Deck.java
                p.addCard(temp); // make an ArrayList of 5 cards in Player.java
            }
            hand = p.getHand();        // get ArrayList from player
            Collections.sort(hand);    // sort the list

            int bet;    // get user input for how many tokens to bet
            Scanner scan = new Scanner(System.in);    
            System.out.println("You have "+ p.getBankroll() +" tokens.");
            System.out.println("\nHow many tokens, from 1 to 5,"+
                               " would you like to bet?");
            bet = scan.nextInt();
            // accounts for erroneous input by maxing out or minimuming out
            if (bet>5){
                System.out.println("Thanks for the extra cash! But"+
                      "maybe think about feeding your kids. Here are your "
                      +(bet-5)+" tokens back.");
                bet = 5;
                
            }
            if (bet<1){
                System.out.println("I'm trying to run a business here! "+
                                   "Let me have that token.");
                bet = 1;
            }
            p.bets(bet);
            System.out.println("\nYou have "+p.getBankroll()+" tokens left.\n");
                        // subtract bet from Bankroll

            System.out.println("Your cards are "); // print out the sorted cards
            String say = "";
            int list = 1;
            for (Card thecard : hand){
                say= say + list + ". " + thecard.toString() + "\n";
                list++;
            }
            System.out.println(say);
                                      // ask user to keep or return cards
            Scanner scan1= new Scanner(System.in);        
            System.out.println("What do you want to do? \n1. Keep all cards");
            System.out.println("2. Return all cards and receive new ones");
            System.out.println("3. Choose some cards to return "+
                  "\nPlease enter the number corresponding to your choice.");
            if (!(scan1.hasNextInt())){
                System.out.println("Error!");
            }
            int choice =scan1.nextInt();
            if (choice==2){
                hand.clear();
            }

            if (choice==3){
                int selector=0;
                scan1= new Scanner(System.in);
                System.out.println("Do you want to keep the first card?"+
                                   " 1 for yes, 0 for no");
                int result = scan1.nextInt();
                if (result==0){
                        System.out.println("Card removed.");
                        hand.remove(selector);

                }
                else if (result==1){
                    System.out.println("Card kept.");
                    selector++;
                }
                else{
                    System.out.println("Error: Please enter valid input");
                }

                scan1 = new Scanner(System.in);
                System.out.println("Do you want to keep the second card?"+
                                   " 1 for yes, 0 for no");
                result = scan1.nextInt();
                if (result==0){
                    System.out.println("Card removed.");
                    hand.remove(selector);
                }
                else if (result==1){
                    System.out.println("Card kept.");
                    selector++;
                }
                else{
                    System.out.println("Error: Please enter valid input");
                }

                scan1 = new Scanner(System.in);
                System.out.println("Do you want to keep the third card?"+
                                   " 1 for yes, 0 for no");
                result = scan1.nextInt();
                    if (result == 0){
                        System.out.println("Card removed.");
                        hand.remove(selector);
                    }
                    else if (result == 1){
                        System.out.println("Card kept.");
                        selector++;
                    }
                    else{
                        System.out.println("Error: Please enter valid input");
                    }

                scan1 = new Scanner(System.in);
                System.out.println("Do you want to keep the fourth card?"+
                                   " 1 for yes, 0 for no");
                result = scan1.nextInt();
                if (result == 0){
                    System.out.println("Card removed.");
                    hand.remove(selector);
                }
                else if (result == 1){
                    System.out.println("Card kept.");
                    selector++;
                }
                else{
                    System.out.println("Error: Please enter valid input");
                }

                scan1 = new Scanner(System.in);
                System.out.println("Do you want to keep the fifth card?"+
                                   " 1 for yes, 0 for no");
                result = scan1.nextInt();
                if (result == 0){
                    System.out.println("Card removed.");
                    hand.remove(selector);
                }
                else if (result == 1){
                    System.out.println("Card kept.");
                    selector++;
                }
                else{
                    System.out.println("Error: Please enter valid input");
                }

                if (hand.size()>0){
                System.out.println("These are your cards ");
                say = "";
                list = 1;
                for (Card thecard2 : hand){
                    say = say + list + ". " + thecard2.toString() + "\n";
                    list++;
                }
                System.out.println(say); 
                }

                else{
                    System.out.println("You have no cards left.");
                }
            }                        // get new cards
            if (choice>1){
                System.out.println("Dealing...");
                while (hand.size()<5){

                    temp = cards.deal();
                    p.addCard(temp);
                } 


                Collections.sort(hand);    // sort the new cards

                System.out.println("These are your cards ");
                say = "";
                list = 1;
                for (Card thecard3 : hand){
                    say = say + list + ". " + thecard3.toString() + "\n";
                    list++;
                }
                System.out.println(say);  // print the final card list
            }
                                    // start evaluating the hand
            System.out.println("\nThe result is.... ");
            CardCheck cardCheck = new CardCheck(hand);
            System.out.println(cardCheck.checkHand());
                                    // print the value of the hand
                        
            p.winnings(cardCheck.odds());
            System.out.println("You won "+p.getWin()+ " tokens!");   
            System.out.println("\nYou now have "+p.getBankroll()+" tokens.");  
                            // tell player how much money they now have
            if (p.getBankroll()==0){
                System.out.println("You're out of tokens, bub. Go hit the ATM,"+
                                "or see someone about your gambling problem.");
            }                  // game exits if out of tokens
            scan1 = new Scanner(System.in);
            
            hand.clear();          // reset the hand at the end of the game

            System.out.println("\nWould you like to play again? "+
                               "\n1 for yes, and 0 for no.");
            again = scan1.nextInt();
            if (again != 1 || p.getBankroll()== 0 ){
                System.out.println("              GAME OVER!!! \n\n"+
                "♤ ♡ ♢ ♧ ♤ ♥ ♢ ♧  Thanks for playing!   ♤ ♡ ♢ ♧ ♤ ♥ ♢ ♧");
            }
                                            // end of game

        }
    }
}