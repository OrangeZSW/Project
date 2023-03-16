import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.event.ActionEvent;
import java.io.*;

public class StandardFunctionButtonsActionListener extends Button_ActionListener {
    public StandardFunctionButtonsActionListener(StandardWindow standardWindow) {
        super(standardWindow);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // 平方按钮
        if (e.getSource() == standardWindow.bu_x2) {
            String text = standardWindow.textField2.getText().trim();
            double number = Double.parseDouble(text);
            if (number == 0) return;
            standardWindow.textField1.setText("pow(" + text + ",2)" + "=");
            standardWindow.textField2.setText("" + (number * number));

            // 保存过程到文本区
            int length = standardWindow.textField1.getText().length();
            String text1 = standardWindow.textField1.getText();
            number = Double.parseDouble(standardWindow.textField2.getText());
            if (number < 0) {
                standardWindow.textaArea1.append("=" + text1.substring(0, length - 1) + "\n" + Math.abs(number) + "-" + "\n\n");
            } else {
                standardWindow.textaArea1.append("=" + text1.substring(0, length - 1) + "\n" + number + "\n\n");
            }

        } else if (e.getSource() == standardWindow.bu_bc) {
            // 保存按钮
            JFileChooser jFileChooser = new JFileChooser();
            int state = jFileChooser.showSaveDialog(null);
            File file = jFileChooser.getSelectedFile();
            if (file != null && state == JFileChooser.APPROVE_OPTION) {
                try {
                    String content = standardWindow.textaArea1.getText();
                    StringReader read = new StringReader(content);
                    BufferedReader in = new BufferedReader(read);
                    FileWriter outOne = new FileWriter(file);
                    BufferedWriter out = new BufferedWriter(outOne);
                    String str = null;
                    while ((str = in.readLine()) != null) {
                        out.write(str);
                        out.newLine();
                    }
                    in.close();
                    out.close();
                } catch (IOException e1) {
                }
            }

        } else if (e.getSource() == standardWindow.bu_baifenhao) {
            // 百分号按钮
            String text = standardWindow.textField2.getText().trim();
            double number = Double.parseDouble(text);
            if (number == 0) {
                return;
            }
            standardWindow.textField1.setText(text + "%" + "=");
            standardWindow.textField2.setText("" + number / 100);

            int length = standardWindow.textField1.getText().length();
            String text1 = standardWindow.textField1.getText();
            number = Double.parseDouble(standardWindow.textField2.getText());
            if (number < 0) {
                standardWindow.textaArea1.append("=" + text1.substring(0, length - 1) + "\n" + Math.abs(number) + "-" + "\n\n");
            } else {
                standardWindow.textaArea1.append("=" + text1.substring(0, length - 1) + "\n" + number + "\n\n");
            }
        } else if (e.getSource() == standardWindow.bu_fuhao) {
            // 相反数按钮
            String text = standardWindow.textField2.getText().trim();
            double number = Double.parseDouble(text);
            if (number == 0) return;
            standardWindow.textField2.setText("" + (-number));
            // 根号2
        } else if (e.getSource() == standardWindow.bu_genhao2) {
            String text = standardWindow.textField2.getText().trim();
            double number = Double.parseDouble(text);
            standardWindow.textField1.setText("sqrt(" + text + ")" + "=");
            standardWindow.textField2.setText("" + Math.sqrt(number));

            // 保存在文本区
            int length = standardWindow.textField1.getText().length();
            String text1 = standardWindow.textField1.getText();
            number = Double.parseDouble(standardWindow.textField2.getText());
            if (number < 0) {
                standardWindow.textaArea1.append("=" + text1.substring(0, length - 1) + "\n" + Math.abs(number) + "-" + "\n\n");
            } else {
                standardWindow.textaArea1.append("=" + text1.substring(0, length - 1) + "\n" + number + "\n\n");
            }

        } else if (e.getSource() == standardWindow.bu_1x) {
            // 倒数按钮
            String text = standardWindow.textField2.getText().trim();
            Double number = Double.parseDouble(text);
            if (number == 0) return;
            standardWindow.textField1.setText("1" + "/" + standardWindow.textField2.getText() + "=");
            standardWindow.textField2.setText("" + (1 / number));

            // 保存在文本区
            int length = standardWindow.textField1.getText().length();
            String text1 = standardWindow.textField1.getText();
            number = Double.parseDouble(standardWindow.textField2.getText());
            if (number < 0) {
                standardWindow.textaArea1.append("=" + text1.substring(0, length - 1) + "\n" + Math.abs(number) + "-" + "\n\n");
            } else {
                standardWindow.textaArea1.append("=" + text1.substring(0, length - 1) + "\n" + number + "\n\n");
            }
        } else if (e.getSource() == standardWindow.bu_fz) {
            // 复制按钮
            String text = new String(standardWindow.textField1.getText() + standardWindow.textField2.getText() + "");
            setSysClipboardText(text);

        } else if (e.getSource() == standardWindow.bu_qc) {
            // 清除按钮
            standardWindow.textaArea1.setText("");

        } else if (e.getSource() == standardWindow.bu_C || e.getSource() == standardWindow.bu_CE) {
            // c和ce
            if (e.getActionCommand().length() > 1) {
                standardWindow.textField2.setText("0");
                // 如果过程框包含等号，则将该文本框置空
                if (standardWindow.textField1.getText().contains("=")) standardWindow.textField1.setText("");
            } else {
                standardWindow.textField2.setText("0");
                standardWindow.textField1.setText("");
            }
        } else if (e.getSource() == standardWindow.bu_cha) {
            // 退格按钮
            String text = standardWindow.textField2.getText().trim();
            int length = standardWindow.textField2.getText().length();
            if (length == 1 && text.contains("0")) return;
            else {
                if (length == 1 || standardWindow.textField1.getText().contains("=")) {
                    standardWindow.textField2.setText("0");
                } else {
                    // 去掉最一个数字
                    standardWindow.textField2.setText(standardWindow.textField2.getText().substring(0, length - 1));
                }
            }
        }

    }

    /**
     * 将字符串复制到剪切板。
     */
    void setSysClipboardText(String writeMe) {
        Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable tText = new StringSelection(writeMe);
        clip.setContents(tText, null);
    }

}
