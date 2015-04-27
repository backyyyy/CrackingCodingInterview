import java.util.HashSet;
import java.util.Set;

// Feb 27, 2015

/**
 * Given a string s and a dictionary of words dict, determine if 
 * s can be segmented into a space-separated sequence of one or 
 * more dictionary words.
 * 
 * For example, given
 * s = "leetcode",
 * dict = ["leet", "code"].
 * 
 * Return true because "leetcode" can be segmented as "leet code".
 */

public class WordBreak {
	
    public boolean wordBreak(String s, Set<String> dict) {  	
    	if(s==null || dict==null || s.length()==0) return false;
       
    	boolean[] dp=new boolean[s.length()+1];
        dp[0]=true;
        
        for(int i=1; i<s.length()+1; i++){           
            for(int j=0; j<i; j++){
            	System.out.println("i=" + i + "; j=" + j + "; dp[" + j+ "]=" + dp[j] + "; s.substring(" + j + "," + i + ")= " + s.substring(j,i));
                if(dp[j] && dict.contains(s.substring(j,i))) {
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[s.length()]; 
    }
    
    public boolean wordBreak2(String s, Set<String> dict) { 
    	
    	// Only applicable if each word in dict only apprears once
    	if(s==null || dict==null || s.length()==0) return false;
    	
    	boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        int start = 0;
        
        for(int i=1; i<s.length()+1; i++){           
            for(int j=start; j<i; j++){
            	System.out.println("i=" + i + "; j=" + j + "; dp[" + j+ "]=" + dp[j] + "; s.substring(" + j + "," + i + ")= " + s.substring(j,i));
                if(dp[j] && dict.contains(s.substring(j,i))) {
                    dp[i]=true;
                    start = i;
                    break;
                }
            }
        }
    	
    	return dp[s.length()];
    }
    
    public static void main(String[] args){
    	WordBreak test = new WordBreak();
    	String input = "aaaaaaaaa";
    	Set<String> dict = new HashSet<String>();
    	
    	dict.add("aaa");
    	dict.add("aa");
    	dict.add("aa");
    	System.out.println(test.wordBreak(input, dict));   	
//    	System.out.println(test.wordBreak2(input, dict));   	

    }
}
