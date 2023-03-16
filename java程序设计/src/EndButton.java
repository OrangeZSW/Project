import java.awt.event.ActionEvent;

public class EndButton extends Button_ActionListener {
    public EndButton(StandardWindow standardWindow) {
        super(standardWindow);
    }

    @Override
    /*
    等于按钮的监控
    */
    public void actionPerformed(ActionEvent e) {
        // 存储参与运算的两个数
        double firstNumber;
        double secondNumber;
        // 第一个字符串的长度
        int lengthOne = standardWindow.textField1.getText().length();
        // 第二个字符串长度
        int lengthTwo = standardWindow.textField2.getText().length();
        // 分别得到两个文本框的字符
        String firstCharacter = standardWindow.textField1.getText().trim();
        String secondCharacter = standardWindow.textField2.getText().trim();
        // 第一个文本框无数据，但第二个文本框有数据则直接等于
        if (lengthOne == 0 && lengthTwo != 0) {
            // 第二个文本框有数据，但是是初始的0，则不运行
            if (lengthTwo == 1 && standardWindow.textField2.getText().contains("0")) return;
            standardWindow.textField1.setText(standardWindow.textField2.getText() + "=");
            return;
        }
        // 当已经计算过了但是没有继续输入下一个数;也就是第二个文本框里面为0
        if (standardWindow.textField1.getText().contains("=") && lengthTwo == 1 && standardWindow.textField2.getText().contains("0")) {
        /*
            看看后面需要补不，先完成基本功能
        */
        }
        // 如果第二个文本框没有数，则将第一个文本框的值赋给它
        if (lengthTwo == 0) {
            secondCharacter = firstCharacter.substring(0, lengthOne - 1);
        }
        // 将字符串转化为double类型数据进行计算
        firstNumber = Double.parseDouble(firstCharacter.substring(0, lengthOne - 1));
        secondNumber = Double.parseDouble(secondCharacter);
        // 判断运算符号并进行计算
        // 保留5位小数
        if (firstCharacter.charAt(lengthOne - 1) == '+') {
            standardWindow.textField2.setText("" + (firstNumber + secondNumber));
            standardWindow.textField1.setText(standardWindow.textField1.getText() + "" + secondCharacter + "=");
        } else if (firstCharacter.charAt(lengthOne - 1) == '-') {
            standardWindow.textField2.setText("" + (firstNumber - secondNumber));
            standardWindow.textField1.setText(standardWindow.textField1.getText() + "" + secondCharacter + "=");
        } else if (firstCharacter.charAt(lengthOne - 1) == '×') {
            standardWindow.textField2.setText("" + (firstNumber * secondNumber));
            standardWindow.textField1.setText(standardWindow.textField1.getText() + "" + secondCharacter + "=");
        } else {
            standardWindow.textField2.setText("" + (firstNumber / secondNumber));
            standardWindow.textField1.setText(standardWindow.textField1.getText() + "" + secondCharacter + "=");
        }
        // 将结果记录在右边的文本区;
        String text1 = standardWindow.textField1.getText().trim();
        int length = text1.length();
        double number = Double.parseDouble(standardWindow.textField2.getText());
        // 如果结果小于0，则要将负号向后移（文本区的右显示问题）
        if (number < 0) {
            standardWindow.textaArea1.append("=" + text1.substring(0, length - 1) + "\n" + Math.abs(number) + "-" + "\n\n");
        } else {
            standardWindow.textaArea1.append("=" + text1.substring(0, length - 1) + "\n" + number + "\n\n");
        }
    }
}