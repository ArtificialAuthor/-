//CFG0
package game.objects;


public class Shape {
    //CFG1
    public double[] r;
    public double[] a;

    //CFG2
    public Shape(){
    }
    public Shape(double[] newR, double[] newA){
        r = newR;
        a = newA;

    }
    public Shape(double newR, double[] newA){
        double[] setR = new double[newA.length];
        for (int i=0; i<newA.length; i++){
            setR[i] = newR;
        }
        r = setR;
    }

    //CFG3
    public static Shape cube() {
        double newR = .5d * Math.pow(2, 1 / 2d);
        double[] newA = new double[4];
        for (int ang = 0; ang < 4; ang++) {
            newA[ang] = Math.PI * 4 * (1 + 2 * ang);
        }
        return new Shape(newR, newA);
    }
}
