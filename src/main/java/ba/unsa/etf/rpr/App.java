package ba.unsa.etf.rpr;

import java.util.Scanner;

/** Klasa App ima javne staticke metode main i ValidacijaIzraza.
 * U main se vrsi unos izraza i hvatanje izuzetaka.
 * ValidacijaIzraza je metoda koja prima izraz i vrši njegovu validaciju. U slučaju neispravnog izraza, baca se RunTimeException, dok u slučaju validnog izraza vraća vrijednost true.
 *
 *<br>
 * <b>English description</b>
 * <br>
 * The App class has public static methods main and ExpressionValidation.
 * In main, expressions are entered and exceptions are caught.
 * ValidacijaIzraza is a method that receives an expression and validates it. In the case of an invalid expression, a RunTimeException is thrown, while in the case of a valid expression, it returns the value true.
 * */
public class App
{
    /**
     * Metoda ValidacijaIzraza testira izraze na pravilan unos.
     * Provjerava se: Velicina izraza, uparenost zagrada, broj operacija i operanada i broj razmaka između njih.
     *<br>
     * <b>English description</b>
     * <br>
     * The ValidacijaIzraza method tests expressions on correct input.
     * The previous method checks: The size of the expression (empty string and special cases), the pairing of parentheses, the number of operations and operands and the number of spaces between them.
     * */
    public static boolean ValidacijaIzraza(String izraz) throws RuntimeException
    {
        if(izraz.isEmpty()) throw new IllegalArgumentException("Izraz je prazan!");
        if(izraz.endsWith("(") || izraz.startsWith(")") || izraz.endsWith(" ") || izraz.startsWith(" ") || izraz.equals("()") || izraz.startsWith("( ")==false || izraz.endsWith(" )")==false) throw new IllegalArgumentException("Izraz ne pocinje sa ispravnom zagradom ili pocinje sa prazninom!");

        int br3=0; // Brojac zagrada (
        int br4=0; // Brojac zagrada )
        int br5=0; // Broj operatora (operacija)
        int br6=0; // Broj operanada (brojeva)

        for(int i=0;i<izraz.length();i++)
        {
            if((izraz.charAt(i)=='+' || izraz.charAt(i)=='-' || izraz.charAt(i)=='*' || izraz.charAt(i)=='/') && (izraz.charAt(i-1)!=' ' || izraz.charAt(i+1)!=' ')) throw new IllegalArgumentException("Neisprava broj razmaka!");

            if(izraz.charAt(i)=='(') br3++;
            if(izraz.charAt(i)==')') br4++;
            if(izraz.charAt(i)=='+' || izraz.charAt(i)=='-' ||izraz.charAt(i)=='*' ||izraz.charAt(i)=='/') br5++;
        }
        if(br3!=br4) throw new IllegalArgumentException("Neisprava broj unesenih zagrada!");

        String[] i=izraz.split(" ");

        int tmp=0,k=br6; //Kontrola korijena

        for(String s:i)
        {
            if(s.equals("sqrt")) {br5++; tmp=1; k=br6; continue;}
            if(s.equals("(")==false  && s.equals(")")==false && s.equals("+")==false && s.equals("-")==false && s.equals("*")==false && s.equals("/")==false && s.equals("sqrt")==false) br6++;
            if(tmp==1 && k==br6) throw new IllegalArgumentException("Neisprava broj operatora i operanada!");
            else tmp=0;
        }
        if(br6!=br5+1 && br6!=br5 || br6==1 && br5==0) throw new IllegalArgumentException("Neisprava broj operatora i operanada!");

        return true;
    }
    /**
     *  main metoda vrši pokretanja programa, unos izraza i poziva metodu za validaciju.<br>
     *
     *  <b>English description</b>
     *  The main method starts the program, enters expressions and calls the method for validation.
     *  <br>
     */
    public static void main(String args )
    {
        Scanner unos = new Scanner(System.in);
        try
        {
            System.out.println("Pocetak :");
            System.out.print("Unesite izraz:");
            String izraz = unos.nextLine();
            ValidacijaIzraza(izraz);

            ExpressionEvaluator e = new ExpressionEvaluator();
            Double rezultat= e.evaluate(izraz);

            System.out.println("Rezulta je: "+rezultat);
        }
        catch (Exception e)
        {
            System.out.println("Greska: "+e.getMessage());
        }
    }
}
