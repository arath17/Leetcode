import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/*
 * @lc app=leetcode id=380 lang=java
 *
 * [380] Insert Delete GetRandom O(1)
 */

// @lc code=start
class RandomizedSet {
    HashMap<Integer, Integer> valueIndexMap;
    List<Integer> values;
    int index;

    public RandomizedSet() {
        valueIndexMap = new HashMap<>();
        values = new ArrayList<>();
        index = 0;
    }

    public boolean insert(int val) {
        if (valueIndexMap.putIfAbsent(val, index) == null) {
            values.add(val);
            index++;
            return true;
        }
        return false;
    }

    public boolean remove(int val) {
        int targetIndex = valueIndexMap.getOrDefault(val, -1);
        if (targetIndex != -1) {
            int lastValue = values.remove(values.size() - 1);
            if (targetIndex < values.size()) {
                values.set(targetIndex, lastValue);
                valueIndexMap.put(lastValue, targetIndex);
            }
            valueIndexMap.remove(val);
            index--;
            return true;
        }
        return false;

    }

    public int getRandom() {
        int randomIndex = (int) Math.floor(Math.random() * values.size());
        return values.get(randomIndex);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
// @lc code=end
