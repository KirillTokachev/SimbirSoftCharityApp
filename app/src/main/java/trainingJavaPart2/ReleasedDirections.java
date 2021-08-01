package trainingJavaPart2;

import static trainingJavaPart2.Directions.DOWN;
import static trainingJavaPart2.Directions.LEFT;
import static trainingJavaPart2.Directions.RIGHT;
import static trainingJavaPart2.Directions.UP;

import java.util.Arrays;

public class ReleasedDirections {

    public int[] coordinatChanges(int x, int y, Directions p){

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

    public Integer[] steps(){
        Integer[] location = {0,0};
        Directions[] path = {UP, UP, LEFT,
                DOWN, LEFT, DOWN, DOWN,
                RIGHT, RIGHT, DOWN,
                RIGHT};
        for (int i = 0; i < path.length; i++){
            switch (path[i]){
                case UP:
                    coordinatChanges(location[0] = location[0], location[1] += 1, path[i]);
                    break;
                case DOWN:
                    coordinatChanges(location[0] = location[0], location[1] -= 1, path[i]);
                    break;
                case LEFT:
                    coordinatChanges(location[0] -= 1, location[1] = location[1], path[i]);
                    break;
                case RIGHT:
                    coordinatChanges(location[0] += 1, location[1] = location[1], path[i]);
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
