import java.awt.event.ActionEvent;

public class BasicOperator_Button extends Button_ActionListener {
    public BasicOperator_Button(StandardWindow standardWindow) {
        super(standardWindow);
    }

    /*
     �Ӽ��˳���ť
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        //  �õ�����    ȥ��ǰ��հ���
        String buttonName = e.getActionCommand().trim();
        //  ת��Ϊ�ַ�
        char charName = buttonName.charAt(0);
        // �����
        if (standardWindow.textField2.getText().length() == 0) ;
        else {
            standardWindow.textField1.setText(standardWindow.textField2.getText() + charName);
            standardWindow.textField2.setText("0");
        }


    }
}
