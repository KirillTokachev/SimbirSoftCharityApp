package trainingJavaPart2.DirectionsTask;

import static trainingJavaPart2.DirectionsTask.Directions.DOWN;
import static trainingJavaPart2.DirectionsTask.Directions.LEFT;
import static trainingJavaPart2.DirectionsTask.Directions.RIGHT;
import static trainingJavaPart2.DirectionsTask.Directions.UP;

import java.util.Arrays;

public class ReleasedDirections {

    public int[] coordinatChanges(Directions p, int x, int y){

        switch (p){
            case UP:
                x = x;
                y += 1;
                break;
            case DOWN:
                x = x;
                y -= 1;
                break;
            case LEFT:
                x -= 1;
                y = y;
                break;
            case RIGHT:
                x += 1;
                y = y;
                break;
            default:
                break;
        }

        return new int[] {x,y};
    }

    public int[] steps(){
       int[] location = {0,0};
        Directions[] path = {UP, UP, LEFT,
                DOWN, LEFT, DOWN, DOWN,
                RIGHT, RIGHT, DOWN,
                RIGHT};
        for (int i = 0; i < path.length; i++){
            switch (path[i]){
                case UP:
                    location = coordinatChanges(path[i], location[0], location[1]);
                    break;
                case DOWN:
                    location = coordinatChanges(path[i], location[0], location[1]);
                    break;
                case LEFT:
                    location = coordinatChanges(path[i], location[0], location[1]);
                    break;
                case RIGHT:
                    location = coordinatChanges(path[i], location[0], location[1]);
                    break;
                default:
                    break;
            }
            System.out.print(Arrays.toString(location) + " ");
        }
        System.out.println();
        return location;
    }

}
