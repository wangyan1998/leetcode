package classify.test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

/**
 * @author wy
 * @date 2021/4/22 15:02
 */
public class Topicture {
    public static void topicture() throws IOException {
        Random r = new Random();


        int[][] col={{2,1,9,6,6,8,8,4,2,4,2,7},
                     {2,3,4,4,7,0,1,6,7,6,6,6},
                     {2,0,1,5,4,5,2,1,4,6,1,8},
                     {2,2,1,2,9,3,0,9,3,6,7,7},
                     {2,2,2,9,2,0,3,5,2,7,3,7},
                     {2,2,0,9,2,7,5,7,5,7,8,7} };
        Color[][] arr = new Color[col.length][col[0].length];
        BufferedImage b = new BufferedImage(col.length*100, col[0].length*100, BufferedImage.TYPE_INT_RGB);
        Graphics g = b.getGraphics();
        for(int n=0; n<col.length; n++) {
            for(int m=0; m<col[0].length; m++) {
                //arr[n][m] = new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256));
                arr[n][m] = new Color(27*col[n][m], 10*col[n][m], 20*col[n][m]);
                g.setColor(arr[n][m]);
                g.fillRect(n*100, m*100, 100, 100);
            }
        }
        File file=new File("C:\\pic\\c");
        FileOutputStream fileOutputStream=new FileOutputStream(file);
        ImageIO.write(b, "jpg", fileOutputStream);
    }

    public static void main(String[] args) throws IOException {
        topicture();
    }
}
