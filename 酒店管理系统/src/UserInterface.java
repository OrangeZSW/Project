import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//用户界面
public class UserInterface implements ActionListener {
    JSplitPane jsPlitPane;
    Panel leftPanel, rightPanel;
    Button availableRooms, roomBooked;
    JFrame frame;
    TextField usernameTextBox, accountBox, roomNumber;
    Button signOut, submit, determine, checkOut;
    TextArea textArea;
    JComboBox<String> roomComboboxs;
    DatabaseOperations a;

    UserInterface() {
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
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(new Color(51, 204, 255));
        Label title = new Label("欢迎来到酒店管理系统");
        title.setAlignment(1);
        title.setFont(new Font("微软雅黑", Font.BOLD, 40));
        menuBar.add(title);

        //region左面板

        //个人信息文字
        Label personalInformation = new Label("个人信息");
        personalInformation.setFont(new Font("微软雅黑", Font.BOLD, 30));
        personalInformation.setBounds(90, 40, 200, 50);
        leftPanel.add(personalInformation);
        //头像
        ImageIcon headPortrait = new ImageIcon("hotelManagementSystem_images//x_头像.png");
        JLabel headPortraitLabel = new JLabel(headPortrait);
        headPortraitLabel.setBounds(130, 120, 50, 50);
        leftPanel.add(headPortraitLabel);
        //用户名
        Label Name = new Label("姓名:");
        Name.setFont(new Font("微软雅黑", Font.BOLD, 22));
        Name.setBounds(40, 250, 60, 50);
        leftPanel.add(Name);
        usernameTextBox = new TextField("");
        usernameTextBox.setFocusable(false);
        usernameTextBox.setFont(new Font("微软雅黑", Font.BOLD, 22));
        usernameTextBox.setBounds(120, 260, 150, 30);
        usernameTextBox.setEditable(false);
        leftPanel.add(usernameTextBox);
        //账户
        Label account = new Label("用户名:");
        account.setFont(new Font("微软雅黑", Font.BOLD, 22));
        account.setBounds(20, 320, 80, 30);
        leftPanel.add(account);
        accountBox = new TextField("");
        accountBox.setFocusable(false);
        accountBox.setFont(new Font("微软雅黑", Font.BOLD, 22));
        accountBox.setBounds(120, 320, 150, 30);
        accountBox.setEditable(false);
        leftPanel.add(accountBox);
        //退出登录
        signOut = new Button("退出登录");
        signOut.setFont(new Font("微软雅黑", Font.BOLD, 22));
        signOut.setBounds(120, 400, 120, 60);
        signOut.setBackground(new Color(22, 155, 213));
        signOut.setForeground(Color.white);
        leftPanel.add(signOut);

        //endregion

        //region右面板
        //标签1
        availableRooms = new Button("可供选择房间");
        availableRooms.setForeground(Color.blue);
        availableRooms.setFont(new Font("微软雅黑", Font.BOLD, 15));
        availableRooms.setBounds(120, 40, 100, 40);
        availableRooms.setBackground(new Color(242, 242, 242));
        rightPanel.add(availableRooms);
        //标签2
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

        //查找区

        Label seek = new Label("查找");
        seek.setFont(new Font("黑体", Font.BOLD, 35));
        seek.setForeground(Color.CYAN);
        seek.setBounds(20, 320, 80, 40);
        rightPanel.add(seek);
        //房间类型
        Label roomType = new Label("类型:");
        roomType.setFont(new Font("微软雅黑", Font.BOLD, 22));
        roomType.setBounds(80, 380, 60, 40);
        rightPanel.add(roomType);
        //复选框
        roomComboboxs = new JComboBox<String>();
        roomComboboxs.addItem("单人间");
        roomComboboxs.addItem("双人间");
        roomComboboxs.addItem("套间客房");
        roomComboboxs.addItem("商务客房");
        roomComboboxs.addItem("公寓式客房");
        roomComboboxs.addItem("总统套房");
        roomComboboxs.setFont(new Font("微软雅黑", Font.BOLD, 22));
        roomComboboxs.setBounds(150, 380, 150, 40);
        rightPanel.add(roomComboboxs);
        //确定按钮
        determine = new Button("确定");
        determine.setFont(new Font("微软雅黑", Font.BOLD, 22));
        determine.setBounds(320, 370, 70, 60);
        rightPanel.add(determine);
        //预定区

        //标签
        Label destine = new Label("预定/退房");
        destine.setForeground(Color.CYAN);
        destine.setFont(new Font("黑体", Font.BOLD, 35));
        destine.setBounds(20, 460, 180, 40);
        rightPanel.add(destine);
        //房间号
        Label room_number = new Label("房间号:");
        room_number.setFont(new Font("微软雅黑", Font.BOLD, 22));
        room_number.setBounds(80, 520, 80, 40);
        rightPanel.add(room_number);
        //输入预定框
        roomNumber = new TextField("");
        roomNumber.setFont(new Font("微软雅黑", Font.BOLD, 22));
        roomNumber.setForeground(Color.red);
        roomNumber.setBounds(170, 525, 50, 30);
        roomNumber.setForeground(Color.red);
        rightPanel.add(roomNumber);
        //提交按钮
        submit = new Button("提交");
        submit.setFont(new Font("微软雅黑", Font.BOLD, 26));
        submit.setBounds(240, 515, 70, 60);
        submit.setBackground(Color.blue);
        submit.setForeground(Color.white);
        rightPanel.add(submit);
        //退房按钮
        checkOut = new Button("退房");
        checkOut.setFont(new Font("微软雅黑", Font.BOLD, 26));
        checkOut.setBounds(320, 515, 70, 60);
        checkOut.setBackground(Color.RED);
        rightPanel.add(checkOut);
        //endregion
        frame.setJMenuBar(menuBar);
        //初始数据导入
        textArea.setText(a.getAllRooms());
        //注册监视器
        signOut.addActionListener(this);
        availableRooms.addActionListener(this);
        roomBooked.addActionListener(this);
        determine.addActionListener(this);
        submit.addActionListener(this);
        checkOut.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = e.getActionCommand();
        if (name.equals("退出登录")) {
            LoginInterface loginInterface = new LoginInterface();
            loginInterface.setVisible(true);
            this.frame.setVisible(false);
        } else if (name.equals("可供选择房间")) {
            textArea.setText(a.getAllRooms());
        } else if (name.equals("已预定房间")) {
            textArea.setText(a.findAReservedRoom(accountBox.getText()));
        } else if (name.equals("确定")) {
            textArea.setText("");
            textArea.setText(a.typeFindRoom((String) roomComboboxs.getSelectedItem()));
        } else if (name.equals("提交")) {
            a.roomNumberToChooseWhetherToBook(a, this, roomNumber.getText(), accountBox.getText(), usernameTextBox.getText());
        } else if (name.equals("退房")) {
            a.checkOutTheRoomNumber(a, this, roomNumber.getText(), accountBox.getText());
        }
    }
}
