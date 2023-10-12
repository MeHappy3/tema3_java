package ex1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("in.txt"));

        List<Parabola> lista = new ArrayList<Parabola>();
        while(scanner.hasNextInt()){
            int a=scanner.nextInt(),
                    b= scanner.nextInt(),
                    c=scanner.nextInt();
            lista.add(new Parabola(a,b,c));
        }
        for (Parabola par: lista) {
            System.out.println(par.toString()+" " + Parabola.Vf(par).toString());
        }
        Parabola par1 = lista.get(0);
        Parabola par2=lista.get(1);
        System.out.println("\n\n"+ par1 + " "+ Parabola.Vf(par1));
        System.out.println( par2 + " "+ Parabola.Vf(par2));
        System.out.println("MIjlocul segmentului are uneste aceste parabole este: "+ Parabola.mijlocPrabola(par1,par2)+" si lungimea segmentului care le uneste este: "+Parabola.lengthConnecting(par1,par2));
    }
}
