import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.JTextField;
import java.awt.Font;
/**
 * The class Snakes_and_ladders is the logic of the game and sets the players in according order. 
 * @author Omar Elmasaoudi
 *
 */


/**
 * The driver class is used to determine how many players are going to play the
 * game, and creates a new instance of the startingpage class if the condition
 * has been met once the button has been pressed.
 * If the condition isnt met, the program prints a message and no further action
 * can be taken by the user
 */
public class driver implements ActionListener {

        // declare all necessary visual instances.
        static JLabel title = new JLabel();
        static JFrame frame = new JFrame();
        static JPanel panel = new JPanel();
        static JTextField text = new JTextField();
        static JButton button = new JButton();

        /**
         * main method that is created to run the entire program once the user loads the
         * game up.
         * 
         * @param args main method
         */
        public static void main(String[] args) {

                // JLabel that promts the user to enter the nums of players
                title = new JLabel("Please enter the number of players that are going to play, and press enter:");
                // new instance of a textfield
                text = new JTextField();

                // button for enter
                button = new JButton("enter");
                button.setVisible(true);

                // will dispose of the JFrame when the user closes the window.
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                // frame is set to visible
                frame.setVisible(true);
                // sets the size of the frame
                frame.setSize(500, 500);
                // sets the title of the JFrame
                frame.setTitle("Omars Snakes and Ladders game");
                frame.add(panel, BorderLayout.CENTER);

                panel.setBorder(BorderFactory.createEmptyBorder(50, 50, 20, 20));
                panel.setLayout(new GridLayout(12, 1));

                // adds all necessary instances of our GUI
                panel.add(title);
                panel.add(text);
                panel.add(button);

                // actionlistener method that checks if the user has pressed our button object.
                button.addActionListener(new driver());

        }

        /**
         * @param e takes in a paramater of a class which is a new object of the driver
         *          class and if our textfield is > 2 than print a error message other
         *          wise create a new instance of the startingpage class and start the
         *          game
         */
        @Override
        public void actionPerformed(ActionEvent e) {

                // if we press our button and the textfield equals 2 create a new startingpage
                // object
                if (e.getSource() == button && text.getText().equals("2")) {

                        frame.dispose();
                        new startingpage();
                }

                // if we press our button and the textfield equals 0 or 1 create a new
                // startingpage object
                else if (e.getSource() == button && text.getText().equals("1") || text.getText().equals("0")) {

                        frame.dispose();
                        new startingpage();

                }

                // if none of the above conditions are met print an error message and remove all
                // visual instances from our panel.
                else {
                        JLabel exit = new JLabel(
                                        "You need to have 2 players to play, exit from the window, find a friendand and comeback. bye bye :(");
                        exit.setFont(new Font("Serif", Font.CENTER_BASELINE, 24));
                        panel.add(exit);
                        // remove our textfield to disallow any reentries
                        panel.remove(text);
                        panel.remove(title);
                        // disallow any reentries
                        button.setVisible(false);

                }
        }

}
