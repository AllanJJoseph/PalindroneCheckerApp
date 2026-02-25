import java.util.Stack;

/**
 * --------------------------------------------------------
 * MAIN CLASS - UseCase13PalindromeCheckerApp
 * --------------------------------------------------------
 *
 * Use Case 13: Performance Comparison
 *
 * Description:
 * Measures execution time of palindrome checking algorithm.
 *
 * @version 13.0
 */

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        String input = "level";

        long startTime = System.nanoTime();

        boolean result = checkPalindrome(input);

        long endTime = System.nanoTime();

        long executionTime = endTime - startTime;

        System.out.println("Input : " + input);
        System.out.println("Is Palindrome : " + result);
        System.out.println("Execution Time : " + executionTime + " ns");

    }

    /**
     * Stack based palindrome logic
     */

    public static boolean checkPalindrome(String input) {

        Stack<Character> stack = new Stack<>();

        for(char c : input.toCharArray()) {

            stack.push(c);

        }

        for(char c : input.toCharArray()) {

            if(c != stack.pop())
                return false;

        }

        return true;

    }

}