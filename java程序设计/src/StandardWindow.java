import javax.swing.*;
import java.awt.*;

public class StandardWindow {
    CalculatorWindow calculatorWindow;
    // region��׼���������
    JTextArea textaArea1;
    JTextField textField1, textField2;
    JSplitPane jsplitPane;
    // ��һ��
    Button bu_baifenhao, bu_CE, bu_C, bu_cha;
    // �ڶ���
    Button bu_1x, bu_x2, bu_genhao2, bu_chu;
    // ������
    Button bu_7, bu_8, bu_9, bu_cheng;
    // ������
    Button bu_4, bu_5, bu_6, bu_jiang;
    // ������
    Button bu_1, bu_2, bu_3, bu_jia;
    // ������
    Button bu_fuhao, bu_0, bu_dian, bu_denyu;
    //�ұ�������ť
    Button bu_bc, bu_fz, bu_qc;

    // endregion
    public StandardWindow(CalculatorWindow calculatorWindow) {
        this.calculatorWindow = calculatorWindow;
        calculatorWindow.setSize(800, 600);
        // ����
        calculatorWindow.setLocationRelativeTo(null);
        init();
        // ע�������
        initActionListener();
    }

    void init() {

        JPanel jPanel = new JPanel();
        //  region��ʼ�����
        textField1 = new JTextField("");//	�������
        textField2 = new JTextField("0");//	������

        textField1.setFont(new Font("Arial", Font.BOLD, 25));
        // ���ܴӼ�������
        textField1.setEditable(false);
        textField1.setHorizontalAlignment(JTextField.RIGHT);// �ұ���ʾ

        textField2.setFont(new Font("Arial", Font.BOLD, 25));
        textField2.setEditable(false);
        textField2.setHorizontalAlignment(JTextField.RIGHT);// �ұ���ʾ

        // ��һ��
        bu_baifenhao = new Button("%");
        bu_CE = new Button("CE");
        bu_C = new Button("C");
        bu_cha = new Button("��");

        // �ڶ���
        bu_1x = new Button("1/x");
        bu_x2 = new Button("x^2");
        bu_genhao2 = new Button("sqrt(x)");
        bu_chu = new Button("/");

        // ������
        bu_7 = new Button("7");
        bu_8 = new Button("8");
        bu_9 = new Button("9");
        bu_cheng = new Button("��");

        // ������
        bu_4 = new Button("4");
        bu_5 = new Button("5");
        bu_6 = new Button("6");
        bu_jiang = new Button("-");

        // ������
        bu_1 = new Button("1");
        bu_2 = new Button("2");
        bu_3 = new Button("3");
        bu_jia = new Button("+");

        // ������
        bu_fuhao = new Button("+/-");
        bu_0 = new Button("0");
        bu_dian = new Button(".");
        bu_denyu = new Button("=");

        // endregion

        // region�����
        JPanel leftPane = new JPanel();
        leftPane.setLayout(new GridLayout(3, 0, -1, -1));
        // �������ı���
        JPanel textPane = new JPanel();
        textPane.setLayout(new GridLayout(2, 0, -1, -1));// ���� ���� �� ˮƽ ��ֱ ���
        textField1.setBackground(new Color(224, 224, 224));// ��ɫ
        textField2.setBackground(new Color(194, 194, 194));
        textPane.add(textField1);
        textPane.add(textField2);
        leftPane.add(textPane);
        // Ϊ�˰�ť�ֲ����ȣ�����߷�Ϊ���У����зָ���ť
        JPanel buttonpane = new JPanel();
        JPanel buttonpane2 = new JPanel();
        buttonpane.setLayout(new GridLayout(3, 4, -1, -1));
        buttonpane2.setLayout(new GridLayout(3, 4, -1, -1));

        buttonpane.setBackground(new Color(194, 194, 194));
        buttonpane2.setBackground(new Color(194, 194, 194));

        // ��ť��
        //   region��ť��������
        bu_baifenhao.setFont(new Font("Arial", Font.BOLD, 20));
        bu_CE.setFont(new Font("Arial", Font.BOLD, 20));
        bu_C.setFont(new Font("Arial", Font.BOLD, 20));
        bu_cha.setFont(new Font("", Font.BOLD, 20));

        bu_1x.setFont(new Font("Arial", Font.BOLD, 20));
        bu_x2.setFont(new Font("Arial", Font.BOLD, 20));
        bu_genhao2.setFont(new Font("", Font.BOLD, 20));
        bu_chu.setFont(new Font("Arial", Font.BOLD, 20));
        bu_7.setFont(new Font("Arial", Font.BOLD, 20));
        bu_8.setFont(new Font("Arial", Font.BOLD, 20));
        bu_9.setFont(new Font("Arial", Font.BOLD, 20));
        bu_cheng.setFont(new Font("Arial", Font.BOLD, 20));

        bu_4.setFont(new Font("Arial", Font.BOLD, 20));
        bu_5.setFont(new Font("Arial", Font.BOLD, 20));
        bu_6.setFont(new Font("Arial", Font.BOLD, 20));
        bu_jiang.setFont(new Font("Arial", Font.BOLD, 20));

        bu_1.setFont(new Font("Arial", Font.BOLD, 20));
        bu_2.setFont(new Font("Arial", Font.BOLD, 20));
        bu_3.setFont(new Font("Arial", Font.BOLD, 20));
        bu_jia.setFont(new Font("Arial", Font.BOLD, 20));

        bu_fuhao.setFont(new Font("Arial", Font.BOLD, 20));
        bu_0.setFont(new Font("Arial", Font.BOLD, 20));
        bu_dian.setFont(new Font("Arial", Font.BOLD, 20));
        bu_denyu.setFont(new Font("Arial", Font.BOLD, 20));
        // ���ڰ�ť��ɫ
        bu_denyu.setBackground(new Color(201, 145, 209));// ��ɫ
        // endregion

        // region��ť���
        buttonpane.add(bu_baifenhao);
        buttonpane.add(bu_CE);
        buttonpane.add(bu_C);
        buttonpane.add(bu_cha);
        buttonpane.add(bu_1x);
        buttonpane.add(bu_x2);
        buttonpane.add(bu_genhao2);
        buttonpane.add(bu_chu);
        buttonpane.add(bu_7);
        buttonpane.add(bu_8);
        buttonpane.add(bu_9);
        buttonpane.add(bu_cheng);
        buttonpane2.add(bu_4);
        buttonpane2.add(bu_5);
        buttonpane2.add(bu_6);
        buttonpane2.add(bu_jiang);
        buttonpane2.add(bu_1);
        buttonpane2.add(bu_2);
        buttonpane2.add(bu_3);
        buttonpane2.add(bu_jia);
        buttonpane2.add(bu_fuhao);
        buttonpane2.add(bu_0);
        buttonpane2.add(bu_dian);
        buttonpane2.add(bu_denyu);
        // endregion

        leftPane.add(buttonpane);
        leftPane.add(buttonpane2);
        // endregion

        // region�����
        JPanel rightPane = new JPanel();
        rightPane.setLayout(new BorderLayout());
        JPanel panel_south = new JPanel();
        panel_south.setLayout(new GridLayout(1, 3, -1, -1));
        // �ı���
        textaArea1 = new JTextArea("");
        textaArea1.setFont(new Font("Arial", Font.ITALIC, 20));
        // ��ӹ�����
        JScrollPane textaArea = new JScrollPane(textaArea1);
        // ���ұ���ʾ
        textaArea1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        // ���ò��ɱ༭
        textaArea1.setEditable(false);
        // ������ɫ
        textaArea1.setBackground(new Color(163, 163, 163));
        // ��ť
        bu_bc = new Button("����");
        bu_fz = new Button("����");
        bu_qc = new Button("���");

        panel_south.add(bu_bc);
        panel_south.add(bu_fz);
        panel_south.add(bu_qc);
        // ����
        rightPane.add(textaArea, BorderLayout.CENTER);
        rightPane.add(panel_south, BorderLayout.SOUTH);
        // endregion

        // �÷ָ���彫�����Ϊ������
        jsplitPane = new JSplitPane(1, false, leftPane, rightPane);
        // ���÷ָ�����λ��,����������(����)��ٷֱ���ָ��.
        jsplitPane.setDividerLocation(500);
        jsplitPane.setEnabled(false);// �ָ���ֹ�ƶ�
        // �������
        calculatorWindow.add(jsplitPane);
    }

    void initActionListener() {
        //  region��ť������ע��
        // region�������ּ���С���㣻
        Numeric_button numeric_button = new Numeric_button(this);
        bu_1.addActionListener(numeric_button);
        bu_2.addActionListener(numeric_button);
        bu_3.addActionListener(numeric_button);
        bu_4.addActionListener(numeric_button);
        bu_5.addActionListener(numeric_button);
        bu_6.addActionListener(numeric_button);
        bu_7.addActionListener(numeric_button);
        bu_8.addActionListener(numeric_button);
        bu_9.addActionListener(numeric_button);
        bu_0.addActionListener(numeric_button);
        bu_dian.addActionListener(numeric_button);
        // endregion

        // region���������
        BasicOperator_Button basicOperatorButton = new BasicOperator_Button(this);
        bu_jia.addActionListener(basicOperatorButton);
        bu_jiang.addActionListener(basicOperatorButton);
        bu_cheng.addActionListener(basicOperatorButton);
        bu_chu.addActionListener(basicOperatorButton);
        // endregion

        // region���ں�
        EndButton endButton = new EndButton(this);
        bu_denyu.addActionListener(endButton);
        // endregion
        StandardFunctionButtonsActionListener standardFunctionButtonsActionListener = new StandardFunctionButtonsActionListener(this);
        // regionC��CE��
        bu_C.addActionListener(standardFunctionButtonsActionListener);
        bu_CE.addActionListener(standardFunctionButtonsActionListener);
        // endregion

        // �˸��
        bu_cha.addActionListener(standardFunctionButtonsActionListener);
        // ƽ����ť
        bu_x2.addActionListener(standardFunctionButtonsActionListener);
        // �෴����ť
        bu_fuhao.addActionListener(standardFunctionButtonsActionListener);
        // ������ť
        bu_1x.addActionListener(standardFunctionButtonsActionListener);
        // �����Ű�ť
        bu_genhao2.addActionListener(standardFunctionButtonsActionListener);
        // �ٷֺŰ�ť
        bu_baifenhao.addActionListener(standardFunctionButtonsActionListener);
        // �����ť
        bu_qc.addActionListener(standardFunctionButtonsActionListener);
        // ���ư�ť   ���Ƶ�ǰ������
        bu_fz.addActionListener(standardFunctionButtonsActionListener);
        // ���水ť
        bu_bc.addActionListener(standardFunctionButtonsActionListener);
        // endregion
    }

}
