import java.util.Arrays;

public class Room {
    int width_pixels, length_pixels;
    int[][] floor;
    public Room (int width, int length){
        this.width_pixels = width*2;
        this.length_pixels = length*2;
        this.floor =  new int[length_pixels][width_pixels];
    }
    // grid we can obstacles
}
