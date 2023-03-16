import java.awt.event.ActionEvent;

public class BasicOperator_Button extends Button_ActionListener {
    public BasicOperator_Button(StandardWindow standardWindow) {
        super(standardWindow);
    }

    /*
     加减乘除按钮
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        //  得到符号    去除前后空白区
        String buttonName = e.getActionCommand().trim();
        //  转化为字符
        char charName = buttonName.charAt(0);
        // 结果区
        if (standardWindow.textField2.getText().length() == 0) ;
        else {
            standardWindow.textField1.setText(standardWindow.textField2.getText() + charName);
            standardWindow.textField2.setText("0");
        }


    }
}
