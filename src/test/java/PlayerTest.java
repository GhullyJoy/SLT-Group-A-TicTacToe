import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    @Test
    void getMarker() {
        Player positivePlayer = new Player('x');
        assertEquals('x',positivePlayer.getMarker(),"Marker falsch gesetzt");

        //kein negativer testfall möglich, da man weder einen leeren char, noch 2 chars übergeben kann
    }
}