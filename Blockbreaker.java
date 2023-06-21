import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Blockbreaker extends JPanel implements KeyListener {

    ArrayList<Block> blocks;
    Block ball;
    Block paddle;
    Thread thread;
    // ArrayList<Block> blocks = new ArrayList<Block>();
    // Animate animate;
    JFrame frame, startcreen;

    void reset() {

        blocks = new ArrayList<Block>();
        ball = new Block(232, 435, 35, 25, "paddle.png");
        paddle = new Block(175, 480, 150, 25, "redbar.png");

        for (int i = 0; i < 10; i++) {
            blocks.add(new Block(i * 60 + 2 * i, 10, 60, 20, "red.png"));

        }
        for (int i = 0; i < 10; i++) {
            blocks.add(new Block(i * 60 + 2 * i, 32, 60, 20, "red.png"));

        }
        for (int i = 0; i < 10; i++) {
            blocks.add(new Block(i * 60 + 2 * i, 54, 60, 20, "red.png"));

        }
        for (int i = 0; i < 10; i++) {
            blocks.add(new Block(i * 60 + 2 * i, 76, 60, 20, "red.png"));

        }

        addKeyListener(this);
        setFocusable(true);

    }

    Blockbreaker(JFrame frame, JFrame startscreen) {

        this.frame = frame;
        this.startcreen = startscreen;
        reset();
    }

    public void paintComponent(Graphics g) {
        blocks.forEach(block -> {

            block.draw(g, this);
        });
        ball.draw(g, this);
        paddle.draw(g, this);

    }

    public void update() {
        repaint();

        ball.x += ball.mx;
        ball.y += ball.my;

        if (ball.x > getWidth() - ball.width || ball.x < 0) {

            ball.mx *= -1;
            return;

        }

        if (ball.y < 0 || ball.intersects(paddle)) {
            ball.my *= -1;
            return;
        }

        blocks.forEach(block -> {

            if (ball.intersects(block) && !block.destroyed) {
                block.destroyed = true;
                ball.my = -1 * ball.my;
                // return;

            }
            // repaint(block);

        }

        );
        if (ball.y > getHeight()) {

            thread = null;
            reset();
            frame.setVisible(false);

            startcreen.setVisible(true);

        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            thread = new Thread(() -> {

                while (true) {
                    // System.out.println("run");

                    update();

                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException er) {
                        er.printStackTrace();
                    }

                }
            });
            thread.start();
        }

        if (e.getKeyCode() == KeyEvent.VK_RIGHT && paddle.x < getWidth() - paddle.width) {

            // System.out.println("right");
            // update();

            // repaint();
            paddle.x += 15;

            // repaint();
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT && paddle.x > 0) {

            paddle.x -= 15;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
