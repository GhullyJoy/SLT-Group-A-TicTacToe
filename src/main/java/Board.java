public class Board {
    private char[][] cells = new char[3][3];

    public char[][] getCells() {
        return cells;
    }

    public Board(){
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                cells[x][y]=' ';
            }
        }
    }
    public boolean isCellEmpty(int x, int y)throws IllegalArgumentException{
        if(x>2||y>2||x<0||y<0){
            throw new IllegalArgumentException("Für X oder Y wurde ein Wert übergeben der nicht zwischen 0 und 2 liegt.");
        }
        if(cells[x][y]!=' '){
            return true;
        }else{
            return false;
        }
    }

    public void place(int x, int y, char marker)throws IllegalArgumentException{
        if(x>2||y>2||x<0||y<0){
            throw new IllegalArgumentException("Für X oder Y wurde ein Wert übergeben der nicht zwischen 0 und 2 liegt.");
        }
        if(isCellEmpty(x, y)){
            throw new IllegalArgumentException("Cell is already occupied");
        }
        cells[x][y]=marker;
    }

    public void print(){
        System.out.println("-------");
        for (int i = 0; i <= 2; i++) {
            System.out.print("|");

            for (int j = 0; j <= 2; j++) {
                if(cells[i][j] == 'x'){
                    System.out.print("X|");
                }
                else if (cells[i][j] == 'o') {
                    System.out.print("O|");
                }
                else{
                    System.out.print(" |");
                }

            }
            System.out.print("\n");

        }
        System.out.println("-------");
    }

    public GameState checkGameState() {
        // check rows
        for (int i = 0; i < 3; i++) {
            if (cells[i][0] != ' ' &&
                    cells[i][0] == cells[i][1] &&
                    cells[i][1] == cells[i][2]) {

                return (cells[i][0] == 'x')
                        ? GameState.X_WINS
                        : GameState.O_WINS;
            }
        }
        // check columns
        for (int i = 0; i < 3; i++) {
            if (cells[0][i] != ' ' &&
                    cells[0][i] == cells[1][i] &&
                    cells[0][i] == cells[2][i]) {

                return (cells[0][i] == 'x')
                        ? GameState.X_WINS
                        : GameState.O_WINS;
            }
        }
        // check anit-diagonal
        if (cells[0][2] != ' ' &&
                cells[0][2] == cells[1][1] &&
                cells[1][1] == cells[2][0]) {

            return (cells[0][2] == 'x')
                    ? GameState.X_WINS
                    : GameState.O_WINS;
        }
        // check main diagonal
        if (cells[0][0] != ' ' &&
                cells[0][0] == cells[1][1] &&
                cells[1][1] == cells[2][2]) {

            return (cells[0][0] == 'x')
                    ? GameState.X_WINS
                    : GameState.O_WINS;
        }
        // check if there are still empty spaces
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                if (cells[x][y] == ' ') {
                    return GameState.RUNNING;
                }
            }
        }
        // if none of the above, the game ends in a draw since if GameState isn't .RUNNING, it's over.
        return GameState.DRAW;
    }

    public void clear(){
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                cells[i][j] = ' ';
            }
        }
    }
}
