import javax.swing.*;
import java.awt.*;

/**
 * @author orange
 * 程序员窗格
 */
public class ProGrammerSPane {

    // region组件声明
    CalculatorWindow calculatorWindow;
    // 输入文本框和输出文本框
    JTextField textFieldone, textFieldtwo;
    // 10个数字按钮；
    Button[] numberButtons;
    // 4个转化类型按钮
    Button[] conversionTypeButton;
    // 等于按钮
    Button equalButton;
    // 小数点按钮
    Button decimalPointButton;
    // 相反数按钮
    Button oppositeNumberButton;
    // 退格按钮
    Button backspaceButton;
    // 清零按钮
    Button clearButton;
    // 空白按钮
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
        // region显示区
        //	输入面板
        textFieldone = new JTextField("");
        textFieldone.setEditable(false);
        //	输出面板
        textFieldtwo = new JTextField("0");
        textFieldtwo.setEditable(false);
        //
        textFieldone.setFont(new Font("Arial", Font.BOLD, 25));
        textFieldone.setEditable(false);
        textFieldtwo.setFont(new Font("Arial", Font.BOLD, 25));
        textFieldtwo.setEditable(false);
        // endregion

        // region按钮区
        // 数字按钮
        numberButtons = new Button[10];
        for (int i = 0; i <= 9; i++) {
            numberButtons[i] = new Button(i + "");
        }
        // S四个类型转化按钮
        conversionTypeButton = new Button[4];
        conversionTypeButton[0] = new Button("HEX");
        conversionTypeButton[1] = new Button("DEX");
        conversionTypeButton[2] = new Button("0CT");
        conversionTypeButton[3] = new Button("BIN");
        // 退格按钮
        backspaceButton = new Button("←");
        // 等于按钮
        equalButton = new Button("=");
        // 清除按钮
        clearButton = new Button("C");
        // 相反数按钮
        oppositeNumberButton = new Button("+/-");
        // 小数点按钮
        decimalPointButton = new Button(".");
        // 空白按钮
        blankButton = new Button("");
        // endregion

        // region面板设置
        // 全局面板
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(3, 0, -1, -1));
        // 上面板
        JPanel topJpanel = new JPanel();
        topJpanel.setLayout(new GridLayout(2, 0, -1, -1));
        // 中面板
        JPanel midPanel = new JPanel();
        midPanel.setLayout(new GridLayout(2, 5, -1, -1));
        // 下面板
        JPanel lowerPanel = new JPanel();
        lowerPanel.setLayout(new GridLayout(2, 5, -1, -1));

        jPanel.add(topJpanel);
        jPanel.add(midPanel);
        jPanel.add(lowerPanel);
        //endregion

        // region组件添加
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
     * 美化设置
     * 字体和颜色
     */
    void beautify() {

        // region字体设置
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

        //region颜色设置

        //endregion
    }

    /**
     * 注册监视器
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
