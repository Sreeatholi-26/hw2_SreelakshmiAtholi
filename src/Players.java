import cs3331Helper.cs3331TicTacToePlayer;
import cs3331Helper.cs3331TicTacToeSquare;

public class Players implements cs3331TicTacToePlayer 
{
    //Creates instance variables for player icon and game reference
    private String icon;
    private myTicTacToe game;
    
    //Constructor for the Players class
    public Players(String icon,myTicTacToe game)
    {
        this.icon=icon; //Set player icon to either X or O
        this.game=game; //Refernce to the game instance
    }

    //Getter method to retrieve the player's icon
    public String getIcon() 
    {
        return icon;
    }

    //Method to handle square selection by the player
     @Override
    public void selectSquare(int row, int col) 
    {
        //Get the square method at specified row and column
        cs3331TicTacToeSquare square=this.game.board.squareAt(row,col);
        
        //Mark the square with the player's icon
        square.markSquare(icon);
        //Set a message indicating the player has finished their turn
        this.game.controller.setControllerMessage(" Player " + icon + " has finished ");
        //Notify the controller the player has finished the turn
        this.game.controller.finishedTurn();
    }
}