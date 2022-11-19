package ba.unsa.etf.rpr;

import java.lang.invoke.StringConcatFactory;
import java.util.Scanner;
public class App
{
    public static void ValidacijaIzraza(String izraz) throws RuntimeException
    {
        if(izraz.isEmpty()) throw new IllegalArgumentException();
        if(izraz.equals("()") || izraz.equals("( )") || !izraz.endsWith(")") || !izraz.startsWith("(")) throw new IllegalArgumentException();

        int br1=0; // Brojac praznina
        int br2=0; // Brojac svih karaktera razlicitih od razmaka
        int br3=0; // Brojac zagrada (
        int br4=0; // Brojac zagrada )
        int br5=0; // Broj operatora
        int br6=0; // Broj operanada

        for(int i=0;i<izraz.length();i++)
        {
            if(izraz.charAt(i)==' ') br1++;
        }

        for(String s:izraz.split(" "))
        {
            if(!s.equals("")) br2++;
            if(s.equals("(")) br3++;
            if(s.equals(")")) br4++;
            if(s.equals("+") || s.equals("-") || s.equals("*") ||s.equals("/") ||s.equals("sqrt")) br5++;

        }
    }
    /**
     Klasa App sa pocetnom main vrsi unos stringa za izracun*/
    public static void main( String[] args )
    {
        Scanner unos = new Scanner(System.in);

        try
        {
            System.out.print("Unesite izraz:");
            String izraz = unos.nextLine();
            ValidacijaIzraza(izraz);
            ExpressionEvaluator e = new ExpressionEvaluator();
            Double rezultat= e.evaluate(izraz);

            System.out.println("Rezulta je: "+rezultat);

        }
        catch (Exception e)
        {
            System.out.println("Greska: Neispravan unos!");
        }
    }
}
