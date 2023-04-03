package Maze_Solver;

import java.util.ArrayList;

public class DepthFirstSearch {
    public static boolean searchPath(int[][] maze , int x , int y , ArrayList<Integer> path){
        if(maze[y][x] == 9){
            path.add(x);  // adding both the coordinates including the destination one
            path.add(y);
            return true;
        }
        if(maze[y][x] == 0){  // only runs if i can go to the path
            maze[y][x] = 2;
            int dx = -1;
            int dy = 0;
            if(searchPath(maze , x+dx , y+dy , path)){  // go up and add both the coordinates
                path.add(x);
                path.add(y);
                return true;
            }
            dx = 1;
            dy = 0;
            if(searchPath(maze , x+dx , y+dy , path)){  // go down
                path.add(x);
                path.add(y);
                return true;
            }
            dx = 0;
            dy = -1;
            if(searchPath(maze , x+dx , y+dy , path)){  // go left
                path.add(x);
                path.add(y);
                return true;
            }
            dx = 0;
            dy = 1;
            if(searchPath(maze , x+dx , y+dy , path)){  // go right
                path.add(x);
                path.add(y);
                return true;
            }
        }
        return false;
    }
}
