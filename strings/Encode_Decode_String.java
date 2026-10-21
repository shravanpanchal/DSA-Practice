
/*
 * LeetCode Problem: 271 - Encode and Decode Strings
 *
 * Problem:
 * Design an algorithm to encode a list of strings into a single
 * string and decode that string back into the original list.
 *
 * Note:
 * This delimiter-based implementation works only when the input
 * strings do not contain '#' and do not include problematic empty
 * strings. For a fully reliable solution, use length-prefix encoding.
 */

package strings;

import java.util.Arrays;

public class Encode_Decode_String {

    // Encodes an array of strings into a single string.
    public static String enCode(String[] list) {

        String result = "";

        // Append each string followed by the delimiter '#'.
        for (int i = 0; i < list.length; i++) {
            result = result.concat(list[i]);
            result = result.concat("#");
        }

        return result;
    }

    // Decodes the encoded string back into an array of strings.
    public static String[] deCode(String cipher) {

        // Split the string wherever the delimiter '#' appears.
        return cipher.split("#");
    }

    // Main method to test encoding and decoding.
    public static void main(String[] args) {

        // Original array of strings.
        String[] input = {"hello", "world", "java"};

        // Encode the array into a single string.
        String encoded = enCode(input);
        System.out.println("Original Array: " + Arrays.toString(input));
        System.out.println("Encoded String: " + encoded);

        // Decode the encoded string back into an array.
        String[] decoded = deCode(encoded);
        System.out.println("Decoded Array: " + Arrays.toString(decoded));

        // Check whether the original and decoded arrays match.
        System.out.println(
            "Are both arrays equal? " + Arrays.equals(input, decoded)
        );
    }
}
