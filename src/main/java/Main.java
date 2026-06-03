public class Main {

    static public void main(String[] args){
        Board board= new Board();
        Player player1= new Player('x');
        Player player2= new Player('o');
        TicTacToe ticTacToe=new TicTacToe(board, player1, player2);

        ticTacToe.start();
    }
}
