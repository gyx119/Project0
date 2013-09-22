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

    /** Return true iff string s is all uppercase letters. */
    public static boolean isUpperCase(String s) {
    	for (int i = 0;i < s.length();i++) {
    		if (Character.isLowerCase(s.charAt(i))) {
    			return false;
    		}
    	}
    	return true;
    }

    /** Return true iff LINE is an Enigma configuration line. */
    private static boolean isConfigurationLine(String line) {
    	String[] parts = line.split(" ");
    	int tracker = 7;
    	if (parts[0] != "*") {
    		return false;
    	}
    	if (parts[1] != "B" && parts[1] != "C") {
    		return false;
    	}
    	if (parts[2] != "BETA" && parts[2] != "GAMMA") {
    		return false;
    	}
    	if (parts[3] != "I" || parts[3] != "II" || parts[3] !="III" 
    			|| parts[3] != "IV" || parts[3] != "V" || parts[3] != "VI" 
    			|| parts[3] != "VII" || parts[3] != "VIII") {
    		return false;
    	}
    	if (parts[4] != "I" || parts[4] != "II" || parts[4] !="III" 
    			|| parts[4] != "IV" || parts[4] != "V" || parts[4] != "VI" 
    			|| parts[4] != "VII" || parts[4] != "VIII" 
    			|| parts[4] == parts[3] ) {
    		return false;
    	}
    	if (parts[5] != "I" || parts[5] != "II" || parts[5] !="III" 
    			|| parts[5] != "IV" || parts[5] != "V" || parts[5] != "VI" 
    			|| parts[5] != "VII" || parts[5] != "VIII" 
    			|| parts[5] == parts[3] || parts[5] == parts[4]) {
    		return false;
    	}
	    while (tracker < parts.length) {
	   		if (isUpperCase(parts[tracker])) {
	   			tracker++;
	   		} else {
	   			return false;
    		}
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
     	String noblank = line.replaceAll("\\s", "");
     	Pattern pattern = Pattern.compile("[^A-Za-z]");
		Matcher m = pattern.matcher(line);
		boolean t = m.find(0);
    	if (t){
    		throw new IllegalArgumentException("Contains non-allowed characters");
    	}
    	String upper = noblank.toUpperCase();
        return upper; 
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

