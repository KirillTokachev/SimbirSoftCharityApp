package trainingJava;

import java.util.ArrayList;
import java.util.Arrays;

public class RealeseDirections {

    //
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

    public int[] steps(){
        Integer[] location = {0,0};
        ArrayList<Integer> fullPath = new ArrayList<Integer>();
        fullPath.addAll(Arrays.asList(location));
        Directions[] path = {Directions.UP,Directions.UP,Directions.LEFT,
                Directions.DOWN,Directions.LEFT,Directions.DOWN,Directions.DOWN,
                Directions.RIGHT,Directions.RIGHT,Directions.DOWN,
                Directions.RIGHT};
        for (int i = 0; i < path.length; i++){
            switch (path[i]){
                case UP:
                    location[0] = location[0];
                    location[1] += 1;
                    break;
                case DOWN:
                    location[0] = location[0];
                    location[1] -= 1;
                    break;
                case LEFT:
                    location[0] -= 1;
                    location[1] = location[1];
                    break;
                case RIGHT:
                    location[0] += 1;
                    location[1] = location[1];
                    break;
                default:
                    break;
            }
            fullPath.add(location[0]);
            fullPath.add(location[1]);
        }
        int[] finalPathArray = new int[fullPath.size()];
        for(int i = 0; i < fullPath.size(); i++){
            finalPathArray[i] = fullPath.get(i);
        }
        return finalPathArray;
    }

}
