import java.awt.*;
public class Obstacles {
    int plength, pwidth; // in pixels
    // from and to is just the two diagonal point that are on different x and y axis
    Obstacles (int length, int width){
        this.plength = length*2;
        this.pwidth = width*2;
    }
    public void setPoint( Point from, Point to, int [][] arr){ // how to determine point ?? I need to know that 左上到右下角
        for (int i = from.x; i < to.x; i++) {
            for (int j = from.y; j <to.y ; j++) {
                if(arr[i][j]==-1){
                    throw new IllegalArgumentException("it is occupied");
                }
                arr[i][j]  = -1;
            }
        }
    }
}