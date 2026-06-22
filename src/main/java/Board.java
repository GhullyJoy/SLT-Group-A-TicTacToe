public class Board {
    private char[][] cells = new char[3][3];

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


}
