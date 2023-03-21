
import java.awt.*;
import java.util.*;
import javax.swing.*;

public class MazeSolver extends JFrame {
    
    //Creating a Maze as 2D array
    private int[][] maze ={{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                           {1,0,1,0,1,0,1,0,1,0,0,1,0,1,1},
                           {1,0,0,0,0,0,0,0,0,1,1,0,0,0,1},
                           {1,0,1,0,1,1,1,1,0,0,1,0,1,0,1},
                           {1,1,0,0,1,1,1,1,0,0,0,0,0,0,1},
                           {1,0,0,0,0,0,0,0,0,1,1,1,1,0,1},
                           {1,0,1,0,1,1,0,1,0,0,0,0,1,0,1},
                           {1,0,0,0,1,1,0,0,0,1,1,0,0,9,1},
                           {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}};

    // Path array which will contain the coordinates of the resultant path
    ArrayList<Integer> path = new ArrayList<>();

    //Constructor for the mazeSolver class
    MazeSolver(){

      //Creating a Jframe with the following structures
      setTitle("Maze Solver");
      setSize(800, 600);
      setLocation(50, 50);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      //Calling the DFS function which stores the path coordinates in path array
       DFS.findPath(maze, 1, 1,path);
       System.out.println(path);
    }
     
    //Using the in built paint method to draw the graphics of the maze and path
    @Override
    public void paint(Graphics g) {
        g.translate(50, 50); // location of the maze in the frame

        //Creating a maze with every coordinates in the maze array
       for(int i=0;i<maze.length;i++){
        for(int j=0;j<maze[0].length;j++){
            Color clr;
            switch(maze[i][j]){
                //if maze[i][j] == 1,then it iss a blockages where we cannot pass through,represented as Black color
                case 1 : clr = Color.BLACK; 
                break;
                case 9 : clr = Color.ORANGE; // if it is 9 then it is sthe destination with orange color
                break;
                default : clr = Color.white; // 0s are represented as white where we can pass through
            }
            g.setColor(clr); // seting the respective color to the grid
            g.fillRect(30*j,30*i, 30, 30); // fill the respective color
            g.setColor(Color.red); 
            g.drawRect(30*j,30*i, 30, 30); // marking the boundary of the each rectangles
        }
       } 
       // after getting the path, the path should be marked in the maze
       // iterating on the path array getting the cocordinates and filling with the colors
       for(int i=0;i<path.size();i=i+2){
        //g.translate(path.get(i), path.get(i+1));
        g.setColor(Color.GREEN);
        g.fillRect(30*path.get(i+1)+10,30*path.get(i)+10, 10, 10);
        
       }
    }
}
