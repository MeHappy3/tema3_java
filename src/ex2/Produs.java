package ex2;

import java.util.Date;

public class Produs {
    private String nume;
    private double pret;
    private int cantitate;
    private Date data_expirarii;
    private static double incasari ;
    Produs(String nume, double pret, int cantitate, Date data_expirarii){
        this.nume=nume;
        this.pret=pret;
        this.cantitate=cantitate;
        this.data_expirarii=data_expirarii;
        incasari = 0;
    }

    public Date getData_expirarii() {
        return data_expirarii;
    }

    public int getCantitate() {
        return cantitate;
    }

    public double getPret() {
        return pret;
    }

    public String getNume() {
        return nume;
    }

    @Override
    public String toString() {
        return this.nume+" "+pret+ " "+this.cantitate+" "+this.data_expirarii;
    }
    public void sell (int cantitate){
        if(cantitate>= this.cantitate){
            this.cantitate-=cantitate;
            incasari+=incasari*pret;
            System.out.println("S au vandut "+ cantitate + " de "+this.nume+"pentru "+this.pret+"lei");
        }
        else System.out.println("nu exista destul in stoc");
    }

}
