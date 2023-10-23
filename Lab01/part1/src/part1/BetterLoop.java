package part1;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class BetterLoop {
  /**
   * Accept an applicant if they have at least 4 grades above 85. Their non-CS
   * GPA counts as a grade in this case.
   * 
   * @param scores The applicant's list of scores
   * @return true if the applicant meets the requirements
   */
  public static boolean atLeastFourOver85(int[] scores) {
    int count = 0;
    /*
     * Use a FOR-EACH loop. How would you keep count of the number of scores over 85?
     */
    for (int score: scores) {
      if (score > 85) {
        count++;
      }
    }

    return (count >= 4);
  }

  /**
   * Compute an applicant's average score in their 5 CS courses (that is, you must
   * NOT consider the final item in the array, the non-CS GPA).
   * 
   * @param scores
   * @return The average score
   */
  public static double average(int[] scores) {
    /*
     * A "normal" for-loop can sometimes be more useful than a for-each loop. How would
     * you solve this problem with a for loop?
     */
    double numerator = 0;

    for (int i = 0; i < 5; i++) {
      numerator += scores[i];
    }

    return (numerator / 5);
  }
}
