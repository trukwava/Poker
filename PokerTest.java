/** This class is the tester for the poker game */
public class PokerTest{ 
    public static void main(String[] args){
        if (args.length<1){
                Game g = new Game();
                g.play();
        }
        else{
            if(args.length==5){
            Game g = new Game(args);
            g.play();
            }
            else{
                System.out.println("Please enter 5 cards");
            }
        }
    }

}
