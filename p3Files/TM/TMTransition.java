package TM;

/**
 * TMTransition represents a transition from one state to another
 * for a turing machine. Each turing transition contains
 * next_state, write_state, move.
 *
 * @author johngarcia joshmiller
 */
public class TMTransition {
    private int nextState;
    private int writeState;
    private Character move;

    /**
     * Constructor for a turing machine transition. Contains
     * the nextState, writeState, and move which are all
     * parameters for a turing machine transition.
     *
     * @param nextState
     * @param writeState
     * @param move
     */
    public TMTransition(int nextState, int writeState, Character move) {
        this.nextState = nextState;
        this.writeState = writeState;
        this.move = move;
    }

    /**
     * Returns nextState
     *
     * @return nextState
     */
    public int getNextState() {
        return nextState;
    }

    /**
     * Returns writeState
     *
     * @return writeState
     */
    public int getWriteState() {
        return writeState;
    }

    /**
     * Returns move
     *
     * @return move direction
     */
    public Character getMove() {
        return move;
    }
}