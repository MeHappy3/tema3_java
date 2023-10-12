package ex1;

public class Punct {
    public float x,y;
    Punct(float x,float y ){
        this.x=x;
        this.y=y;
    }

    @Override
    public String toString() {
        return "("+this.x+","+this.y+")";
    }

    public static Punct mijloc(Punct punct1, Punct punct2){
        return new Punct((punct1.x+ punct2.x)/2,(punct1.y+ punct2.y)/2);
    }
}
