import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

// import static video_graphics_2d_part_2.Ball.BOX_HEIGHT;
// import static video_graphics_2d_part_2.Ball.BOX_WIDTH;


public class BouncingBallWithMouseListener extends JFrame {
    public static final int BOX_MARGIN = 50;
    public static final int TIMER_DELAY = 2;
    public static final int DECAY = 15;
    private int decayCounter = 0;
    public BouncingBallJPanel panel;
    public Timer timer;

    public static void main(String[] a) {
        new BouncingBallWithMouseListener();
    }

    public BouncingBallWithMouseListener() {
        setTitle("Bouncing Balls using Mouse Listener");
        getContentPane().setPreferredSize(new Dimension(Ball.BOX_WIDTH + 2 * BOX_MARGIN, Ball.BOX_HEIGHT + 2 * BOX_MARGIN));
        setResizable(false);
        panel = new BouncingBallJPanel();
        add(panel);
        timer = new Timer(TIMER_DELAY, new TimerListener());
        timer.start();
        addMouseListener(new MouseClickListener());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    class TimerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ev) {
            for (Ball b : panel.ballArray)
                b.move();
            if(timer.getDelay()<120 && decayCounter>DECAY){
                timer.setDelay(timer.getDelay()+1);
                decayCounter = 0;
            }
            repaint();
            decayCounter++;
        }
    }

    class MouseClickListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent ev) {
            timer.setDelay(TIMER_DELAY);
        }
    }
}

