import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

// Feb 8, 2015

public class GraphTraversal_DFS_BFS {	
		
//		HashSet<Node> dfsList = new HashSet<Node>(); // I saw some online program using Stack for DFS, what's the diff here?
		public void dfs(Node node) {
			HashSet<Node> dfsList = new HashSet<Node>(); // I saw some online program using Stack for DFS, what's the diff here?
			dfsList.add(node);
			System.out.println(node.label);
			ArrayList<Node> neighbourhoodOfNode = node.neighbourhood;
			for(Node neighbour : neighbourhoodOfNode) {
				if(!dfsList.contains(neighbour)) {
					dfs(neighbour);
				}
			}
		}
		
		public void bfs(Node node) {
			HashSet<Node> bfsList = new HashSet<Node>();
			Queue<Node> queue = new LinkedList<Node>(); // Why use LinkedList for queue?
			queue.add(node);
			bfsList.add(node);
			while(!queue.isEmpty()) {
				Node n = queue.poll();
				System.out.println(n.label);
				ArrayList<Node> neighbourhoodOfN = n.neighbourhood;
				for(Node neighbour : neighbourhoodOfN) {
					if(!bfsList.contains(neighbour)) {
						queue.add(neighbour);
						bfsList.add(neighbour); // Why BFS is not recursive but DFS is recursive?
					}
				}
			}
		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			GraphTraversal_DFS_BFS solution = new GraphTraversal_DFS_BFS();
			Node n1 = new Node(1);
			Node n2 = new Node(2);
			Node n3 = new Node(3);
			Node n4 = new Node(4);
			Node n5 = new Node(5);
			
			n1.neighbourhood.add(n2);
			n1.neighbourhood.add(n3);
			n1.neighbourhood.add(n4);
			
			n2.neighbourhood.add(n1);
			n2.neighbourhood.add(n3);
			n2.neighbourhood.add(n5);
			
			n3.neighbourhood.add(n1);
			n3.neighbourhood.add(n2);
			n3.neighbourhood.add(n5);
			
			n4.neighbourhood.add(n1);
			
			n5.neighbourhood.add(n2);
			n5.neighbourhood.add(n3);

			
			System.out.println("DFS: "); 
			solution.dfs(n1);
			System.out.println("BFS: "); 
			solution.bfs(n1);
		}
}

class Node {
	int label;
	ArrayList<Node> neighbourhood;
	
	public Node(int label){
		this.label = label;
		neighbourhood = new ArrayList<Node>();
	}
}
