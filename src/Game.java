import javax.swing.*;

/**
 * Created by John on 12/10/2014.
 */
public class Game implements Runnable {
    public static final int NUM_GUNS = 3;
    public static final int LOOP_INTERVAL = 5;
    private final Board board = new Board();
    public boolean running = false;

    public Game() {
        JFrame frame = new JFrame("Space Invaders");
        frame.setSize(Board.WIDTH, Board.HEIGHT);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.add(board);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void stop() {
        running = false;
    }

    public void reset() {
        running = false;
    }

    @Override
    public void run() {
        running = true;
        while (running) {
            try {
                Thread.sleep(Game.LOOP_INTERVAL);
                board.advance();
            } catch (Exception e) {
                System.err.println(e);
            }
        }
    }
}
