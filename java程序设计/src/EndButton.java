import java.awt.event.ActionEvent;

public class EndButton extends Button_ActionListener {
    public EndButton(StandardWindow standardWindow) {
        super(standardWindow);
    }

    @Override
    /*
    ���ڰ�ť�ļ��
    */
    public void actionPerformed(ActionEvent e) {
        // �洢���������������
        double firstNumber;
        double secondNumber;
        // ��һ���ַ����ĳ���
        int lengthOne = standardWindow.textField1.getText().length();
        // �ڶ����ַ�������
        int lengthTwo = standardWindow.textField2.getText().length();
        // �ֱ�õ������ı�����ַ�
        String firstCharacter = standardWindow.textField1.getText().trim();
        String secondCharacter = standardWindow.textField2.getText().trim();
        // ��һ���ı��������ݣ����ڶ����ı�����������ֱ�ӵ���
        if (lengthOne == 0 && lengthTwo != 0) {
            // �ڶ����ı��������ݣ������ǳ�ʼ��0��������
            if (lengthTwo == 1 && standardWindow.textField2.getText().contains("0")) return;
            standardWindow.textField1.setText(standardWindow.textField2.getText() + "=");
            return;
        }
        // ���Ѿ�������˵���û�м���������һ����;Ҳ���ǵڶ����ı�������Ϊ0
        if (standardWindow.textField1.getText().contains("=") && lengthTwo == 1 && standardWindow.textField2.getText().contains("0")) {
        /*
            ����������Ҫ����������ɻ�������
        */
        }
        // ����ڶ����ı���û�������򽫵�һ���ı����ֵ������
        if (lengthTwo == 0) {
            secondCharacter = firstCharacter.substring(0, lengthOne - 1);
        }
        // ���ַ���ת��Ϊdouble�������ݽ��м���
        firstNumber = Double.parseDouble(firstCharacter.substring(0, lengthOne - 1));
        secondNumber = Double.parseDouble(secondCharacter);
        // �ж�������Ų����м���
        // ����5λС��
        if (firstCharacter.charAt(lengthOne - 1) == '+') {
            standardWindow.textField2.setText("" + (firstNumber + secondNumber));
            standardWindow.textField1.setText(standardWindow.textField1.getText() + "" + secondCharacter + "=");
        } else if (firstCharacter.charAt(lengthOne - 1) == '-') {
            standardWindow.textField2.setText("" + (firstNumber - secondNumber));
            standardWindow.textField1.setText(standardWindow.textField1.getText() + "" + secondCharacter + "=");
        } else if (firstCharacter.charAt(lengthOne - 1) == '��') {
            standardWindow.textField2.setText("" + (firstNumber * secondNumber));
            standardWindow.textField1.setText(standardWindow.textField1.getText() + "" + secondCharacter + "=");
        } else {
            standardWindow.textField2.setText("" + (firstNumber / secondNumber));
            standardWindow.textField1.setText(standardWindow.textField1.getText() + "" + secondCharacter + "=");
        }
        // �������¼���ұߵ��ı���;
        String text1 = standardWindow.textField1.getText().trim();
        int length = text1.length();
        double number = Double.parseDouble(standardWindow.textField2.getText());
        // ������С��0����Ҫ����������ƣ��ı���������ʾ���⣩
        if (number < 0) {
            standardWindow.textaArea1.append("=" + text1.substring(0, length - 1) + "\n" + Math.abs(number) + "-" + "\n\n");
        } else {
            standardWindow.textaArea1.append("=" + text1.substring(0, length - 1) + "\n" + number + "\n\n");
        }
    }
}