package org.example.Graph;

public class GraphFloodFill {
    //DFS or BFS problems
    int totalRows;
    int totalCols;

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        totalRows = image.length;
        totalCols = image[0].length;

        boolean visited[][] = new boolean[totalRows][totalCols];
        dfs(sr,sc,color,image[sr][sc],visited,image);
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
