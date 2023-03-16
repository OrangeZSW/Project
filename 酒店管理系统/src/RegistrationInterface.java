import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//ע�����
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
        frame.setTitle("ע��");
        frame.add(panel);
        frame.setDefaultCloseOperation(2);
        frame.setSize(600, 450);
        frame.setLocationRelativeTo(null);
    }

    void init() {
        panel.setLayout(null);
        panel.setBackground(new Color(255, 255, 255));
        //�û���
        Label userName = new Label("*�û���");
        userName.setFont(new Font("΢���ź�", 0, 18));
        userName.setBounds(50, 30, 70, 40);
        panel.add(userName);
        usernameBox = new JTextField("");
        usernameBox.setFont(new Font("΢���ź�", Font.BOLD, 15));
        usernameBox.setHorizontalAlignment(JTextField.LEFT);
        usernameBox.setBounds(130, 30, 360, 35);
        panel.add(usernameBox);
        //����
        Label fullName = new Label("*����");
        fullName.setFont(new Font("΢���ź�", 0, 18));
        fullName.setBounds(68, 90, 60, 40);
        panel.add(fullName);
        nameBox = new JTextField("");
        nameBox.setFont(new Font("΢���ź�", Font.BOLD, 15));
        nameBox.setHorizontalAlignment(2);
        nameBox.setBounds(130, 90, 360, 35);
        panel.add(nameBox);
        //����
        Label password = new Label("*����");
        password.setFont(new Font("΢���ź�", 0, 18));
        password.setBounds(67, 150, 60, 40);
        panel.add(password);
        passwordBox = new JPasswordField();
        passwordBox.setFont(new Font("΢���ź�", 1, 15));
        passwordBox.setHorizontalAlignment(2);
        passwordBox.setBounds(130, 150, 360, 35);
        panel.add(passwordBox);
        //�ظ�����
        Label repeatPassword = new Label("*�ظ�����");
        repeatPassword.setFont(new Font("΢���ź�", 0, 18));
        repeatPassword.setBounds(33, 210, 80, 40);
        panel.add(repeatPassword);
        repeatPasswordBox = new JPasswordField("");
        repeatPasswordBox.setFont(new Font("΢���ź�", 1, 15));
        repeatPasswordBox.setHorizontalAlignment(2);
        repeatPasswordBox.setBounds(130, 210, 360, 35);
        panel.add(repeatPasswordBox);
        //��ϵ�绰
        Label contactNumber = new Label("*��ϵ�绰");
        contactNumber.setFont(new Font("΢���ź�", 0, 18));
        contactNumber.setBounds(33, 270, 80, 40);
        panel.add(contactNumber);
        contactPhoneBox = new JTextField();
        contactPhoneBox.setFont(new Font("΢���ź�", 1, 15));
        contactPhoneBox.setHorizontalAlignment(2);
        contactPhoneBox.setBounds(130, 270, 360, 35);
        panel.add(contactPhoneBox);
        //ע�ᰴť
        registered = new Button("ע��");
        registered.setFont(new Font("΢���ź�", 1, 18));
        registered.setBackground(new Color(64, 158, 255));
        registered.setForeground(Color.white);
        registered.setBounds(190, 330, 80, 40);
        panel.add(registered);
        cancel = new Button("ȡ��");
        cancel.setBackground(Color.white);
        cancel.setFont(new Font("΢���ź�", 1, 18));
        cancel.setBounds(290, 330, 80, 40);
        panel.add(cancel);
        //ע�������
        registered.addActionListener(this);
        cancel.addActionListener(this);
    }

    //������
    @Override
    public void actionPerformed(ActionEvent e) {
        String username, name, password, repeat_password, phone;
        username = usernameBox.getText();
        name = nameBox.getText();
        password = passwordBox.getText();
        repeat_password = repeatPasswordBox.getText();
        phone = contactPhoneBox.getText();
        String button_name = e.getActionCommand();
        if (button_name.equals("ע��")) {
            if (password.equals(repeat_password)) {
                int n = a.registerAnAccount(username, name, password, phone);
                if (n == 1) {
                    JOptionPane.showMessageDialog(frame, "�û����ظ���", "����", 0);
                } else if (n == 2) {
                    JOptionPane.showMessageDialog(frame, "�õ绰�Ѱ󶨣�", "����", 0);
                } else if (n == 0) {
                    JOptionPane.showMessageDialog(frame, "ע��ɹ���", "�ɹ�", 1);
                    frame.setVisible(false);
                } else if (n == 3) {
                    JOptionPane.showMessageDialog(frame, "���ݿ�ϵͳ����", "����", 0);
                }
            } else {
                JOptionPane.showMessageDialog(frame, "������������벻һ��!����������", "����", 0);
            }
        } else {
            frame.setVisible(false);
        }
    }
}
