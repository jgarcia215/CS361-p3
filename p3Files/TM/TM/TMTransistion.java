package TM;

/**
 * TMTransition represents a transition from one state to another
 * for a turing machine. Each turing transition contains
 * next_state, write_state, move. A separate class is needed
 * to encapsulate this data to assist in entirety of the TM
 *
 * @author johngarcia joshmartin
 */
public class TMTransistion {
    private String nextState;
    private String writeState;
    private char move;

    /**
     * Constructor for a turing machine transition. Contains
     * the nextState, writeState, and move which are all
     * parameters for a turing machine transition.
     *
     * @param nextState
     * @param writeState
     * @param move
     */
    public TMTransistion(String nextState, String writeState, char move) {
        this.nextState = nextState;
        this.writeState = writeState;
        this.move = move;
    }

    /**
     * Returns nextState
     *
     * @return
     */
    public String getNextState() {
        return nextState;
    }

    /**
     * Returns writeState
     *
     * @return
     */
    public String getWriteState() {
        return writeState;
    }

    /**
     * Returns move
     *
     * @return
     */
    public char move() {
        return move;
    }
}