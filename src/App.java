import cs3331Helper.cs3331TicTacToeFrame;
import javafx.application.Application;
import javafx.stage.Stage;

//Main Application class
public class App extends Application{

    public void start(Stage stage){
        
        //Create the Tic Tac Toe frame
        cs3331TicTacToeFrame frame = new cs3331TicTacToeFrame(stage);
     
        //Create a new game
        myTicTacToe game = new myTicTacToe();
        //Add the game to the frame
        frame.addGame(game);

        //Create two players, one with 'X' and other with 'O'
        Players player1 =new Players("X",game);
        Players player2= new Players("O",game);

        //Add players to the game controller
        game.controller.addPlayer(player1);
        game.controller.addPlayer(player2);

    }
    //Main method
    public static void main(String[] args) throws Exception {
        launch(args);
    }
}
