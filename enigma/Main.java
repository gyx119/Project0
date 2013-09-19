// This is a SUGGESTED skeleton file.  Throw it away if you want.
package enigma;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/** Enigma simulator.
 *  @author
 */
public final class Main {

    // WARNING: Not all methods that have code in them are complete!

    /** Process a sequence of encryptions and decryptions, as
     *  specified in the input from the standard input.  Print the
     *  results on the standard output. Exits normally if there are
     *  no errors in the input; otherwise with code 1. */
    public static void main(String[] unused) {
        Machine M;
        BufferedReader input =
            new BufferedReader(new InputStreamReader(System.in));

        buildRotors();

        M = null;

        try {
            while (true) {
                String line = input.readLine();
                if (line == null) {
                    break;
                }
                if (isConfigurationLine(line)) {
                    M = new Machine();
                    configure(M, line);
                } else {
                    printMessageLine(M.convert(standardize(line)));
                }
            }
        } catch (IOException excp) {
            System.err.printf("Input error: %s%n", excp.getMessage());
            System.exit(1);
        }
    }

    /** Return true iff LINE is an Enigma configuration line. */
    private static boolean isConfigurationLine(String line) {
    char[] line1 = line.toCharArray();
	    int tracker = 0;
	    	while (tracker < line1.length) {
	    		if (Character.isUpperCase(line1[tracker])) {
	    			tracker++;
	    		}
	    		return false;
	    	}
	    return true;
    }

    /** Configure M according to the specification given on CONFIG,
     *  which must have the format specified in the assignment. */
    private static void configure(Machine M, String config) {
        // FIXME
    }

    /** Return the result of converting LINE to all upper case,
     *  removing all blanks and tabs.  It is an error if LINE contains
     *  characters other than letters and blanks. */
    private static String standardize(String line) {
        if (line.contains("^[A-z]")) {
            throw new IllegalArgumentException("Contains non-allowed characters");
    	}
        String noblank = line.replaceAll("\\s", "");
        String upper = noblank.toUpperCase();
        return upper; 
        }
    }

    /** Print MSG in groups of five (except that the last group may
     *  have fewer letters). */
    private static void printMessageLine(String msg) {
    	String msgFinal = "";
    	int index = 0;
    	while (index < msg.length()) {
    		msgFinal += msg.substring(index, index + 1);
    		if ((index + 1) % 5 == 0) {
    			msgFinal += " ";
    		}
    		index += 1;
    	}
    	System.out.println(msgFinal);
    }

    /** Create all the necessary rotors. */
    private static void buildRotors() {
        // FIXME
    }

}

