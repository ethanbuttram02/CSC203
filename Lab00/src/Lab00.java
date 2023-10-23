/* this part is as comment similar to comments in Python
CPE/CSC 203 Lab00
Name: Ethan Buttram

Section: 15

*/
public class Lab00 {
    public static void main(String[] arguments) {

        // declaring and initializing some variables

        byte x = 12;

        String y = "WELCOME to CSC/CPE203";

        float z = 3.1415f;

        // printing the variables

        System.out.println("x: " + x + " y: " + y + " z: " + z);

        // a list (make an array in java)

        byte[] nums = new byte[]{5, 16, -8, 2, 11};

        for (int i: nums) {
            System.out.println(i);
        }

        // call a function

        int numFound = count(y, 'C');

        System.out.println("Number of C in " + y);

        System.out.println("Found: " + numFound);

        // a counting for loop

        for (int i = 1; i < 15; i++) {
            System.out.print(i + " ");
        }
    }

    // function counts the given character in the given string
    // str str -> int
    static int count(String S, char C) {
        byte count = 0;
        char[] characters = S.toCharArray();

        for (char letter: characters) {
            if (letter == C) {
                count++;
            }
        }

        return count;
    }
}


