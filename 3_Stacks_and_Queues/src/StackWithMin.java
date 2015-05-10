import java.util.Stack;

public class StackWithMin extends Stack<NodeWithMin>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void push(int value){
		int newMin = Math.min(value, min());
		super.push(new NodeWithMin(value,newMin));
	}
	
	public int myPop(){
		NodeWithMin node = super.pop();
		int value = node.value;
		return value;
	}
	
	public int min(){
		if(this.isEmpty()){
			return Integer.MAX_VALUE;
		}else{
			return peek().min;
		}
	}
}

class NodeWithMin{
	public int value;
	public int min;
	
	public NodeWithMin(int v, int min){
		value = v;
		this.min = min;
	}
}


