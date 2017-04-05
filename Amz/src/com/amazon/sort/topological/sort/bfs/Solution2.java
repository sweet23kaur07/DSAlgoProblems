package com.amazon.sort.topological.sort.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Vector;

public class Solution2 {
	public static void main(String[] args) {
		String[] dict = {"baa", "abcd", "abca", "cab", "cad"};
		DAG g = createDAG(dict);
		
		/*DAG g = new DAG(6);
		
	    g.addEdge(5, 2);
	    g.addEdge(5, 0);
	    g.addEdge(4, 0);
	    g.addEdge(4, 1);
	    g.addEdge(2, 3);
	    g.addEdge(3, 1);*/
	    System.out.println("Following is a Topological Sort");
	    g.topologicalSort();
	}

	private static DAG createDAG(String[] dict) {
		int V = dict.length;
		DAG dag = new DAG(V);
		for(int i = 0; i < V-2; i++){
			char[] c1 = dict[i].toCharArray();
			char[] c2 = dict[i+1].toCharArray();
			int size = c1.length < c2.length ? c1.length : c2.length;
			for(int j=0; j < size;j++){
				if(c1[j] == c2[j]){
					continue;
				}
				dag.addEdge(c1[j] - 'a', c2[j] - 'a');
				break;
			}
		}
		return dag;
	}
}

class DAG{
	int V;
	List<Integer>[] adj; 
	
	public DAG(int V) {
		this.V = V;
		this.adj = new ArrayList[V];
		
		for(int i = 0; i < V; i++){
			adj[i] = new ArrayList<Integer>();
		}
	}
	
	public void addEdge(int U, int V){
		adj[U].add(V);
	}
	
	public void topologicalSort(){
		int[] inDegree = new int[V];
		
		//put indegree data
		for(List<Integer> list : adj){
			for(int node : list){
				inDegree[node]++;
			}
		}
		// Create a queue and enqueue all vertices with
        // indegree 0
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i = 0;i < V; i++)
        {
            if(inDegree[i]==0)
                q.add(i);
        }
         
        // Initialize count of visited vertices
        int cnt = 0;
         
        // Create a vector to store result (A topological
        // ordering of the vertices)
        Vector <Integer> topOrder=new Vector<Integer>();
        while(!q.isEmpty())
        {
            // Extract front of queue (or perform dequeue)
            // and add it to topological order
            int u=q.poll();
            topOrder.add(u);
             
            // Iterate through all its neighbouring nodes
            // of dequeued node u and decrease their in-degree
            // by 1
            for(int node : adj[u])
            {
                // If in-degree becomes zero, add it to queue
                if(--inDegree[node] == 0)
                    q.add(node);
            }
            cnt++;
        }
         
        // Check if there was a cycle       
        if(cnt != V)
        {
            System.out.println("There exists a cycle in the graph");
            return ;
        }
         
        // Print topological order          
        for(int i : topOrder)
        {
            System.out.print((char)(i+'a') + " ");
        }
	}
}