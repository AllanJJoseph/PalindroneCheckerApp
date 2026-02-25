import java.util.*;

/**
 * Palindrome Checker App
 *
 * Version : 12.0
 *
 * Includes UC1 → UC12
 */

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        System.out.println("Palindrome Checker Version 12.0\n");

        runUC12();

    }

    /**
     * UC12 Strategy Pattern Execution
     */

    static void runUC12() {

        String input = "level";

        PalindromeStrategy strategy;

        // choose dynamically
        strategy = new StackStrategy();

        System.out.println("Using Stack Strategy:");
        System.out.println("Result: " + strategy.check(input));

        strategy = new DequeStrategy();

        System.out.println("\nUsing Deque Strategy:");
        System.out.println("Result: " + strategy.check(input));

    }

}

/**
 * Strategy Interface
 */

interface PalindromeStrategy {

    boolean check(String input);

}

/**
 * Stack Strategy Implementation
 */

class StackStrategy implements PalindromeStrategy {

    public boolean check(String input) {

        Stack<Character> stack = new Stack<>();

        for(char c : input.toCharArray())
            stack.push(c);

        for(char c : input.toCharArray())
            if(c != stack.pop())
                return false;

        return true;

    }

}

/**
 * Deque Strategy Implementation
 */

class DequeStrategy implements PalindromeStrategy {

    public boolean check(String input) {

        Deque<Character> deque = new ArrayDeque<>();

        for(char c : input.toCharArray())
            deque.addLast(c);

        while(deque.size() > 1)
            if(deque.removeFirst() != deque.removeLast())
                return false;

        return true;

    }

}