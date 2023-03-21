
import java.awt.*;
import java.util.*;
import javax.swing.*;

public class MazeSolver extends JFrame {
    
    private int[][] maze ={{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                           {1,0,1,0,1,0,1,0,1,0,0,1,0,1,1},
                           {1,0,0,0,0,0,0,0,0,1,1,0,0,0,1},
                           {1,0,1,0,1,1,1,1,0,0,1,0,1,0,1},
                           {1,1,0,0,1,1,1,1,0,0,0,0,1,0,1},
                           {1,0,0,0,0,0,0,0,0,1,1,1,1,0,1},
                           {1,0,1,0,1,1,0,1,0,0,0,0,1,0,1},
                           {1,0,0,0,1,1,0,0,0,1,1,0,0,9,1},
                           {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}};

            int grid[][] = {{1,1,1,1,1},
                            {1,0,1,0,1},
                            {1,0,0,0,1},
                            {1,0,0,9,1},
                            {1,1,1,1,1}};

    ArrayList<Integer> path = new ArrayList<>();
    ArrayList<ArrayList<Integer>> allPath = new ArrayList<>();
    boolean[][] vis = new boolean[maze.length][maze[0].length];
    MazeSolver(){
      setTitle("Maze Solver");
      setSize(800, 800);
      setLocation(50, 50);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       BFS.findPath(maze,path,allPath,vis);

       

    //    for(int k=0;k<allPath.size();k++)
    //     System.out.println(allPath.get(k));
     }
     
    @Override
    public void paint(Graphics g) {
        g.translate(50, 50);
       for(int i=0;i<maze.length;i++){
        for(int j=0;j<maze[0].length;j++){
            Color clr;
            switch(maze[i][j]){
                case 1 : clr = Color.BLACK; 
                break;
                case 9 : clr = Color.ORANGE;
                break;
                default : clr = Color.white;
            }
            g.setColor(clr);
            g.fillRect(30*j,30*i, 30, 30);
            g.setColor(Color.red);
            g.drawRect(30*j,30*i, 30, 30);
        }
      }

      ArrayList<Integer> minPath = new ArrayList<>(allPath.get(allPath.size()-1));
      System.out.println(minPath);

       for(int j=0;j<minPath.size();j=j+2){
        g.setColor(Color.GREEN);
        g.fillRect(30*minPath.get(j+1)+10,30*minPath.get(j)+10, 10, 10);      
       }
    }

}
