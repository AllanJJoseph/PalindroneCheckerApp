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
 * Use Cases Implemented:
 *
 * UC1 - Welcome Message
 * UC2 - Half Comparison
 * UC3 - Reverse String
 * UC4 - Char Array Two Pointer
 * UC5 - Stack
 * UC6 - Queue + Stack
 * UC7 - Deque
 * UC8 - Linked List Based Palindrome Checker
 *
 * @author YourName
 * @version 8.0
 */

public class PalindromeCheckerApp {

    /**
     * Node class for Linked List (UC8)
     */
    static class Node {

        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println("   PALINDROME CHECKER APPLICATION");
        System.out.println("   Version : 8.0");
        System.out.println("======================================\n");

        runUC1();
        runUC2();
        runUC3();
        runUC4();
        runUC5();
        runUC6();
        runUC7();
        runUC8();

    }

    public static void runUC1() {

        System.out.println("---- UC1: Welcome Page ----");
        System.out.println("System initialized successfully.\n");

    }

    public static void runUC2() {

        System.out.println("---- UC2: Half Comparison ----");

        String input = "madam";
        boolean isPalindrome = true;

        for(int i=0;i<input.length()/2;i++) {

            if(input.charAt(i)!=input.charAt(input.length()-1-i)) {

                isPalindrome=false;
                break;

            }

        }

        System.out.println("Input: "+input);
        System.out.println("Is Palindrome: "+isPalindrome+"\n");

    }

    public static void runUC3() {

        System.out.println("---- UC3: Reverse String ----");

        String original="madam";
        String reversed="";

        for(int i=original.length()-1;i>=0;i--) {

            reversed=reversed+original.charAt(i);

        }

        System.out.println("Original: "+original);
        System.out.println("Reversed: "+reversed);
        System.out.println("Is Palindrome: "+original.equals(reversed)+"\n");

    }

    public static void runUC4() {

        System.out.println("---- UC4: Char Array ----");

        String input="madam";

        char[] chars=input.toCharArray();

        int start=0;
        int end=chars.length-1;

        boolean isPalindrome=true;

        while(start<end) {

            if(chars[start]!=chars[end]) {

                isPalindrome=false;
                break;

            }

            start++;
            end--;

        }

        System.out.println("Input: "+input);
        System.out.println("Is Palindrome: "+isPalindrome+"\n");

    }

    public static void runUC5() {

        System.out.println("---- UC5: Stack ----");

        String input="madam";

        Stack<Character> stack=new Stack<>();

        for(char c:input.toCharArray()) {

            stack.push(c);

        }

        boolean isPalindrome=true;

        for(char c:input.toCharArray()) {

            if(c!=stack.pop()) {

                isPalindrome=false;
                break;

            }

        }

        System.out.println("Input: "+input);
        System.out.println("Is Palindrome: "+isPalindrome+"\n");

    }

    public static void runUC6() {

        System.out.println("---- UC6: Queue + Stack ----");

        String input="madam";

        Stack<Character> stack=new Stack<>();
        Queue<Character> queue=new LinkedList<>();

        for(char c:input.toCharArray()) {

            stack.push(c);
            queue.add(c);

        }

        boolean isPalindrome=true;

        while(!stack.isEmpty()) {

            if(stack.pop()!=queue.remove()) {

                isPalindrome=false;
                break;

            }

        }

        System.out.println("Input: "+input);
        System.out.println("Is Palindrome: "+isPalindrome+"\n");

    }

    public static void runUC7() {

        System.out.println("---- UC7: Deque ----");

        String input="madam";

        Deque<Character> deque=new ArrayDeque<>();

        for(char c:input.toCharArray()) {

            deque.addLast(c);

        }

        boolean isPalindrome=true;

        while(deque.size()>1) {

            if(deque.removeFirst()!=deque.removeLast()) {

                isPalindrome=false;
                break;

            }

        }

        System.out.println("Input: "+input);
        System.out.println("Is Palindrome: "+isPalindrome+"\n");

    }

    /**
     * UC8: Linked List Based Palindrome Checker
     */
    public static void runUC8() {

        System.out.println("---- UC8: Linked List ----");

        String input="madam";

        Node head=null;
        Node tail=null;

        // Create linked list
        for(char c:input.toCharArray()) {

            Node newNode=new Node(c);

            if(head==null) {

                head=newNode;
                tail=newNode;

            }

            else {

                tail.next=newNode;
                tail=newNode;

            }

        }

        // Find middle
        Node slow=head;
        Node fast=head;

        while(fast!=null && fast.next!=null) {

            slow=slow.next;
            fast=fast.next.next;

        }

        // Reverse second half
        Node prev=null;
        Node current=slow;

        while(current!=null) {

            Node next=current.next;
            current.next=prev;
            prev=current;
            current=next;

        }

        // Compare
        Node first=head;
        Node second=prev;

        boolean isPalindrome=true;

        while(second!=null) {

            if(first.data!=second.data) {

                isPalindrome=false;
                break;

            }

            first=first.next;
            second=second.next;

        }

        System.out.println("Input: "+input);
        System.out.println("Is Palindrome: "+isPalindrome+"\n");

    }

}