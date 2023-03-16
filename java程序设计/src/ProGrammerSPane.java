import javax.swing.*;
import java.awt.*;

/**
 * @author orange
 * ����Ա����
 */
public class ProGrammerSPane {

    // region�������
    CalculatorWindow calculatorWindow;
    // �����ı��������ı���
    JTextField textFieldone, textFieldtwo;
    // 10�����ְ�ť��
    Button[] numberButtons;
    // 4��ת�����Ͱ�ť
    Button[] conversionTypeButton;
    // ���ڰ�ť
    Button equalButton;
    // С���㰴ť
    Button decimalPointButton;
    // �෴����ť
    Button oppositeNumberButton;
    // �˸�ť
    Button backspaceButton;
    // ���㰴ť
    Button clearButton;
    // �հװ�ť
    Button blankButton;
    // endregion

    ProGrammerSPane(CalculatorWindow calculatorWindow) {
        this.calculatorWindow = calculatorWindow;
        calculatorWindow.setSize(800, 600);
        calculatorWindow.setLocationRelativeTo(null);
        init();
        initActionListener();
        beautify();

    }

    void init() {
        // region��ʾ��
        //	�������
        textFieldone = new JTextField("");
        textFieldone.setEditable(false);
        //	������
        textFieldtwo = new JTextField("0");
        textFieldtwo.setEditable(false);
        //
        textFieldone.setFont(new Font("Arial", Font.BOLD, 25));
        textFieldone.setEditable(false);
        textFieldtwo.setFont(new Font("Arial", Font.BOLD, 25));
        textFieldtwo.setEditable(false);
        // endregion

        // region��ť��
        // ���ְ�ť
        numberButtons = new Button[10];
        for (int i = 0; i <= 9; i++) {
            numberButtons[i] = new Button(i + "");
        }
        // S�ĸ�����ת����ť
        conversionTypeButton = new Button[4];
        conversionTypeButton[0] = new Button("HEX");
        conversionTypeButton[1] = new Button("DEX");
        conversionTypeButton[2] = new Button("0CT");
        conversionTypeButton[3] = new Button("BIN");
        // �˸�ť
        backspaceButton = new Button("��");
        // ���ڰ�ť
        equalButton = new Button("=");
        // �����ť
        clearButton = new Button("C");
        // �෴����ť
        oppositeNumberButton = new Button("+/-");
        // С���㰴ť
        decimalPointButton = new Button(".");
        // �հװ�ť
        blankButton = new Button("");
        // endregion

        // region�������
        // ȫ�����
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(3, 0, -1, -1));
        // �����
        JPanel topJpanel = new JPanel();
        topJpanel.setLayout(new GridLayout(2, 0, -1, -1));
        // �����
        JPanel midPanel = new JPanel();
        midPanel.setLayout(new GridLayout(2, 5, -1, -1));
        // �����
        JPanel lowerPanel = new JPanel();
        lowerPanel.setLayout(new GridLayout(2, 5, -1, -1));

        jPanel.add(topJpanel);
        jPanel.add(midPanel);
        jPanel.add(lowerPanel);
        //endregion

        // region������
        topJpanel.add(textFieldone);
        topJpanel.add(textFieldtwo);

        midPanel.add(numberButtons[7]);
        midPanel.add(numberButtons[8]);
        midPanel.add(numberButtons[9]);
        midPanel.add(blankButton);
        midPanel.add(conversionTypeButton[0]);
        midPanel.add(numberButtons[4]);
        midPanel.add(numberButtons[5]);
        midPanel.add(numberButtons[6]);
        midPanel.add(backspaceButton);
        midPanel.add(conversionTypeButton[1]);

        lowerPanel.add(numberButtons[1]);
        lowerPanel.add(numberButtons[2]);
        lowerPanel.add(numberButtons[3]);
        lowerPanel.add(clearButton);
        lowerPanel.add(conversionTypeButton[2]);
        lowerPanel.add(oppositeNumberButton);
        lowerPanel.add(numberButtons[0]);
        lowerPanel.add(decimalPointButton);
        lowerPanel.add(equalButton);
        lowerPanel.add(conversionTypeButton[3]);

        calculatorWindow.add(jPanel);
        // endregion
    }

    /**
     * ��������
     * �������ɫ
     */
    void beautify() {

        // region��������
        for (int i = 0; i <= 9; i++) {
            numberButtons[i].setFont(new Font("Arial", Font.BOLD, 25));
        }
        for (int i = 0; i <= 3; i++) {
            conversionTypeButton[i].setFont(new Font("Arial", Font.BOLD, 25));
        }
        clearButton.setFont(new Font("Arial", Font.BOLD, 25));
        oppositeNumberButton.setFont(new Font("Arial", Font.BOLD, 25));
        decimalPointButton.setFont(new Font("Arial", Font.BOLD, 25));
        backspaceButton.setFont(new Font("Arial", Font.BOLD, 25));
        equalButton.setFont(new Font("Arial", Font.BOLD, 25));
        // endregion

        //region��ɫ����

        //endregion
    }

    /**
     * ע�������
     */
    void initActionListener() {
        ProgrammerNumberButton programmerNumberButton = new ProgrammerNumberButton(this);
        for (int i = 0; i <= 9; i++) {
            numberButtons[i].addActionListener(programmerNumberButton);
        }
        ProgrammerFunctionButton programmerFunctionButton = new ProgrammerFunctionButton(this);
        backspaceButton.addActionListener(programmerFunctionButton);
        clearButton.addActionListener(programmerFunctionButton);
        oppositeNumberButton.addActionListener(programmerFunctionButton);
        decimalPointButton.addActionListener(programmerFunctionButton);
        for (int i = 0; i < 4; i++) {
            conversionTypeButton[i].addActionListener(programmerFunctionButton);
        }
    }
}
