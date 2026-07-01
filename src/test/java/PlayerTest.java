import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    @Test
    void getMarker() {
        Player playerx = new Player('x');
        assertEquals('x',playerx.getMarker(),"Marker falsch gesetzt");

        Player playery = new Player('y');
        assertEquals('y',playery.getMarker(),"Kann nicht mit anderen markern umgehen");


    }
}