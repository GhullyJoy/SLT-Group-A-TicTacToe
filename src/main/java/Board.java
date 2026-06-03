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
        cells[x][y]=marker;
    }


}
