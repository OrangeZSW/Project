import java.awt.event.ActionEvent;

public class ProgrammerNumberButton extends ProgrammerPaneListener {
    ProgrammerNumberButton(ProGrammerSPane proGrammerSPane) {
        super(proGrammerSPane);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String textOne = proGrammerSPane.textFieldone.getText();
        String textTwo = proGrammerSPane.textFieldtwo.getText();
        String name = e.getActionCommand().trim();
        if (textTwo.length() < 15) {
            if (textTwo.equals("0")) {
                proGrammerSPane.textFieldtwo.setText(name);
            } else {
                proGrammerSPane.textFieldtwo.setText(textTwo + name);
            }
        }
    }
}
