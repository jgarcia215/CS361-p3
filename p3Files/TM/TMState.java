package TM;

import java.util.ArrayList;

/**
 * Represents a turing machine state. Is able to add
 * transitions.
 *
 * @author jackgarcia joshmiller
 */
public class TMState extends State {

    private final ArrayList<TMTransition> transitions;

    /**
     * Constructor for TMState
     *
     * @param length
     */
    public TMState(int length) {
        this.transitions = new ArrayList<>();

        for (int i = 0; i <= length; i++) {
            transitions.add(null);          //Populate array with null values
        }
    }

    /**
     * Creates a new TMTransition and adds it to
     * our ArrayList which tracks the transitions for
     * each TMState.
     *
     * @param currentState
     * @param nextState
     * @param writeState
     * @param move
     */
    public void addTransition(int currentState, int nextState, int writeState, Character move) {
        transitions.set(currentState, new TMTransition(nextState, writeState, move));
    }

    /**
     * Returns the transition at the specified
     * index.
     *
     * @param index
     * @return
     */
    public TMTransition getTransition(int index) {
        return transitions.get(index);
    }
}