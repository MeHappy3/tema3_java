package ex1;

public class Parabola {
    int a,b,c;
Parabola(int a,int b,int c){
    this.a=a;
    this.b=b;
    this.c=c;
}
    @Override
    public String toString() {
        return "f(x)="+a+"x^2+"+b+"x+"+c;
    }
    public static Punct Vf(Parabola parabola){
        return new Punct((float) ((-1) * parabola.b) /(2*parabola.a),(float)((-1)*parabola.b*parabola.b+4*parabola.a*parabola.c)/(4*parabola.a));
    }
    public Punct mijlocParabola(Parabola parabola){
    Punct vfThis = Vf(this);
    Punct vfParabola = Vf(parabola);
    return Punct.mijloc(vfThis,vfParabola);
    }
    public static Punct mijlocPrabola(Parabola par1, Parabola par2){
        Punct vf1 = Vf(par1);
        Punct vf2=Vf(par2);
        return Punct.mijloc(vf1,vf2);

    }
    public double lengthConnecting(Parabola par){
    Punct vfThis = Vf(this);
    Punct vfPar = Vf(par);
    return Math.hypot(vfThis.x- vfPar.x, vfThis.y- vfPar.y);
    }
    public static double lengthConnecting(Parabola par1,Parabola par2){
    Punct vf1 = Vf(par1);
    Punct vf2=Vf(par2);
    return Math.hypot(vf1.x- vf2.x, vf1.y- vf2.y);
    }
}
