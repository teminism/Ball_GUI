//import static video_graphics_2d_part_2.Ball.BOX_HEIGHT;
//import static video_graphics_2d_part_2.Ball.BOX_WIDTH;


import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;

public class BouncingBallWithTimer extends JFrame {
    public static final int BOX_MARGIN = 50;
    public BouncingBallJPanel panel;

    public static void main(String[] a) {
        new BouncingBallWithTimer();
    }

    public BouncingBallWithTimer() {
        setTitle("Bouncing Balls using Swing Timer");
        getContentPane().setPreferredSize(new Dimension(Ball.BOX_WIDTH + 2 * BOX_MARGIN, Ball.BOX_HEIGHT + 2 * BOX_MARGIN));
        setResizable(false);
        panel = new BouncingBallJPanel();
        add(panel);
        Timer timer = new Timer(15, new TimerListener());
        timer.start();
        pack();
        setVisible(true);
    }

    class TimerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ev) {
            for (Ball b : panel.ballArray)
                b.move();
            repaint();
        }
    }
}

