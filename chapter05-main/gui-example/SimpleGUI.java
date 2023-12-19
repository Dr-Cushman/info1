import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.function.*;
/**
 * A very simple example for a GUI.
 * Lambdas are an elegant way to attach
 * functionality to a button as shown here.
 *
 * @author Barne Kleinen
 * @version 0.2
 */
public class SimpleGUI
{

    public SimpleGUI()
    {
        createFrame();
    }

    private void createFrame(){  
        JFrame frame = new JFrame();

        JPanel panel = (JPanel)frame.getContentPane();
        panel.setLayout(new FlowLayout());

        JTextField input = new JTextField(20);
        panel.add(input);

        JLabel output = new JLabel("output");

        JButton button;

        button= new JButton("upperCase");
        button.addActionListener(
            (ActionEvent e) -> output.setText(input.getText().toUpperCase())
        );
        panel.add(button);

        // The lambda can also be stored in a Variable.
        // It has to be of type ActionListener because that's
        // what the addActionListener method expects.

        ActionListener countLambda = (ActionEvent e) -> 
                output.setText(String.valueOf(input.getText().length()));

        button = new JButton("count");
        button.addActionListener(countLambda);
        panel.add(button);

        // add everything, pack and show

        panel.add(output);
        frame.pack();
        frame.setVisible(true);
    }
}
