import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode id=8 lang=java
 *
 * [8] String to Integer (atoi)
 */

// @lc code=start
class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        int num = 0;
        int sign = '+';
        List<Integer> numRange = Arrays
                .stream(new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 })
                .boxed()
                .toList();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i == 0 && (c == '-' || c == '+')) {
                if (c == '-')
                    sign = '-';
            } else if (numRange.contains(c - 48)) {
                int value = c - 48;
                if (num != 0) {
                    if (sign == '-' && num > (Math.abs((long)Integer.MIN_VALUE)-value)/10) {
                        num = Integer.MIN_VALUE;
                        System.out.println(num);
                        break;
                    }
                    if (sign == '+' && num > (Integer.MAX_VALUE - value)/10.0) {
                        num = Integer.MAX_VALUE;
                        break;
                    }
                }
                num = num * 10 + value;

            } else {
                break;
            }
        }

        if (sign == '-' && num!=Integer.MIN_VALUE) {
            return -num;
        }
        return num;
    }
}
// @lc code=end
