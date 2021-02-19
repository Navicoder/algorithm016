package src.collections;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingDeque;

public class T {
    public static void main(String[] args) {
        testStack();
        System.out.println("----------------------------------------------");
        testDeque();


    }
    private static void testDeque() {
        Deque d = new ArrayDeque();
        Deque dd = new LinkedList();
        Deque ddd = new LinkedBlockingDeque();

        d.add(1);//addLast(e);
        d.add(2);
        d.add(3);
        for (Object o : d) {
            System.out.println(o);
        }
        Object element = d.element();

        d.push(11);//addFirst(e);
        d.poll();//pollFirst
        d.peek();//peekFirst



        dd.add(1);//addLast(e);
        dd.addFirst(22);
        dd.addLast(33);
    }
    private static void testStack() {
        Stack<Integer> stack = new Stack<>();
        stack.add(1);
        stack.add(2);
        stack.add(3);

        for (Integer integer : stack) {
            System.out.println(integer);
        }
    }
}
