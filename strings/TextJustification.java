
/*
 * TEXT JUSTIFICATION - 68
 *
 * Given an array of strings words and an integer maxWidth,
 * format the text such that each line contains exactly
 * maxWidth characters and is fully (left and right) justified.
 *
 * Rules:
 *
 * 1. Pack as many words as possible in each line (Greedy).
 * 2. Distribute extra spaces between words as evenly as possible.
 * 3. If spaces cannot be distributed equally, left gaps
 *    should receive more spaces than right gaps.
 * 4. The last line should be left-justified.
 * 5. No extra spaces should be inserted between words
 *    in the last line.
 *
 * Example:
 *
 * words = {"This", "is", "an", "example", "of", "text",
 *          "justification."}
 *
 * maxWidth = 16
 *
 * Output:
 *
 * [
 *   "This    is    an",
 *   "example  of text",
 *   "justification.  "
 * ]
 *
 *
 * APPROACHES:
 *
 * 1. Brute Force Approach
 *    Time Complexity: O(n * maxWidth)
 *    Space Complexity: O(maxWidth) auxiliary
 *
 * 2. Greedy + String Manipulation - OPTIMIZED APPROACH
 *    Time Complexity: O(n * maxWidth)
 *    Space Complexity: O(maxWidth) auxiliary
 */

package strings;

import java.util.List;
import java.util.ArrayList;


public class TextJustification {


    // ============================================================
    // APPROACH 1: BRUTE FORCE
    //
    // 1. Greedily select maximum words for each line.
    // 2. Initially assign one space to every gap.
    // 3. Distribute remaining spaces one by one from left to right.
    // 4. Last line is left-justified.
    //
    // Time: O(n * maxWidth)
    // Space: O(maxWidth) auxiliary
    // ============================================================

    public ArrayList<String> justifyBruteForce(String[] words, int maxWidth) {

        int n = words.length;
        int i = 0;

        ArrayList<String> result = new ArrayList<>();

        while (i < n) {

            List<String> line = new ArrayList<>();
            int letters = 0;

            // Step 1: Greedily select maximum words for current line
            while (i < n &&
                   letters + words[i].length() + line.size() <= maxWidth) {

                line.add(words[i]);
                letters += words[i].length();
                i++;
            }

            int gaps = line.size() - 1;
            int spaces = maxWidth - letters;

            StringBuilder sb = new StringBuilder();

            // Step 2: Last line or single-word line
            if (i == n || gaps == 0) {

                for (int j = 0; j < line.size(); j++) {

                    sb.append(line.get(j));

                    // Add only one space between words
                    if (j < gaps) {
                        sb.append(" ");
                    }
                }

                // Left-justify by adding spaces at the end
                while (sb.length() < maxWidth) {
                    sb.append(" ");
                }

            } else {

                // Step 3: Store spaces for every gap
                int[] spaceCount = new int[gaps];

                // Initially assign one space to every gap
                for (int j = 0; j < gaps; j++) {
                    spaceCount[j] = 1;
                    spaces--;
                }

                // Distribute remaining spaces from left to right
                while (spaces > 0) {

                    for (int j = 0; j < gaps && spaces > 0; j++) {

                        spaceCount[j]++;
                        spaces--;
                    }
                }

                // Step 4: Build the fully justified line
                for (int j = 0; j < line.size(); j++) {

                    sb.append(line.get(j));

                    if (j < gaps) {

                        // Append calculated spaces for current gap
                        for (int k = 0; k < spaceCount[j]; k++) {
                            sb.append(" ");
                        }
                    }
                }
            }

            // Store completed line
            result.add(sb.toString());
        }

        return result;
    }



    // ============================================================
    // APPROACH 2: GREEDY + STRING MANIPULATION
    //              - OPTIMIZED APPROACH
    //
    // 1. Greedily select maximum words for each line.
    // 2. Calculate minimum spaces per gap using division.
    // 3. Distribute remaining spaces using modulo.
    // 4. Leftmost gaps receive extra spaces.
    // 5. Last line is left-justified.
    //
    // Time: O(n * maxWidth)
    // Space: O(maxWidth) auxiliary
    // ============================================================

    public ArrayList<String> justifyOptimized(String[] words, int maxWidth) {

        int n = words.length;
        int i = 0;

        ArrayList<String> result = new ArrayList<>();

        while (i < n) {

            List<String> line = new ArrayList<>();
            int letters = 0;

            // Step 1: Greedily select maximum words for current line
            while (i < n &&
                   letters + words[i].length() + line.size() <= maxWidth) {

                line.add(words[i]);
                letters += words[i].length();
                i++;
            }

            // Number of gaps between words
            int gaps = line.size() - 1;

            // Total spaces available after accounting for letters
            int spaces = maxWidth - letters;

            StringBuilder sb = new StringBuilder();

            // Step 2: Last line or single-word line
            if (i == n || gaps == 0) {

                for (int j = 0; j < line.size(); j++) {

                    sb.append(line.get(j));

                    // Last line gets only one space between words
                    if (j < gaps) {
                        sb.append(" ");
                    }
                }

                // Add remaining spaces at the end
                while (sb.length() < maxWidth) {
                    sb.append(" ");
                }

            } else {

                // Step 3: Calculate equal space distribution

                // Minimum spaces assigned to every gap
                int spacesPerGap = spaces / gaps;

                // Extra spaces remaining after equal distribution
                int extraSpaces = spaces % gaps;

                // Step 4: Build the fully justified line
                for (int j = 0; j < line.size(); j++) {

                    sb.append(line.get(j));

                    if (j < gaps) {

                        // Every gap gets minimum spaces
                        int count = spacesPerGap;

                        // Leftmost gaps get one additional space
                        if (j < extraSpaces) {
                            count++;
                        }

                        // Append calculated spaces
                        for (int k = 0; k < count; k++) {
                            sb.append(" ");
                        }
                    }
                }
            }

            // Store completed line
            result.add(sb.toString());
        }

        return result;
    }



    // ============================================================
    // MAIN METHOD
    // ============================================================

    public static void main(String[] args) {

        String[] words = {
            "This", "is", "an", "example",
            "of", "text", "justification."
        };

        int maxWidth = 16;

        TextJustification obj = new TextJustification();

        // Brute Force Approach
        System.out.println(
            "Brute Force Approach\n" +
            "Time: O(n * maxWidth)\n" +
            "Space: O(maxWidth)\n" +
            obj.justifyBruteForce(words, maxWidth)
        );


        // Optimized Approach
        System.out.println(
            "\nOptimized Approach\n" +
            "Time: O(n * maxWidth)\n" +
            "Space: O(maxWidth)\n" +
            obj.justifyOptimized(words, maxWidth)
        );
    }
}
