import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//��¼����
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
        setTitle("�Ƶ����ϵͳ");
        setSize(1000, 700);
        setVisible(true);
        setLocationRelativeTo(null);
        setBackground(new Color(162, 176, 207));
        //�ص�����
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        //������
        init();
    }

    void init() {
        //��ʼ�����
        userName = new JTextField();
        password = new JPasswordField();
        logIn = new Button("��¼");
        logIn.setBackground(Color.blue);
        logIn.setForeground(Color.white);
        registered = new Button("�û�ע��");
        registered.setBackground(Color.GRAY);
        logIn.setFont(new Font("Arial", Font.ITALIC, 25));
        registered.setFont(new Font("Arial", Font.ITALIC, 20));
        //���������С
        userName.setFont(new Font("Arial", Font.BOLD, 25));
        userName.setHorizontalAlignment(2);
        password.setFont(new Font("Arial", Font.BOLD, 25));
        password.setHorizontalAlignment(2);

        userName.setSize(300, 50);
        password.setSize(300, 50);
        logIn.setSize(100, 50);
        registered.setSize(100, 50);
        //�������λ��
        userName.setLocation(350, 350);
        password.setLocation(350, 450);
        logIn.setLocation(375, 550);
        registered.setLocation(525, 550);
        //������
        add(userName);
        add(password);
        add(logIn);
        add(registered);
        //��ǩ
        title = new Label("�Ƶ����ϵͳ");
        title.setForeground(Color.RED);
        title.setFont(new Font("Arial", Font.BOLD, 60));
        text1 = new Label("�û���:");
        text1.setForeground(Color.blue);
        text1.setFont(new Font("Arial", Font.BOLD, 25));
        text2 = new Label("����:");
        text2.setForeground(Color.blue);
        text2.setFont(new Font("Arial", Font.BOLD, 25));
        text1.setBounds(230, 350, 100, 50);
        text2.setBounds(260, 450, 100, 50);
        title.setBounds(300, 80, 1000, 200);
        add(title);
        add(text1);
        add(text2);
        //ע�������
        logIn.addActionListener(this);
        registered.addActionListener(this);

    }

    //������
    @Override
    public void actionPerformed(ActionEvent e) {
        String name = e.getActionCommand();
        String user = userName.getText();
        String pass = password.getText();
        if (name.equals("��¼")) {
            //����Ա����
            if (user.equals("root") && pass.equals("421232")) {
                AdminInterface adminInterface = new AdminInterface();
                adminInterface.frame.setVisible(true);
                this.setVisible(false);
            } else {
                //�����ݿ���Ѱ���˺�
                if (a.checkAccountAndPassword(user, pass)) {
                    UserInterface userInterface = new UserInterface();
                    //���û��������û�����
                    userInterface.accountBox.setText(user);
                    //��������
                    String sql = "select * from �û� where �û���='" + user + "';";
                    try {
                        a.rs = a.stmt.executeQuery(sql);
                        if (a.rs.next()) {
                            userInterface.usernameTextBox.setText(a.rs.getString("����"));
                        }
                    } catch (Exception e1) {
                        System.out.println(e1);
                    }
                    userInterface.frame.setVisible(true);
                    this.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(this, "�û��������������", "����", 0);
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
