import java.awt.event.ActionEvent;

public class Numeric_button extends Button_ActionListener {

    public Numeric_button(StandardWindow standardWindow) {
        super(standardWindow);
    }

    @Override
    /*
    ���ֺ�С����
    * */
    public void actionPerformed(ActionEvent e) {
        String name = e.getActionCommand();

        // �Ѿ����˼����ٴ���������ʱ�������ı�����Ҫ����
        if (standardWindow.textField1.getText().contains("=")) {
            standardWindow.textField1.setText("");
            standardWindow.textField2.setText("");
        }
        // �����Ϊ15
        if (standardWindow.textField2.getText().length() <= 15) {
            // ���������
            String but_name = e.getActionCommand().trim();
            // ת��Ϊ�ַ�
            char digit = but_name.charAt(0);
            //  �ж��Ƿ�����0
            if (digit == '0') {
                // ��һ����Ϊ0ʱ���ڶ�������Ϊ0
                if (standardWindow.textField2.getText().length() == 1 && standardWindow.textField2.getText().contains("0"))
                    ;
                else standardWindow.textField2.setText(standardWindow.textField2.getText() + digit);
                // �ж��Ƿ�����С����
            } else if (digit == '.') {
                // �Ѿ������
                if (standardWindow.textField1.getText().contains("=")) {
                    standardWindow.textField1.setText("");
                    standardWindow.textField2.setText("0" + ".");
                    return;
                }
                // ���Ѿ�����С����������������ܼ�С����
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