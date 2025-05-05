package org.example.Graph;

public class GraphNoOfIslands {
    int totalRows;
    int totalCols;

    public int numIslands(char[][] grid) {
        totalRows = grid.length;
        totalCols = grid[0].length;
        int count=0;
        boolean visited[][] = new boolean[totalRows][totalCols];
        for (int i=0;i<totalRows;i++){
            for(int j=0;j<totalCols;j++){
                if(grid[i][j]=='1' && !visited[i][j]){
                    dfs(i,j,visited,grid);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs (int row, int col, boolean visited[][], char[][] grid){
        //out of bound cases
        if(row<0 || row>=totalRows || col<0 || col>=totalCols || grid[row][col]=='0' || visited[row][col]){
            return;
        }
        visited[row][col]=true;
        int adj[][] = {{row-1,col},{row,col+1},{row+1,col},{row,col-1}};
        for(int neighbour[] : adj){
            int r = neighbour[0];
            int c = neighbour[1];
            dfs(r,c,visited,grid);
        }

    }

    public static void main(String[] args) {
       char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
       GraphNoOfIslands graph = new GraphNoOfIslands();
        System.out.println( graph.numIslands(grid));
    }
}
