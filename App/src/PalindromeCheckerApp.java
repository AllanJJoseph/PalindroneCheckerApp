import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Deque;
import java.util.ArrayDeque;

/**
 * --------------------------------------------------------
 * MAIN CLASS - PalindromeCheckerApp
 * --------------------------------------------------------
 *
 * Project: Palindrome Checker App
 *
 * Description:
 * This application demonstrates multiple approaches
 * to validating whether a string is a palindrome.
 *
 * Implemented Use Cases:
 *
 * UC1 - Application Entry & Welcome Message
 * UC2 - Half-Length Comparison
 * UC3 - Reverse String Method
 * UC4 - Character Array Two-Pointer Technique
 * UC5 - Stack-Based Palindrome Checker
 * UC6 - Queue + Stack Based Comparison
 * UC7 - Deque-Based Optimized Palindrome Checker
 *
 * Concepts Covered:
 * - Strings & Character Arrays
 * - Loops & Conditionals
 * - Stack (LIFO)
 * - Queue (FIFO)
 * - Deque (Double Ended Queue)
 * - Two-Pointer Optimization
 *
 * @author YourName
 * @version 7.0
 */

public class PalindromeCheckerApp {

    /**
     * --------------------------------------------------------
     * MAIN METHOD
     * --------------------------------------------------------
     */
    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println("   PALINDROME CHECKER APPLICATION");
        System.out.println("   Version : 7.0");
        System.out.println("======================================\n");

        runUC1();
        runUC2();
        runUC3();
        runUC4();
        runUC5();
        runUC6();
        runUC7();
    }

    /**
     * UC1: Application Entry & Welcome Message
     */
    public static void runUC1() {
        System.out.println("---- UC1: Welcome Page ----");
        System.out.println("System initialized successfully.\n");
    }

    /**
     * UC2: Half-Length Comparison
     */
    public static void runUC2() {

        System.out.println("---- UC2: Half-Length Comparison ----");

        String input = "madam";
        boolean isPalindrome = true;

        for (int i = 0; i < input.length() / 2; i++) {
            if (input.charAt(i) != input.charAt(input.length() - 1 - i)) {
                isPalindrome = false;
                break;
            }
        }

        System.out.println("Input: " + input);
        System.out.println("Is Palindrome: " + isPalindrome + "\n");
    }

    /**
     * UC3: Reverse String Method
     */
    public static void runUC3() {

        System.out.println("---- UC3: Reverse String Method ----");

        String original = "madam";
        String reversed = "";

        for (int i = original.length() - 1; i >= 0; i--) {
            reversed = reversed + original.charAt(i);
        }

        System.out.println("Original: " + original);
        System.out.println("Reversed: " + reversed);
        System.out.println("Is Palindrome: " + original.equals(reversed) + "\n");
    }

    /**
     * UC4: Character Array Two-Pointer Technique
     */
    public static void runUC4() {

        System.out.println("---- UC4: Char Array Two-Pointer ----");

        String input = "madam";
        char[] characters = input.toCharArray();

        int start = 0;
        int end = characters.length - 1;
        boolean isPalindrome = true;

        while (start < end) {
            if (characters[start] != characters[end]) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }

        System.out.println("Input: " + input);
        System.out.println("Is Palindrome: " + isPalindrome + "\n");
    }

    /**
     * UC5: Stack-Based Palindrome Checker
     */
    public static void runUC5() {

        System.out.println("---- UC5: Stack-Based Palindrome Check ----");

        String input = "madam";
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }

        boolean isPalindrome = true;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != stack.pop()) {
                isPalindrome = false;
                break;
            }
        }

        System.out.println("Input: " + input);
        System.out.println("Is Palindrome: " + isPalindrome + "\n");
    }

    /**
     * UC6: Queue + Stack Based Palindrome Check
     */
    public static void runUC6() {

        System.out.println("---- UC6: Queue + Stack Based Check ----");

        String input = "madam";
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();

        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
            queue.add(input.charAt(i));
        }

        boolean isPalindrome = true;

        while (!stack.isEmpty()) {
            if (!stack.pop().equals(queue.remove())) {
                isPalindrome = false;
                break;
            }
        }

        System.out.println("Input: " + input);
        System.out.println("Is Palindrome: " + isPalindrome + "\n");
    }

    /**
     * UC7: Deque-Based Optimized Palindrome Checker
     */
    public static void runUC7() {

        System.out.println("---- UC7: Deque-Based Optimized Check ----");

        String input = "madam";
        Deque<Character> deque = new ArrayDeque<>();

        // Insert characters into deque
        for (int i = 0; i < input.length(); i++) {
            deque.addLast(input.charAt(i));
        }

        boolean isPalindrome = true;

        // Compare front and rear
        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                isPalindrome = false;
                break;
            }
        }

        System.out.println("Input: " + input);
        System.out.println("Is Palindrome: " + isPalindrome + "\n");
    }
}