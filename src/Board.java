import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by John on 12/10/2014.
 */
public class Board extends JPanel {
    public static int WIDTH = 800;
    public static int HEIGHT = 600;
    private int deadGuns = 0;
    private final Gun gun;
    public final Scoreboard scoreboard = new Scoreboard();
    public final List<Rampart> ramparts = new ArrayList<Rampart>();
    public final List<Alien> aliens = new ArrayList<Alien>();
    public Board() {
        super();
        setSize(WIDTH, HEIGHT);
        setBackground(new Color(30, 30, 30));
        setFocusable(true);
        gun = new Gun(this);
        GunController gc = new GunController(gun);
        addKeyListener(gc);
        repaint();
    }

    public void advance() {
        gun.advanceBullet();
        repaint();
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        scoreboard.paint(g2d);
        gun.paint(g2d);
    }

    public void reset() {
        scoreboard.reset();
        gun.reset();
        deadGuns = 0;
    }
}
