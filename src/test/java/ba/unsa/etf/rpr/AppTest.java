package ba.unsa.etf.rpr;

import static ba.unsa.etf.rpr.App.*;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;

public class AppTest
{

    @Test
    void ValidacijaTest1()
    {
        assertEquals(true,App.ValidacijaIzraza("( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )"));
    }

    @Test
     void ValidacijaTest2()
    {
        assertEquals(true,App.ValidacijaIzraza("( 1 + ( 4 * 5 ) )"));
    }

    @Test
     void ValidacijaTest3()
    {
        assertThrows(RuntimeException.class, ()->ValidacijaIzraza("( (1 + 5 ) ++ 1 )"),"Nevalidan format izraza");
    }

    @Test
     void ValidacijaTest4()
    {
        assertThrows(RuntimeException.class, ()->ValidacijaIzraza("((1 + 5 )+ 1 )"),"Nevalidan format izraza");
    }

    @Test
     void ValidacijaTest5()
    {
        assertThrows(RuntimeException.class, ()->ValidacijaIzraza("(1+2*3)"),"Nevalidan format izraza");
    }


}
