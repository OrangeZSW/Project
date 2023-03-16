import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;

/**
 * @author orange 主要窗口
 */
public class CalculatorWindow extends JFrame implements MenuListener {

    StandardWindow standardWindow;
    ProGrammerSPane proGrammerSPane;
    JMenuBar menuBar;
    JMenu menu;
    JMenu menu1, menu2;

    // 初始化
    CalculatorWindow() {
        init();
        this.setTitle("计算器");
        // 位置and大小
        setVisible(true);
        // 关闭窗口后关闭程序
        setDefaultCloseOperation(3);
    }

    void init() {
        menuBar = new JMenuBar();
        menu = new JMenu("计算器");
        menu1 = new JMenu("标准");
        menu2 = new JMenu("程序员");
        menuBar.setBackground(new Color(237, 237, 237));
        menu.add(menu1);
        menu.add(menu2);
        menuBar.add(menu);
        setJMenuBar(menuBar);
        menu1.addMenuListener(this);
        menu2.addMenuListener(this);
        standardWindow = new StandardWindow(this);
        // 设置图标
        Image image = (new ImageIcon("src//image//jsq.ico")).getImage();
        setIconImage(image);
        //方法会使容器再次布置其子组件。已经布置容器后，在修改此容器的子组件的时候（在容器中添加或移除组件，或者更改与布局相关的信息），应该调用上述方法。
        validate();
    }

    @Override
    public void menuSelected(MenuEvent e) {
        if (e.getSource() == menu1) {
            this.getContentPane().removeAll();
            standardWindow = new StandardWindow(this);
            validate();
        } else if (e.getSource() == menu2) {
            // 清除窗格所有组件
            this.getContentPane().removeAll();
            proGrammerSPane = new ProGrammerSPane(this);
            validate();
        }
    }

    @Override
    public void menuDeselected(MenuEvent e) {
    }

    @Override
    public void menuCanceled(MenuEvent e) {
    }
}
