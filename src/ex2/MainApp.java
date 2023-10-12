package ex2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

public class MainApp {
    public static void main(String[] args) throws IOException, ParseException {
        Scanner scanner = new Scanner(new File("produse.csv"));
        List<Produs> produse = new ArrayList<Produs>();
        scanner.nextLine();
        while(scanner.hasNextLine()){
        Scanner scanner1 = new Scanner(scanner.nextLine());
        scanner1.useDelimiter(", ");
        String nume = scanner1.next();
        double pret  = scanner1.nextDouble();
        int cantitate = scanner1.nextInt();
        String data_String = scanner1.next();
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
        Date data = parser.parse(data_String);
         produse.add(new Produs(nume,pret,cantitate,data));
        }
        String opt;
        do {
        System.out.print("Opt: ");
        opt=(new Scanner(System.in)).next();
            switch (opt) {
                case "a":
                    for (Produs prod : produse) {
                        System.out.println(prod);
                    }
                    break;
                case "b":
                    for (Produs prod : produse) {
                        if (prod.getData_expirarii().compareTo(new Date()) < 0) {
                            System.out.println(prod);
                        }
                    }
                case "c":
                    System.out.println("Care produs sa fie vandut: ");
                    String cautat = new Scanner(System.in).next();
                    for (Produs prod : produse)
                        if (prod.getNume().equals(cautat)) {
                            System.out.println("Cat doriti ?");
                            prod.sell(new Scanner(System.in).nextInt());
                            if (prod.getCantitate() == 0) {
                                produse.remove(prod);
                                break;
                            }
                        }
                    break;
                case "d":
                    Produs mic=produse.get(0);
                    for(Produs prod:produse){
                        if(mic.getPret()>prod.getPret())
                            mic = prod;
                    }
                    System.out.println(mic); break;
                case "e":
                    File save = new File("saved.txt");
                    save.createNewFile();
                    FileWriter writer = new FileWriter(save);
                    System.out.println("Cantitatea dorita: ");
                    int cant = new Scanner(System.in).nextInt();
                    for(Produs prod:produse){
                        if(prod.getCantitate()<cant){
                            writer.write(prod.toString());

                        }
                    }
                    writer.close();
                    break;
                default:
                    if(!opt.equals("o"))
                        System.out.println("nu e");
                    break;
            }

        }while(!opt.equals("o"));
    }
}
