/**
 * ==========================================================
 * MAIN CLASS - PalindromeCheckerApp
 * ==========================================================
 *
 * Use Case 5: Stack Based Palindrome Checker
 *
 * Description:
 * Validates a palindrome using a Stack data structure
 * which follows LIFO (Last In First Out) principle.
 *
 * @author Developer
 * @version 5.0
 */

import java.util.Stack;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        // Declare and initialize the input string
        String input = "noon";

        // Create a Stack to store characters
        Stack<Character> stack = new Stack<>();

        // Push each character of the string into the stack
        for (char c : input.toCharArray()) {
            stack.push(c);
        }

        // Assume palindrome initially
        boolean isPalindrome = true;

        // Iterate again through original string
        for (char c : input.toCharArray()) {

            // Pop character from stack
            if (c != stack.pop()) {
                isPalindrome = false;
                break;
            }
        }

        // Display result
        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + isPalindrome);
    }
}