import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SnakeFarm extends JFrame {
    SnakePanel snakepanel;

    SnakeFarm() {
        this.snakepanel = snakepanel;
        init();
        snakepanel = new SnakePanel();
        add(snakepanel);

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    if (snakepanel.gamefail) {
                        snakepanel.init();
                    } else {
                        snakepanel.gamestart = !snakepanel.gamestart;
                    }
                }
                // ·½Ïò
                else if (e.getKeyCode() == KeyEvent.VK_RIGHT && snakepanel.gamestart) {
                    snakepanel.theDirectionOf = "R";
                } else if (e.getKeyCode() == KeyEvent.VK_LEFT && snakepanel.gamestart) {
                    snakepanel.theDirectionOf = "L";
                } else if (e.getKeyCode() == KeyEvent.VK_UP && snakepanel.gamestart) {
                    snakepanel.theDirectionOf = "U";
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN && snakepanel.gamestart) {
                    snakepanel.theDirectionOf = "D";
                }
            }
        });
    }

    void init() {
        setSize(890, 700);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(3);

    }


    public static void main(String[] args) {
        new SnakeFarm();
    }
}
