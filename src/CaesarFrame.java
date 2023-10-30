import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CaesarFrame extends JFrame {

    private JTextField up = new JTextField(20);
    private JTextField down = new JTextField(20);
    private JButton button = new JButton("Code!");
    private String [] letters =  {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    private JComboBox combo = new JComboBox(letters);

    CaesarFrame() {
        super("SwingLab");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 110);
        setResizable(false);



        JLabel label = new JLabel("Output:");
        setLayout(new GridLayout(2,1));

        JPanel upper = new JPanel();
        JPanel downer = new JPanel();
        upper.setLayout(new FlowLayout(FlowLayout.CENTER, 0,5));
        downer.setLayout(new BorderLayout(0, 0));

        upper.add(combo);
        upper.add(up);
        upper.add(button);

        downer.add(label, BorderLayout.WEST);
        downer.add(down);

        setResizable(true);
        down.setEditable(false);

        add(upper);
        add(downer);


        final class OKButtonListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                    down.setText(caesarCode(up.getText(), (Character) combo.getSelectedItem().toString().charAt(0)));
            }

        }
        button.addActionListener(new OKButtonListener());
    }




    private String caesarCode(String input, char offset) {
        int shift = (Character.toUpperCase(offset) - 'A') % 26;
        input = input.toUpperCase();
        String result = "";
        for (int i = 0; i < input.length(); i++) {
            char shifted = (char) ((input.charAt(i) - 'A' + shift) % 26 + 'A');
            result += shifted;
        }
        return result.toString();
    }
}
