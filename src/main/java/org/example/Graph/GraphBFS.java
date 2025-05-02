package org.example.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GraphBFS {
    ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj){
        ArrayList<Integer> res = new ArrayList<>();
        boolean visited[] = new boolean[V];
        Queue<Integer> queue = new LinkedList<>(); // because Queue is an Interface
        // what if there are multiple components.
        for(int i=0;i<V;i++){
            bfs(i,queue,visited,res,adj);
        }
        return res;
     }

     public void bfs(int source, Queue<Integer> queue, boolean visited[], ArrayList<Integer> res,ArrayList<ArrayList<Integer>> adj){
         visited[source] = true; //source node given
         queue.offer(source);
         while(!queue.isEmpty()){
             int node = queue.poll();
             res.add(node);
             for(int neighbour:adj.get(node)){
                 if(!visited[neighbour]){
                     visited[neighbour] = true;
                     queue.offer(neighbour);
                 }
             }
         }
     }
}
