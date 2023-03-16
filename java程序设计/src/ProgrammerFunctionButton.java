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
        // 清零按钮
        if (e.getSource() == proGrammerSPane.clearButton) {
            proGrammerSPane.textFieldtwo.setText("0");
            proGrammerSPane.textFieldone.setText("");
            // 退格按钮
        } else if (e.getSource() == proGrammerSPane.backspaceButton) {
            if (textOne.length() > 0 || textTwo.length() == 1) {
                proGrammerSPane.textFieldtwo.setText("0");
                proGrammerSPane.textFieldone.setText("");
            } else {
                proGrammerSPane.textFieldtwo.setText(textTwo.substring(0, textTwo.length() - 1));
            }
            // 相反数按钮
        } else if (e.getSource() == proGrammerSPane.oppositeNumberButton) {

            if (textTwo.equals("0")) return;
            else proGrammerSPane.textFieldtwo.setText("-" + textTwo);
            // 小数点按钮
        } else if (e.getSource() == proGrammerSPane.decimalPointButton) {
            if (textTwo.contains(".")) return;

            else {
                proGrammerSPane.textFieldtwo.setText(textTwo + ".");
            }
            // 等于按钮
        } else if (e.getSource() == proGrammerSPane.equalButton) {
            return;
        } else {
            // 十六进制
            if (e.getSource() == proGrammerSPane.conversionTypeButton[0]) {
                String numer;
                if (textTwo.contains(".")) {
                    numer = Double.toHexString(Double.parseDouble(textTwo));
                    proGrammerSPane.textFieldone.setText(numer + "H");
                } else {
                    numer = Integer.toHexString(Integer.parseInt(textTwo));
                    proGrammerSPane.textFieldone.setText(numer + "H");
                }
                // 十进制
            } else if (e.getSource() == proGrammerSPane.conversionTypeButton[1]) {
                proGrammerSPane.textFieldone.setText(textTwo + "D");
                // 八进制
            } else if (e.getSource() == proGrammerSPane.conversionTypeButton[2]) {
                String numer;
                if (textTwo.contains(".")) {

                } else {
                    numer = Integer.toOctalString(Integer.parseInt(textTwo));
                    proGrammerSPane.textFieldone.setText(numer + "O");
                }
                // 二进制
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
