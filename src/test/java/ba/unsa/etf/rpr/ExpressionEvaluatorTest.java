package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class ExpressionEvaluatorTest {

    // Testovi evaluation - evaluation9 testira izračunavanje i povratni rezultat posljeđenog izraza.
    // Test evaluation10 testira bacanje RunTimeException izuzetka.
    @Test
    void evaluate() {
        ExpressionEvaluator e = new ExpressionEvaluator();
         Double rezultat = e.evaluate("( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )");
        assertEquals(101,rezultat);
    }

    @Test
    void evaluate1() {
        ExpressionEvaluator e = new ExpressionEvaluator();
        Double rezultat = e.evaluate("( 10 + 5 )");
        assertEquals(15,rezultat);
    }

    @Test
    void evaluate2() {
        ExpressionEvaluator e = new ExpressionEvaluator();
        Double rezultat = e.evaluate("( 10 - 5 )");
        assertEquals(5,rezultat);
    }

    @Test
    void evaluate3() {
        ExpressionEvaluator e = new ExpressionEvaluator();
        Double rezultat = e.evaluate("( 1 * ( 4 * 5 ) )");
        assertEquals(20,rezultat);
    }

    @Test
    void evaluate4() {
        ExpressionEvaluator e = new ExpressionEvaluator();
        Double rezultat = e.evaluate("( 10 / ( 2 + 3 ) )");
        assertEquals(2,rezultat);
    }

    @Test
    void evaluate5() {
        ExpressionEvaluator e = new ExpressionEvaluator();
        Double rezultat = e.evaluate("( sqrt 25 )");
        assertEquals(5,rezultat);
    }

    @Test
    void evaluate6() {
        ExpressionEvaluator e = new ExpressionEvaluator();
        Double rezultat = e.evaluate("( 1.5 * 2.5 )");
        assertEquals(3.75,rezultat);
    }

    @Test
    void evaluate7() {
        ExpressionEvaluator e = new ExpressionEvaluator();
        Double rezultat = e.evaluate("( -1.5 / 2.5 )");
        assertEquals(-0.6,rezultat);
    }

    @Test
    void evaluate8() {
        ExpressionEvaluator e = new ExpressionEvaluator();
        Double rezultat = e.evaluate("( 1 + ( 5 * 20 ) )");
        assertEquals(101,rezultat);
    }

    @Test
    void evaluate9() {
        ExpressionEvaluator e = new ExpressionEvaluator();
        Double rezultat = e.evaluate("( ( 1 + ( 5 * 20 ) ) + 1 )");
        assertEquals(102,rezultat);
    }

    @Test
    void evaluate10() {
        ExpressionEvaluator e = new ExpressionEvaluator();
        assertThrows(RuntimeException.class, ()->e.evaluate("( (1 + 5 ) + 1 )"),"Nevalidan format izraza");

    }

}