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
 * Description:
 * Demonstrates palindrome checking using multiple methods.
 *
 * UC1 - Welcome
 * UC2 - Half Comparison
 * UC3 - Reverse String
 * UC4 - Char Array
 * UC5 - Stack
 * UC6 - Queue + Stack
 * UC7 - Deque
 * UC8 - Linked List
 * UC9 - Recursion
 *
 * @version 9.0
 */

public class PalindromeCheckerApp {

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
        System.out.println(" PALINDROME CHECKER APPLICATION");
        System.out.println(" Version : 9.0");
        System.out.println("======================================\n");

        runUC1();
        runUC2();
        runUC3();
        runUC4();
        runUC5();
        runUC6();
        runUC7();
        runUC8();
        runUC9();

    }

    public static void runUC1() {

        System.out.println("UC1 Welcome");

    }

    public static void runUC2() {

        String input="madam";

        boolean result=true;

        for(int i=0;i<input.length()/2;i++) {

            if(input.charAt(i)!=input.charAt(input.length()-1-i)) {

                result=false;
                break;

            }

        }

        System.out.println("UC2 Result: "+result);

    }

    public static void runUC3() {

        String input="madam";
        String reversed="";

        for(int i=input.length()-1;i>=0;i--) {

            reversed+=input.charAt(i);

        }

        System.out.println("UC3 Result: "+input.equals(reversed));

    }

    public static void runUC4() {

        String input="madam";

        char[] arr=input.toCharArray();

        int start=0;
        int end=arr.length-1;

        boolean result=true;

        while(start<end) {

            if(arr[start]!=arr[end]) {

                result=false;
                break;

            }

            start++;
            end--;

        }

        System.out.println("UC4 Result: "+result);

    }

    public static void runUC5() {

        String input="madam";

        Stack<Character> stack=new Stack<>();

        for(char c:input.toCharArray()) {

            stack.push(c);

        }

        boolean result=true;

        for(char c:input.toCharArray()) {

            if(c!=stack.pop()) {

                result=false;
                break;

            }

        }

        System.out.println("UC5 Result: "+result);

    }

    public static void runUC6() {

        String input="madam";

        Stack<Character> stack=new Stack<>();
        Queue<Character> queue=new LinkedList<>();

        for(char c:input.toCharArray()) {

            stack.push(c);
            queue.add(c);

        }

        boolean result=true;

        while(!stack.isEmpty()) {

            if(stack.pop()!=queue.remove()) {

                result=false;
                break;

            }

        }

        System.out.println("UC6 Result: "+result);

    }

    public static void runUC7() {

        String input="madam";

        Deque<Character> deque=new ArrayDeque<>();

        for(char c:input.toCharArray()) {

            deque.addLast(c);

        }

        boolean result=true;

        while(deque.size()>1) {

            if(deque.removeFirst()!=deque.removeLast()) {

                result=false;
                break;

            }

        }

        System.out.println("UC7 Result: "+result);

    }

    public static void runUC8() {

        String input="madam";

        Node head=null;
        Node tail=null;

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

        Node slow=head;
        Node fast=head;

        while(fast!=null && fast.next!=null) {

            slow=slow.next;
            fast=fast.next.next;

        }

        Node prev=null;
        Node current=slow;

        while(current!=null) {

            Node next=current.next;
            current.next=prev;
            prev=current;
            current=next;

        }

        Node first=head;
        Node second=prev;

        boolean result=true;

        while(second!=null) {

            if(first.data!=second.data) {

                result=false;
                break;

            }

            first=first.next;
            second=second.next;

        }

        System.out.println("UC8 Result: "+result);

    }

    /**
     * UC9 Recursive Palindrome Checker
     */

    public static void runUC9() {

        String input="madam";

        boolean result=checkRecursive(input,0,input.length()-1);

        System.out.println("UC9 Result: "+result);

    }

    public static boolean checkRecursive(String s,int start,int end) {

        if(start>=end)
            return true;

        if(s.charAt(start)!=s.charAt(end))
            return false;

        return checkRecursive(s,start+1,end-1);

    }

}