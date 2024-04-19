package TM;

import java.util.ArrayList;

/**
 *
 *
 */
public class TM {

    private final ArrayList<Integer> tape;
    private final ArrayList<TMState> currentStates;
    private final int numStates;
    private int currIndex;
    private int tapeIndex;

    public TM(int numStates, int alphabet) {
        this.numStates = numStates;
        tape = new ArrayList<>();
        currentStates = new ArrayList<>(numStates);

        for (int i = 0; i < numStates; i++) {
            currentStates.add(new TMState(numStates));       //Populates array with our alphabet
        }
    }

    /**
     * Returns the size of our tape.
     *
     * @return tape size
     */
    public int getTapeSize() {
        return tape.size();
    }

    /**
     * Returns the specific index in the tape.
     *
     * @param index
     * @return tape at index
     */
    public Integer getTapeAtIndex(int index) {
        return tape.get(index);
    }

    /**
     * Adds a transition to the tape.
     *
     * @param fromState
     * @param currState
     * @param inputStr
     */
    public void addStateTransition(int fromState, int currState, String inputStr) {
        int to = Character.getNumericValue(inputStr.charAt(0));
        int from = Character.getNumericValue(inputStr.charAt(2));       //Hard coded to read from file
        Character move = inputStr.charAt(4);
        currentStates.get(fromState).addTransition(currState, to, from, move);
    }

    /**
     *
     *
     * @param line - line to be read from file input
     */
    public void initializeTape(String line) {
        int charValue = 0;

        if (line != null && !line.isEmpty()) {
            for (int i = 0; i < line.length(); i++) {
                charValue = Character.getNumericValue(line.charAt(i));  //Converts each character to an integer and then adds it to our tape.
                tape.add(charValue);
            }
        }
    }

    /**
     * Simulates the Turing Machine.
     */
    public void simulate() {
        boolean isDone = false;

        // Ensure there's at least one element on the tape
        if (tape.isEmpty()) {
            tape.add(0);
        }

        // Run the simulation until it's marked as finished or reaches the end state
        while (!isDone && currIndex >= 0) {
            executeCurrentTransition();

            // Check for the termination condition
            if (currIndex == numStates - 1) {
                isDone = true;
            }
        }
    }

    /**
     * Executes the transition based on the current state and the symbol under the tape head.
     */
    private void executeCurrentTransition() {
        int inputSymbol = tape.get(tapeIndex); //Retrieve the current input symbol from the tape
        TMTransition transition = currentStates.get(currIndex).getTransition(inputSymbol);   //Fetch the transition details based on the current state and input symbol

        tape.set(tapeIndex, transition.getWriteState());    //Apply the transition: write value, move tape head, and update state
        currIndex = transition.getNextState();
        adjustTapeHeadPosition(transition.getMove());
    }

    /**
     *
     *
     * @param direction
     */
    private void adjustTapeHeadPosition(char direction) {
        if (direction == 'L') {
            tapeIndex--;        //Moves tape to the left
            if (tapeIndex < 0) {
                tape.add(0, 0);
                tapeIndex = 0;
            }
        } else if (direction == 'R') {
            tapeIndex++; //Moves tape to the right
            if (tapeIndex >= tape.size()) {
                tape.add(0);
            }
        }
    }
}