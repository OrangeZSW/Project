import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//�û�����
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
        //��ʼ������
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
        //�ָ��
        jsPlitPane.setDividerLocation(300);
        jsPlitPane.setEnabled(false);
        //�˵���
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(new Color(51, 204, 255));
        Label title = new Label("��ӭ�����Ƶ����ϵͳ");
        title.setAlignment(1);
        title.setFont(new Font("΢���ź�", Font.BOLD, 40));
        menuBar.add(title);

        //region�����

        //������Ϣ����
        Label personalInformation = new Label("������Ϣ");
        personalInformation.setFont(new Font("΢���ź�", Font.BOLD, 30));
        personalInformation.setBounds(90, 40, 200, 50);
        leftPanel.add(personalInformation);
        //ͷ��
        ImageIcon headPortrait = new ImageIcon("hotelManagementSystem_images//x_ͷ��.png");
        JLabel headPortraitLabel = new JLabel(headPortrait);
        headPortraitLabel.setBounds(130, 120, 50, 50);
        leftPanel.add(headPortraitLabel);
        //�û���
        Label Name = new Label("����:");
        Name.setFont(new Font("΢���ź�", Font.BOLD, 22));
        Name.setBounds(40, 250, 60, 50);
        leftPanel.add(Name);
        usernameTextBox = new TextField("");
        usernameTextBox.setFocusable(false);
        usernameTextBox.setFont(new Font("΢���ź�", Font.BOLD, 22));
        usernameTextBox.setBounds(120, 260, 150, 30);
        usernameTextBox.setEditable(false);
        leftPanel.add(usernameTextBox);
        //�˻�
        Label account = new Label("�û���:");
        account.setFont(new Font("΢���ź�", Font.BOLD, 22));
        account.setBounds(20, 320, 80, 30);
        leftPanel.add(account);
        accountBox = new TextField("");
        accountBox.setFocusable(false);
        accountBox.setFont(new Font("΢���ź�", Font.BOLD, 22));
        accountBox.setBounds(120, 320, 150, 30);
        accountBox.setEditable(false);
        leftPanel.add(accountBox);
        //�˳���¼
        signOut = new Button("�˳���¼");
        signOut.setFont(new Font("΢���ź�", Font.BOLD, 22));
        signOut.setBounds(120, 400, 120, 60);
        signOut.setBackground(new Color(22, 155, 213));
        signOut.setForeground(Color.white);
        leftPanel.add(signOut);

        //endregion

        //region�����
        //��ǩ1
        availableRooms = new Button("�ɹ�ѡ�񷿼�");
        availableRooms.setForeground(Color.blue);
        availableRooms.setFont(new Font("΢���ź�", Font.BOLD, 15));
        availableRooms.setBounds(120, 40, 100, 40);
        availableRooms.setBackground(new Color(242, 242, 242));
        rightPanel.add(availableRooms);
        //��ǩ2
        roomBooked = new Button("��Ԥ������");
        roomBooked.setForeground(Color.BLUE);
        roomBooked.setFont(new Font("΢���ź�", Font.BOLD, 15));
        roomBooked.setBounds(380, 40, 80, 40);
        roomBooked.setBackground(new Color(242, 242, 242));
        rightPanel.add(roomBooked);
        //�ı���
        textArea = new TextArea();
        textArea.setBounds(0, 100, 680, 200);
        textArea.setFont(new Font("΢���ź�", 1, 15));
        textArea.setEditable(false);
        textArea.setFocusable(false);
        rightPanel.add(textArea);

        //������

        Label seek = new Label("����");
        seek.setFont(new Font("����", Font.BOLD, 35));
        seek.setForeground(Color.CYAN);
        seek.setBounds(20, 320, 80, 40);
        rightPanel.add(seek);
        //��������
        Label roomType = new Label("����:");
        roomType.setFont(new Font("΢���ź�", Font.BOLD, 22));
        roomType.setBounds(80, 380, 60, 40);
        rightPanel.add(roomType);
        //��ѡ��
        roomComboboxs = new JComboBox<String>();
        roomComboboxs.addItem("���˼�");
        roomComboboxs.addItem("˫�˼�");
        roomComboboxs.addItem("�׼�ͷ�");
        roomComboboxs.addItem("����ͷ�");
        roomComboboxs.addItem("��Ԣʽ�ͷ�");
        roomComboboxs.addItem("��ͳ�׷�");
        roomComboboxs.setFont(new Font("΢���ź�", Font.BOLD, 22));
        roomComboboxs.setBounds(150, 380, 150, 40);
        rightPanel.add(roomComboboxs);
        //ȷ����ť
        determine = new Button("ȷ��");
        determine.setFont(new Font("΢���ź�", Font.BOLD, 22));
        determine.setBounds(320, 370, 70, 60);
        rightPanel.add(determine);
        //Ԥ����

        //��ǩ
        Label destine = new Label("Ԥ��/�˷�");
        destine.setForeground(Color.CYAN);
        destine.setFont(new Font("����", Font.BOLD, 35));
        destine.setBounds(20, 460, 180, 40);
        rightPanel.add(destine);
        //�����
        Label room_number = new Label("�����:");
        room_number.setFont(new Font("΢���ź�", Font.BOLD, 22));
        room_number.setBounds(80, 520, 80, 40);
        rightPanel.add(room_number);
        //����Ԥ����
        roomNumber = new TextField("");
        roomNumber.setFont(new Font("΢���ź�", Font.BOLD, 22));
        roomNumber.setForeground(Color.red);
        roomNumber.setBounds(170, 525, 50, 30);
        roomNumber.setForeground(Color.red);
        rightPanel.add(roomNumber);
        //�ύ��ť
        submit = new Button("�ύ");
        submit.setFont(new Font("΢���ź�", Font.BOLD, 26));
        submit.setBounds(240, 515, 70, 60);
        submit.setBackground(Color.blue);
        submit.setForeground(Color.white);
        rightPanel.add(submit);
        //�˷���ť
        checkOut = new Button("�˷�");
        checkOut.setFont(new Font("΢���ź�", Font.BOLD, 26));
        checkOut.setBounds(320, 515, 70, 60);
        checkOut.setBackground(Color.RED);
        rightPanel.add(checkOut);
        //endregion
        frame.setJMenuBar(menuBar);
        //��ʼ���ݵ���
        textArea.setText(a.getAllRooms());
        //ע�������
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
        if (name.equals("�˳���¼")) {
            LoginInterface loginInterface = new LoginInterface();
            loginInterface.setVisible(true);
            this.frame.setVisible(false);
        } else if (name.equals("�ɹ�ѡ�񷿼�")) {
            textArea.setText(a.getAllRooms());
        } else if (name.equals("��Ԥ������")) {
            textArea.setText(a.findAReservedRoom(accountBox.getText()));
        } else if (name.equals("ȷ��")) {
            textArea.setText("");
            textArea.setText(a.typeFindRoom((String) roomComboboxs.getSelectedItem()));
        } else if (name.equals("�ύ")) {
            a.roomNumberToChooseWhetherToBook(a, this, roomNumber.getText(), accountBox.getText(), usernameTextBox.getText());
        } else if (name.equals("�˷�")) {
            a.checkOutTheRoomNumber(a, this, roomNumber.getText(), accountBox.getText());
        }
    }
}
