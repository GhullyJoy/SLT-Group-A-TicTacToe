import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    void getCells() {
    }

    @Test
    void isCellEmpty() {
        Board positiveBoard = new Board();
        positiveBoard.place(0,0,'x');
        assertFalse(positiveBoard.isCellEmpty(0,0),"Zelle wurde nicht korrekt befüllt");

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
    }

    @Test
    void checkGameState() {
    }

    @Test
    void clear() {
    }
}