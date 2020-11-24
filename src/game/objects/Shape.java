//CFG0
package game.objects;


public class Shape {
    //CFG1
    public int[][] dots = {};

    //CFG2
    public Shape(){

    }
    public Shape(int[][] setDots){
        dots = setDots;
    }

    //CFG3
    public static Shape cube(){
        int[][] cubeDots = {{1,1,-1,-1},{1,-1,1,-1}};
        return new Shape(cubeDots);
    }
}
