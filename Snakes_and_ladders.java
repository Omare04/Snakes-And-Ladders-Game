/**
 * The class Snakes_and_ladders is the logic of the game and sets the players in according order. 
 * @author Omar Elmasaoudi
 *
 */


/**
 * The Snakes_and_ladders class allows the player to play the game and set their
 * respective positions, it returns crucial information and set the starting
 * players
 */
public class Snakes_and_ladders {

    private static int num_of_attempts;
    private int position;
    private int y;
    private String username;
    private int dice;
    private static Snakes_and_ladders startingplayer;
    private static Snakes_and_ladders secondplayer;
    private static Snakes_and_ladders temphold1;
    private static Snakes_and_ladders temphold2;
    private int storeposition;
    private Snakes_and_ladders winner;

    /**
     * temporary hold method that holds 2 Snakes_and_ladders objects
     * 
     * @param p1 temporary player to transfer both players into the gamepage class
     *           and set them to either starting player or second player once both
     *           players have rolled their dices.
     * @param p2 temporary player to transfer both players into the gamepage class
     *           and set them to either starting player or second player once both
     *           players have rolled their dices.
     */
    public static void settemphold(Snakes_and_ladders p1, Snakes_and_ladders p2) {
        temphold1 = p1;
        temphold2 = p2;
    }

    /**
     * 
     * @return returns the 1st player object
     */
    public Snakes_and_ladders gettemphold1() {
        return temphold1;
    }

    /**
     * 
     * @return returns the second player object
     */
    public Snakes_and_ladders gettemphold2() {
        return temphold2;
    }

    /**
     * method that determines the starting order of the game.
     * 
     * @param player1 pass through gettemphold in the gamepage class to determine
     *                the starting positions
     * @param player2 pass through gettemphold in the gamepage class to determine
     *                the starting positions
     */

    public static void setstartingplayer(Snakes_and_ladders player1, Snakes_and_ladders player2) {

        /**
         * if player1 objects dice is greater than player2 object dice set player1 as
         * the starting player.
         */
        if (player1.getdice() > player2.getdice()) {
            startingplayer = player1;
            secondplayer = player2;
            // System.out.println(startingplayer.getUsername() + " rolled a " +
            // player1.getdice() + " and " + player2.getUsername() + " rolled a " +
            // player2.getdice() + " therefore " + player1.getUsername() + " starts");
        }

        /**
         * if player2 objects dice is greater than player1 object dice set player2 as
         * the starting player.
         */
        else if (player2.getdice() > player1.getdice()) {
            startingplayer = player2;
            secondplayer = player1;
            // System.out.println(startingplayer.getUsername() + " rolled a " +
            // player2.getdice() + " and " + player1.getUsername() + " rolled a " +
            // player1.getdice() + " therefore " + player2.getUsername() + " starts");
        }

    }

    /**
     * 
     * @return returns the player that starts second
     */
    public Snakes_and_ladders getsecondplayer() {
        return secondplayer;
    }

    /**
     * 
     * @return returns the player that starts first
     */
    public Snakes_and_ladders getstartingplayer() {
        return startingplayer;
    }

    /**
     * 
     * @return returns the dice for each object
     */
    public int getdice() {
        return dice;
    }

    /**
     * 
     * @param dice takes in the dice that a player has rolled from the play method.
     */
    public void setdice(int dice) {
        this.dice = dice;
    }

    /**
     * default constructor
     */
    public Snakes_and_ladders() {
    }

    /**
     * paramatized constructor that sets each attribute to its initial value.
     * 
     * @param username takes in the username that a player has set, and sets it as
     *                 that player objects username
     */
    public Snakes_and_ladders(String username) {
        this.username = username;
        num_of_attempts = 1;
        position = 0;
        this.y = 1;

    }

    /**
     * method that returns the value of a dice as an int
     * 
     * @return returns the value of the dice as an int range: 1-6
     */
    public int flipDice() {

        int flip = (int) Math.ceil((Math.random() * 6)); // make it so that you cannot roll a 1
        return flip;

    }

    /**
     * method that sets the winner of the game
     * 
     * @param winner sets the player that has won the game.
     */
    public void setwinner(Snakes_and_ladders winner) {
        this.winner = winner;
    }

    /**
     * method that returns the winner of the game
     * 
     * @return returns the winner of the game
     */
    public Snakes_and_ladders getwinner() {
        return winner;
    }

    /**
     * play method that flips the dice, sets the storedposition, sets the y
     * position, sets the position, drops a player down if hit a snakes head, and
     * raises a player if they reach the bottom of a ladder
     * 
     * @param numplayerspass takes in the number of players from the driver class
     */
    public void play(int numplayerspass) {

        // more optimized version of the game
        // public void play(int numPlayersPass) {
        // dice = flipDice();
        // setDice(dice);
        // setStorePosition(dice);
        // setPosition(getPosition() + dice);

        // if (getPosition() > 10 && getY() > 0) {
        // setPosition(getStorePosition() - getY() * 10);
        // setY(getY() + 1);
        // } else if (getPosition() > 10 && getY() == 1) {
        // setPosition(getStorePosition() - getY() + 1 * 10);
        // setY(getY() + 1);
        // }

        // int[][] snakesAndLadders = {
        // {1, 8, 4, 37},
        // {4, 4, 2, 10},
        // {9, 1, 4, 22},
        // {16, 6, 1, -6},
        // {21, 2, 5, 21},
        // {28, 4, 9, 56},
        // {36, 4, 5, 8},
        // {48, 0, 3, -18},
        // {51, 7, 7, 16},
        // {62, 9, 2, -43},
        // {64, 0, 7, -4},
        // {71, 1, 10, 20},
        // {80, 10, 10, 20},
        // {93, 8, 7, -25},
        // {95, 4, 3, -71},
        // {97, 6, 8, 21},
        // {98, 8, 8, 78}
        // };

        // for (int[] entry : snakesAndLadders) {
        // if (getStorePosition() == entry[0]) {
        // setPosition(entry[1]);
        // setY(entry[2]);
        // setStorePosition(entry[3]);
        // break;
        // }
        // }
        // }

        dice = this.flipDice();

        this.setdice(dice);
        this.setstoreposition(dice);
        this.setposition(this.getposition() + dice);

        if (this.getposition() > 10 && this.gety() > 0) {
            this.setposition(this.getstoreposition() - this.gety() * 10);
            this.sety(gety() + 1);
        }

        else if (this.getposition() > 10 && this.gety() == 1) {
            this.setposition(this.getstoreposition() - this.gety() + 1 * 10);
            this.sety(gety() + 1);
        }

        // if(this.getstoreposition() >= 100 ){
        // this.setwinner(this);
        // }

        // rather than adding a static number you must set the storeposition to how many
        // more positions hes made ex: if at p1, set store position needs to be 38 - 1
        // only for ladders
        // make them more accurate to the board if at 31 y=3 ok.

        if (this.getstoreposition() == 1) {
            this.setposition(8);
            this.sety(4);
            this.setstoreposition(37);
        }
        if (this.getstoreposition() == 4) {
            this.setposition(4);
            this.sety(2);
            this.setstoreposition(10);
        }
        if (this.getstoreposition() == 9) {
            this.setposition(1);
            this.sety(4);
            this.setstoreposition(22);
        }
        if (this.getstoreposition() == 16) {
            this.setposition(6);
            this.sety(1);
            this.setstoreposition(-6);
        }
        if (this.getstoreposition() == 21) {
            this.setposition(2);
            this.sety(5);
            this.setstoreposition(21);
        }
        if (this.getstoreposition() == 28) {
            this.setposition(4);
            this.sety(9);
            this.setstoreposition(56);
        }
        if (this.getstoreposition() == 36) {
            this.setposition(4);
            this.sety(5);
            this.setstoreposition(8);
        }
        if (this.getstoreposition() == 48) {
            this.setposition(0);
            this.sety(3);
            this.setstoreposition(-18);
        }
        if (this.getstoreposition() == 51) {
            this.setposition(7);
            this.sety(7);
            this.setstoreposition(16);
        }
        if (this.getstoreposition() == 62) {
            this.setposition(9);
            this.sety(2);
            this.setstoreposition(-43);
        }
        if (this.getstoreposition() == 64) {
            this.setposition(0);
            this.sety(7);
            this.setstoreposition(-4);
        }
        if (this.getstoreposition() == 71) {
            this.setposition(1);
            this.sety(10);
            this.setstoreposition(20);
        }
        if (this.getstoreposition() == 80) {
            this.setposition(10);
            this.sety(10);
            this.setstoreposition(20);
        }
        if (this.getstoreposition() == 93) {
            this.setposition(8);
            this.sety(7);
            this.setstoreposition(-25);
        }
        if (this.getstoreposition() == 95) {
            this.setposition(4);
            this.sety(3);
            this.setstoreposition(-71);
        }
        if (this.getstoreposition() == 97) {
            this.setposition(6);
            this.sety(8);
            this.setstoreposition(21);
        }
        if (this.getstoreposition() == 98) {
            this.setposition(8);
            this.sety(8);
            this.setstoreposition(78);
        }

    }

    /**
     * equals method that compares the position of both player objects and if one is
     * equal to the others, than the person that came into that cell last will be
     * booted down to cell 0,1
     * 
     * @param player
     */
    public void equals(Snakes_and_ladders player) {

        if (this.position == player.getposition() && this.gety() == player.gety()) {
            player.setposition(0);
            player.sety(1);
        }
    }

    /**
     * @return return the players username, position, y position, the dice he
     *         rolled, the storedposition, and the number of attempts between all
     *         players.
     */
    public String toString() {
        return getUsername() + "'s position: " + getposition() + " ,y position " + gety() + " you rolled a " + getdice()
                + " and your stored position is: " + getstoreposition();
    }

    /**
     * 
     * @return returns the players position
     */
    public int getposition() {
        return position;
    }

    /**
     * 
     * @return returns the number of attempts between all players
     */
    public int getnumber_of_attempts() {
        return num_of_attempts;
    }

    /**
     * method that sets the number of attempts between both players.
     * 
     * @param attempts sets the number of attempts everytime a player has pressed
     *                 their repective button to roll the dice.
     */
    public void setnum_attempts(int attempts) {
        num_of_attempts = attempts;
    }

    /**
     * 
     * @param username
     */

    /**
     * method that returns the username for each player.
     * 
     * @return returns the players username
     */
    public String getUsername() {
        return username;
    }

    /**
     * a method that returns the y position for each player
     * 
     * @return returns the y position for each player
     */
    public int gety() {
        return y;
    }

    /**
     * a method that returns the y position for any given player
     * 
     * @param y returns the y position for any given player
     */
    public void sety(int y) {
        this.y = y;
    }

    /**
     * method that sets the players position
     * 
     * @param position sets the players position
     */
    public void setposition(int position) {
        this.position = position;
    }

    /**
     * a method that sets the stored position of the player
     * 
     * @param storeposition sets the stored position of the player
     */
    public void setstoreposition(int storeposition) {
        this.storeposition += storeposition;
    }

    /**
     * a method that returns the stored position of each player
     * 
     * @return returns the stored position of each player
     */
    public int getstoreposition() {
        return storeposition;
    }

}
