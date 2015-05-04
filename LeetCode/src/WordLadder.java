import java.util.Set;

// Feb 27, 2015

/**
 * Given two words (start and end), and a dictionary, 
 * find the length of shortest transformation sequence 
 * from start to end, such that:
 * 
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the dictionary
 * 
 * For example,
 * Given:
 * start = "hit"
 * end = "cog"
 * dict = ["hot","dot","dog","lot","log"]
 * 
 * As one shortest transformation is "hit" -> "hot" -> 
 * "dot" -> "dog" -> "cog",
 * return its length 5.
 * 
 * Note:
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lower-case alphabetic characters.
 */

public class WordLadder {
    public int ladderLength(String start, String end, Set<String> dict) {
        if(start == null || end == null || dict == null) return 0;
        
        return 0;
    }
}
