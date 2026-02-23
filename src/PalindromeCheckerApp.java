/**
 * ==========================================================
 * MAIN CLASS - PalindromeCheckerApp
 * ==========================================================
 *
 * Use Case 3: Reverse String Based Palindrome Check
 *
 * Description:
 * Checks whether a string is a palindrome
 * by reversing it and comparing with original.
 *
 * @author Developer
 * @version 3.0
 */

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        // Hardcoded string
        String input = "madam";

        System.out.println("Palindrome Checker App - UC3");
        System.out.println("Original String: " + input);

        String reversed = "";

        // Iterate from last character to first
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed = reversed + input.charAt(i);
        }

        System.out.println("Reversed String: " + reversed);

        // Compare original and reversed string
        if (input.equals(reversed)) {
            System.out.println("Result: The string is a Palindrome.");
        } else {
            System.out.println("Result: The string is NOT a Palindrome.");
        }
    }
}