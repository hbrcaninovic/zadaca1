package ba.unsa.etf.rpr;

import java.util.Stack;

public class ExpressionEvaluator {
    public Double evaluate(String izraz)
    {
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
