import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * The class Snakes_and_ladders is the logic of the game and sets the players in according order. 
 * @author Omar Elmasaoudi
 *
 */

/**
 * The startingpage class inherits the Snakes_and_ladders class and implements
 * the ActionListener Interface
 * It sets the username for both player 1 and player 2, and creates an instance
 * of the gamepage class once both -
 * players have set their respective names.
 */
public class startingpage extends Snakes_and_ladders implements ActionListener {

    // button
    private JButton button;

    // labels for player entries & title
    private JLabel player01;
    private JLabel player02;
    private JLabel title;

    private JTextField username1;
    private JTextField username2;

    static JFrame frame = new JFrame();
    static JPanel panel = new JPanel();

    /**
     * Starting page that allows both players to set their usernames through given
     * textboxes and press enter when finished, which open the gamepage class.
     */
    public startingpage() {

        // This is the title of the game
        title = new JLabel("Snakes And Ladders");
        title.setFont(new Font("Serif", Font.CENTER_BASELINE, 30));

        title = new JLabel("Please enter your usernames to start the game");
        title.setFont(new Font("Serif", Font.CENTER_BASELINE, 30));

        // title of the player 1 textfield
        player01 = new JLabel("Player 1:");
        player01.setBounds(10, 20, 80, 25);

        // Actual textfield for player 1
        username1 = new JTextField(10);
        username1.setBounds(100, 20, 165, 25);

        // title of the player 1 textfield
        player02 = new JLabel("Player 2:");
        player02.setBounds(10, 20, 80, 25);

        // Actual textfield for player 2
        username2 = new JTextField(10);
        username2.setBounds(100, 20, 165, 25);

        // our enter button
        button = new JButton("enter");
        button.setBounds(10, 80, 80, 25);
        button.addActionListener(this);

        // will dispose of the JFrame when the user closes the window.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame is set to visible
        frame.setVisible(true);
        // sets the size of the frame
        frame.setSize(500, 500);
        // sets the title of the JFrame
        frame.setTitle("Omars Snakes and Ladders game");
        frame.add(panel, BorderLayout.CENTER);

        // everything within the curly brackets is just adding all of the above elements
        // to the panel.
        {
            panel.add(title);
            panel.add(player01);
            panel.add(username1);
            panel.add(player02);
            panel.add(username2);
            panel.add(button);
        }

        // set the border of the panel, to 50 pixes from the y-axis (top), 50 from the
        // x-axis (left), 20 from the y-axis(bottom), and 20 from the x-axis(right)
        panel.setBorder(BorderFactory.createEmptyBorder(50, 50, 20, 20));
        // sets our layout
        panel.setLayout(new GridLayout(12, 1));

    }

    /**
     * this method creates 2 instances of the Snakes_and_ladders class and sets the
     * usernames for both players through its parameters, where it is then passed
     * through the settemphold method in the Snakes_and_ladders class.
     * From there, it dispose of the startingpage from, and creates a new instance
     * of the gamepage class which starts the game.
     * 
     * @param e takes in a parameter of type Action event, which can be any instance
     *          of a class, in this case it's "this"
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        // if the user presses the button
        if (e.getSource() == button) {

            // dispose of the JFrame in this class.
            frame.dispose();

            // creates 2 player objects of type Snakes_and_ladders and sets their usersname
            Snakes_and_ladders player1 = new Snakes_and_ladders(username1.getText());
            Snakes_and_ladders player2 = new Snakes_and_ladders(username2.getText());

            // passes through both player1 and 2, through the settemphold method in the
            // Snakes_and_ladders class.
            settemphold(player1, player2);

            // creates a new instance of the gamepage class
            new gamepage();

        }

    }

}
