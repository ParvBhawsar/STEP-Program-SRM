/**
 * ==========================================================
 * MAIN CLASS - PalindromeCheckerApp
 * ==========================================================
 *
 * Use Case 12: Strategy Pattern for Palindrome Algorithms
 *
 * Description:
 * Demonstrates dynamic selection of palindrome
 * validation algorithms using the Strategy Pattern.
 *
 * This use case:
 * - Defines a PalindromeStrategy interface
 * - Implements a Stack-based strategy
 * - Injects the strategy at runtime
 *
 * Focus: Algorithm interchangeability.
 *
 * @author Developer
 * @version 12.0
 */

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        String input = "level";

        // Inject strategy at runtime
        PalindromeStrategy strategy = new StackStrategy();

        boolean result = strategy.check(input);

        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + result);
    }
}

/**
 * ==========================================================
 * INTERFACE - PalindromeStrategy
 * ==========================================================
 * Defines a contract for palindrome algorithms.
 */
interface PalindromeStrategy {
    boolean check(String input);
}

/**
 * ==========================================================
 * CLASS - StackStrategy
 * ==========================================================
 * Stack-based implementation of palindrome check.
 */
class StackStrategy implements PalindromeStrategy {

    @Override
    public boolean check(String input) {

        java.util.Stack<Character> stack = new java.util.Stack<>();

        // Push characters to stack
        for (char c : input.toCharArray()) {
            stack.push(c);
        }

        // Compare by popping
        for (char c : input.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}