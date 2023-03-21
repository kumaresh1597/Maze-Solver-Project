import java.util.*;

public class DFS {
    //Direction array up,down,left,right
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};

    //Depth first search is applied on the maze array starting from (1,1) to find the path and 
    //coordinates  are stored in the path array
    public static boolean findPath(int[][] maze,int i,int j,ArrayList<Integer> path) {
        if(maze[i][j] == 9){
            path.add(i);
            path.add(j);
            return true;
        }
        if(maze[i][j] == 0){
            maze[i][j] = 2;
            for(int k=0;k<4;k++){
                int nr = i+dr[k];
                int nc = j+dc[k];
               boolean res = findPath(maze,nr,nc,path);
              if(res){
               path.add(i);
               path.add(j);
               return true;
              }
            }
        }
        return false;
    }
}