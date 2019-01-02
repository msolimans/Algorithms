package com.probs;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by msoliman on 5/3/17.
 */
public class p_16_QuadRuplets {
    public static void main(String[] args) {
        System.out.print(Run(new int[]{0,1,2,3,4,5,6,7}, 5));

    }

    static String Run(int[] arr, int target) {
        StringBuilder result = new StringBuilder();

        Map<Integer, Integer> map = new HashMap<>();

        for (int i :
                arr) {
            map.put(i, (map.getOrDefault(i, 0) + 1));
        }

        int seed=0;

        for(int i = target; ;i--){

            if(seed > i)
                break;

            if(map.getOrDefault(i,-1) > 0 && map.getOrDefault(seed, -1) > 0){

                map.put(i, map.get(i) - 1);
                map.put(seed, map.get(seed) - 1);

                result.append("..." +i+","+seed);

            }

            seed++;
        }

        return result.toString();

    }
}
