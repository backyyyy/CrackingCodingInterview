
public class TestStackWithMin {

	public static void main(String[] args) {
		StackWithMin mStack = new StackWithMin();

		for(int i=10; i>0; i--){
			mStack.push(i);
		}
		
		for(int i=0; i<10; i++){
			System.out.println(mStack.myPop());
		}

	}

}
