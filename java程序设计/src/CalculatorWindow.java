import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;

/**
 * @author orange ��Ҫ����
 */
public class CalculatorWindow extends JFrame implements MenuListener {

    StandardWindow standardWindow;
    ProGrammerSPane proGrammerSPane;
    JMenuBar menuBar;
    JMenu menu;
    JMenu menu1, menu2;

    // ��ʼ��
    CalculatorWindow() {
        init();
        this.setTitle("������");
        // λ��and��С
        setVisible(true);
        // �رմ��ں�رճ���
        setDefaultCloseOperation(3);
    }

    void init() {
        menuBar = new JMenuBar();
        menu = new JMenu("������");
        menu1 = new JMenu("��׼");
        menu2 = new JMenu("����Ա");
        menuBar.setBackground(new Color(237, 237, 237));
        menu.add(menu1);
        menu.add(menu2);
        menuBar.add(menu);
        setJMenuBar(menuBar);
        menu1.addMenuListener(this);
        menu2.addMenuListener(this);
        standardWindow = new StandardWindow(this);
        // ����ͼ��
        Image image = (new ImageIcon("src//image//jsq.ico")).getImage();
        setIconImage(image);
        //������ʹ�����ٴβ�������������Ѿ��������������޸Ĵ��������������ʱ������������ӻ��Ƴ���������߸����벼����ص���Ϣ����Ӧ�õ�������������
        validate();
    }

    @Override
    public void menuSelected(MenuEvent e) {
        if (e.getSource() == menu1) {
            this.getContentPane().removeAll();
            standardWindow = new StandardWindow(this);
            validate();
        } else if (e.getSource() == menu2) {
            // ��������������
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
