import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;

class BoardTest {

    @Test
    void getCells() {
        Board board = new Board();
        board.place(0,0,'x');

        assertEquals('x',board.getCells()[0][0],"getCells spiegelt game state nicht wieder");

        board.place(1,1,'y');
        assertEquals('y',board.getCells()[1][1],"getCells kann nicht mit anderen zeichen umgehen");
    }

    @Test
    void isCellEmpty() {
        Board positiveBoard = new Board();
        positiveBoard.place(0,0,'x');
        assertFalse(positiveBoard.isCellEmpty(0,0),"Zelle wurde nicht korrekt befüllt");

        positiveBoard.place(1,1,'y');
        assertFalse(positiveBoard.isCellEmpty(1,1),"Zelle wurde nicht korrekt befüllt");

        Board negativeBoard = new Board();
        assertThrows(
                IllegalArgumentException.class
                ,()->{
                    negativeBoard.isCellEmpty(3,3);
                }
                ,"Wirft keine Exception wenn invalider Input gegeben wurde"
        );
    }

    @Test
    void place() {

        //erster test eher redundant, weil er von isCellEmpty abhängt
        Board positiveBoard = new Board();
        positiveBoard.place(0,0,'x');
        assertFalse(positiveBoard.isCellEmpty(0,0),"Zelle wurde nicht korrekt befüllt");

        Board negativeBoard = new Board();
        assertThrows(
                IllegalArgumentException.class
                ,()->{
                    negativeBoard.place(3,3,'x');
                }
                ,"Wirft keine Exception wenn invalider Input gegeben wurde"
        );
    }

    @Test
    void print() {
        Board board = new Board();
        board.place(0,0,'x');

        try {
            String text = tapSystemOut(() -> {
                board.print(); // Diese Methode ruft intern System.out.println() auf
            });
            text=text.trim();//Zeilenumbrüche trimmen
            assertEquals(
                    """
                            -------
                            |X| | |
                            | | | |
                            | | | |
                            -------"""
                    ,text
            ,"Gibt board state nicht korrekt wieder");


            board.place(1,1,'y');

            text = tapSystemOut(() -> {
                board.print(); // Diese Methode ruft intern System.out.println() auf
            });
            text=text.trim();//Zeilenumbrüche trimmen
            assertEquals(
                    """
                            -------
                            |X| | |
                            | |Y| |
                            | | | |
                            -------"""
                    ,text
                    ,"Gibt board state nicht korrekt wieder");

        } catch (Exception e) {
            System.out.println("Etwas ist mit tapSystemOut shief gelaufen: "+e.getStackTrace());
        }

    }

    @Test
    void checkGameState() {
        Board board = new Board();

        assertEquals(GameState.RUNNING,board.checkGameState());

        board.place(0,0,'x');
        board.place(1,1,'x');
        board.place(2,2,'x');

        assertEquals(GameState.X_WINS,board.checkGameState(),"Erkennt nicht wann ein Spieler gewonnen hat");


        Board undefinedPlayer = new Board();
        undefinedPlayer.place(0,0,'y');
        undefinedPlayer.place(1,1,'y');
        undefinedPlayer.place(2,2,'y');

        assertNotEquals(GameState.RUNNING,undefinedPlayer.checkGameState(),"Spiel läuft weiter obwohl ein Spieler bereits gewonnen hat");
        assertNotEquals(GameState.O_WINS,undefinedPlayer.checkGameState(),"y wird mit o verwechselt");
        assertNotEquals(GameState.X_WINS,undefinedPlayer.checkGameState(),"y wird mit x verwechselt");

    }

    @Test
    void clear() {
        Board board = new Board();

        board.place(0,0,'x');
        board.place(1,1,'x');
        board.place(2,2,'x');

        board.clear();
        assertEquals(' ',board.getCells()[0][0],"marker wurde nicht entfernt");
        assertEquals(GameState.RUNNING,board.checkGameState(),"clear setzt den gamestate nicht zurück");
    }
}