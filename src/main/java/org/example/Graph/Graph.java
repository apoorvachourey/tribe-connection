package org.example.Graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    class Pair{
        int node;
        int weight;

        public Pair(int n, int w){
            node = n;
            weight = w;
        }

        @Override
        public String toString() {
            return "("+node+","+weight+")";
        }
    }

    int adjmatrix[][];
    List<List<Integer>> adjList;
    List<List<Pair>> adjListWithWt;


    public Graph(int nodes) {
        adjmatrix = new int[nodes][nodes];
        adjList = new ArrayList<>();
        adjListWithWt = new ArrayList<>();
        for(int i=0;i<nodes;i++){
            adjList.add(new ArrayList<>()); //empty list initialised for each node
            adjListWithWt.add(new ArrayList<>());
        }
    }

    //  -> [[0,2],[0,1],[2,0]]
    public void addEdgeinMatrix(int edges[][], boolean isDirected){
        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            //directed graph
            if(isDirected) {
                adjmatrix[u][v] = w;
            }else{
                adjmatrix[u][v] = w;
                adjmatrix[v][u] = w;
            }

        }
    }
    public void addEdgeinList(int edges[][], boolean isDirected){
        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];
            //directed graph
            if(isDirected) {
                adjList.get(u).add(v);
            }else{
                adjList.get(u).add(v);
                adjList.get(v).add(u);
            }

        }
    }
    public void addWeightedEdgeinList(int edges[][], boolean isDirected){
        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            //directed graph
            if(isDirected) {
                Pair pair = new Pair(v,w); //jispe ja rhi hai woh + weight
                adjListWithWt.get(u).add(pair);
            }else{
                Pair p1 = new Pair(u,w);
                Pair p2 = new Pair(v,w);
                adjListWithWt.get(u).add(p2);
                adjListWithWt.get(v).add(p1);
            }

        }
    }
    public void printMatrix(){
        for(int i=0;i<adjmatrix.length;i++){
            System.out.print("row "+i+" -> ");
            for(int j=0;j<adjmatrix[i].length;j++){
                System.out.print(adjmatrix[i][j]);
                if(j!=adjmatrix[i].length-1){
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
    }

    public void printList(){
        for(int i=0;i<adjList.size();i++){
            System.out.print(i+" -> ");
            System.out.print("[");
            for(int j=0; j < adjList.get(i).size(); j++){
                System.out.print(adjList.get(i).get(j));
                if(j!=adjList.get(i).size()-1){
                    System.out.print(",");
                }
            }
            System.out.print("]");
            System.out.println();
        }
        System.out.println();
    }

    public void printWeightedList(){
        for(int i=0;i<adjListWithWt.size();i++){
            System.out.print(i+" -> ");
            System.out.print("[");
            for(int j=0; j < adjListWithWt.get(i).size(); j++){
                System.out.print(adjListWithWt.get(i).get(j));
                if(j!=adjListWithWt.get(i).size()-1){
                    System.out.print(",");
                }
            }
            System.out.print("]");
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        /*

        int edges[][] = {{0,2},{0,1},{1,3}};
        int nodes = 4;
        System.out.println("Undirected -- > ");
        Graph graph = new Graph(nodes);
        graph.addEdgeinMatrix(edges,false);
        graph.printMatrix();
        System.out.println("Directed --- >");
        Graph graphDir = new Graph(nodes);
        graphDir.addEdgeinMatrix(edges,true);
        graphDir.printMatrix();

         */

      /*  int edges[][] = {{0,2,10},{0,1,20},{1,3,30}};
        int nodes = 4;
        System.out.println(" Weighted Undirected -- > ");
        Graph graph = new Graph(nodes);
        graph.addEdgeinMatrix(edges,false);
        graph.printMatrix();
        System.out.println("Weighted Directed --- >");
        Graph graphDir = new Graph(nodes);
        graphDir.addEdgeinMatrix(edges,true);
        graphDir.printMatrix();

       */

      /*  int edges[][] = {{0,2,10},{0,1,20},{1,3,30}};
        int nodes = 4;
        System.out.println("  Undirected -- > ");
        Graph graph = new Graph(nodes);
        graph.addEdgeinList(edges,false);
        graph.printList();

       System.out.println(" Directed --- >");
        Graph graphDir = new Graph(nodes);
        graphDir.addEdgeinList(edges,true);
        graphDir.printList();*/

        int edges[][] = {{0,2,10},{0,1,20},{1,3,30}};
        int nodes = 4;
        System.out.println("Weighted  Undirected -- > ");
        Graph graph = new Graph(nodes);
        graph.addWeightedEdgeinList(edges,false);
        graph.printWeightedList();

        System.out.println("Weighted Directed --- >");
        Graph graphDir = new Graph(nodes);
        graphDir.addWeightedEdgeinList(edges,true);
        graphDir.printWeightedList();
    }
}
