import java.util.*;

public class BFS {

    static class Pair{
        int r;
        int c;
        int cost;
        Pair(int r, int c,int cost){
            this.r =  r;
            this.c = c;
            this.cost = cost;
        }
     }

     static int[] dr = {0,1,0,-1};
     static int[] dc = {1,0,-1,0};
    static int len = Integer.MAX_VALUE;
    public static void findPath(int[][] maze,ArrayList<Integer> path,ArrayList<ArrayList<Integer>> allPath,boolean[][]vis) {
        PriorityQueue<Pair> que = new PriorityQueue<>((a,b)->{
            return b.cost - a.cost;
        });    
        que.add(new Pair(1,1,1));
        vis[1][1] = true;
        while(que.size() > 0){
            Pair point = que.remove();
            int r = point.r;
            int c = point.c;
            int cost = point.cost;
            
            path.add(r);
            path.add(c);
            
            if(maze[r][c] == 9){
               allPath.add(path);
               return;
            }

          //  boolean flag = false;
            for(int i=0;i<4;i++){
               int nr = r+dr[i];
               int nc = c+dc[i];
                if(maze[nr][nc] != 1 && !vis[nr][nc]){
                    vis[nr][nc] = true;
                //    flag = true;
                    que.add(new Pair(nr,nc,cost+1));
                }
            }
            // if(flag == false){
            //     path.remove(path.size()-1);
            //     path.remove(path.size()-1);
            // }
        }
    }
}