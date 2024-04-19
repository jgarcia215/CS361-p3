package TM;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class TMSimulator {

    private static int numStates;
    private static int alphabet;

    public static void main(String[] args) {
        try {
            if (args.length != 1) {
                System.out.println("Usage: java TMSimulator.java <inputFilePath>");
                System.exit(1);
            }

            String file = args[0];
            simulate(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Driver for TM.
     *
     * @param file
     * @throws IOException
     */
    public static void simulate(String file) throws IOException {
        BufferedReader br;

        try {
            br = new BufferedReader(new FileReader(file));      //Initializes a new buffered reader
            String line = br.readLine();

            //Parse through values at the beginning of input file.
            numStates = Integer.parseInt(line);
            line = br.readLine();
            alphabet = Integer.parseInt(line);

            TM tm = new TM(numStates, alphabet);        //Initialize new turing machine

            for (int i = 0; i < numStates - 1; i++) {
                for (int j = 0; j <= alphabet; j++) {
                    tm.addStateTransition(i, j, br.readLine());
                }
            }

            tm.initializeTape(br.readLine());
            tm.simulate();

            //Prints the output to the console.
            int sum = 0;
            StringBuilder output = new StringBuilder();

            for (int i = 0; i < tm.getTapeSize(); i++) {
                output.append(tm.getTapeAtIndex(i));
                sum += Integer.parseInt(tm.getTapeAtIndex(i).toString());
            }

            System.out.println("output: " + output);
            System.out.println("output length: " + tm.getTapeSize());
            System.out.println("sum of symbols: " + sum);

            br.close();     //Closes buffered reader
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}