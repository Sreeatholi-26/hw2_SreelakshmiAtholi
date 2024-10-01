import javafx.scene.paint.Color;
import cs3331Helper.cs3331TicTacToeBoard;
import cs3331Helper.cs3331TicTacToeGame;
import cs3331Helper.cs3331TicTacToePlayer;
import cs3331Helper.cs3331TicTacToeController;

//Main class for the Tic Tac Toe game
public class myTicTacToe implements cs3331TicTacToeGame 
{
    cs3331TicTacToeBoard board;
    cs3331TicTacToeController controller;

    //Constructor myTicTacToe initializes the game board and controller
    public myTicTacToe() 
    {
        board = new cs3331TicTacToeBoard();
        controller = new cs3331TicTacToeController();
        
        //Set initial game message
        controller.setControllerMessage("Select a square to start playing!");
    }

    //Method to handle an invalid square chosen
    @Override
    public void invalidSquareChosen(int row, int col) 
    {
        //Set a message for the user to understand
        controller.setControllerMessage("Square chosen has already been taken. Try again.");
        // Flash the selected square in red color to indicate an error
        this.board.squareAt(row,col).flashColor(Color.RED);
    }
    
    //Method called when a player wins
    @Override
    public void playerWins() 
    {
        //Get the winning player from the controller
        cs3331TicTacToePlayer winningPlayer= controller.getWinningPlayer();
        Players actualPlayer=null;

        //Check if the winning player is an instance of player and cast it 
        if(winningPlayer instanceof Players)
        {
            actualPlayer = (Players) winningPlayer;
        } 
        
        //Set the message that indicates which player won
        this.controller.setControllerMessage(actualPlayer.getIcon() + " Wins! ");

        //Highlight the winning squares in yellow
        this.board.highlightWinningSquares(Color.PALETURQUOISE);
    }

    //Method called when there is no winner
    @Override
    public void noWinner() 
    {
        //Set a message indicating the game ended in a tie
        controller.setControllerMessage("It's a tie!");
    }

    //Method to restart the game
    @Override
    public void restartGame() 
    {
        //Clear the board symbols and highlights
        this.board.clearSymbols();
        this.board.clearHighlights();

        //Prompt to play again
        this.controller.playAgain();

        //Reset to the initial game message
        controller.setControllerMessage("Select a square to start playing!");
        
    }

   
}
