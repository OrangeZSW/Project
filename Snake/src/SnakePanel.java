import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SnakePanel extends JPanel implements ActionListener {

    ImageIcon title = new ImageIcon("image/title.jpg");
    ImageIcon food = new ImageIcon("image/food.png");
    ImageIcon body = new ImageIcon("image/body.png");
    ImageIcon right = new ImageIcon("image/right.png");
    ImageIcon left = new ImageIcon("image/left.png");
    ImageIcon up = new ImageIcon("image/up.png");
    ImageIcon down = new ImageIcon("image/down.png");
    // 长度和分数
    int length = 3, scores = 0;
    // 蛇
    int snakexy[][] = new int[600][2];
    // 蛇头方向
    String theDirectionOf;
    // 食入位置
    int foodxy[][] = new int[1][2];
    // 游戏开始
    boolean gamestart;
    boolean gamefail;

    SnakePanel() {
        setSize(890, 700);
        init();
        // 触发监视器
        Timer timer = new Timer(100, this);
        timer.start();

    }

    // 初始化
    void init() {
        length = 3;
        scores = 0;

        theDirectionOf = "R";

        snakexy[0][0] = 110;
        snakexy[0][1] = 105;
        snakexy[1][0] = 85;
        snakexy[1][1] = 105;
        snakexy[2][0] = 60;
        snakexy[2][1] = 105;

        foodxy[0][0] = (int) (Math.random() * 34) * 25 + 10;
        foodxy[0][1] = (int) (Math.random() * 21) * 25 + 80;

        gamestart = false;
        gamefail = false;
    }

    @Override
    public void paint(Graphics g) {
        // TODO Auto-generated method stub
        super.paint(g);
        // 标题
        g.drawImage(title.getImage(), 10, 20, this);
        // 分数和长度
        g.setFont(new Font("微软雅黑", Font.BOLD, 20));
        g.setColor(Color.white);
        g.drawString("长度:" + length, 700, 40);
        g.drawString("分数:" + scores, 700, 65);
        // 网格
        g.setColor(Color.black);
        for (int i = 0; i < 22; i++) {
            g.drawLine(10, 80 + i * 25, 860, 80 + i * 25);
        }
        for (int i = 0; i < 35; i++) {
            g.drawLine(10 + i * 25, 80, 10 + i * 25, 605);
        }
        // 蛇头
        if (theDirectionOf.equals("R")) {
            g.drawImage(right.getImage(), snakexy[0][0], snakexy[0][1], this);
        } else if (theDirectionOf.equals("L")) {
            g.drawImage(left.getImage(), snakexy[0][0], snakexy[0][1], this);
        } else if (theDirectionOf.equals("U")) {
            g.drawImage(up.getImage(), snakexy[0][0], snakexy[0][1], this);
        } else if (theDirectionOf.equals("D")) {
            g.drawImage(down.getImage(), snakexy[0][0], snakexy[0][1], this);
        }
        // 蛇身
        for (int i = 1; i < length; i++) {
            g.drawImage(body.getImage(), snakexy[i][0], snakexy[i][1], this);
        }
        // 食物
        g.drawImage(food.getImage(), foodxy[0][0], foodxy[0][1], this);
        g.setColor(Color.red);
        if (!gamestart) {
            g.setFont(new Font("手书体", Font.BOLD, 40));
            if (!gamefail) {
                g.drawString("按空格开始或暂停游戏!", 225, 300);
            } else {
                g.drawString("游戏失败！按空格重新开始", 225, 300);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (gamestart) {
            for (int i = length - 1; i > 0; i--) {
                snakexy[i][0] = snakexy[i - 1][0];
                snakexy[i][1] = snakexy[i - 1][1];
            }
        }
        if ("R".equals(theDirectionOf) && gamestart) {
            if (snakexy[0][0] > 810) {
                snakexy[0][0] = 10;
            } else {
                snakexy[0][0] += 25;
            }
        } else if ("L".equals(theDirectionOf) && gamestart) {
            if (snakexy[0][0] < 35) {
                snakexy[0][0] = 835;
            } else {
                snakexy[0][0] -= 25;
            }
        } else if ("U".equals(theDirectionOf) && gamestart) {
            if (snakexy[0][1] < 105) {
                snakexy[0][1] = 580;
            } else {
                snakexy[0][1] -= 25;
            }
        } else if ("D".equals(theDirectionOf) && gamestart) {
            if (snakexy[0][1] > 555) {
                snakexy[0][1] = 80;
            } else {
                snakexy[0][1] += 25;
            }
        }
        if (snakexy[0][0] == foodxy[0][0] && snakexy[0][1] == foodxy[0][1]) {
            length++;
            foodxy[0][0] = (int) (Math.random() * 34) * 25 + 10;
            foodxy[0][1] = (int) (Math.random() * 21) * 25 + 80;
            scores++;
        }
        for (int i = 1; i < length; i++) {
            if (snakexy[0][0] == snakexy[i][0] && snakexy[0][1] == snakexy[i][1] && gamestart) {
                gamefail = !gamefail;
                gamestart = false;
            }
        }
        repaint();
    }
}
