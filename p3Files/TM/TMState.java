package TM;

import java.util.ArrayList;

/**
 *
 *
 */
public class TMState extends State {

    private final ArrayList<TMTransition> transitions;

    /**
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
     *
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
     *
     *
     * @param index
     * @return
     */
    public TMTransition getTransition(int index) {
        return transitions.get(index);
    }
}