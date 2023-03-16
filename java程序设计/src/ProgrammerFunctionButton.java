import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.BreakIterator;
import java.util.BitSet;

public class ProgrammerFunctionButton extends ProgrammerPaneListener {
    ProgrammerFunctionButton(ProGrammerSPane proGrammerSPane) {
        super(proGrammerSPane);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String textOne, textTwo;
        textOne = proGrammerSPane.textFieldone.getText().trim();
        textTwo = proGrammerSPane.textFieldtwo.getText().trim();
        // ���㰴ť
        if (e.getSource() == proGrammerSPane.clearButton) {
            proGrammerSPane.textFieldtwo.setText("0");
            proGrammerSPane.textFieldone.setText("");
            // �˸�ť
        } else if (e.getSource() == proGrammerSPane.backspaceButton) {
            if (textOne.length() > 0 || textTwo.length() == 1) {
                proGrammerSPane.textFieldtwo.setText("0");
                proGrammerSPane.textFieldone.setText("");
            } else {
                proGrammerSPane.textFieldtwo.setText(textTwo.substring(0, textTwo.length() - 1));
            }
            // �෴����ť
        } else if (e.getSource() == proGrammerSPane.oppositeNumberButton) {

            if (textTwo.equals("0")) return;
            else proGrammerSPane.textFieldtwo.setText("-" + textTwo);
            // С���㰴ť
        } else if (e.getSource() == proGrammerSPane.decimalPointButton) {
            if (textTwo.contains(".")) return;

            else {
                proGrammerSPane.textFieldtwo.setText(textTwo + ".");
            }
            // ���ڰ�ť
        } else if (e.getSource() == proGrammerSPane.equalButton) {
            return;
        } else {
            // ʮ������
            if (e.getSource() == proGrammerSPane.conversionTypeButton[0]) {
                String numer;
                if (textTwo.contains(".")) {
                    numer = Double.toHexString(Double.parseDouble(textTwo));
                    proGrammerSPane.textFieldone.setText(numer + "H");
                } else {
                    numer = Integer.toHexString(Integer.parseInt(textTwo));
                    proGrammerSPane.textFieldone.setText(numer + "H");
                }
                // ʮ����
            } else if (e.getSource() == proGrammerSPane.conversionTypeButton[1]) {
                proGrammerSPane.textFieldone.setText(textTwo + "D");
                // �˽���
            } else if (e.getSource() == proGrammerSPane.conversionTypeButton[2]) {
                String numer;
                if (textTwo.contains(".")) {

                } else {
                    numer = Integer.toOctalString(Integer.parseInt(textTwo));
                    proGrammerSPane.textFieldone.setText(numer + "O");
                }
                // ������
            } else if (e.getSource() == proGrammerSPane.conversionTypeButton[3]) {
                String numer;
                if (textTwo.contains(".")) {

                } else {
                    numer = Integer.toBinaryString(Integer.parseInt(textTwo));
                    proGrammerSPane.textFieldone.setText(numer + "B");
                }
            }
        }
    }
}
