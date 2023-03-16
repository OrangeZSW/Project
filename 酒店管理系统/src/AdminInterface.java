import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//用户界面
public class AdminInterface implements ActionListener {
    JMenuBar menuBar;
    JSplitPane jsPlitPane;
    Panel leftPanel, rightPanel;
    JFrame frame;
    TextArea textArea;
    Button signOut, roomBooked, remainingRoom;
    DatabaseOperations a;

    AdminInterface() {
        a = new DatabaseOperations();
        a.connectToTheDatabase();
        frame = new JFrame();
        frame.setSize(1000, 700);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(3);
        //初始化界面
        init();
        frame.add(jsPlitPane);
    }

    void init() {
        leftPanel = new Panel();
        leftPanel.setLayout(null);
        leftPanel.setBackground(new Color(242, 242, 242));
        rightPanel = new Panel();
        rightPanel.setLayout(null);
        rightPanel.setBackground(new Color(255, 255, 255));
        jsPlitPane = new JSplitPane(1, true, leftPanel, rightPanel);
        //分割点
        jsPlitPane.setDividerLocation(300);
        jsPlitPane.setEnabled(false);
        //菜单栏
        menuBar = new JMenuBar();
        menuBar.setBackground(new Color(51, 204, 255));
        Label title = new Label("管理员界面");
        title.setAlignment(1);
        title.setFont(new Font("微软雅黑", Font.BOLD, 40));
        menuBar.add(title);

        //region左面板
        //个人信息文字
        Label personalInformation = new Label("管理员");
        personalInformation.setFont(new Font("微软雅黑", Font.BOLD, 30));
        personalInformation.setBounds(90, 40, 200, 50);
        leftPanel.add(personalInformation);
        //头像
        ImageIcon adminAvatar = new ImageIcon("hotelManagementSystem_images/管理员.png");
        JLabel adminPicture = new JLabel(adminAvatar);
        adminPicture.setBounds(62, 100, 150, 150);
        leftPanel.add(adminPicture);
        //退出登录
        signOut = new Button("退出登录");
        signOut.setFont(new Font("微软雅黑", Font.BOLD, 22));
        signOut.setBounds(80, 300, 120, 60);
        signOut.setBackground(new Color(22, 155, 213));
        signOut.setForeground(Color.white);
        leftPanel.add(signOut);
        //endregion

        //region右面板
        //剩余房间
        remainingRoom = new Button("剩余房间");
        remainingRoom.setForeground(Color.blue);
        remainingRoom.setFont(new Font("微软雅黑", Font.BOLD, 15));
        remainingRoom.setBounds(120, 40, 70, 40);
        remainingRoom.setBackground(new Color(242, 242, 242));
        rightPanel.add(remainingRoom);
        //已预定房间
        roomBooked = new Button("已预定房间");
        roomBooked.setForeground(Color.BLUE);
        roomBooked.setFont(new Font("微软雅黑", Font.BOLD, 15));
        roomBooked.setBounds(380, 40, 80, 40);
        roomBooked.setBackground(new Color(242, 242, 242));
        rightPanel.add(roomBooked);
        //文本区
        textArea = new TextArea();
        textArea.setBounds(0, 100, 680, 200);
        textArea.setFont(new Font("微软雅黑", 1, 15));
        textArea.setEditable(false);
        textArea.setFocusable(false);
        rightPanel.add(textArea);
        //endregion
        frame.setJMenuBar(menuBar);
        //注册监视器
        signOut.addActionListener(this);
        //数据初始化
        textArea.setText(a.getAllRooms());
        //注册监视器
        remainingRoom.addActionListener(this);
        roomBooked.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = e.getActionCommand();
        if (name.equals("退出登录")) {
            LoginInterface loginInterface = new LoginInterface();
            loginInterface.setVisible(true);
            frame.setVisible(false);
        } else if (name.equals("剩余房间")) {
            textArea.setText(a.getAllRooms());
        } else if (name.equals("已预定房间")) {
            textArea.setText(a.allBookedRooms());
        }
    }
}
