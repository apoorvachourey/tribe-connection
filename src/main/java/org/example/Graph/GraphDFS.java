package org.example.Graph;

import java.util.ArrayList;

public class GraphDFS {
    ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj){
        ArrayList<Integer> res = new ArrayList<>();
        boolean visited[] = new boolean[V];
        for(int i=0;i<V;i++) {
            if (!visited[i]) {
                dfs(i, visited, res, adj);
            }
        }
        return res;
    }

    public void dfs(int node,boolean visited[], ArrayList<Integer> res,ArrayList<ArrayList<Integer>> adj){
        visited[node] = true;
        res.add(node);
        for(int neighbour : adj.get(node)){
            if(!visited[neighbour]){
                dfs(neighbour,visited,res,adj);
            }
        }
    }
}
