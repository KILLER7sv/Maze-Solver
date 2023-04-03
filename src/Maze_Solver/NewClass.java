package Maze_Solver;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class NewClass extends JFrame{

    // creating a maze to be solved , 1--> obstacle , 2--> empty space(i can go there) , 9--> destination
    private int[][] maze = {{1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,0,1,0,1,0,1,0,0,0,0,0,1},
            {1,0,1,0,0,0,1,0,1,1,1,0,1},
            {1,0,1,1,1,1,1,0,0,0,0,0,1},
            {1,0,0,1,0,0,0,0,1,1,1,0,1},
            {1,0,1,0,1,1,1,0,1,0,0,0,1},
            {1,0,1,0,1,0,0,0,1,1,1,0,1},
            {1,0,1,0,1,1,1,0,1,0,1,0,1},
            {1,0,0,0,0,0,0,0,0,0,1,9,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,1}
    };

    ArrayList<Integer> path = new ArrayList<>();  //  to store the path from start to end


    // GUI Application frame
    public NewClass(){
        setTitle("Maze Solver");
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // program terminates as soon as we hit close button

        DepthFirstSearch.searchPath(maze , 1 ,1 ,path);  // using DFS to go to destination
//        System.out.println(path);
    }

    // over riding to use this inbuilt function as per my needs
    @Override
    public void paint(Graphics g){
        g.translate(50,100);     // set the staring of maze
        for(int i = 0 ; i < maze.length;i++){
            for(int j = 0; j < maze[0].length ; j++){
                Color color;    // assigning the color class object
                switch(maze[i][j]){
                    case 1 : color = Color.BLACK;break;   // obstacles black
                    case 9 : color = Color.red;break;   // destination is red
                    default : color = Color.WHITE;break; // where i can go is white
                }
                g.setColor(color); // setting the color as per switch statement
                g.fillRect(30*j , 30*i , 30 , 30);  // setting the color of whole rectangle
                g.setColor(Color.red);
                g.drawRect(30*j , 30*i , 30 , 30);  // separating the blocks with red outlines
            }
        }
        for(int i = 0 ; i < path.size() ; i+=2){
            int px = path.get(i);
            int py = path.get(i+1);
//            System.out.println("x --> " + px);
//            System.out.println("Y --> " + py);

            g.setColor(Color.GREEN);
            g.fillRect(30 * px , 30 * py , 20 ,20);  // all the coordinates are present in the list so coloring them as green
        }
    }

    public static void main(String[] args) {
        NewClass view = new NewClass();
        view.setVisible(true); // so that the app is visible
    }
}
