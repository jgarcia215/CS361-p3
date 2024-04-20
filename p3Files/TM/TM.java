package TM;

import java.util.ArrayList;

/**
 * Represents a turing machine. Contains a tape which
 * has the ability to move left and right and is also
 * capable off adding transitions.
 *
 * @author jackgarcia joshmiller
 */
public class TM {

    private final ArrayList<Integer> tape;
    private final ArrayList<TMState> currentStates;
    private final int numStates;
    private int currIndex;
    private int tapeIndex;

    /**
     * Constructor for TM
     *
     * @param numStates
     * @param alphabet
     */
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
     * Initializes the tape when reading from the file. Converts
     * each char to an integer and adds it to the tape.
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
     *
     */
    public void simulate() {
        boolean isDone = false;
        int inputSymbol = 0;

        //Ensure there's at least one element on the tape
        if (tape.isEmpty()) {
            tape.add(0);
        }

        //Run the simulation until it's done
        while (!isDone && currIndex >= 0) {

            //Executes the transition based on the current state and the symbol under the tape head.
            inputSymbol = tape.get(tapeIndex);      //Retrieve the current input symbol from the tape
            TMTransition transition = currentStates.get(currIndex).getTransition(inputSymbol);      //Fetch the transition details based on the current state and input symbol

            tape.set(tapeIndex, transition.getWriteState());        //Set the transition
            currIndex = transition.getNextState();
            adjustTapeHeadPosition(transition.getMove());

            //Check for the tape is done
            if (currIndex == numStates - 1) {
                isDone = true;
            }
        }
    }

    /**
     *  Adjust the head position of the tape to either the left or right.
     *
     * @param direction
     */
    private void adjustTapeHeadPosition(char direction) {
        if (direction == 'L') {
            tapeIndex--;        //Moves tape to the left
            if (tapeIndex < 0) {
                tape.add(0, 0);     //Adds default value when tape goes too far left
                tapeIndex = 0;
            }
        } else if (direction == 'R') {
            tapeIndex++; //Moves tape to the right
            if (tapeIndex >= tape.size()) {
                tape.add(0);    //Adds default value when tape goes too far right
            }
        }
    }
}