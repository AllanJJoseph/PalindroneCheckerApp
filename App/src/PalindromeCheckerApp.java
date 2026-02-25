import java.util.*;

/**
 * --------------------------------------------------------
 * MAIN CLASS - PalindromeCheckerApp
 * --------------------------------------------------------
 *
 * All Use Cases: UC1 to UC11
 *
 * Version : 11.0
 */

public class PalindromeCheckerApp {

    /**
     * Node for LinkedList (UC8)
     */
    static class Node {

        char data;
        Node next;

        Node(char data) {
            this.data = data;
        }

    }

    public static void main(String[] args) {

        System.out.println("Palindrome Checker App Version 11.0\n");

        runUC1();
        runUC2();
        runUC3();
        runUC4();
        runUC5();
        runUC6();
        runUC7();
        runUC8();
        runUC9();
        runUC10();
        runUC11();

    }

    static void runUC1() {

        System.out.println("UC1 Welcome");

    }

    static void runUC2() {

        String s="madam";

        boolean result=true;

        for(int i=0;i<s.length()/2;i++)
            if(s.charAt(i)!=s.charAt(s.length()-1-i))
                result=false;

        System.out.println("UC2: "+result);

    }

    static void runUC3() {

        String s="madam";
        String rev="";

        for(int i=s.length()-1;i>=0;i--)
            rev+=s.charAt(i);

        System.out.println("UC3: "+s.equals(rev));

    }

    static void runUC4() {

        char[] arr="madam".toCharArray();

        int start=0,end=arr.length-1;

        boolean result=true;

        while(start<end)
            if(arr[start++]!=arr[end--])
                result=false;

        System.out.println("UC4: "+result);

    }

    static void runUC5() {

        String s="madam";

        Stack<Character> stack=new Stack<>();

        for(char c:s.toCharArray())
            stack.push(c);

        boolean result=true;

        for(char c:s.toCharArray())
            if(c!=stack.pop())
                result=false;

        System.out.println("UC5: "+result);

    }

    static void runUC6() {

        String s="madam";

        Stack<Character> stack=new Stack<>();
        Queue<Character> queue=new LinkedList<>();

        for(char c:s.toCharArray()) {

            stack.push(c);
            queue.add(c);

        }

        boolean result=true;

        while(!stack.isEmpty())
            if(stack.pop()!=queue.remove())
                result=false;

        System.out.println("UC6: "+result);

    }

    static void runUC7() {

        String s="madam";

        Deque<Character> dq=new ArrayDeque<>();

        for(char c:s.toCharArray())
            dq.add(c);

        boolean result=true;

        while(dq.size()>1)
            if(dq.removeFirst()!=dq.removeLast())
                result=false;

        System.out.println("UC7: "+result);

    }

    static void runUC8() {

        String s="madam";

        Node head=null,tail=null;

        for(char c:s.toCharArray()) {

            Node n=new Node(c);

            if(head==null)
                head=tail=n;

            else {

                tail.next=n;
                tail=n;

            }

        }

        Node slow=head,fast=head;

        while(fast!=null && fast.next!=null) {

            slow=slow.next;
            fast=fast.next.next;

        }

        Node prev=null;

        while(slow!=null) {

            Node next=slow.next;
            slow.next=prev;
            prev=slow;
            slow=next;

        }

        Node first=head,second=prev;

        boolean result=true;

        while(second!=null) {

            if(first.data!=second.data)
                result=false;

            first=first.next;
            second=second.next;

        }

        System.out.println("UC8: "+result);

    }

    static void runUC9() {

        String s="madam";

        System.out.println("UC9: "+checkRec(s,0,s.length()-1));

    }

    static boolean checkRec(String s,int start,int end) {

        if(start>=end)
            return true;

        if(s.charAt(start)!=s.charAt(end))
            return false;

        return checkRec(s,start+1,end-1);

    }

    static void runUC10() {

        String input="A man a plan a canal Panama";

        String normalized=input.replaceAll("[^a-zA-Z]","").toLowerCase();

        boolean result=true;

        for(int i=0;i<normalized.length()/2;i++)
            if(normalized.charAt(i)!=normalized.charAt(normalized.length()-1-i))
                result=false;

        System.out.println("UC10: "+result);

    }

    /**
     * UC11 Object-Oriented Service
     */

    static void runUC11() {

        PalindromeService service=new PalindromeService();

        String input="madam";

        boolean result=service.checkPalindrome(input);

        System.out.println("UC11: "+result);

    }

}

/**
 * PalindromeService Class
 * Encapsulates palindrome logic
 */

class PalindromeService {

    public boolean checkPalindrome(String input) {

        int start=0;
        int end=input.length()-1;

        while(start<end) {

            if(input.charAt(start)!=input.charAt(end))
                return false;

            start++;
            end--;

        }

        return true;

    }

}