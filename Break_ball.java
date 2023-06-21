// package MAIN.FILES;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Break_ball {

    public static void main(String[] args) {
        // System.out.println("djke");
        JFrame frame = new JFrame("Game");

        JFrame startscreen = new JFrame();
        JButton start = new JButton("START");
        Blockbreaker panel = new Blockbreaker(frame, startscreen);

        start.addActionListener(listener -> {

            startscreen.setVisible(false);
            frame.setVisible(true);
        });

        frame.getContentPane().add(panel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(false);

        frame.setSize(490, 600);

        frame.setResizable(false);

        startscreen.getContentPane().add(start);

        startscreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        startscreen.setVisible(true);

        startscreen.setSize(490, 600);

        startscreen.setResizable(false);

    }

}