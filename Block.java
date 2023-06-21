import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Block extends Rectangle {

    Image pic;
    boolean destroyed;

    // int px, py;
    // int width, height;
    int mx, my;

    Block(int x, int y, int w, int h, String s) {
        this.x = x;
        this.y = y;

        mx = 3;
        my = 3;

        this.width = w;
        this.height = h;

        try {
            pic = ImageIO.read(new File("MAIN/" + s));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void draw(Graphics g, Component c) {

        if (!destroyed) {
            // try {
            // Image p = ImageIO.read(new File("MAIN/" + "white.png"));
            // g.drawImage(p, x, y, width, height, c);
            // } catch (IOException e) {

            // e.printStackTrace();
            // }
            g.drawImage(pic, x, y, width, height, c);

        } else {
            // System.out.println("w");
            try {
                Image p = ImageIO.read(new File("MAIN/" + "white.png"));
                g.drawImage(p, x, y, width, height, c);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
