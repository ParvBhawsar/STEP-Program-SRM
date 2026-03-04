/**
 * ==========================================================
 * MAIN CLASS - PalindromeCheckerApp
 * ==========================================================
 *
 * Use Case 4: Character Array Based Validation
 *
 * Description:
 * Validates a palindrome by converting the string
 * into a character array and comparing characters
 * using the two-pointer technique.
 *
 * @author Developer
 * @version 4.0
 */

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        // Declare and initialize the input string
        String input = "radar";

        // Convert string into character array
        char[] chars = input.toCharArray();

        // Initialize pointers
        int start = 0;
        int end = chars.length - 1;

        // Assume palindrome initially
        boolean isPalindrome = true;

        // Continue comparison until pointers cross
        while (start < end) {

            if (chars[start] != chars[end]) {
                isPalindrome = false;
                break;
            }

            start++;
            end--;
        }

        // Display result
        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + isPalindrome);
    }
}
