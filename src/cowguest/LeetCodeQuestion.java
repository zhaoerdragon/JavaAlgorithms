package cowguest;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode题目
 */
public class LeetCodeQuestion {

    /**
     * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
     * Given two integers x and y, calculate the Hamming distance.
     * 461
     * @param x
     * @param y
     * @return
     */
    public static int hammingDistance(int x, int y) {
        int count = 0;
        while (x != 0 || y != 0) {
            if (x % 2 != y % 2) {
                count++;
            }
            x = x / 2;
            y = y / 2;
        }
        return count;
    }

    /**
     * 461
     * @param x
     * @param y
     * @return
     */
    public static int hammingDistance2(int x, int y) {
        /**
         * bitCount()计算数字转换为2进制有多少个1,而^位运算符则将不同的二进制数记为1,这个真的是6
         * 真的是，让我叹服。
         */
        return Integer.bitCount(x ^ y);
    }

    /**
     * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     * 1
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /**
     * 1
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int value = target - nums[i];
            if (hashMap.containsKey(value) && hashMap.get(value) != i) {
                return new int[]{i, hashMap.get(value)};
            }
        }
        return null;
    }

    /**
     * 1
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (hashMap.containsKey(temp)) {
                return new int[]{hashMap.get(temp), i};
            }
            hashMap.put(nums[i], i);
        }
        return null;
    }
}
