/**
 * ==========================================================
 * MAIN CLASS - PalindromeCheckerApp
 * ==========================================================
 *
 * Use Case 6: Queue + Stack Fairness Check
 *
 * Description:
 * Demonstrates palindrome validation using two
 * different data structures:
 *  - Queue (FIFO)
 *  - Stack (LIFO)
 *
 * Characters are inserted into both structures
 * and compared by removing from the front of the
 * queue and the top of the stack.
 *
 * @author Developer
 * @version 6.0
 */

import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        // Define input string
        String input = "civic";

        // Create Queue (FIFO)
        Queue<Character> queue = new LinkedList<>();

        // Create Stack (LIFO)
        Stack<Character> stack = new Stack<>();

        // Insert characters into both queue and stack
        for (char c : input.toCharArray()) {
            queue.add(c);   // Enqueue
            stack.push(c);  // Push
        }

        // Assume palindrome initially
        boolean isPalindrome = true;

        // Compare until queue becomes empty
        while (!queue.isEmpty()) {

            char fromQueue = queue.remove();  // Dequeue
            char fromStack = stack.pop();     // Pop

            if (fromQueue != fromStack) {
                isPalindrome = false;
                break;
            }
        }

        // Display result
        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + isPalindrome);
    }
}