import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//登录界面
public class LoginInterface extends Frame implements ActionListener {
    JTextField userName;
    JPasswordField password;
    Button logIn, registered;
    Label title, text1, text2;
    DatabaseOperations a;

    LoginInterface() {
        a = new DatabaseOperations();
        a.connectToTheDatabase();
        setLayout(null);
        setTitle("酒店管理系统");
        setSize(1000, 700);
        setVisible(true);
        setLocationRelativeTo(null);
        setBackground(new Color(162, 176, 207));
        //关掉窗口
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        //添加组件
        init();
    }

    void init() {
        //初始化组件
        userName = new JTextField();
        password = new JPasswordField();
        logIn = new Button("登录");
        logIn.setBackground(Color.blue);
        logIn.setForeground(Color.white);
        registered = new Button("用户注册");
        registered.setBackground(Color.GRAY);
        logIn.setFont(new Font("Arial", Font.ITALIC, 25));
        registered.setFont(new Font("Arial", Font.ITALIC, 20));
        //设置组件大小
        userName.setFont(new Font("Arial", Font.BOLD, 25));
        userName.setHorizontalAlignment(2);
        password.setFont(new Font("Arial", Font.BOLD, 25));
        password.setHorizontalAlignment(2);

        userName.setSize(300, 50);
        password.setSize(300, 50);
        logIn.setSize(100, 50);
        registered.setSize(100, 50);
        //设置组件位置
        userName.setLocation(350, 350);
        password.setLocation(350, 450);
        logIn.setLocation(375, 550);
        registered.setLocation(525, 550);
        //添加组件
        add(userName);
        add(password);
        add(logIn);
        add(registered);
        //标签
        title = new Label("酒店管理系统");
        title.setForeground(Color.RED);
        title.setFont(new Font("Arial", Font.BOLD, 60));
        text1 = new Label("用户名:");
        text1.setForeground(Color.blue);
        text1.setFont(new Font("Arial", Font.BOLD, 25));
        text2 = new Label("密码:");
        text2.setForeground(Color.blue);
        text2.setFont(new Font("Arial", Font.BOLD, 25));
        text1.setBounds(230, 350, 100, 50);
        text2.setBounds(260, 450, 100, 50);
        title.setBounds(300, 80, 1000, 200);
        add(title);
        add(text1);
        add(text2);
        //注册监视器
        logIn.addActionListener(this);
        registered.addActionListener(this);

    }

    //监视器
    @Override
    public void actionPerformed(ActionEvent e) {
        String name = e.getActionCommand();
        String user = userName.getText();
        String pass = password.getText();
        if (name.equals("登录")) {
            //管理员界面
            if (user.equals("root") && pass.equals("421232")) {
                AdminInterface adminInterface = new AdminInterface();
                adminInterface.frame.setVisible(true);
                this.setVisible(false);
            } else {
                //在数据库中寻找账号
                if (a.checkAccountAndPassword(user, pass)) {
                    UserInterface userInterface = new UserInterface();
                    //将用户名传入用户界面
                    userInterface.accountBox.setText(user);
                    //姓名传入
                    String sql = "select * from 用户 where 用户名='" + user + "';";
                    try {
                        a.rs = a.stmt.executeQuery(sql);
                        if (a.rs.next()) {
                            userInterface.usernameTextBox.setText(a.rs.getString("姓名"));
                        }
                    } catch (Exception e1) {
                        System.out.println(e1);
                    }
                    userInterface.frame.setVisible(true);
                    this.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(this, "用户名或者密码错误", "错误", 0);
                }
            }
        } else {
            RegistrationInterface registrationInterface = new RegistrationInterface();
            registrationInterface.frame.setVisible(true);
        }
    }

    public static void main(String[] args) {
        new LoginInterface();
    }

}
