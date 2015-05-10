
public class ThreeStacks {
	int stackSize = 5;
	int [] buffer = new int [stackSize * 3];
	int [] stackPointer = {-1, -1, -1};
	
	void push(int stackNum, int value) throws Exception{
		if(stackPointer[stackNum] +1 >= stackSize) {
			throw new Exception("Stack is full.");
		}
		
		stackPointer[stackNum] ++;
		buffer[absStackTop(stackNum)] = value;
	}
	
		int pop(int stackNum) throws Exception{
			if (stackPointer[stackNum] == -1){
				throw new Exception("Stack is empty.");
			}
			int value = buffer[absStackTop(stackNum)];
			buffer[absStackTop(stackNum)] = 0;
			stackPointer[stackNum] --;
			return value;
		}
		
		int peek(int stackNum){
			int index = absStackTop(stackNum);
			return buffer[index];
		}
		
		boolean isEmpty(int stackNum){
			return stackPointer[stackNum] == -1;
		}
		
		int absStackTop(int stackNum){
			return stackNum * stackSize + stackPointer[stackNum];
		}
	}
