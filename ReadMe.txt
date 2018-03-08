ReadMe							

Trevor Rukwava ttr2107

COMS W1004

Programming Project 4

Due November 3 at 11:59PM

PROGRAMMING (60 points)
Video Poker: Project P7.9 in the 6th Edition of Big Java 

The package contains Card.java, CardCheck.java, Deck.java,
Game.java, Player.java, and PokerTest.java
This project is a Poker game. It is accessed using the PokerTester.java file.
If you provide command line arguments in the form c = clubs, d = diamonds, h = hearts, s = spades, 
and 1-13 correspond to ace – king (for example: s1 = ace of spades) the program should evaluate the hand. 
Example: testhand = {s1, s13, s12, s11, s10} = royal flush.

If the program is run without command line arguments, then the full game becomes available. 
First, one sees a decorative banner. Then you are informed of how many tokens you have, 100 is the default. 
You then input a single digit between 1 and 5 in order to bet. If you enter a number outside of this range,
you will get a funny message, and the closest appropriate value of bet is chosen. If you enter a non-integer 
at any point during the program, it will crash.

You are then shown your cards, which are drawn from the top of a shuffled deck. 
You chose whether or not to keep your cards. Then after you have returned or not returned as many 
cards as you want, the final hand of 5 cards is processed and evaluated. You then get tokens proportionally
to how many you bet. If you get no pair you get 0 tokens.
One pair= 1*bet
Two pair= 2*bet
Three of a kind= 3*bet
Straight= 4*bet
Flush= 5*bet
Full House= 6*bet
Four of a kind= 25*bet
Straight flush=50*bet
Royal flush=250*bet

Your earnings or losses are added to your bankroll, and you have the option of playing 
again and again until your tokens run out.

I chose to perform the card evaluation in a separate class CardCheck.java because there was so much code involved
that I wanted to encapsulate it. It also made it easier to keep track of the hand between the playThis() and 
playThat() methods.
Some of the tests are not exhaustive, but rely on the previous tests having caught out the other cases. As such,
each individual card check method might not be 100% accurate used in isolation.

I chose to use a boolean interfacedGame which is given true or false in each of the 2 contructors in order
to split the play() method into 2 for the full game, and the code testing mode. This allowed me to avoid
having complicated if loops in the play() method.

I chose to break up the card return phase into 2, in order to save time for people who just want to return all 
cards or keep all cards. If they enter 3, they can chose cards individually. I could have allowed the user to 
chose the cards to return in one step, but that involved unnecessarily complex code, and it was hard. I repeated
the code for the questions when a for loop and a variable to keep track of the current card would have sufficed. 
I just wanted to be extra certain that the cards were being managed correctly, and that the printed message was
meaningful. 

There are a couple of unnecessary variables and methods, for example in the FourOfaKind() method, the scan1 object,
and the enhanced for loop variables. I pretty much just stopped touching the code whenever I got it to work, 
and didn't optimize it much.

The bankroll seems to carry over every time you restart. I haven't tested it out to see if this is always the case.
When your tokens finsh, you can no longer play the game again, and it will print "Game Over" and exit,
even if you press 1 for play again. The deck is reset when the bottom card is reached, when top reaches index of
NUMBER_OF_CARDS - 1.




