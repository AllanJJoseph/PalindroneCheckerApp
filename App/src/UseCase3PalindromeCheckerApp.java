/**
 * --------------------------------------------------------
 * MAIN CLASS - UseCase3PalindromeCheckerApp
 * --------------------------------------------------------
 *
 * Use Case 3: Palindrome Check Using String Reverse
 *
 * Description:
 * This program checks whether a given string
 * is a palindrome by reversing it using a loop.
 *
 * @author YourName
 * @version 3.0
 */

public class UseCase3PalindromeCheckerApp {

    public static void main(String[] args) {

        String original = "madam";
        String reversed = "";

        // Reverse the string using for loop
        for (int i = original.length() - 1; i >= 0; i--) {
            reversed = reversed + original.charAt(i);
        }

        System.out.println("Original String: " + original);
        System.out.println("Reversed String: " + reversed);

        // Compare using equals()
        if (original.equals(reversed)) {
            System.out.println("Result: It is a Palindrome");
        } else {
            System.out.println("Result: It is NOT a Palindrome");
        }
    }
}