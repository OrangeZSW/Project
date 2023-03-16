import javax.swing.*;
import java.awt.*;

public class StandardWindow {
    CalculatorWindow calculatorWindow;
    // region标准，声明组件
    JTextArea textaArea1;
    JTextField textField1, textField2;
    JSplitPane jsplitPane;
    // 第一排
    Button bu_baifenhao, bu_CE, bu_C, bu_cha;
    // 第二排
    Button bu_1x, bu_x2, bu_genhao2, bu_chu;
    // 第三排
    Button bu_7, bu_8, bu_9, bu_cheng;
    // 第四排
    Button bu_4, bu_5, bu_6, bu_jiang;
    // 第五排
    Button bu_1, bu_2, bu_3, bu_jia;
    // 第六排
    Button bu_fuhao, bu_0, bu_dian, bu_denyu;
    //右边三个按钮
    Button bu_bc, bu_fz, bu_qc;

    // endregion
    public StandardWindow(CalculatorWindow calculatorWindow) {
        this.calculatorWindow = calculatorWindow;
        calculatorWindow.setSize(800, 600);
        // 居中
        calculatorWindow.setLocationRelativeTo(null);
        init();
        // 注册监视器
        initActionListener();
    }

    void init() {

        JPanel jPanel = new JPanel();
        //  region初始化组件
        textField1 = new JTextField("");//	输入面板
        textField2 = new JTextField("0");//	输出面板

        textField1.setFont(new Font("Arial", Font.BOLD, 25));
        // 不能从键盘输入
        textField1.setEditable(false);
        textField1.setHorizontalAlignment(JTextField.RIGHT);// 右边显示

        textField2.setFont(new Font("Arial", Font.BOLD, 25));
        textField2.setEditable(false);
        textField2.setHorizontalAlignment(JTextField.RIGHT);// 右边显示

        // 第一排
        bu_baifenhao = new Button("%");
        bu_CE = new Button("CE");
        bu_C = new Button("C");
        bu_cha = new Button("←");

        // 第二排
        bu_1x = new Button("1/x");
        bu_x2 = new Button("x^2");
        bu_genhao2 = new Button("sqrt(x)");
        bu_chu = new Button("/");

        // 第三排
        bu_7 = new Button("7");
        bu_8 = new Button("8");
        bu_9 = new Button("9");
        bu_cheng = new Button("×");

        // 第四排
        bu_4 = new Button("4");
        bu_5 = new Button("5");
        bu_6 = new Button("6");
        bu_jiang = new Button("-");

        // 第五排
        bu_1 = new Button("1");
        bu_2 = new Button("2");
        bu_3 = new Button("3");
        bu_jia = new Button("+");

        // 第六排
        bu_fuhao = new Button("+/-");
        bu_0 = new Button("0");
        bu_dian = new Button(".");
        bu_denyu = new Button("=");

        // endregion

        // region左面板
        JPanel leftPane = new JPanel();
        leftPane.setLayout(new GridLayout(3, 0, -1, -1));
        // 上两个文本区
        JPanel textPane = new JPanel();
        textPane.setLayout(new GridLayout(2, 0, -1, -1));// 行数 列数 和 水平 垂直 间距
        textField1.setBackground(new Color(224, 224, 224));// 颜色
        textField2.setBackground(new Color(194, 194, 194));
        textPane.add(textField1);
        textPane.add(textField2);
        leftPane.add(textPane);
        // 为了按钮分布均匀，将左边分为三行，两行分给按钮
        JPanel buttonpane = new JPanel();
        JPanel buttonpane2 = new JPanel();
        buttonpane.setLayout(new GridLayout(3, 4, -1, -1));
        buttonpane2.setLayout(new GridLayout(3, 4, -1, -1));

        buttonpane.setBackground(new Color(194, 194, 194));
        buttonpane2.setBackground(new Color(194, 194, 194));

        // 按钮区
        //   region按钮字体设置
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
        // 等于按钮颜色
        bu_denyu.setBackground(new Color(201, 145, 209));// 红色
        // endregion

        // region按钮添加
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

        // region右面板
        JPanel rightPane = new JPanel();
        rightPane.setLayout(new BorderLayout());
        JPanel panel_south = new JPanel();
        panel_south.setLayout(new GridLayout(1, 3, -1, -1));
        // 文本区
        textaArea1 = new JTextArea("");
        textaArea1.setFont(new Font("Arial", Font.ITALIC, 20));
        // 添加滚动条
        JScrollPane textaArea = new JScrollPane(textaArea1);
        // 从右边显示
        textaArea1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        // 设置不可编辑
        textaArea1.setEditable(false);
        // 背景颜色
        textaArea1.setBackground(new Color(163, 163, 163));
        // 按钮
        bu_bc = new Button("保存");
        bu_fz = new Button("复制");
        bu_qc = new Button("清除");

        panel_south.add(bu_bc);
        panel_south.add(bu_fz);
        panel_south.add(bu_qc);
        // 布局
        rightPane.add(textaArea, BorderLayout.CENTER);
        rightPane.add(panel_south, BorderLayout.SOUTH);
        // endregion

        // 用分隔面板将窗体分为两部分
        jsplitPane = new JSplitPane(1, false, leftPane, rightPane);
        // 设置分隔器的位置,可以用整数(像素)或百分比来指定.
        jsplitPane.setDividerLocation(500);
        jsplitPane.setEnabled(false);// 分割点禁止移动
        // 设置面板
        calculatorWindow.add(jsplitPane);
    }

    void initActionListener() {
        //  region按钮监视器注册
        // region基本数字键和小数点；
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

        // region基本运算符
        BasicOperator_Button basicOperatorButton = new BasicOperator_Button(this);
        bu_jia.addActionListener(basicOperatorButton);
        bu_jiang.addActionListener(basicOperatorButton);
        bu_cheng.addActionListener(basicOperatorButton);
        bu_chu.addActionListener(basicOperatorButton);
        // endregion

        // region等于号
        EndButton endButton = new EndButton(this);
        bu_denyu.addActionListener(endButton);
        // endregion
        StandardFunctionButtonsActionListener standardFunctionButtonsActionListener = new StandardFunctionButtonsActionListener(this);
        // regionC和CE键
        bu_C.addActionListener(standardFunctionButtonsActionListener);
        bu_CE.addActionListener(standardFunctionButtonsActionListener);
        // endregion

        // 退格键
        bu_cha.addActionListener(standardFunctionButtonsActionListener);
        // 平方按钮
        bu_x2.addActionListener(standardFunctionButtonsActionListener);
        // 相反数按钮
        bu_fuhao.addActionListener(standardFunctionButtonsActionListener);
        // 倒数按钮
        bu_1x.addActionListener(standardFunctionButtonsActionListener);
        // 开根号按钮
        bu_genhao2.addActionListener(standardFunctionButtonsActionListener);
        // 百分号按钮
        bu_baifenhao.addActionListener(standardFunctionButtonsActionListener);
        // 清除按钮
        bu_qc.addActionListener(standardFunctionButtonsActionListener);
        // 复制按钮   复制当前计算结果
        bu_fz.addActionListener(standardFunctionButtonsActionListener);
        // 保存按钮
        bu_bc.addActionListener(standardFunctionButtonsActionListener);
        // endregion
    }

}
