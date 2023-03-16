import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//�û�����
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
        menuBar = new JMenuBar();
        menuBar.setBackground(new Color(51, 204, 255));
        Label title = new Label("����Ա����");
        title.setAlignment(1);
        title.setFont(new Font("΢���ź�", Font.BOLD, 40));
        menuBar.add(title);

        //region�����
        //������Ϣ����
        Label personalInformation = new Label("����Ա");
        personalInformation.setFont(new Font("΢���ź�", Font.BOLD, 30));
        personalInformation.setBounds(90, 40, 200, 50);
        leftPanel.add(personalInformation);
        //ͷ��
        ImageIcon adminAvatar = new ImageIcon("hotelManagementSystem_images/����Ա.png");
        JLabel adminPicture = new JLabel(adminAvatar);
        adminPicture.setBounds(62, 100, 150, 150);
        leftPanel.add(adminPicture);
        //�˳���¼
        signOut = new Button("�˳���¼");
        signOut.setFont(new Font("΢���ź�", Font.BOLD, 22));
        signOut.setBounds(80, 300, 120, 60);
        signOut.setBackground(new Color(22, 155, 213));
        signOut.setForeground(Color.white);
        leftPanel.add(signOut);
        //endregion

        //region�����
        //ʣ�෿��
        remainingRoom = new Button("ʣ�෿��");
        remainingRoom.setForeground(Color.blue);
        remainingRoom.setFont(new Font("΢���ź�", Font.BOLD, 15));
        remainingRoom.setBounds(120, 40, 70, 40);
        remainingRoom.setBackground(new Color(242, 242, 242));
        rightPanel.add(remainingRoom);
        //��Ԥ������
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
        //endregion
        frame.setJMenuBar(menuBar);
        //ע�������
        signOut.addActionListener(this);
        //���ݳ�ʼ��
        textArea.setText(a.getAllRooms());
        //ע�������
        remainingRoom.addActionListener(this);
        roomBooked.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = e.getActionCommand();
        if (name.equals("�˳���¼")) {
            LoginInterface loginInterface = new LoginInterface();
            loginInterface.setVisible(true);
            frame.setVisible(false);
        } else if (name.equals("ʣ�෿��")) {
            textArea.setText(a.getAllRooms());
        } else if (name.equals("��Ԥ������")) {
            textArea.setText(a.allBookedRooms());
        }
    }
}
