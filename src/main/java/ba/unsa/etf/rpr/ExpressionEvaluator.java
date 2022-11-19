package ba.unsa.etf.rpr;

import java.util.Stack;


/** Klasa ExpressionEvaluator ima samo jednu metodu ( evaluate ) pomoću koje računa izraz.<br>
  *
  * <b>English description</b><br>
  * The ExpressionEvaluator class has only one method ( evaluate ) that evaluates the expression.
 * */


public class ExpressionEvaluator {
    /** Metoda evaluate računa vrijednost prosljeđenog String izraza kao parametra i vraća rezultat double tipa.<br>
     * Ova metoda koristi dva stack-a za izračunavanje izraza prema Dijekstra algoritmu.
     * Stack operacije pohranuje operande.
     * Stack brojevi pohranjuje brojčane vrijednosti koje se izračunavanju.<br>
     * Napomena: Ova metoda ne podržava prioritete operatora, tako da je za svaki operator potrebno dodati zagrade koko bi se definisao prioritet nad njima.<br>
     * Primjer: Izraz ( 1 + sqrt 25 ) = 5.0 dok ( 1 + ( sqrt 25 ) ) = 6.0
     * <br><br>
     * <b>English description</b><br>
     * The evaluate method calculates the value of the passed String expression as a parameter and returns a result of type double.<br>
     * This method uses two stacks to calculate the expressions according to the Dijkstra's algorithm.
     * The stack operation stores the operands.
     * Stack numbers stores numerical values that will be calculated.<br>
     * Note: This method does not support operator priorities, so for each operator it is necessary to add parentheses to define priority over them.<br>
     * Example: Expression ( 1 + sqrt 25 ) = 5.0 while ( 1 + ( sqrt 25 ) ) = 6.0
     * */
    public Double evaluate(String izraz)
    {
        if(izraz.equals("( )")) return 0.;
        Stack<String> operacije = new Stack<String>();
        Stack<Double> brojevi = new Stack<Double>();

        String[] s = izraz.split(" ");

        for(String element:s)
        {
            if(element.equals("("));
            else if (element.equals("+")) operacije.push(element);
            else if (element.equals("-")) operacije.push(element);
            else if (element.equals("*")) operacije.push(element);
            else if (element.equals("/")) operacije.push(element);
            else if (element.equals("sqrt")) operacije.push(element);
            else if (element.equals(")"))
            {
                String op = operacije.pop();
                double b = brojevi.pop();

                if(op.equals("+")) b=brojevi.pop()+b;
                else if(op.equals("-")) b=brojevi.pop()-b;
                else if(op.equals("*")) b=brojevi.pop()*b;
                else if(op.equals("/")) b=brojevi.pop()/b;
                else if(op.equals("sqrt")) b=Math.sqrt(b);

                brojevi.push(b);
            }
            else brojevi.push(Double.parseDouble(element));

        }
        return brojevi.pop();
    }
}
