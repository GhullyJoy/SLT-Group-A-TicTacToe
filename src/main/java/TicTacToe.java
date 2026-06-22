import java.util.Scanner;

public class TicTacToe {
    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;


    public TicTacToe(Board board, Player player1, Player player2) {
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;
    }

    private void switchCurrentPlayer(){
        if(currentPlayer == player1){
            currentPlayer = player2;
        }
        else if(currentPlayer == player2){
            currentPlayer = player1;
        }
    }

    public void start(){
        int x,y;
        Scanner sc= new Scanner(System.in);

        while(true){
            board.print();
            System.out.print("Row(0-2): ");
            x= sc.nextInt();

            System.out.println();

            System.out.print("Column(0-2): ");
            y= sc.nextInt();
            board.place(x,y, currentPlayer.getMarker());

            // check game state before switching

            GameState state = board.checkGameState();

            if (state == GameState.X_WINS) {
                board.print();
                System.out.println("X gewinnt!");
                return;
            }
            if (state == GameState.O_WINS) {
                board.print();
                System.out.println("O gewinnt!");
                return;
            }
            if (state == GameState.DRAW) {
                board.print();
                System.out.println("Unentschieden!");
                return;
            }
            switchCurrentPlayer();
        }
    }

}
