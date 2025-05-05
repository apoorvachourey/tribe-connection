package org.example.Graph;

import java.util.LinkedList;
import java.util.Queue;

public class GraphFloodFill {
    //DFS or BFS problems
    int totalRows;
    int totalCols;

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        totalRows = image.length;
        totalCols = image[0].length;

        boolean visited[][] = new boolean[totalRows][totalCols];
       // dfs(sr,sc,color,image[sr][sc],visited,image);
        int curColor = image[sr][sc]; //1
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr,sc});
        image[sr][sc] = color; // mark visited or fill
        while(!queue.isEmpty()){
            int node[] = queue.poll();
            int row = node[0];
            int col = node[1];
            int adjList[][] = {{row-1,col},{row+1,col},{row,col-1},{row,col+1}};
            for(int neighbour[] : adjList){
                int r = neighbour[0];
                int c = neighbour[1];
                if(r<0 || r>=totalRows || c<0 || c>=totalCols || image[r][c]!=curColor || image[r][c]==color){
                    continue;
                }
                queue.offer(new int[]{r,c});
                image[r][c]=color;
            }
        }




        return image;


    }



    void dfs(int row, int col, int newColor, int curcolor, boolean visited[][], int image[][]){
        // out of bound check
        if(row<0 || row>=totalRows || col<0 || col>=totalCols || (image[row][col]!=curcolor) || visited[row][col]){ //ee kaa rat lebo.
            return;
        }

        image[row][col] = newColor;
        visited[row][col] = true;
        //make the neighbours

        int adjacencyList[][] = {
                //up , right, down , left
                {row-1,col},{row,col-1},{row+1,col},{row,col+1},
        };

        for(int neighbour[] : adjacencyList){
            dfs(neighbour[0],neighbour[1],newColor,curcolor,visited,image);
        }

    }

}
