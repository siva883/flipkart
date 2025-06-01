package Assignments;

import java.util.Arrays;
//Hello
public class Score {
    public static void main(String[] args) {
        
        int[] scores = {11, 92, 25, 85, 78, 72, 87, 85, 90, 76};

        System.out.println(" Scores before sort: " + Arrays.toString(scores));
                        
        Arrays.sort(scores);

        System.out.println(" Scores after sorting (Ascending): " + Arrays.toString(scores));
    }
}
