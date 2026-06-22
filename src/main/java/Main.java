public class Main {

    static public void main(String[] args){
        Board board= new Board();
        Player player1= new Player('x');
        Player player2= new Player('o');
        TicTacToe ticTacToe=new TicTacToe(board, player1, player2);

        System.out.println("Hint!\nCoordinate (0, 0) is the top left spot and also counts from the top left spot." +
                "\nFor example (2, 2) is bottom left." +
                "\nPlease enjoy the game!.");

        ticTacToe.start();
    }
}
