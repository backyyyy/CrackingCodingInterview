import java.util.Stack;


public class BigStack {
	private Stack<Integer>[] stacks = new Stack[3]; //stacks = combination of 3 stacks
	private int mostCurrentStack = 0;
	private final int stackSize = 5;
	
	public BigStack(){
		for(int i=0; i<stacks.length; i++) {
			stacks[i] = new Stack<Integer>();
		}
	}
	
	public void push(int x){
		System.out.println("Now pushing "+x);
		stacks[mostCurrentStack].push(x);
		if(stacks[mostCurrentStack].size() == stackSize)	mostCurrentStack++;
	}
	
	public int pop(){ //Assume the stack is not empty
		int toBeReturned = stacks[mostCurrentStack].pop();
		if(stacks[mostCurrentStack].size()==0)	mostCurrentStack--;
		System.out.println("Now popping "+toBeReturned);
		return toBeReturned;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BigStack bs = new BigStack();
		for(int i=0; i<20; i++){
			bs.push(i);
		}
//		bs.push(1);
//		bs.push(2);
//		bs.push(3);
//		bs.push(4);
//		bs.push(5);
//		bs.push(6);
//		bs.push(7);
		bs.pop();bs.pop();bs.pop();bs.pop();bs.pop();
	}

}
