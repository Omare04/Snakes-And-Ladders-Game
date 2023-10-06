import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The class Snakes_and_ladders is the logic of the game and sets the players in
 * according order.
 * 
 * @author Omar Elmasaoudi
 * @version 1.1
 */


public class gamepage extends Snakes_and_ladders implements ActionListener {

    // create instances of the ImageIcon and set the parameters to the path of our
    // image files
    static ImageIcon boardimg = new ImageIcon("images/board.png");

    // create instances for our gui
    static JFrame frame = new JFrame();
    static JPanel panel = new JPanel();
    static JPanel panelh = new JPanel();
    static JButton button = new JButton();
    static JButton button2 = new JButton();
    static JButton button3 = new JButton();
    static JButton button4 = new JButton();
    JLabel p1starts = new JLabel();
    JLabel header = new JLabel();
    JLabel board = new JLabel();

    JLabel sameroll = new JLabel();
    JLabel p2tostring;
    JLabel p1tostring;
    JLabel label1;
    JLabel label2;

    // allows us to print both p1 & p2 tostring and only increments if both players
    // have rolled so if -
    // I wanted to print info for both players i must make sure they have attempted
    // at lease one roll
    // otherwise an exepection will be thrown as the Snake_and_ladders.getposition()
    // will be null.
    private int blnk;

    /**
     * gamepage constructor that creates the gamepage where all of the action
     * happens.
     */
    public gamepage() {

        // buttons only to determine the order of play
        button = new JButton(gettemphold1().getUsername() + " roll the dice to determine the order of play");
        button2 = new JButton(gettemphold2().getUsername() + " roll the dice to determine the order of play");

        // button3 = new JButton(gettemphold1().getUsername() + " roll the dice");
        // button4 = new JButton(gettemphold2().getUsername() + " roll the dice");

        board = new JLabel(boardimg);

        // title of our game.
        header.setText("Omar's Snakes And Ladders Game");
        // sets font and size using a new instance of the Font class from the awt
        // package.
        header.setFont(new Font("Serif", Font.CENTER_BASELINE, 50));
        // sets the visibility
        button.setVisible(true);
        button2.setVisible(false);

        // will dispose of the JFrame when the user closes the window.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame is set to visible
        frame.setVisible(true);
        // sets the size of the frame
        frame.setSize(900, 900);
        // sets the title of the JFrame
        frame.setTitle("Omars Snakes and Ladders game");
        // frame.add(panel, BorderLayout.CENTER);
        frame.setLayout(null);

        // panel.setBorder(BorderFactory.createEmptyBorder(50, 50, 20, 20));
        panel.setLayout(new GridLayout(12, 1));
        panel.setBounds(300, 400, 900, 800);
        panelh.setBounds(300, 0, 900, 800);
        // panelh.setPreferredSize(new Dimension(11,1));
        // panelt.setBounds(100, 800, 1500, 800);
        button.setSize(30, 30);
        button2.setSize(30, 30);

        frame.add(panelh);
        frame.add(panel);

        // adds the above instances to our panel.
        panelh.add(header);
        panelh.add(board);
        panelh.add(button);
        panelh.add(button2);

        // invoking the actionlistener method from the ActionListener interface, which
        // looks for wether the user has pressed either button
        // the parameter this says that its listening for any presses in this class.
        button.addActionListener(this);
        button2.addActionListener(this);

    }

    /**
     * action perfomed method from the Actionlistener interface determines who
     * starts, and once that has been decided the first player will call the play
     * method and play the game from there.
     * After so 2nd player plays and so on.
     * 
     * @param e takes in "this" as a parameter when any button is pressed,
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        // if button has been pressed execute
        if (e.getSource() == button) {

            // flips the dice
            int dice00 = gettemphold1().flipDice();
            // sets the dice of our temporary object
            gettemphold1().setdice(dice00);
            // creates the label to display necessary information
            label1 = new JLabel(gettemphold1().getUsername() + " rolled a " + gettemphold1().getdice());
            // set the font and size of the JLabel above
            label1.setFont(new Font("Serif", Font.CENTER_BASELINE, 25));
            // add the above label
            panel.add(label1);

            // changes the visibility of the button so the other player can roll their dice
            button.setVisible(false);
            button2.setVisible(true);

        }

        else if (e.getSource() == button2) {

            // flips the dice
            int dice01 = gettemphold2().flipDice();
            // sets the dice of our temporary object
            gettemphold2().setdice(dice01);
            // changes the visibility of the 2nd players button after he's rolled the dice
            button2.setVisible(false);
            // creates the label to display necessary information
            label2 = new JLabel(gettemphold2().getUsername() + " rolled a " + gettemphold2().getdice());
            // set the font and size of the JLabel above
            label2.setFont(new Font("Serif", Font.CENTER_BASELINE, 25));

            // add the label to the panel
            panel.add(label2);

            // if both players roll the same dice, they need to re roll
            if (gettemphold1().getdice() == gettemphold2().getdice()) {

                // reset the visibility of the buttons that determine the order of play
                button2.setVisible(false);
                button.setVisible(true);

                // create an instance of the JLabel class and set the text to the necessary
                // information
                sameroll = new JLabel(gettemphold1().getUsername() + " & " + gettemphold2().getUsername()
                        + " both rolled a " + gettemphold1().getdice() + " please roll again.");
                // set the font and size of the above label
                sameroll.setFont(new Font("Serif", Font.CENTER_BASELINE, 15));
                // add it to the panel
                panel.add(sameroll);

            }

            else {

                // if one player rolls a higher dice then statically call the setstartingplayer
                // method and pass through both temporary object as parameters.
                Snakes_and_ladders.setstartingplayer(gettemphold1(), gettemphold2());

                // set the text of the buttons to the necessary information
                button3 = new JButton(getstartingplayer().getUsername() + " roll the dice");
                button4 = new JButton(getsecondplayer().getUsername() + " roll the dice");

                // implement an action listener that listens for button presses in this class.
                button3.addActionListener(this);
                button4.addActionListener(this);

                // set the button visibility of for the starting player to true and the second
                // player to false
                button3.setVisible(true);
                button4.setVisible(false);

                // print out the starting players information
                p1starts = new JLabel();
                p1starts.setText(getstartingplayer().getUsername() + " starts the game");
                p1starts.setFont(new Font("Comic sans", Font.CENTER_BASELINE, 22));

                // add our instances to the panel.
                panelh.add(button3);
                panelh.add(button4);
                panel.add(p1starts);
            }

        }

        // case if the starting player presses the button, **button3 is deticated for
        // the starting player only**
        else if (e.getSource() == button3) {

            // remove all unneccessary information from our panel
            panel.remove(label2);
            panel.remove(label1);
            panel.remove(p1starts);
            panel.remove(sameroll);

            // once the starting player has pressed their button set the starting players
            // buttons visibility to false and the second players to true.
            button3.setVisible(false);
            button4.setVisible(true);

            // allow the the starting player to play the game.
            getstartingplayer().play(2);
            // invoke the equals method to see if either player is in the same cell
            getstartingplayer().equals(getsecondplayer());

            // set the text for the starting player as the toString method.
            p1tostring = new JLabel(getstartingplayer().toString());
            p1tostring.setFont(new Font("Serif", Font.CENTER_BASELINE, 25));

            // add the above JLabel to the panel
            panel.add(p1tostring);

            // if both player have rolled the dice at least once, then we can remove the
            // toString method of the second player to prevent stacking of string
            if (blnk != 0) {
                panel.remove(p2tostring);
            }

            // increment the number of attempts by 1.

            // this condiction checks whether the starting player has won or not.
            if (getstartingplayer().getstoreposition() >= 100) {

                // removes all visual instaces from our frame
                panelh.remove(button4);
                panelh.remove(button3);
                panelh.remove(header);
                panel.remove(p1tostring);
                panel.remove(p2tostring);
                panelh.remove(board);

                // sets the winner to the startingplayer
                setwinner(getstartingplayer());
                // create an intance of the JLabel and sets the text to the winners information
                JLabel label = new JLabel("Congratulations " + getwinner().getUsername() + " you just won!!!!!");
                // set an image
                // style the label
                label.setFont(new Font("Comic sans", Font.CENTER_BASELINE, 30));
                // give the player some winning visual
                // add the text & image to the panel.
                panel.add(label);

            }

        }

        // if the second player where to press their button.
        else if (e.getSource() == button4) {

            // allow the second player to player the game
            getsecondplayer().play(2);
            // invoke the equals method to see if either player is in the same cell
            getsecondplayer().equals(getstartingplayer());
            setnum_attempts(getnumber_of_attempts() + 1);
            // set the text for the starting player as the toString method.
            p2tostring = new JLabel();
            p2tostring.setFont(new Font("Serif", Font.CENTER_BASELINE, 25));
            p2tostring.setText(getsecondplayer().toString());

            // add the above text to our panel and remove the game information from the
            // first player from the panel.
            // changing the visibility would cause stacking so you need to remove and add
            // each time either player presses their button.
            panel.add(p2tostring);
            panel.remove(p1tostring);

            // change the visibility of the button for the starting player to true, and
            // false for the second player, once the second player has pressed their button.
            button3.setVisible(true);
            button4.setVisible(false);

            // and since both players have now set their positions increment the blank int
            // by 1.
            blnk++;

            // condition if the second player were to win.
            if (getsecondplayer().getstoreposition() >= 100) {

                // remove all of the visual instances from our panel
                panelh.remove(button4);
                panelh.remove(button3);
                panelh.remove(header);
                panel.remove(p1tostring);
                panel.remove(p2tostring);
                panelh.remove(board);
                // set the winner to the second player
                setwinner(getsecondplayer());
                // create a winning message for the second player
                JLabel label = new JLabel("Congratulations " + getwinner().getUsername() + " you just won!!!!!");
                // style the label
                label.setFont(new Font("Comic sans", Font.CENTER_BASELINE, 30));
                // add the winning message to our panel.
                panel.add(label);

            }

        }

    }
}
