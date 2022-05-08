import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
 * @lc app=leetcode id=675 lang=java
 *
 * [675] Cut Off Trees for Golf Event
 */

// @lc code=start
class Solution {

    int dp[][];
    public int cutOffTree(List<List<Integer>> forest) {
        List<Integer> trees = new ArrayList<>();
        HashMap<Integer, List<Integer>> treePosition = new HashMap<>();
        int m = forest.size();
        int n = forest.get(0).size();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int value = forest.get(i).get(j);
                if (value != 0 && value != 1) {
                    trees.add(value);
                    treePosition.put(value, new ArrayList<>().addAll(Arrays.asList(i, j)));
                }
            }
        }

        trees.sort();
        dp = new int[trees.size()][trees.size()];
        for(int i = 0;i<trees.size();i++){

        }


    }

    int shortestDistance(int a,int b){
        if(a==0){
            
        }
    }
}
// @lc code=end
