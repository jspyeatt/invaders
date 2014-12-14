import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by John on 12/10/2014.
 */
public class GunController implements KeyListener{
    private final Gun gun;

    public GunController(Gun g) {
        gun = g;
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            gun.moveLeft();
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            gun.moveRight();
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            gun.fire();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
