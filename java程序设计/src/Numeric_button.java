import java.awt.event.ActionEvent;

public class Numeric_button extends Button_ActionListener {

    public Numeric_button(StandardWindow standardWindow) {
        super(standardWindow);
    }

    @Override
    /*
    数字和小数点
    * */
    public void actionPerformed(ActionEvent e) {
        String name = e.getActionCommand();

        // 已经做了计算再次输入数字时，两个文本区都要清零
        if (standardWindow.textField1.getText().contains("=")) {
            standardWindow.textField1.setText("");
            standardWindow.textField2.setText("");
        }
        // 数据最长为15
        if (standardWindow.textField2.getText().length() <= 15) {
            // 对象的内容
            String but_name = e.getActionCommand().trim();
            // 转化为字符
            char digit = but_name.charAt(0);
            //  判断是否输入0
            if (digit == '0') {
                // 第一个数为0时，第二个不能为0
                if (standardWindow.textField2.getText().length() == 1 && standardWindow.textField2.getText().contains("0"))
                    ;
                else standardWindow.textField2.setText(standardWindow.textField2.getText() + digit);
                // 判断是否输入小数点
            } else if (digit == '.') {
                // 已经计算过
                if (standardWindow.textField1.getText().contains("=")) {
                    standardWindow.textField1.setText("");
                    standardWindow.textField2.setText("0" + ".");
                    return;
                }
                // 当已经有了小数点或者无数据则不能加小数点
                if (standardWindow.textField2.getText().contains(".") || standardWindow.textField2.getText().length() == 0) {
                    return;
                } else {
                    standardWindow.textField2.setText(standardWindow.textField2.getText() + digit);
                    return;
                }
            } else if (standardWindow.textField2.getText().length() == 1 && standardWindow.textField2.getText().contains("0")) {
                standardWindow.textField2.setText("" + digit);
            } else {
                standardWindow.textField2.setText(standardWindow.textField2.getText() + digit);
            }
        }
    }
}