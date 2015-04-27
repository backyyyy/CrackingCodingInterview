import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

// Feb 7, 2015

/*
 * Design a stack that supports push, pop, top, and retrieving
 * the minimum element in constant time.
 * 
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 */

public class MinStack {
	int capacity = 255;
	int[] minStack = new int[capacity];
	int size = 0; 
	int min = Integer.MAX_VALUE;
	
	private Stack<Integer> stack = new Stack<Integer>();  
	private Stack<Integer> minStack2 = new Stack<Integer>();
	
	public void push(int x) {
        if(size == capacity) return;
        minStack[size] = x;
        min = Math.min(min,x);
        size ++;
    }
	
	public void push2(int x) {
        if (minStack2.isEmpty() || x <= minStack2.peek())  
            minStack2.push(x);  
        stack.push(x);
	}

    public void pop() {
        if(size > 0) {
        	if(minStack[size] == min) {
        		min = Integer.MAX_VALUE;
        		for(int i=0;i<size;i++){
        			min = Math.min(min, minStack[i]);
        		}
        	}
        	size --;
        } else return;
    }
    
    public void pop2() {
    	if (stack.peek().equals(minStack2.peek()))  
            minStack2.pop();  
        stack.pop();  
    }

    public int top() {
        if(size == 0) return 0;
        return minStack[size];
    }
    
    public int top2() {  
        return stack.peek();  
    }  

    public int getMin() {
        if(size == 0) return Integer.MIN_VALUE;
        return min;
    }
    
    public int getMin2() {  
        return minStack2.peek();  
    } 
    
    public int getSize() {
    	return size;
    }
    
    public static void main(String[] args){
    	MinStack test = new MinStack();
    	test.push(-2);
    	System.out.println("getMin() = " + test.getMin());
//    	test.push(6);
//    	System.out.println("getMin() = " + test.getMin());
//    	test.push(3);
//    	System.out.println("getMin() = " + test.getMin());
//    	test.push(1);
//    	System.out.println("getMin() = " + test.getMin());
//    	test.push(5);
//    	System.out.println("getMin() = " + test.getMin());
//    	test.push(4);
//    	System.out.println("getMin() = " + test.getMin());
//    	
//    	System.out.println("");
//    	test.pop();
//    	System.out.println("getMin() = " + test.getMin() + "; size = " + test.getSize());
//    	test.pop();
//    	System.out.println("getMin() = " + test.getMin() + "; size = " + test.getSize());
//    	test.pop();
//    	System.out.println("getMin() = " + test.getMin() + "; size = " + test.getSize());
//    	test.pop();
//    	System.out.println("getMin() = " + test.getMin() + "; size = " + test.getSize());
//    	test.pop();
//    	System.out.println("getMin() = " + test.getMin() + "; size = " + test.getSize());
//    	test.pop();
//    	System.out.println("getMin() = " + test.getMin() + "; size = " + test.getSize());
//    	test.pop();
//    	System.out.println("getMin() = " + test.getMin() + "; size = " + test.getSize());
//    	test.pop();
//    	System.out.println("getMin() = " + test.getMin() + "; size = " + test.getSize());
    }
}
