
public class TestStack {

	public static void main(String[] args) {
		ThreeStacks ts = new ThreeStacks();
		try{
			ts.push(0, 11);
			ts.push(0, 12);
			ts.push(0, 13);
			ts.push(0, 14);
			ts.push(0, 15);

			ts.push(1, 21);
			ts.push(1, 22);
			ts.push(1, 23);
			ts.push(1, 24);
			ts.push(1, 25);
			
			ts.push(2, 31);
			ts.push(2, 32);
			ts.push(2, 33);
			ts.push(2, 34);
			ts.push(2, 35);		
			
		}catch(Exception e){
			System.out.println("Push Error...");
		}
		
		System.out.println("Stack 0 starts at: " + ts.absStackTop(0));
		System.out.println("Stack 1 starts at: " + ts.absStackTop(1));
		System.out.println("Stack 2 starts at: " + ts.absStackTop(2));
		
		try{
			for(int i = 0; i < 3; i++){
				for(int j = 0; j < ts.stackSize; j++){
					System.out.print("Stack " + i + " : ");
					System.out.println(ts.pop(i));
				}
			}
		}catch(Exception e){
			System.out.println("Pop Error...");
		}
	}
}

