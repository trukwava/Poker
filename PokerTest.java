
public class PokerTest{

    //this class must remain unchanged
    //your code must work with this test class
 
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
