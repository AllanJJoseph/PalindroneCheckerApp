import java.util.Stack;

/**
 * --------------------------------------------------------
 * MAIN CLASS - PalindromeCheckerApp
 * --------------------------------------------------------
 *
 * Project: Palindrome Checker App
 *
 * Description:
 * This application demonstrates multiple approaches
 * to checking whether a string is a palindrome.
 *
 * Implemented Use Cases:
 *
 * UC1 - Application Entry & Welcome Message
 * UC2 - Hardcoded Palindrome Check (Half Comparison)
 * UC3 - Palindrome Check Using String Reverse
 * UC4 - Character Array Based Palindrome Check
 * UC5 - Stack-Based Palindrome Checker
 *
 * Concepts Covered:
 * - String handling
 * - Loops
 * - Conditional statements
 * - Character arrays
 * - Two-pointer technique
 * - Stack (LIFO principle)
 *
 * @author YourName
 * @version 5.0
 */

public class PalindromeCheckerApp {

    /**
     * --------------------------------------------------------
     * MAIN METHOD
     * --------------------------------------------------------
     * Entry point of the application.
     */
    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println("   PALINDROME CHECKER APPLICATION");
        System.out.println("   Version : 5.0");
        System.out.println("======================================\n");

        runUC1();
        runUC2();
        runUC3();
        runUC4();
        runUC5();
    }

    /**
     * --------------------------------------------------------
     * UC1: Application Entry & Welcome Message
     * --------------------------------------------------------
     */
    public static void runUC1() {

        System.out.println("---- UC1: Welcome Page ----");
        System.out.println("System initialized successfully.\n");
    }

    /**
     * --------------------------------------------------------
     * UC2: Hardcoded Palindrome Check
     * --------------------------------------------------------
     * Logic: Compare first half of string with second half.
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
     * --------------------------------------------------------
     * UC3: Palindrome Check Using String Reverse
     * --------------------------------------------------------
     * Logic: Reverse string and compare using equals().
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
     * --------------------------------------------------------
     * UC4: Character Array Based Palindrome Check
     * --------------------------------------------------------
     * Logic: Convert to char[] and use two-pointer approach.
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
     * --------------------------------------------------------
     * UC5: Stack-Based Palindrome Checker
     * --------------------------------------------------------
     * Logic:
     * - Push characters into stack
     * - Pop characters (reversed order)
     * - Compare with original string
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
}