import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//注册界面
public class RegistrationInterface implements ActionListener {
    JFrame frame;
    Panel panel;
    JTextField usernameBox, nameBox, contactPhoneBox;
    JPasswordField passwordBox, repeatPasswordBox;
    Button registered, cancel;
    DatabaseOperations a;

    RegistrationInterface() {
        a = new DatabaseOperations();
        a.connectToTheDatabase();
        frame = new JFrame();
        panel = new Panel();
        init();
        frame.setTitle("注册");
        frame.add(panel);
        frame.setDefaultCloseOperation(2);
        frame.setSize(600, 450);
        frame.setLocationRelativeTo(null);
    }

    void init() {
        panel.setLayout(null);
        panel.setBackground(new Color(255, 255, 255));
        //用户名
        Label userName = new Label("*用户名");
        userName.setFont(new Font("微软雅黑", 0, 18));
        userName.setBounds(50, 30, 70, 40);
        panel.add(userName);
        usernameBox = new JTextField("");
        usernameBox.setFont(new Font("微软雅黑", Font.BOLD, 15));
        usernameBox.setHorizontalAlignment(JTextField.LEFT);
        usernameBox.setBounds(130, 30, 360, 35);
        panel.add(usernameBox);
        //姓名
        Label fullName = new Label("*姓名");
        fullName.setFont(new Font("微软雅黑", 0, 18));
        fullName.setBounds(68, 90, 60, 40);
        panel.add(fullName);
        nameBox = new JTextField("");
        nameBox.setFont(new Font("微软雅黑", Font.BOLD, 15));
        nameBox.setHorizontalAlignment(2);
        nameBox.setBounds(130, 90, 360, 35);
        panel.add(nameBox);
        //密码
        Label password = new Label("*密码");
        password.setFont(new Font("微软雅黑", 0, 18));
        password.setBounds(67, 150, 60, 40);
        panel.add(password);
        passwordBox = new JPasswordField();
        passwordBox.setFont(new Font("微软雅黑", 1, 15));
        passwordBox.setHorizontalAlignment(2);
        passwordBox.setBounds(130, 150, 360, 35);
        panel.add(passwordBox);
        //重复密码
        Label repeatPassword = new Label("*重复密码");
        repeatPassword.setFont(new Font("微软雅黑", 0, 18));
        repeatPassword.setBounds(33, 210, 80, 40);
        panel.add(repeatPassword);
        repeatPasswordBox = new JPasswordField("");
        repeatPasswordBox.setFont(new Font("微软雅黑", 1, 15));
        repeatPasswordBox.setHorizontalAlignment(2);
        repeatPasswordBox.setBounds(130, 210, 360, 35);
        panel.add(repeatPasswordBox);
        //联系电话
        Label contactNumber = new Label("*联系电话");
        contactNumber.setFont(new Font("微软雅黑", 0, 18));
        contactNumber.setBounds(33, 270, 80, 40);
        panel.add(contactNumber);
        contactPhoneBox = new JTextField();
        contactPhoneBox.setFont(new Font("微软雅黑", 1, 15));
        contactPhoneBox.setHorizontalAlignment(2);
        contactPhoneBox.setBounds(130, 270, 360, 35);
        panel.add(contactPhoneBox);
        //注册按钮
        registered = new Button("注册");
        registered.setFont(new Font("微软雅黑", 1, 18));
        registered.setBackground(new Color(64, 158, 255));
        registered.setForeground(Color.white);
        registered.setBounds(190, 330, 80, 40);
        panel.add(registered);
        cancel = new Button("取消");
        cancel.setBackground(Color.white);
        cancel.setFont(new Font("微软雅黑", 1, 18));
        cancel.setBounds(290, 330, 80, 40);
        panel.add(cancel);
        //注册监视器
        registered.addActionListener(this);
        cancel.addActionListener(this);
    }

    //监视器
    @Override
    public void actionPerformed(ActionEvent e) {
        String username, name, password, repeat_password, phone;
        username = usernameBox.getText();
        name = nameBox.getText();
        password = passwordBox.getText();
        repeat_password = repeatPasswordBox.getText();
        phone = contactPhoneBox.getText();
        String button_name = e.getActionCommand();
        if (button_name.equals("注册")) {
            if (password.equals(repeat_password)) {
                int n = a.registerAnAccount(username, name, password, phone);
                if (n == 1) {
                    JOptionPane.showMessageDialog(frame, "用户名重复！", "错误", 0);
                } else if (n == 2) {
                    JOptionPane.showMessageDialog(frame, "该电话已绑定！", "错误", 0);
                } else if (n == 0) {
                    JOptionPane.showMessageDialog(frame, "注册成功！", "成功", 1);
                    frame.setVisible(false);
                } else if (n == 3) {
                    JOptionPane.showMessageDialog(frame, "数据库系统错误！", "错误", 0);
                }
            } else {
                JOptionPane.showMessageDialog(frame, "两次输入的密码不一样!请重新输入", "错误", 0);
            }
        } else {
            frame.setVisible(false);
        }
    }
}
