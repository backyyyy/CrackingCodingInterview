import java.util.ArrayList;
import java.util.List;

// Jan 29, 2015

/**
 * Given a collection of numbers, return all possible 
 * permutations.
 * 
 * For example,
 * [1,2,3] have the following permutations:[1,2,3], 
 * [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 */

public class Permutations {
	public ArrayList<ArrayList<Integer>> permute(int[] num) {	//原题是List<List<Integer>> 为什么改成ArrayList<ArrayList<Integer>>之后才能accept？
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();	// 网上说这个是"NP问题" 什么是NP问题？看了半天Wikipedia看不懂。。。T_T
		ArrayList<Integer> tmp = new ArrayList<Integer>();
		int n = num.length;
		boolean[] visited = new boolean[n];
		permuteImp((ArrayList<ArrayList<Integer>>) list, tmp, num, visited);
		return list;
    }
	
	private void permuteImp(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> tmp, int[] num, boolean[] visited){
		if(tmp.size() == num.length){
			res.add(new ArrayList<Integer>(tmp));
			return;
		}
		for(int i=0;i<num.length;i++){
			if(!visited[i]){					
				tmp.add(num[i]);
				visited[i] = true;
				permuteImp(res,tmp,num,visited);
				visited[i] = false;
				tmp.remove(tmp.size()-1);
			}
		}
	}
	
	public static void main(String[] args){
		int[] num = {1,2,3,4};
		Permutations test = new Permutations();
		System.out.println(test.permute(num));
	}
}
